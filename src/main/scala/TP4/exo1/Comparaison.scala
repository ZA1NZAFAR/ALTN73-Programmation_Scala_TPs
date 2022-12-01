package TP4.exo1

class Comparaison {
  def egal(x: Convertible, y: Convertible): Boolean = x.convertir() == y.convertir()

  def inferieur(x: Convertible, y: Convertible): Boolean = x.convertir() < y.convertir()

  def superieur(x: Convertible, y: Convertible): Boolean = x.convertir() > y.convertir()

  def trier(tab: Array[Convertible]): Array[Convertible] = {
    var i = 0
    var j = 0
    var tmp = tab(0)
    for (i <- tab.indices ; j <- tab.indices) {
      if (inferieur(tab(i), tab(j))) {
        tmp = tab(i)
        tab(i) = tab(j)
        tab(j) = tmp
      }
    }
    tab
  }
}
