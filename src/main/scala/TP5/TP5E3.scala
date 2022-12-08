package TP5

import java.util
import scala.collection.convert.ImplicitConversions.`map AsScala`
import scala.io.Source.fromFile

object TP5E3 {
  def main(args: Array[String]): Unit = {
    // Exercice 5
    //Lire le fichier table.txt,
    //- Ecrire les tuples sous forme d’une séquence d’items. I
    //o Exemple : le premier tuple sera écrit comme suit :
    // Seq(“x1=0”, “x2=1”, “x3=2”, “x4=1”, “x5=2”, “x6=3”, “x7=4”, “x8=2”,
    //“x9=1”) (on ne prend pas en compte la première ligne du fichier)
    val table = fromFile("/Users/zainzafar/Desktop/Data/Projects/IntelliJ/TP1_Scala/src/main/scala/TP5/table.txt")
      .getLines()
      .drop(1)
      .map(_.split(" "))
      .map(x => ("x1" -> x(0), "x2" -> x(1), "x3" -> x(2), "x4" -> x(3), "x5" -> x(4), "x6" -> x(5), "x7" -> x(6), "x8" -> x(7), "x9" -> x(8)))
      .toSeq

    println("Exercice 5")
    println(table)

    //Calculer le nombre d’occurrences de chaque item dans la séquence
    //précédente, et afficher le résultat sous forme d’une Map.

    var occurences = new util.HashMap[(String, String), Int]()

    for (line <- table) {
      println("Line : " + line)
      for (item <- line.productIterator) {
        if (occurences.containsKey(item)) {
          occurences.put(item.asInstanceOf[(String, String)], occurences.get(item.asInstanceOf[(String, String)]) + 1)
        } else {
          occurences.put(item.asInstanceOf[(String, String)], 1)
        }

      }
    }

    //Afficher le résultat sous forme d’une Map.
    println("Occurences : " + occurences)

    //Dans une Liste, ordonner chaque tuple de table.txt dabs l’ordre
    //décroissant de nombres d’occurrence des items.

    val sorted = occurences.toSeq.sortBy(_._2).reverse
    println("Sorted : " + sorted)

    //Supprimer de chaque tuple les items ayant un nombre d’occurrences
    //inférieur ou égale au Smin. (on considère la valeur de Smin = 3).
    val smin = 3
    val filtered = sorted.filter(_._2 > smin)
    println("Filtered : " + filtered)

  }

}
