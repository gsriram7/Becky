package service

import java.util.concurrent.ScheduledThreadPoolExecutor

import broker.MessageBroker

class Subscriber {

  private val executor = new ScheduledThreadPoolExecutor(10)

  println("Subscriber started")

  executor.execute(new Runnable {
    override def run(): Unit = {
      while (true) {
        val student = MessageBroker.poll()
        println(student.v)
      }
    }
  })

}
