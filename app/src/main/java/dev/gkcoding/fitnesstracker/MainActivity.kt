package dev.gkcoding.fitnesstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dev.gkcoding.fitnesstracker.ui.FitnessTrackerApp
import dev.gkcoding.fitnesstracker.ui.theme.GKFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GKFitnessTheme {
                FitnessTrackerApp()
            }
        }
    }
}
