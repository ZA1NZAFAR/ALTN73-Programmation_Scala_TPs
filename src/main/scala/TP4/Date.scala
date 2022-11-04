package TP4

class Date(var annee: Int, var mois: Int, var jour: Int) {
  def afficherDate(): Unit = println("La date est " + jour + "/" + mois + "/" + annee)
}