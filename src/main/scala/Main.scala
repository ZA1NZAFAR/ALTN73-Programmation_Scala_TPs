import java.util.Scanner

object Main {
  def E1(): Unit = {
    //    Exercice 1: Ecrire un programme Scala qui permet à l'utilisateur de saisir , au clavier, un montant en euro,
    // Convertir ce montant en dollar.
    val sc = new Scanner(System.in)
    println("Entrer le montant en euro : ")
    val montant = sc.nextDouble()
    val dollar = montant * 1.1
    println("Le montant en dollar est : " + dollar)
  }

  def E2(): Unit = {
    //Exercice 2: Ecrire un programme qui permet à l'utilisateur de saisir, au clavier, un nombre compris entre 1
    //et 7, afficher le jour de semaine qui correspond à la valeur saisie.
    val sc = new Scanner(System.in)

    println("Entrer un nombre entre 1 et 7 : ")
    val jour = sc.nextInt()

    jour match {
      case 1 => println("Lundi")
      case 2 => println("Mardi")
      case 3 => println("Mercredi")
      case 4 => println("Jeudi")
      case 5 => println("Vendredi")
      case 6 => println("Samedi")
      case 7 => println("Dimanche")
      case _ => println("Erreur")
    }
  }

  def E3(): Unit = {
    //    Exercice 3: Demander à l'utilisateur de saisir un entier, faire un compte à rebours à partir du nombre donné
    //par l'utilisateur jusqu'à 0.
    val sc = new Scanner(System.in)

    println("Entrer un nombre : ")
    val nombre = sc.nextInt()
    for (i <- nombre to 0 by -1) {
      println(i)
    }
  }

  def E4(): Unit = {
    //Exercice 4: Afficher les tables de multiplication des entiers entre 1 et 10

    for (i <- 1 to 10; j <- 1 to 10) {
      println(i + " * " + j + " = " + i * j)
    }
  }

  def E5(): Unit = {
    //    Exercice 5: Afficher la table de multiplication des entiers entre 1 et 10 sauf la table de 5
    for (i <- 1 to 10; j <- 1 to 10; if i != 5) {
      println(i + " * " + j + " = " + i * j)
    }
  }

  def E6(): Unit = {
    //    Exercice 6: Soit la liste de valeurs [3, 5, 6, 8, 9, 2, 1, 12, 18, 17, 32]
    //Ecrire un programme qui permet de retourner le reste de la division de chaque nombre sur 3

    val liste = List(3, 5, 6, 8, 9, 2, 1, 12, 18, 17, 32)
    val res = for (i <- liste) yield i % 3
    println(res)
  }

  def E7(): Unit = {
    //    Exercice 7: Calculatrice: écrire un programme qui demande à l'utilisateur de saisir deux nombres entiers et
    //un opérateur (+, *, -, /, %) et de calculer le résultat de l'opération constitué de l'opérateur saisi et des deux
    //entiers.
    // Gérer le cas de saisi d'un opérateur en dehors de ceux donnés dans l'énoncé
    // Gérer le cas de division par zéro.

    val sc = new Scanner(System.in)

    println("Entrer le premier nombre : ")
    val nombre1 = sc.nextInt()
    println("Entrer le deuxième nombre : ")
    val nombre2 = sc.nextInt()
    println("Entrer l'opérateur : ")
    val operateur = sc.next()

    operateur match {
      case "+" => println(nombre1 + nombre2)
      case "-" => println(nombre1 - nombre2)
      case "*" => println(nombre1 * nombre2)
      case "/" => if (nombre2 == 0) println("Erreur") else println(nombre1 / nombre2)
      case "%" => println(nombre1 % nombre2)
      case _ => println("Erreur")
    }
  }

  def E8(): Unit = {
    //    Exercice 8: Ecrire un programme qui demande à l'utilisateur de saisir un nombre entre 1 et 20 et déterminer
    //si ce dernier est paire ou impaire.

    val sc = new Scanner(System.in)

    println("Entrer un nombre entre 1 et 20 : ")
    val nombre3 = sc.nextInt()
    if (nombre3 >= 1 && nombre3 <= 20) {
      if (nombre3 % 2 == 0) println("Paire") else println("Impaire")
    } else {
      println("Erreur")
    }
  }

  def E9(): Unit = {
    //    Exercice 9: Ecrire un programme qui demande à l'utilisateur de saisir un entier et de vérifier s'il est un
    //nombre premier ou pas.
    val sc = new Scanner(System.in)

    println("Entrer un nombre : ")
    val nombre4 = sc.nextInt()
    var i = 2
    var estPremier = true
    while (i < nombre4 && estPremier) {
      if (nombre4 % i == 0) estPremier = false
      i += 1
    }

    if (estPremier) println("Nombre premier") else println("Nombre non premier")

  }

  def E10(): Unit = {
    //    Exercice 10: Dans l’intervalle des nombre entiers de 100 à 500, il existe uniquement quatre nombres dont la
    //somme des cubes des chiffres le composant est égale au nombre lui-même.
    //Exemple : 153 = 13 + 53 + 33
    // Ecrire un programme en Scala qui permet de retrouver ces 4 nombres

    for (i <- 100 to 500) {
      var somme = 0
      var nombre = i
      while (nombre > 0) {
        somme += Math.pow(nombre % 10, 3).toInt
        nombre /= 10
      }
      if (somme == i) println(i)
    }
  }

  def E11(): Unit = {
    //    Exercice 11: On appelle un nombre dont la somme de tous ses diviseurs, excepté lui-même, est égale au
    //nombre lui-même par un nombre Parfait.
    //Example de nombre parfait : 6
    // Ecrire un programme Scala qui permet de verifier si un nombre est parfait.

    val sc = new Scanner(System.in)

    println("Entrer un nombre : ")
    val nombre5 = sc.nextInt()
    var somme = 0
    for (i <- 1 until nombre5) {
      if (nombre5 % i == 0) somme += i
    }
    if (somme == nombre5) println("Nombre parfait") else println("Nombre non parfait")

  }

  def E12(): Unit = {
    //    Exercice 12: Création d’un mot de passe.
    // Ecrire un programme qui demande à un utilisateur de créer un mot de passe.
    //Il faut lui demander tant que les conditions suivantes ne sont pas respectées:
    //• Une majuscule
    //• Un caract re spécial.
    //• Un chiffre
    //• Entre 5 et 8 caractères
    // Une fois correcte, lui demander de le rentrer une deuxième fois pour confirmation. Si les deux saisies
    //sont différentes, recommencer depuis le point 1.

    val sc = new Scanner(System.in)
    var motDePasse = ""
    var majuscule = false
    var caractereSpecial = false
    var chiffre = false
    var taille = false

    do {
      println("Entrer un mot de passe : ")
      motDePasse = sc.next()
      for (i <- 0 until motDePasse.length) {
        if (motDePasse.charAt(i) >= 'A' && motDePasse.charAt(i) <= 'Z') majuscule = true
        if (motDePasse.charAt(i) == '!' || motDePasse.charAt(i) == '@' || motDePasse.charAt(i) == '#' || motDePasse.charAt(i) == '$' || motDePasse.charAt(i) == '%' || motDePasse.charAt(i) == '^' || motDePasse.charAt(i) == '&' || motDePasse.charAt(i) == '*' || motDePasse.charAt(i) == '(' || motDePasse.charAt(i) == ')') caractereSpecial = true
        if (motDePasse.charAt(i) >= '0' && motDePasse.charAt(i) <= '9') chiffre = true
        if (motDePasse.length >= 5 && motDePasse.length <= 8) taille = true
      }
    } while (!majuscule || !caractereSpecial || !chiffre || !taille)
  }

  def main(args: Array[String]): Unit = {
    E1()
    E2()
    E3()
    E4()
    E5()
    E6()
    E7()
    E8()
    E9()
    E10()
    E11()
    E12()
  }
}