import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/*
    https://www.wikihow.com/Make-a-Sushi-Roll
    Steps:
    1. Cook your rice in your rice cooker
    2. Chop and prepare your vegetables and fish
    3. Put the nori on the bamboo mat shiny side down
    4. Once the rice is ready mix it with rice vinegar
    5. Spread the rice on your nori. Add vegetables and fish
    6. Roll the sushi with the bamboo mat
 */

fun main(args: Array<String>) {
    runBlocking {
        val time = measureTimeMillis {
            println("Let's make some Sushi!")
            val riceJob = cookRice()
            prepareVegetables()
            prepareFish()
            riceJob.join()
            rollTheSushi()
            println("Bon Appétit!")
        }
        println("Total time $time")
    }
}

const val LONG_TIME = 15000L
const val NOT_SO_LONG = 2000L
const val SHORT_TIME = 1000L

suspend fun cookRice(): Job {
    return launch {
        println("Starting cooking rice 🍚")
        delay(LONG_TIME)
        println("Rice cooked 🍚! Thread ${Thread.currentThread().id}")
    }
}

suspend fun prepareVegetables() {
    println("Starting to prepare vegetables 🥒")
    delay(NOT_SO_LONG)
    println("Vegetables ready 🥒! Thread ${Thread.currentThread().id}")
}

suspend fun prepareFish() {
    println("Starting to prepare fish 🐟")
    delay(NOT_SO_LONG)
    println("Fish ready 🐟! Thread ${Thread.currentThread().id}")
}

suspend fun rollTheSushi() {
    delay(SHORT_TIME)
    println("Sushi rolled! 🍣 Thread ${Thread.currentThread().id}")
}