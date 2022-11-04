object TP3 {

  import scala.collection.mutable.Map

  //Exercice 01
  //Créer une MAP dont les clés représentent les noms des salariés d’une division et
  //les valeurs représentent leur salaire.
  //Ecrire une fonction pure qui calcul la moyenne des salaires des employés de cette
  //division.
  val salaried_map = Map(
    "Arsène Lupin" -> 1000,
    "Louis-Ferdinand Céline" -> 500,
    "Charles Nodier" -> 1500,
    "René Chambray" -> 1400)

  def ex1(mapSalaried: Map[String, Int]): Float = {
    mapSalaried.values.sum.toFloat / mapSalaried.size.toFloat
  }


  //Exercice 02
  //Soit les fonctions suivantes :
  //F(x) = x2
  //F(x) = 2x
  //f(x) = xx
  // Comme l’exemple du cours, écrire une fonction qui calcule

  def f = ex2(x => x * x)

  def g = ex2(x => Math.pow(x, 2).toInt)

  def h = ex2(x => Math.pow(x, x).toInt)

  def ex2(f: Int => Int): (Int, Int) => Int = {
    def ex2Interieur(x: Int, y: Int): Int = {
      if (x > y) 0 else f(x) + ex2Interieur(x + 1, y)
    }

    ex2Interieur
  }


  //Exercice 03
  //Ecrire une fonction curryfiée qui permet de calculer la factorielle d’un nombre
  //entier.
  def e3(n: Int => Int): Int => Int = {
    def fac(n: Int): Int = {
      if (n == 0) 1 else n * fac(n - 1)
    }

    fac
  }

  def fx = e3(x => x)




  //Exercice 04
  //Écrire une fonction produit qui calcule le produit des valeurs d'une fonction
  //f(x) pour les points appartenant à l’intervalle [a, b]. Avec une fonction curryfiée.


  def e4(op: Int => Int): (Int, Int) => Int = {
    def prod(a: Int, b: Int): Int = {
      if (a == b) op(a) else {
        if (a > b) throw new Exception("L'intervalle débutant à a doit finir à b.")
        else op(a) + prod(a + 1, b)
      }
    }

    prod
  }

  def gx = e4(x => x)


//  En se basant sur le principe de fonctions imbriquées, écrire une fonction
  //calculatrice() qui prend en paramètre deux nombres entiers et effectue les
  //différentes opérations arithmétiques (+ , -, /, % , *) sur ces nombres.

  def calculatrice(a: Int, b: Int): (String => Int) = {
    def add: Int = a + b
    def sub: Int = a - b
    def div: Int = a / b
    def mod: Int = a % b
    def mul: Int = a * b

    def calculatriceInterieur(op: String): Int = {
        op match {
        case "+" => add
        case "-" => sub
        case "/" => div
        case "%" => mod
        case "*" => mul
        case _ => throw new Exception("Opération non reconnue.")
      }
    }

    calculatriceInterieur
  }




  def main(args: Array[String]): Unit = {
    println(ex1(salaried_map))
    println(f(1, 5))
    println(fx(5))
    println(gx(1, 5))
    println(calculatrice(5, 5)("+"))
    println(calculatrice(5, 5)("-"))
  }

}
