package de.eisner.thirtydaysapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import de.eisner.thirtydaysapp.R
import de.eisner.thirtydaysapp.data.AffirmationRepository
import de.eisner.thirtydaysapp.model.Affirmation
import de.eisner.thirtydaysapp.ui.theme.Shape
import de.eisner.thirtydaysapp.ui.theme.ThirtyDaysAppTheme
import java.time.LocalDate


@Composable
fun ThirtyDaysApp(modifier: Modifier = Modifier) {
    val today = LocalDate.now().dayOfMonth
    val affirmations = AffirmationRepository.affirmations
    val initialIndex = (today - 1).coerceIn(0, affirmations.lastIndex)
    var affirmationIndex by remember { mutableIntStateOf(initialIndex) }
    var isDialogVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                isDialogVisible = isDialogVisible,
                onIsDialogVisibleChange = { isDialogVisible = it }
            )
        },
        modifier = Modifier.fillMaxSize()
            .then(modifier),
    ) { innerPadding ->
        ThirtyDaysAppScreen(
            affirmationIndex = affirmationIndex,
            affirmations = affirmations,
            isDialogVisible = isDialogVisible,
            onAffirmationIndexChange = { affirmationIndex = it },
            onIsDialogVisibleChange = { isDialogVisible = it },
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
fun ThirtyDaysAppScreen(
    affirmationIndex: Int,
    affirmations: List<Affirmation>,
    onAffirmationIndexChange: (Int) -> Unit,
    onIsDialogVisibleChange: (Boolean) -> Unit,
    isDialogVisible: Boolean,
    modifier: Modifier = Modifier
) {
    val selectedAffirmation = affirmations[affirmationIndex.coerceIn(0, affirmations.lastIndex)]

    Box(
        modifier = Modifier
            .then(modifier)
    ) {
        if (isDialogVisible) {
            AffirmationPicker(
                onAffirmationIndexChange = onAffirmationIndexChange,
                onIsDialogVisibleChange = onIsDialogVisibleChange,
                affirmations = affirmations,
                modifier = Modifier
            )
        }

        AffirmationCard(
            affirmation = selectedAffirmation,
        )
    }
}

@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
            .then(modifier),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(affirmation.dayResId),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = Shape.medium
                    )
                    .border(2.dp, MaterialTheme.colorScheme.primary, Shape.medium)
                    .clip(Shape.medium)
            ) {
                Image(
                    painter = painterResource(affirmation.imageId),
                    contentDescription = if (affirmation.imageDescription == null) null
                    else stringResource(affirmation.imageDescription)
                )
            }

            Spacer(Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colorScheme.surfaceContainerHigh,
                        shape = Shape.medium,
                    )
                    .border(2.dp, color = MaterialTheme.colorScheme.primary, Shape.medium)
                    .fillMaxWidth()
                    .height(150.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = stringResource(affirmation.textId),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    isDialogVisible: Boolean,
    onIsDialogVisibleChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displayLarge
            )
        },
        actions = {
            IconButton(
                onClick = { onIsDialogVisibleChange(!isDialogVisible) },
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                )
            ) {
                Icon(
                    imageVector = if (isDialogVisible)
                        Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = stringResource(R.string.affirmation_picker),
                )
            }
        },
        modifier = Modifier
            .then(modifier),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        )
    )
}

@Composable
fun AffirmationPicker(
    onAffirmationIndexChange: (Int) -> Unit,
    onIsDialogVisibleChange: (Boolean) -> Unit,
    affirmations: List<Affirmation>,
    modifier: Modifier = Modifier,
) {
    val gridCells = 2
    Dialog(
        onDismissRequest = { onIsDialogVisibleChange(false) },
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
        )
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxHeight(.8f)
                .then(modifier)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .height(52.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                TextButton(
                    onClick = {
                        onAffirmationIndexChange(LocalDate.now().dayOfMonth - 1)
                        onIsDialogVisibleChange(false)
                    },
                    modifier = Modifier.fillMaxHeight()
                        .padding(4.dp),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                ) {
                    Text(
                        text = "Reset",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                IconButton(
                    onClick = { onIsDialogVisibleChange(false) },
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(4.dp),
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_affirmation_picker),
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(gridCells),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.Center,
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
                    )
                    .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)),
            ) {
                itemsIndexed(
                    affirmations,
                ) { index, item ->
                    val shape = getRoundedCorner(index, affirmations.size, gridCells)

                    ListItem(
                        shadowElevation = 4.dp,
                        headlineContent = {
                            Text(
                                text = stringResource(item.dayResId),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                            )
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(2.dp)
                            .clickable {
                                onAffirmationIndexChange(index)
                                onIsDialogVisibleChange(false)
                            }
                            .clip(shape),
                        colors = ListItemDefaults.colors(
                            containerColor = MaterialTheme.colorScheme.surface,
                            headlineColor = MaterialTheme.colorScheme.onSurface,
                        ),
                    )
                }
            }
        }
    }
}

fun getRoundedCorner(index: Int, size: Int, gridCells: Int): RoundedCornerShape {
    val rowCount = (size + 1) / gridCells
    val rowIndex = index / gridCells
    val isFirstRow = rowIndex == 0
    val isLastRow = rowIndex == rowCount - 1
    val isLeftColumn = index % 2 == 0

    return when {
        isFirstRow && isLeftColumn -> RoundedCornerShape(topStart = 16.dp)
        isFirstRow -> RoundedCornerShape(topEnd = 16.dp)
        isLastRow && isLeftColumn -> RoundedCornerShape(bottomStart = 16.dp)
        isLastRow -> RoundedCornerShape(bottomEnd = 16.dp)
        else -> RoundedCornerShape(0.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun ThirtyDaysAppPreview() {
    ThirtyDaysAppTheme {
        ThirtyDaysApp()
    }
}