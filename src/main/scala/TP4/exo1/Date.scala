package TP4.exo1

class Date(var annee: Int, var mois: Int, var jour: Int) extends Convertible {
  def afficherDate(): Unit = println("La date est " + jour + "/" + mois + "/" + annee)
  override def convertir(): Int = Integer.parseInt(annee+""+mois+""+jour)

}