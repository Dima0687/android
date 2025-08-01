package de.eisner.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.eisner.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeQuadrantTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ComposeQuadrantScreen(
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
fun ComposeQuadrantScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            Quadrant(
                heading = "Text composable",
                paragraph = "Display text and follows the recommended Material Design guidelines",
                color = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f),
            )
            Quadrant(
                heading = "Image composable",
                paragraph = "Creates a composable that lays out and draws a given Painter class object.",
                color = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Quadrant(
                heading = "Row Composable",
                paragraph = "A layout composable that places its children in a horizontal sequence.",
                color = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f),
            )
            Quadrant(
                heading = "Column composable",
                paragraph = "A layout composable that places its children in a vertical sequence.",
                color = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun Quadrant(heading: String, paragraph: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = heading,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = paragraph,
            textAlign = TextAlign.Justify,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantScreenPreview() {
    ComposeQuadrantScreen()
}