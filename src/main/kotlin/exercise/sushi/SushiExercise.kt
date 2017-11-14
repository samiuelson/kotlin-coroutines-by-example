package exercise.sushi

import exercise.Exercise

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


object SushiExercise : Exercise {

    override suspend fun doTheThings() {
        println("Let's make some Sushi! ${Thread.currentThread()}")

        TODO()

        println("Bon Appétit! ${Thread.currentThread()}")
    }

    const val VERY_LONG = 10_000L
    const val NOT_SO_LONG = 2_000L
    const val SHORT_TIME = 1_000L

    fun cookRice() {
        println("Starting cooking rice 🍚 on Thread ${Thread.currentThread().id}")
        Thread.sleep(VERY_LONG)
        println("Rice cooked 🍚! on Thread ${Thread.currentThread().id}")
    }

    fun prepareVegetables() {
        println("Starting to prepare vegetables 🥒 on Thread ${Thread.currentThread().id}")
        Thread.sleep(NOT_SO_LONG)
        println("Vegetables ready 🥒! on Thread ${Thread.currentThread().id}")
    }

    fun prepareFish() {
        println("Starting to prepare fish 🐟 on Thread ${Thread.currentThread().id}")
        Thread.sleep(NOT_SO_LONG)
        println("Fish ready 🐟! on Thread ${Thread.currentThread().id}")
    }

    fun rollTheSushi() {
        Thread.sleep(SHORT_TIME)
        println("Sushi rolled! 🍣 on Thread ${Thread.currentThread().id}")
    }

}