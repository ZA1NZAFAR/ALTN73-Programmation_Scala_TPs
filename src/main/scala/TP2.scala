object TP2 {

  //  Exercice 01
  //o Créer un tableau de N String , remplir le tableau avec des
  //chaines de caractères en minuscule
  //o Afficher le tableau
  //o Transformer les éléments du tableau en majuscule
  def E1(size: Int): Unit = {
    val tab = new Array[String](size)
    for (i <- 0 until size)
    // une chaine aleatoire de 3 caracteres
      tab(i) = (Math.random() * 26 + 'a'.toInt).toChar + "" + (Math.random() * 26 + 'a'.toInt).toChar + "" + (Math.random() * 26 + 'a'.toInt).toChar

    println("Affichage du tableau : ")
    for (i <- 0 until size)
      println(tab(i))

    println("Affichage du tableau en majuscule : ")
    for (i <- 0 until size) {
      println(tab(i).toUpperCase())
    }
  }


  // Exercice 02
  //o Créer et initialiser un tableau de N entier
  //o Lever au carré de chaque élément.
  //Exemple :
  //4 5 2 3 7 1 6
  //16 25 4 9 49 1 36

  def carre(x: Int) = x * x

  def E2(array: Array[Int]): Array[Int] = {
    println("Affichage du tableau : ")
    for (i <- array.indices)
      println(array(i))

    val res = (for (i <- array.indices) yield carre(array(i))).toArray

    println("Affichage du tableau au carre : ")
    for (i <- res.indices)
      println(res(i))

    res
  }


  // Exercices 03
  //Soit le tableau à deux dimensions suivant :
  //2 6 3 23 12 11 7 33 18 24 43
  //44 21 27 34 1 10 15 17 19 27 4
  //A partir de ce tableaux, créer deux nouveaux tableaux, le premier
  //contiendra les nombre paires et le deuxième les nombre impaires.

  def E3(array: Array[Array[Int]]): Unit = {
    println("Affichage du tableau : ")
    for (i <- array.indices) {
      for (j <- array(i).indices) {
        print(array(i)(j) + " ")
      }
      println()
    }

    val res = (for (i <- array.indices; j <- array(i).indices if array(i)(j) % 2 == 0) yield array(i)(j)).toArray
    val res2 = (for (i <- array.indices; j <- array(i).indices if array(i)(j) % 2 != 0) yield array(i)(j)).toArray

    println("Affichage du tableau des nombres paires : ")
    for (i <- res.indices)
      print(res(i) + " ")
    println()
    println("Affichage du tableau des nombres impaires : ")
    for (i <- res2.indices)
      print(res2(i) + " ")
  }

  //Exercice 05
  //o Ecrire un programme scala qui permet de vérifier si deux
  //tableaux sont identiques.
  def E5(array1: Array[Int], array2: Array[Int]): Boolean = {
    if (array1.length != array2.length)
      return false
    for (i <- array1.indices)
      if (array1(i) != array2(i))
        return false
    true
  }

  //Exercice 06
  //o Soit L une liste à N entier, écrire un programme scala qui
  //permet de trier les éléments de la liste dans un ordre
  //décroissant.
  //o Trier ensuite la liste dans un ordre croissant.

  //sort a list in descending order
  def sortDescending(list: List[Int]): List[Int] = {
    var l = list
    for (i <- 0 until l.length - 1) {
      for (j <- i + 1 until l.length) {
        if (l(i) < l(j)) {
          val tmp = l(i)
          l = l.updated(i, l(j))
          l = l.updated(j, tmp)
        }
      }
    }
    l
  }
  def E6(list: List[Int]): Unit = {
    println("Affichage de la liste : ")
    for (i <- list.indices)
      print(list(i) + " ")
    println()

    val res = sortDescending(list)
    println("Affichage de la liste triee dans l'ordre decroissant : ")
    for (i <- res.indices)
      print(res(i) + " ")
    println()

    val res2 = res.reverse
    println("Affichage de la liste triee dans l'ordre croissant : ")
    for (i <- res2.indices)
      print(res2(i) + " ")
    println()
  }

  //Exercice 07
  //Soit L1 une liste contenant des listes imbriqués:
  // val L1 = "Vert" :: ("Rouge" :: ("orange" :: "Noir"))
  //Afficher la couleur « orange »
  //Supprimer la couleur « Noir «
  //Soit L2 une autre liste :
  // val L2 = "Marron" :: "Beige" :: "Blanc" :: "Noir"
  //Fusionner les deux listes et afficher le résultat.

  def E7(): Unit = {
    val L1 = "Vert" :: ("Rouge" :: ("orange" :: "Noir" :: Nil))
    println("Affichage de la liste L1 : ")
    for (i <- L1.indices)
      print(L1(i) + " ")
    println()

    println("Affichage de la couleur orange : ")
    println(L1.tail.tail.head)

    println("Affichage de la liste L1 la couleur noir : ")
    println(L1.tail.tail.tail)

    val L2 = "Marron" :: "Beige" :: "Blanc" :: "Noir" :: Nil
    println("Affichage de la liste L2 : ")
    for (i <- L2.indices)
      print(L2(i) + " ")


    val res = L1 ::: L2
    println("Affichage de la liste L1 et L2 fusionnees : ")
    for (i <- res.indices)
      print(res(i) + " ")
  }

  // Exercice 08
  //- Soit L1 une liste de caractères, concaténer les éléments de la liste
  //pour obtenir une chaine de caractères.
  def E8(list: List[Char]): String = {
    println("Affichage de la liste : ")
    for (i <- list.indices)
      print(list(i) + " ")
    println()

    val res = list.mkString
    println("Affichage de la liste concatenee : \n" + res)
    res
  }

  // Exercice 09
  //- Soit E un ensemble d’entiers, écrire un programme qui supprime
  //de E tous les nombres premiers.
  def isPrime(n: Int): Boolean = {
    println("Entrer un nombre : ")
    var i = 2
    var estPremier = true
    while (i < n && estPremier) {
      if (n % i == 0) estPremier = false
      i += 1
    }
    estPremier
  }

  def E9(array: Array[Int]): Unit = {
    println("Affichage de l'ensemble : ")
    for (i <- array)
      print(i + " ")
    println()

    val res = array.filter(x => !isPrime(x))
    println("Affichage de l'ensemble sans les nombres premiers : ")
    for (i <- res)
      print(i + " ")
    println()
  }


  //Exercice 10
  //- Soit L une liste des étudiants :
  //- « Natacha » ::« Steven » :: « Alia » :: « Marie » :: « Paul » :: « Roger
  //» :: « Anna »
  //- Transformer cette liste en une Map, tel que les clés sont des
  //valeurs allant de 1 à n (avec n le nombre d’élements dans la liste)

  def E10(list: List[String]): Map[Int,String] = {
    println("Affichage de la liste : ")
    for (i <- list.indices)
      print(list(i) + " ")
    println()

    val res = list.zipWithIndex.map(x => (x._2, x._1)).toMap
    println("Affichage de la liste transformee en map : ")

    for (i <- res)
      print(i + " ")
    println()

    res
  }

  //Exercice 11
  //- Soit la liste L1 des étudiants :
  //- « Natacha » ::Steven » :: « Alia » :: « Marie » :: « Paul » :: « Roger »
  //:: « Anna »
  //- Soit L2, une liste des moyennes de ces étudiants dans l’ordre
  //- 12.4 :: 16 :: 14.5 :: 9.87 :: 13:: 7.4 :: 18.45
  //- Créer une MAP à partir des deux listes L1 et L2 tel que les clés sont
  //les noms des étudiants et les valeurs sont leurs moyennes.
  //- Modifier la MAP créée pour garder uniquement les étudiants ayant
  //une moyenne supérieur ou égale à 10.

  def E11(list1: List[String], list2: List[Double]): Map[String,Double] = {
    println("Affichage de la liste 1 : ")
    for (i <- list1.indices)
      print(list1(i) + " ")
    println()

    println("Affichage de la liste 2 : ")
    for (i <- list2.indices)
      print(list2(i) + " ")
    println()

    var res = list1.zip(list2).toMap
    println("Affichage de la liste 1 et 2 transformee en map : ")

    for (i <- res)
      print(i + " ")
    println()

    res = res.filter(x => x._2 >= 10)
    println("Affichage de la liste 1 et 2 transformee en map avec les etudiants ayant une moyenne superieure ou egale a 10 : ")

    for (i <- res)
      print(i + " ")
    println()

    res
  }

  // Exercice 12
  //- Ecrire en langage scala une fonction qui calcul la factoriel d’un
  //nombre

  def E12(n: Int): Int = {
    if (n == 0) 1
    else n * E12(n - 1)
  }

  // Exercice 13
  //- Ecrire une fonction qui prend en paramètre une Liste d’entiers et
  //qui retourne le maximum.

  def E13(list: List[Int]): Int = {
    var max = list.head
    for (i <- list.indices)
      if (list(i) > max) max = list(i)
    max
  }

//  Exercice 14
  //- Ecrire une fonction qui prend en paramètre une liste d’entiers L et
  //qui retourne une nouvelle liste L1 contenant le carré des nombres
  //paires de L1.

  def E14(list: List[Int]): List[Int] = {
    (for (i <- list.filter(x=>x%2==0).indices) yield i*i).toList
  }

//  Exercice 15
  //Ecrire une fonction qui prend en paramètre une liste d’entiers et qui
  //calcul la moyenne.
  def E15(list: List[Int]): Double = {
    var sum = 0
    for (i <- list.indices)
      sum += list(i)
    sum / list.length
  }

  // Exercice 16 (utiliser la fonction map)
  //Soit la liste suivante dont les éléments représentent des
  //enregistrements fictifs de températures avec format (N° station, année,
  //mois, température, code_departement)
  //val listeTemp = List("7,2010,04,27,75", "12,2009,01,31,78",
  //"41,2009,03,25,95", "2,2008,04,28,76", "7,2010,02,32,91")
  //Calculer la température maximale de l’année 2009
  //▪ Calculer la température moyenne de l’année 2009

  def E16(): Unit ={
    val listeTemp = List("7,2010,04,27,75", "12,2009,01,31,78", "41,2009,03,25,95", "2,2008,04,28,76", "7,2010,02,32,91")
    val res = listeTemp.map(x => x.split(",")).filter(x => x(1) == "2009").map(x => x(3).toInt).max
    println("La temperature maximale de l'annee 2009 est : " + res)
    val res2 = listeTemp.map(x => x.split(",")).filter(x => x(1) == "2009").map(x => x(3).toInt).sum / listeTemp.map(x => x.split(",")).filter(x => x(1) == "2009").map(x => x(3).toInt).length
    println("La temperature moyenne de l'annee 2009 est : " + res2)
  }

  def main(args: Array[String]): Unit = {
    E1( 5)
    E2( Array(1,2,3,4,5,6,7,8,9,10))
    E3(Array(Array(2,6,3,23,12,11,7,33,18,24,43), Array(44,21,27,34,1,10,15,17,19,27,4)))
    println(E5( Array(1,2,3,4,5,6,7,8,9,10), Array(1,2,3,4,5,6,7,8,9,10)))
    E6(List(44,21,27,34,1,10,15,17,19,27,4))
    E7()
    E8(List('a','d','f'))
    E9(Array(1,2,3,4,5,6,7,8,9,10))
    E10(List("Natacha", "Steven", "Alia", "Marie", "Paul", "Roger", "Anna"))
    E11(List("Natacha", "Steven", "Alia", "Marie", "Paul", "Roger", "Anna"), List(12.4, 16, 14.5, 9.87, 13, 7.4, 18.45))
    println(E12(5))
    println(E13(List(1, 2, 3, 2433, 4, 5, 6, 7, 8, 9, 10)))
    println(E14(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    E15(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    E16()

  }

}
