package de.eisner.artworkspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import androidx.compose.ui.zIndex
import de.eisner.artworkspace.data.DataSource
import de.eisner.artworkspace.model.GalleryItemModel
import de.eisner.artworkspace.ui.theme.ArtworkSpaceTheme
import de.eisner.artworkspace.ui.theme.background
import de.eisner.artworkspace.ui.theme.onSurface
import de.eisner.artworkspace.ui.theme.onSurfaceVariant
import de.eisner.artworkspace.ui.theme.outline
import de.eisner.artworkspace.ui.theme.scrim
import de.eisner.artworkspace.ui.theme.secondary
import de.eisner.artworkspace.ui.theme.surface
import de.eisner.artworkspace.ui.theme.surfaceTint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtworkSpaceTheme {
                Scaffold(
                    modifier = Modifier
                        .background(surface)
                        .fillMaxSize()
                ) { innerPadding ->
                    ArtworkSpaceScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtworkSpaceScreen(modifier: Modifier = Modifier) {
    val gallery = DataSource.loadGallery()
    val imagesCount = gallery.size
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = pluralStringResource(R.plurals.images, imagesCount, imagesCount),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 8.dp)
        )
        Gallery(
            gallery = gallery,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

@Composable
fun Gallery(gallery: List<GalleryItemModel>, modifier: Modifier = Modifier) {
    val categories = stringArrayResource(R.array.categories)

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 4.dp, bottom = 4.dp, start = 24.dp, end = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(gallery) {
            GalleryItem(
                category = categories[it.categoryIndex],
                image = it.imageRes,
                title = it.titleRes,
                strengths = it.strengthsRes,
                shadows = it.shadowsRes,
                analysis = it.analysis,
                contentDescription = it.contentDescriptionRes,
            )
        }
    }
}

@Composable
fun GalleryItem(
    category: String,
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes contentDescription: Int,
    @ArrayRes strengths: Int,
    @ArrayRes shadows: Int,
    @StringRes analysis: Int,
    modifier: Modifier = Modifier
) {
    var showImageInFullscreen by remember { mutableStateOf(false) }

    Card(
        heading = category,
        image = image,
        strengths = strengths,
        shadows = shadows,
        contentDescription = contentDescription,
        onShowImageFullscreenChange = { showImageInFullscreen = true },
        modifier = modifier
            .height(250.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                dimensionResource(R.dimen.card_stroke_width),
                outline,
                RoundedCornerShape(16.dp)
            )
    )

    if (showImageInFullscreen) {
        FullScreenImage(
            category = category,
            title = title,
            image = image,
            strengths = strengths,
            shadows = shadows,
            analysis = analysis,
            contentDescription = contentDescription,
            onShowImageFullscreenChange = { showImageInFullscreen = it }
        )
    }
}

@Composable
fun FullScreenImage(
    category: String,
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes contentDescription: Int,
    @ArrayRes strengths: Int,
    @ArrayRes shadows: Int,
    @StringRes analysis: Int,
    onShowImageFullscreenChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var showInterpretation by remember { mutableStateOf(true) }

    Dialog(
        onDismissRequest = { onShowImageFullscreenChange(false) },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            securePolicy = SecureFlagPolicy.SecureOn
        )
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(scrim.copy(alpha = .5f)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(contentDescription),
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 100.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            IconButton(
                onClick = { onShowImageFullscreenChange(false) },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(dimensionResource(R.dimen.card_padding))
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Fullscreen Image",
                    tint = surfaceTint
                )
            }

            StyledText(
                text = category,
                color = surfaceTint,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 40.dp, start = 20.dp)
            )

            CardInDialog(
                strengths = strengths,
                shadows = shadows,
                title = title,
                analysis = analysis,
                modifier = modifier
                    .fillMaxWidth()
                    .zIndex(3f)
                    .align(Alignment.BottomCenter)
                    .padding(start = 40.dp, end = 40.dp, bottom = 120.dp),
                showInterpretation = showInterpretation,
                onShowInterpretation = { showInterpretation = it }
            )
        }
    }
}

@Composable
fun CardInDialog(
    @StringRes title: Int,
    @ArrayRes strengths: Int,
    @ArrayRes shadows: Int,
    @StringRes analysis: Int,
    showInterpretation: Boolean,
    onShowInterpretation: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    if (showInterpretation) {
        Box(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .background(surface)
        ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    StyledText(
                        text = stringResource(title),
                        color = onSurface,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                    )
                    StyledText(
                        text = stringResource(analysis),
                        fontWeight = FontWeight.W500,
                        fontStyle = FontStyle.Normal,
                        modifier = Modifier
                            .padding(bottom = 24.dp),
                        maxLines = Int.MAX_VALUE,
                    )
                    StyledText(
                        text = stringResource(R.string.strengths),
                        withExtras = true,
                        traits = stringArrayResource(strengths),
                        maxLines = 4,
                    )
                    Spacer(Modifier.height(8.dp))
                    StyledText(
                        text = stringResource(R.string.shadows),
                        withExtras = true,
                        traits = stringArrayResource(shadows),
                        maxLines = 4,
                    )
                }

                TextButton(
                    onClick = { onShowInterpretation(false) },
                    colors = ButtonDefaults.textButtonColors()
                        .copy(
                            contentColor = surfaceTint,
                        ),
                    modifier = Modifier
                        .padding(top = 0.dp)
                        .align(Alignment.TopEnd)
                ) {
                    Text(text = stringResource(R.string.hide_interpretation))
                }
        }
    } else {
       Box(
           modifier = modifier
               .fillMaxWidth()
               .zIndex(3f),
       ) {
           TextButton(
               onClick = { onShowInterpretation(true) },
               colors = ButtonDefaults.textButtonColors()
                   .copy(
                       contentColor = surfaceTint,
                       containerColor = surface.copy(alpha = 0.9f)
                   ),
               modifier = Modifier
                   .clip(RoundedCornerShape(4f))
                   .align(Alignment.BottomEnd)
           ) {
               Text(
                   text = stringResource(R.string.show_interpretation),
                   style = TextStyle(
                       shadow = Shadow(
                           color = surfaceTint.copy(
                               alpha = 0.5f
                           ),
                           offset = Offset(4f, 4f),
                       )
                   ),
               )
           }
       }
    }
}

@Composable
fun Card(
    heading: String,
    @DrawableRes image: Int,
    @StringRes contentDescription: Int,
    @ArrayRes strengths: Int,
    @ArrayRes shadows: Int,
    onShowImageFullscreenChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(end = dimensionResource(R.dimen.card_padding))
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .aspectRatio(0.75f)
                .zIndex(0f)
                .clickable { onShowImageFullscreenChange(true) },
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.CenterEnd)
                .zIndex(1f)
                .fillMaxWidth(0.75f)
                .fillMaxHeight(0.8f)
                .border(
                    dimensionResource(R.dimen.card_stroke_width),
                    outline,
                    RoundedCornerShape(
                        dimensionResource(R.dimen.card_rounded_corner)
                    )
                )
                .clip(RoundedCornerShape(dimensionResource(R.dimen.card_rounded_corner)))
                .background(surface)
                .padding(horizontal = dimensionResource(R.dimen.card_padding))
                .clickable(onClick = {}),
        ) {
            Column(
                modifier = Modifier
                    .padding(all = dimensionResource(R.dimen.inner_card_padding)),
            ){
                StyledText(
                    text = stringResource(R.string.card_title, heading),
                    style = MaterialTheme.typography.titleSmall,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                StyledText(
                    text = stringResource(R.string.strengths),
                    withExtras = true,
                    traits = stringArrayResource(strengths),
                    textDecoration = TextDecoration.Underline,
                    maxLines = 4,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                )
                StyledText(
                    text = stringResource(R.string.shadows),
                    withExtras = true,
                    textDecoration = TextDecoration.Underline,
                    traits = stringArrayResource(shadows),
                    maxLines = 4,
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                )
            }

            StyledText(
                text = stringResource(R.string.info),
                style = MaterialTheme.typography.labelSmall,
                color = onSurfaceVariant,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 8.dp)
            )
        }
    }
}


@Composable
fun StyledText(
    modifier: Modifier = Modifier,
    text: String? = null,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    traits: Array<String>? = null,
    withExtras: Boolean = false,
    maxLines: Int = 2,
    fontWeight: FontWeight = FontWeight.Bold,
    fontStyle: FontStyle = FontStyle.Italic,
    textDecoration: TextDecoration = TextDecoration.None,
    color: Color = onSurface,
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = fontWeight,
                fontStyle = fontStyle,
                textDecoration = textDecoration,
            )
        ) {
            append(text)
            if (withExtras) {
                append(": ")
            }
        }
        if (withExtras) {
            append(" \n- ")
            append(traits?.joinToString("\n- "))
        }
    }

    Text(
        text = annotatedString,
        style = style,
        maxLines = maxLines,
        modifier = modifier,
        color = color,
    )
}


@Preview(showBackground = true)
@Composable
fun PreviewArtworkSpaceScreen() {
    ArtworkSpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArtworkSpaceScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFullScreenImage() {
    val galleryItem = DataSource.loadGallery()
    val categories = stringArrayResource(R.array.categories)


    with(galleryItem[7]) {
        FullScreenImage(
            category = categories[this.categoryIndex],
            title = this.titleRes,
            image = this.imageRes,
            strengths = this.strengthsRes,
            shadows = this.shadowsRes,
            analysis = this.analysis,
            contentDescription = this.contentDescriptionRes,
            onShowImageFullscreenChange = {  },
        )
    }
}