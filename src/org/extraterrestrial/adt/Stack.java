package org.extraterrestrial.adt; /**
 * 
 */
//package mk.nds.adt;

 /**
 * Klasse org.extraterrestrial.adt.Stack zur Umsetzung des ADT Stapel entsprechend der Vorgaben
 * des KC Informatik f�r die gymnasiale Oberstufe in Niedersachsen
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 0.8_20200429
 */
public class Stack
{
  private int length;
  private Element bottom;
  /**
   * Ein leerer Stapel wird angelegt.
   */
  public Stack()
  {
    length = 0;
    bottom = null;
  }                  
  /**
   * Es wird gepr�ft, ob der Stapel leer ist.
   * @return Wenn der Stapel kein Element enth�lt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */
  public boolean isEmpty()
  {
    if (length==0)
      return true;
    //else 
    return false;
  }

  /**
   * Der Inhalt des obersten Elements des Stapels wird ausgelesen.
   * Das Element wird dabei nicht aus dem Stapel entfernt.
   * @return Der Inhalt des obersten Elements des Stapels.
   */
  public Object top()
  {
    // 
    if (!isEmpty())
      return getElement(length-1).data;
    //else
    return null;
  }

  
  /**
   * Ein neues Element mit dem �bergebenen Inhalt wird auf dem Stapel abgelegt.
   * @param data Der Inhalt f�r das neue Element.
   */ 
  public void push(Object data)
  {
    if (!isEmpty())
    {
      getElement(length-1).next = new Element(data);
    }
    else
    {
      bottom = new Element(data);
    }
    length++;
  }
  
  /**
  * Das erste Element des Stapels wird entnommen und dessen Inhalt zur�ckgegeben.
  * @return Der Inhalt des entnommenen Elements.
  */
  public Object pop()
  {
    // 
    if (!isEmpty())
    {
      Element temp = getElement(length-1);
      if (length > 1)
      { 
        getElement(length-2).next = null;
      }
      else
      {
        bottom = null;
      }
      length--;
      return temp.data;
    }
    // else
    return null;
  }

  private Element getElement(int index)
  {  
    // Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente des Stapels
    if (length > index)
    {
      Element current = bottom;
      for (int i=0; i < index; i++)
      {
        current = current.next;
      }
      return current;
    }
    return null;
  }

  // Klasse Element zur internen Verwaltung der einzelnen Elemente des Stapels
  private class Element
  {
    public Object data;
    public Element next;

    public Element(Object d)
    {
      data = d;
      next = null;
    }
  } //Ende der Klasse Element
} // Ende der Klasse org.extraterrestrial.adt.Stack