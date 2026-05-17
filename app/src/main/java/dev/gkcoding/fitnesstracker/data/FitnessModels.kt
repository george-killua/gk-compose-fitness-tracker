package dev.gkcoding.fitnesstracker.data

data class Workout(val title: String, val focus: String, val duration: String, val calories: Int)
data class Habit(val label: String, val progress: Float)

val workouts = listOf(
    Workout("Strength Builder", "Upper body", "42 min", 410),
    Workout("Mobility Reset", "Flexibility", "24 min", 180),
    Workout("Core Control", "Abs + stability", "31 min", 260),
)

val habits = listOf(
    Habit("Weekly goal", 0.72f),
    Habit("Hydration", 0.58f),
    Habit("Recovery", 0.84f),
)
