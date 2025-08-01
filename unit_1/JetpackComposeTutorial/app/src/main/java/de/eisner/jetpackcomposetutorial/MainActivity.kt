package de.eisner.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.eisner.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JetpackComposeTutorialScreen(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun JetpackComposeTutorialScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Banner(
            image = painterResource(R.drawable.bg_compose_background),
            modifier = Modifier.fillMaxWidth()
        )
        Heading(
            text = stringResource(R.string.heading),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Paragraph(
            text = stringResource(R.string.first_paragraph),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify,
        )
        Paragraph(
            text = stringResource(R.string.second_paragraph),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Banner(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun Heading(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
    )
}

@Composable
fun Paragraph(
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    textAlign: TextAlign? = null,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = modifier,
        textAlign = textAlign,
    )
}

@Composable
@Preview(
    showBackground = true
)
fun JetpackComposeTutorialTheme() {
    JetpackComposeTutorialScreen()
}