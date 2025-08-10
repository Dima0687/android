package de.eisner.superhero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import de.eisner.superhero.data.HeroesRepository
import de.eisner.superhero.ui.screens.HeroList
import de.eisner.superhero.ui.screens.HeroTopAppBar
import de.eisner.superhero.ui.theme.SuperheroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroTheme {
                Scaffold(
                    topBar = {
                        HeroTopAppBar()
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HeroList(
                        heroes = HeroesRepository.heroes,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

