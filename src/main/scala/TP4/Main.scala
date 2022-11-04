package TP4

object Main {

  def main(args: Array[String]): Unit = {
    var c = new Compte("toto", 1, 100)
    var date = new Date(2020, 10, 10)


    var x = new Comparaison()

    println(x.egal(c, date))



  }

}
