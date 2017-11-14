package solution.sushi

import exercise.Exercise
import kotlin.concurrent.thread

object ThreadedSushi: Exercise {

    suspend override fun doTheThings() {
        println("Let's make some Sushi! ${Thread.currentThread()}")

        val riceThread = thread { cookRice() }
        val vegeThread = thread { prepareVegetables() }
        val fishThread = thread { prepareFish() }
        riceThread.join()
        vegeThread.join()
        fishThread.join()
        rollTheSushi()

        println("Bon Appétit! ${Thread.currentThread()}")
    }

    fun cookRice() {
        println("Starting cooking rice 🍚  on Thread ${Thread.currentThread().id}")
        Thread.sleep(RxSushi.LONG_TIME)
        println("Rice cooked 🍚  on Thread ${Thread.currentThread().id}")
    }

    fun prepareVegetables() {
        println("Starting to prepare vegetables 🥒  on Thread ${Thread.currentThread().id}")
        Thread.sleep(RxSushi.NOT_SO_LONG)
        println("Vegetables ready 🥒  on Thread ${Thread.currentThread().id}")
    }

    fun prepareFish() {
        println("Starting to prepare fish 🐟  on Thread ${Thread.currentThread().id}")
        Thread.sleep(RxSushi.NOT_SO_LONG)
        println("Fish ready 🐟  on Thread ${Thread.currentThread().id}")
    }

    fun rollTheSushi() {
        Thread.sleep(RxSushi.SHORT_TIME)
        println("Sushi rolled 🍣  on Thread ${Thread.currentThread().id}")
    }

}