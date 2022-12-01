package TP4.exo1

object Main {

  def main(args: Array[String]): Unit = {
    var c = new Compte("toto", 1, 100)
    var date = new Date(2020, 10, 10)


    var x = new Comparaison()

    println(x.egal(c, date))
    var xx = x.trier(Array(c, date, new Compte("titi", 2, 200), new Date(2020, 10, 11)))

    for (i <- xx.indices) {
      println(xx(i).convertir())
    }


  }

}
