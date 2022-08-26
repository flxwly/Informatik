package org.extraterrestrial.adt; /**
 * 
 */
//package mk.nds.adt;

/**
  * Klasse BinTree zur Umsetzung des ADT Bin�rbaum entsprechend der Vorgaben
  * des KC Informatik f�r die gymnasiale Oberstufe in Niedersachsen
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 0.8_20200429
 */
public class BinTree
{
  private BinTree left, right;
  private Object data;
 
  /**
 * Ein leerer Baum wird erzeugt.
 * Der Baum besitzt keine Teilb�ume. Die Wurzel besitzt keinen Inhalt.
 */
  public BinTree()
  {
    left = null;
    right = null;
    data = null;
  }
 
  /**
   * Ein Baum mit dem �bergebenen Inhalt als Wert der Wurzel wird erzeugt.
   * Der Baum besitzt keine Teilb�ume.
   * @param d Der Inhalt f�r die Wurzel des neuen Baums.
   */
  public BinTree(Object d)
  {
    data = d;
    left = null;
    right = null;
  }
  
  /**
   * Es wird �berpr�ft, ob die Wurzel des Baums einen Inhalt besitzt.
   * @return Wenn die Wurzel des Baums einen Inhaltswert besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */
  public boolean hasItem()
  {
    // 
    if(data != null)
      return true;
    // else
    return false;
  }

  /**
   * Die Operation gibt den Inhaltswert der Wurzel des Baums zur�ck.
   * @return Der Inhaltswert der Wurzel.
   */
  public Object getItem()
  {
    return data;
  }
  
  /**
  * Die Wurzel des Baums erh�lt den �bergebenen Inhalt als Wert.
  * @param d Der neue Inhaltswert f�r die Wurzel.
  */
  public void setItem(Object d)
  {
    data = d;
  }

  /**
   * Die Operation l�scht den Inhaltswert der Wurzel des Baums.
   */
  public void deleteItem()
  {
    data = null;
  }

  /**
   * Die Operation pr�ft, ob die Wurzel des Baums ein Blatt ist, d.h. ob der Baum keine Teilb�ume besitzt.
   * @return Wenn der Baum keine Teilb�ume besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */
  public boolean isLeaf()
  {
    return (left == null && right == null);
  }

  /**
   * Die Operation pr�ft, ob der Baum einen linken Teilbaum besitzt.
   * @return Wenn der Baum einen linken Teilbaum besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */  
  public boolean hasLeft()
  {
    return (left != null);
  }
  
  /**
  * Die Operation gibt den linken Teilbaum zur�ck.
  * Der Teilbaum wird dabei nicht entfernt.
  * @return Der linke Teilbaum.
  */
  public BinTree getLeft()
  {
    // 
    return left;
  }
  
  /**
  * Der �bergebene Baum wird als linker Teilbaum gesetzt.
  * @param b Der Baum, der als linker Teilbaum gesetzt werden soll.
  */
  public void setLeft(BinTree b)
  {

    left = b;
  }
  
  /**
   * Die Operation l�scht den linken Teilbaum.
   */
  public void deleteLeft()
  {
    left = null;
  }

  /**
   * Die Operation pr�ft, ob der Baum einen rechten Teilbaum besitzt.
   * @return Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */  
  public boolean hasRight()
  {
    return (right != null);
  }
  
  /**
   * Die Operation gibt den linken Teilbaum zur�ck.
   * Der Teilbaum wird dabei nicht entfernt.
   * @return Der linke Teilbaum.
   */
  public BinTree getRight()
  {
    return right;
  }
  
  /**
  * Der �bergebene Baum wird als rechter Teilbaum gesetzt.
  * @param b Der Baum, der als rechter Teilbaum gesetzt werden soll.
  */
  public void setRight(BinTree b)
  {
    right = b;
  }
  
  /**
   * Die Operation l�scht den rechten Teilbaum.
   */
  public void deleteRight()
  {
    right = null;
  }
}// Ende der Klasse BinTree