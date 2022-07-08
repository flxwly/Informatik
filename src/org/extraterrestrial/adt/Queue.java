package org.extraterrestrial.adt;

/**
 * Klasse Queue zur Umsetzung des ADT Schlange entsprechend der Vorgaben
 * des KC Informatik f�r die gymnasiale Oberstufe in Niedersachsen
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe
 * @version 0.8_20200429
 */
public class Queue
{
  private int length;
  private Element head;

  /**
   * Eine leere Schlange wird angelegt.
   */
  public Queue()
  {
    length = 0;
    head = null;
  }   
  
  /**
   * Es wird gepr�ft, ob die Schlange leer ist.
   * @return Wenn die Schlange kein Element enth�lt, wird der Wert true zur�ckgegeben, sonst der Wert false.
   */
  public boolean isEmpty()
  {
    if (length==0)
      return true;
    //else 
    return false;
  }
  
  /**
   * Der Inhalt des ersten Elements der Schlange wird ausgelesen.
   * Das Element wird dabei aber nicht aus der Schlange entfernt.
   * @return Der Inhalt des ersten Elements der Schlange.
   */
  public Object head()
  {
    if (!isEmpty())
      return head.data;
    //else
    return null;
  }
  
  /**
   * Ein neues Element mit dem �bergebenen Inhalt wird an die Schlange angeh�ngt.
   * @param data Der Inhalt f�r das neue Element.
   */ 
  public void enqueue(Object data)
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
   * Das erste Element der Schlange wird entnommen und dessen Inhalt zur�ckgegeben. 
   * @return Der Inhalt des entnommenen Elements.
   */
  public Object dequeue()
  {
    if (!isEmpty())
    {
      Element temp = head;
      head = head.next;
      length--;
      return temp.data;
    }
    // else
    return null;
  }

  public int getLength() {
    return length;
  }

  public String toString() {
    StringBuilder str = new StringBuilder("[");
    Queue h = new Queue();
    while(!this.isEmpty()) {
      str.append(this.head.data).append(", ");
      h.enqueue(this.dequeue());
    }
    while (!h.isEmpty()) {
      this.enqueue(h.dequeue());
    }
    return str.append("]").toString();
  }

  private Element getElement(int index)
  {  
    // Interne Hilfsoperation zum vereinfachten Zugriff auf die Elemente der Reihung
    // durch die �ffentlichen Operationen
    if (length >= index)
    {
      Element current = head;
      for (int i=0; i < index; i++)
      {
        current = current.next;
      }
      return current;
    }
    return null;
  }

  // Klasse Element zur internen Verwaltung der einzelnen Elemente der Schlange
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
} //Ende der Klasse Queue
