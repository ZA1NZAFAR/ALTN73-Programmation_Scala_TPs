package TP4.exo1

// use trait Convertible

class Compte(var titulaire: String, var numero: Int, var solde: Double) extends Convertible {
  def deposer(argent: Double): Unit = solde += argent

  def retirer(argent: Double): Unit = solde -= argent

  def afficherSolde(): Unit = println("Le solde du compte est de " + solde)

  override def convertir(): Int = solde.toInt
}