package de.eisner.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.eisner.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        message = stringResource(R.string.happy_birthday),
                        from = stringResource(R.string.from),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        GreetingBackgroundImage(
            image = painterResource(id = R.drawable.birthday_bg),
            modifier = Modifier
                .fillMaxSize()
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun GreetingBackgroundImage(image: Painter, modifier: Modifier = Modifier) {
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier,
        alpha = 1F
    )
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    val messageFontSize = dimensionResource(id = R.dimen.message_font_size)
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = with(LocalDensity.current) { messageFontSize.toSp() },
            lineHeight = 104.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = from,
            fontSize = 36.sp,
            lineHeight = 50.sp,
            color = Color.White,
            modifier = Modifier
                .padding(end = 16.dp)
                .align(alignment = Alignment.End),
        )
    }
}

@Preview(
    showBackground = true,
    name = "Happy Birthday Text"
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Greeting(
            message = stringResource(R.string.happy_birthday),
            from = stringResource(R.string.from),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}