package service

import java.util.concurrent.ScheduledThreadPoolExecutor

import broker.MessageBroker
import model.{Person, Student}

import scala.util.Random

class Publisher {

  private val executor = new ScheduledThreadPoolExecutor(10)
  private val rand = Random

  println("Publisher started")

  executor.execute(new Runnable {
    override def run(): Unit = {
      while (true) {
        val name = rand.nextString(5)
        MessageBroker.put(Student(name, Person(name, rand.nextInt(75))))
      }
    }
  })

}
