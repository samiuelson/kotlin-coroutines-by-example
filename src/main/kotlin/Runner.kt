import exercise.playground.Playground
import exercise.sushi.SushiExercise
import kotlinx.coroutines.experimental.runBlocking
import solution.sushi.CoroutinedSushi
import solution.sushi.RxSushi
import solution.sushi.ThreadedSushi
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    val time = measureTimeMillis {
        val exerciseName = args[0]
        exercises[exerciseName]?.doTheThings()
    }
    println("Total time: $time ms")

}

val exercises = mapOf("Sushi" to SushiExercise,
        "CoroutinedSushi" to CoroutinedSushi,
        "ThreadedSushi" to ThreadedSushi,
        "RxSushi" to RxSushi,
        "Playground" to Playground)
