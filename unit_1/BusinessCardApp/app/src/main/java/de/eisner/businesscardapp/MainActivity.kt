package de.eisner.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import de.eisner.businesscardapp.ui.theme.BusinessCardAppTheme
import de.eisner.businesscardapp.ui.theme.DarkBlue
import de.eisner.businesscardapp.ui.theme.DarkBlueVariant
import de.eisner.businesscardapp.ui.theme.LightBlue

val CurvedTopShape = GenericShape { size, _ ->
    moveTo(0f, 50f)

    cubicTo(
        size.width * .25f, 0f,
        size.width * .75f, 0f,
        size.width, 50f
    )

    lineTo(size.width, size.height)
    lineTo(0f, size.height)
    close()
}

val gradientBrush = Brush.linearGradient(
    colors = listOf(DarkBlue, LightBlue),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardAppScreen(
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
fun BusinessCardAppScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(gradientBrush)
    ) {
        Profile(
            modifier = Modifier
                .zIndex(2f)
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(1f)
                .fillMaxWidth()
                .height(350.dp)
                .clip(CurvedTopShape)
                .background(Color(0xFF_DD_EE_EE))
        ){}
    }
}

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier
                .padding(bottom = 92.dp)
        )
        Image(
            painter = painterResource(R.drawable.me),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(6.dp, Color.White, CircleShape)
        )
        Spacer(
            modifier = Modifier
                .padding(top = 26.dp)
        )
        Text(
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.dev_name),
            fontSize = 32.sp,
            letterSpacing = 4.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier
                .padding(top = 12.dp)
        )
        Text(
            text = stringResource(R.string.sub_title),
            fontSize = 22.sp,
            color = Color.White,
        )
        Spacer(
            modifier = Modifier
                .padding(top = 42.dp)
        )
        Text(
            text = "\u00A9 2025",
            color = Color.White,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic
        )

        Contact(
            modifier = Modifier
                .padding(top = 24.dp)
        )
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Card(
            imageVector = Icons.Default.Phone,
            text = stringResource(R.string.card_tel),
        )
        Spacer(
            modifier = Modifier
                .padding(top = 22.dp)
        )
        Card(
            imageVector = Icons.Default.Email,
            text = stringResource(R.string.card_email),
        )
        Spacer(
            modifier = Modifier
                .padding(top = 22.dp)
        )
        Card(
            imageVector = Icons.Default.LocationOn,
            text = stringResource(R.string.location),
        )
    }
}

@Composable
fun Card(imageVector: ImageVector, text: String, modifier: Modifier = Modifier) {
    val color = Color.White
    Row(
        modifier = modifier
            .width(370.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color)
            .padding(start = 18.dp, top = 18.dp, bottom = 18.dp, end = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(36.dp),
            tint = DarkBlueVariant,
        )
        Spacer(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardAppScreenPreview() {
    BusinessCardAppScreen()
}



