package TP5

import java.util
import scala.collection.convert.ImplicitConversions.`map AsScala`
import scala.io.Source.fromFile

object TP5 {

  def main(args: Array[String]): Unit = {
    //Exercice 1
    val list = List("Bonjour", "Aujourd’hui", "C’est", "La", "Fete", "Des", "Papas")
    println("Exercice 1")
    println(list)
    println(longueur(list))
    println(motPlusLongeur(list))


    // Exercice 2
    val map = Map(1 -> "un", 2 -> "Deux", 3 -> "Trois", 4 -> "Quatre", 5 -> "Cinq", 6 -> "Six")
    println("Exercice 2")
    println(map)
    println(majuscule(map))

    // Exercice 3
    val seq = 0 until 7
    println("Exercice 3")
    println(seq)
    println(seq1(seq))
    println(seq2(seq1(seq)))

    // Exercice 4
    val liste = List("10", "52", "65", "85", "96", "42", "88", "32",
      "83", "122", "823", "786", "95", "81", "87", "13", "19", "78", "65", "485", "62", "55",
      "292", "472", "712");
    println("Exercice 4")
    println(liste)
    println(liste.map(_.toInt).filter(_ % 2 == 0).sum)

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

  //Exercice 1
  //Retourner une nouvelle liste, ou chaque élément représente la longueur du mot à la même position.
  def longueur(list: List[String]): List[Int] = {
    list.map(_.length)
  }

  //Retourner une nouvelle liste, ou chaque élément est un coupe de valeurs (mot, longueur_mot).
  def motPlusLongeur(list: List[String]): List[(String, Int)] = {
    list.map(x => (x, x.length))
  }

  //Exercice 02
  //Ecrire une programme scala qui permet d’écrire les valeurs de la Map en majuscule.
  def majuscule(map: Map[Int, String]): Map[Int, String] = {
    map.map { case (x, y) => (x, y.toUpperCase) }
  }

  //Exercice 03
  //Ecrire un programme scala qui retourne une collection (vecteur)seq1, tel que
  //chaque élément est 0 until n, avec n une valeur de seq
  //i.e : (0 until 7, 1 until 7, 2 unitl 8, …)

  def seq1(seq: Seq[Int]): Seq[Seq[Int]] = {
    seq.map(_.until(8));
  }

  //Puis transformer ce vecteur en une liste de valeur composée de toutes les
  //valeurs seq1.
  //i.e : (0, 1, 2, …7, 1, 2, …7, 2, 3, …, 7, 3,…, 7, …).

  def seq2(seq: Seq[Seq[Int]]): List[Int] = {
    seq.flatten.toList
  }


}
