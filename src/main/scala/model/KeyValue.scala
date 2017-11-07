package model

sealed trait Key[K] {
  def k: K
}
sealed trait Value[V] {
  def v: V
}

sealed trait KeyValue[K, V] extends Key[K] with Value[V]

case class Person(name: String, age: Int)

object Person {
  type name = String
}

case class Student(name: Person.name, person: Person) extends KeyValue[Person.name, Person] {
  override def v: Person = person

  override def k: Person.name = name
}