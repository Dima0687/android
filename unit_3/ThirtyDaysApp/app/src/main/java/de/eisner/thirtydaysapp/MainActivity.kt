package de.eisner.thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import de.eisner.thirtydaysapp.ui.screen.ThirtyDaysApp
import de.eisner.thirtydaysapp.ui.theme.ThirtyDaysAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThirtyDaysAppTheme {
                ThirtyDaysApp()
            }
        }
    }
}