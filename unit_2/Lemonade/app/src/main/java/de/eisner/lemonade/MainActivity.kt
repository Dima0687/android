package de.eisner.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.eisner.lemonade.ui.theme.LemonadeTheme

enum class LemonStage {
    TREE, SQUEEZE, DRINK, RESTART
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeScreen(
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
fun LemonadeScreen(modifier: Modifier = Modifier) {
    ImageButtonAndText(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ImageButtonAndText(modifier: Modifier = Modifier) {
    var stage by remember { mutableStateOf(LemonStage.TREE) }
    var doTaps by remember() { mutableIntStateOf( (2..4).random()) }
    val images = listOf (
            R.drawable.lemon_tree to R.string.lemon_tree_content_description,
            R.drawable.lemon_squeeze to R.string.lemon_content_description,
            R.drawable.lemon_drink to R.string.glass_of_lemonade_content_description,
            R.drawable.lemon_restart to R.string.empty_glass_content_description,
    )
    val (image, description) = images[stage.ordinal]

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                when (stage) {
                    LemonStage.TREE -> stage = LemonStage.SQUEEZE
                    LemonStage.SQUEEZE -> if (doTaps > 0) doTaps-- else stage = LemonStage.DRINK
                    LemonStage.DRINK -> stage = LemonStage.RESTART
                    LemonStage.RESTART -> {
                        stage = LemonStage.TREE
                        doTaps = (2..4).random()
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(0xFFC3ECD2)
            ),
            shape = RoundedCornerShape(32.dp),
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(description),
            )
        }
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        Text(
            text = stringResource(description),
            color = Color.Black,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeScreenPreview() {
    LemonadeTheme {
        LemonadeScreen()
    }
}