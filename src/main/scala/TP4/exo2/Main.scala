package TP4.exo2

import scala.io.Source.fromFile;

object Main {

  def main(args: Array[String]): Unit = {
    val employees = fromFile("/Users/zainzafar/Desktop/Data/Projects/IntelliJ/TP1_Scala/src/main/scala/TP4/exo2/employes.txt")
      .getLines()
      .map(_.split(","))
      .map(e => Employee(e(0).toInt, e(2), e(1), e(3).toInt))
      .toList

    // 1. Afficher les employes
    employees.foreach(println)


    for (e <- employees) {
      println("Countx of " + e.nom + " is " + employees.count(em => em.num_empl == e.num_empl))

    }


    // remove duplicates
    val employees2 = employees.distinct
    // remove duplicates using a set
    val employees3 = employees.toSet.toList
    // remove duplicates using filter
    val employees5 = employees.filter(e => employees.indexOf(e) == employees.lastIndexOf(e))

  }

}
