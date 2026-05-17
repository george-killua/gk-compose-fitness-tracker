package dev.gkcoding.fitnesstracker.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.gkcoding.fitnesstracker.data.Habit
import dev.gkcoding.fitnesstracker.data.Workout
import dev.gkcoding.fitnesstracker.data.habits
import dev.gkcoding.fitnesstracker.data.workouts

@Composable
fun FitnessTrackerApp() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item { HeaderCard() }
            item { StatsRow() }
            item { SectionTitle("Today\'s workouts") }
            items(workouts) { workout -> WorkoutCard(workout) }
            item { SectionTitle("Habits") }
            items(habits) { habit -> HabitCard(habit) }
        }
    }
}

@Composable
private fun HeaderCard() {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), shape = RoundedCornerShape(28.dp)) {
        Column(Modifier.padding(22.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("GK", color = MaterialTheme.colorScheme.onPrimary, fontWeight = FontWeight.Black)
                }
                Spacer(Modifier.size(12.dp))
                Column {
                    Text("Fitness Tracker", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text("Compose product UI sample", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            Spacer(Modifier.height(22.dp))
            Text(
                "Track workouts, habits, calories, and weekly progress with a clean premium Android UI.",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Black,
            )
        }
    }
}

@Composable
private fun StatsRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.fillMaxWidth()) {
        StatCard("Workouts", "4", Modifier.weight(1f))
        StatCard("Calories", "850", Modifier.weight(1f))
    }
}

@Composable
private fun StatCard(label: String, value: String, modifier: Modifier) {
    Card(modifier = modifier, colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary), shape = RoundedCornerShape(22.dp)) {
        Column(Modifier.padding(18.dp)) {
            Text(label, color = MaterialTheme.colorScheme.onPrimary)
            Text(value, color = MaterialTheme.colorScheme.onPrimary, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Black)
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(text, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Black)
}

@Composable
private fun WorkoutCard(workout: Workout) {
    OutlinedCard(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        colors = CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(22.dp),
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(18.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(workout.title, fontWeight = FontWeight.Bold)
                Text(workout.focus, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(workout.duration, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Text("${workout.calories} kcal", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}

@Composable
private fun HabitCard(habit: Habit) {
    OutlinedCard(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceVariant),
        colors = CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(20.dp),
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(habit.label, fontWeight = FontWeight.Bold)
                Text("${(habit.progress * 100).toInt()}%", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Black)
            }
            Spacer(Modifier.height(10.dp))
            LinearProgressIndicator(progress = { habit.progress }, modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.primary)
        }
    }
}
