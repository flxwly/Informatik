package org.extraterrestrial.adt; /**
 * 
 */
//package mk.nds.adt;

/**
 * Klasse org.extraterrestrial.adt.DynArray zur Umsetzung des ADT Dynamische Reihung entsprechend der Vorgaben
 * des KC Informatik f�r die gymnasiale Oberstufe in Niedersachsen
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 0.8_20200429
 */
public class DynArray
{
  private int length;
  private Element head;

  /**
   * Eine leerere dynamische Reihung wird angelegt.
   */
  public DynArray()
  {
    length = 0;
    head = null;
  }                  

  /**
   * Es wird gepr�ft, ob die dynamische Reihung leer ist.
   * @return Wenn die dyn. Reihung kein Element enth�lt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */
  public boolean isEmpty()
  {
    if (length == 0)
      return true;
    //else 
    return false;
  }

  /**
   * Der Inhalte des Elements an der Position index wird ausgelesen.
   * Das Element wird dabei nicht aus der dynamischen Reihung entfernt.
   * @return Der Inhalt des Elements an der Position index.
   * @param index Die Position des auszulesenden Elements.
   */
  public Object getItem(int index)
  {
    // Der Inhalt des Elements an der Position index wird zur�ckgegeben.
    if (length > index)
    {
      Element current = head;
      for (int i=0; i < index; i++)
      {
        current = current.next;
      }
      return current.data;
    }
    //else
    return null;
  }
  
  /**
   * Ein neues Element mit dem �bergebenen Inhalt wird am Ende an die dynamische Reihung angef�gt.
   * @param data Der Inhalt f�r das neue Element.
   */ 
  public void append(Object data)
  {

    if (!isEmpty())
    {
      getElement(length-1).next = new Element(data);
    }
    else
    {
      head = new Element(data);
    }
    length++;
  }
  
  /**
  * Ein neues Element mit dem �bergebenen Inhalt wird der Position index in die dynamische Reihung eingef�gt.
  * Das Element, das sich vorher an dieser befunden hat, und alle nachfolgenden Elemente werden nach hinten verschoben.
  * Entspricht der Wert von index der L�nge der dynamischen Reihung, so wird ein neues Element am Ende der dynamischen Reihung
  * angef�gt.
   * @param index Die Position f�r das neue Element.
   * @param data Der Inhalt f�r das neue Element.
   */
  public void insertAt(int index, Object data)
  {

    if (index < length && index > 0) // Es wird mittig eingef�gt.
    {
      Element n = new Element(data);
      Element temp = getElement(index);
      getElement(index-1).next = n;
      n.next = temp;
      length++;
    }
    else if (index == 0 && !isEmpty()) // Es wird vorne eingef�gt.
    {
      Element temp = head;
      head = new Element(data);
      head.next = temp;
      length++;
    }
    else if (index == length) // Es wird am Ende hinzugef�gt.
    {
      append(data);
    }
  }
  
  /**
  * Der Inhalt des Elements an der Position index wird durch den �bergebenen Inhalt ersetzt.
  * @param index Die Position f�r das Ersetzen.
  * @param data Der neue Inhalt.
  */
  public void setItem(int index, Object data)
  {
    if (index >= 0 && index < length)
    {
      getElement(index).data = data;
    }
    // Soll hier wie bei append ein neues Element angef�gt werden, wenn index = laenge?
  }

  /**
   * Das Element an der Position index wird gel�scht.
   * Alle folgenden Elemente werden um eine Position nach vorne geschoben.
   * @param index Die Position des zu l�schenden Elements.
   */
  public void delete(int index)
  {
     if (index == 0 && length > 0) // Es wird das erste Element gel�scht.
    {
      head = head.next;
      length--;
    }
    else if (index > 0 && index < length) // Es wird nicht vorne gel�scht.
    {
      getElement(index-1).next = getElement(index-1).next.next;
      length--;
    }
  }
  /**
  * Die Anzahl der Elemente der dynamischen Reihung wird zur�ckgegeben.
  * @return Anzahl der enthaltenen Elemente
  */
  public int getLength()
  {
    return length;
  }

  private Element getElement(int index)
  {  
    // Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente der dynamischen Reihung.
    if (index < length)
    {
      Element current = head;
      for (int i=0; i < index; i++)
      {
        current = current.next;
      }
      return current;
    }
    // else
    return null;
  }

  // Klasse Element zur internen Verwaltung der einzelnen Elemente der dynamischen Reihung
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
}// Ende der Klasse org.extraterrestrial.adt.DynArray