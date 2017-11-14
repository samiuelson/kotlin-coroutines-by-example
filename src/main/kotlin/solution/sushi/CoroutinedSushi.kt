package solution.sushi

import exercise.Exercise
import kotlinx.coroutines.experimental.*

/**
 *
 * Sushi Exercise.
 *
 * Steps to make sushi:
 * 1. Cook rice. It takes @see {VERY_LONG} time.
 * 2. Prepare vegetables. It takes @see {NOT_SO_LONG}
 * 3. Prepare fish. It takes @see {NOT_SO_LONG}
 * 4. Roll the sushi once the rice is ready. It takes @see {SHORT_TIME}
 *
 * Additional constraints:
 * Unfortunately you are have to go out in 8_000L millis to pickup children from school.
 * Make sure to cancel sushi job before going out.
 *
 */
object CoroutinedSushi : Exercise {

    override suspend fun doTheThings() {
        println("Let's make some Sushi! ${Thread.currentThread()}")

        val context = newSingleThreadContext("sushi")
//        run {
//            val riceJob = launch(context) { cookRice() }
//            launch(context) { prepareVegetables() }
//            launch(context) { prepareFish() }
//            riceJob.join()
//            rollTheSushi()
//            run { println("Bon Appétit! ${Thread.currentThread()}")}
//        }
            val j = launch(context) {
                val job = launch(context) { cookRice() }
                prepareVegetables()
                prepareFish()
                job.join()
                rollTheSushi()
            }
            j.join()
    }

    const val LONG_TIME = 10_000L
    const val NOT_SO_LONG = 2_000L
    const val SHORT_TIME = 1_000L

    suspend fun cookRice() {
        println("Starting cooking rice 🍚  on Thread ${Thread.currentThread().id}")
//        delay(LONG_TIME)
        Thread.sleep(LONG_TIME)
        println("Rice cooked 🍚  on Thread ${Thread.currentThread().id}")
    }

    suspend fun prepareVegetables() {
        println("Starting to prepare vegetables 🥒  on Thread ${Thread.currentThread().id}")
        delay(NOT_SO_LONG)
        println("Vegetables ready 🥒  on Thread ${Thread.currentThread().id}")
    }

    suspend fun prepareFish() {
        println("Starting to prepare fish 🐟  on Thread ${Thread.currentThread().id}")
        delay(NOT_SO_LONG)
        println("Fish ready 🐟  on Thread ${Thread.currentThread().id}")
    }

    suspend fun rollTheSushi() {
        delay(SHORT_TIME)
        println("Sushi rolled 🍣  on Thread ${Thread.currentThread().id}")
    }
}
