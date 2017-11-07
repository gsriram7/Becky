package broker

import java.util.concurrent.ConcurrentLinkedQueue

import model.Student

object MessageBroker {

  private val queue = new ConcurrentLinkedQueue[Student]()

  def put(kv: Student): Unit = {
    queue.add(kv)
  }

  def poll(): Student = {
    queue.poll()
  }

}
