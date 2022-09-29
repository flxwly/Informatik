package org.extraterrestrial.adt; /**
 *
 */
//package mk.nds.adt;

/**
 * Klasse BinTree zur Umsetzung des ADT Bin�rbaum entsprechend der Vorgaben
 * des KC Informatik f�r die gymnasiale Oberstufe in Niedersachsen
 *
 * @author Landesnetzwerk Informatik Niedersachsen, Carsten Rohe, flxwly
 * @version 0.8_20200429
 */
public class BinTree {
    private BinTree left, right;
    private Object data;

    /**
     * Ein leerer Baum wird erzeugt.
     * Der Baum besitzt keine Teilb�ume. Die Wurzel besitzt keinen Inhalt.
     */
    public BinTree() {
        left = null;
        right = null;
        data = null;
    }

    /**
     * Ein Baum mit dem �bergebenen Inhalt als Wert der Wurzel wird erzeugt.
     * Der Baum besitzt keine Teilb�ume.
     *
     * @param d Der Inhalt f�r die Wurzel des neuen Baums.
     */
    public BinTree(Object d) {
        data = d;
        left = null;
        right = null;
    }

    /**
     * Es wird �berpr�ft, ob die Wurzel des Baums einen Inhalt besitzt.
     *
     * @return Wenn die Wurzel des Baums einen Inhaltswert besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
     */
    public boolean hasItem() {
        //
        if (data != null)
            return true;
        // else
        return false;
    }

    /**
     * Die Operation gibt den Inhaltswert der Wurzel des Baums zur�ck.
     *
     * @return Der Inhaltswert der Wurzel.
     */
    public Object getItem() {
        return data;
    }

    /**
     * Die Wurzel des Baums erh�lt den �bergebenen Inhalt als Wert.
     *
     * @param d Der neue Inhaltswert f�r die Wurzel.
     */
    public void setItem(Object d) {
        data = d;
    }

    /**
     * Die Operation l�scht den Inhaltswert der Wurzel des Baums.
     */
    public void deleteItem() {
        data = null;
    }

    /**
     * Die Operation pr�ft, ob die Wurzel des Baums ein Blatt ist, d.h. ob der Baum keine Teilb�ume besitzt.
     *
     * @return Wenn der Baum keine Teilb�ume besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    /**
     * Die Operation pr�ft, ob der Baum einen linken Teilbaum besitzt.
     *
     * @return Wenn der Baum einen linken Teilbaum besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
     */
    public boolean hasLeft() {
        return (left != null);
    }

    /**
     * Die Operation gibt den linken Teilbaum zur�ck.
     * Der Teilbaum wird dabei nicht entfernt.
     *
     * @return Der linke Teilbaum.
     */
    public BinTree getLeft() {
        //
        return left;
    }

    /**
     * Der �bergebene Baum wird als linker Teilbaum gesetzt.
     *
     * @param b Der Baum, der als linker Teilbaum gesetzt werden soll.
     */
    public void setLeft(BinTree b) {

        left = b;
    }

    /**
     * Die Operation l�scht den linken Teilbaum.
     */
    public void deleteLeft() {
        left = null;
    }

    /**
     * Die Operation pr�ft, ob der Baum einen rechten Teilbaum besitzt.
     *
     * @return Wenn der Baum einen rechten Teilbaum besitzt, wird der Wert true zur�ckgegeben, sonst der Wert false.
     */
    public boolean hasRight() {
        return (right != null);
    }

    /**
     * Die Operation gibt den linken Teilbaum zur�ck.
     * Der Teilbaum wird dabei nicht entfernt.
     *
     * @return Der linke Teilbaum.
     */
    public BinTree getRight() {
        return right;
    }

    /**
     * Der �bergebene Baum wird als rechter Teilbaum gesetzt.
     *
     * @param b Der Baum, der als rechter Teilbaum gesetzt werden soll.
     */
    public void setRight(BinTree b) {
        right = b;
    }

    /**
     * Die Operation l�scht den rechten Teilbaum.
     */
    public void deleteRight() {
        right = null;
    }

    public int depth() {
        return Math.max(this.hasLeft() ? this.getLeft().depth(2) : 1, this.hasRight() ? this.getRight().depth(2) : 1);
    }

    private int depth(int n) {
        return Math.max(this.hasLeft() ? this.getLeft().depth(n + 1) : n, this.hasRight() ? this.getRight().depth(n + 1) : n);
    }

    private int getCharWidth() {
        return Math.max(this.hasLeft() ? this.getLeft().getCharWidth() : (this.hasItem() ? this.getItem().toString().length() : 0),
                this.hasRight() ? this.getRight().getCharWidth() : (this.hasItem() ? this.getItem().toString().length() : 0));
    }

    private void getArr(BinTree[] arr, int left, int right) {
        int pivot = (left + right) / 2;
        if (left <= right) {
            BinTree cur = arr[pivot];
            if (cur == null) {
                return;
            }

            if (cur.hasLeft()) {
                arr[(left + pivot) / 2] = cur.getLeft();
                getArr(arr, left, pivot);
            }
            if (cur.hasRight()) {
                arr[(pivot + right + 1) / 2] = cur.getRight();
                getArr(arr, pivot + 1, right);
            }
        }
    }

    public String toString() {

        int depth = this.depth();

        if (depth == 1) {
            if (this.hasItem()) {
                return this.data.toString();
            }
            return "";
        }

        int charWidth = 2; //this.getCharWidth();
        int elementSpan = (int) Math.pow(2, depth) - 1;

        BinTree[] elements = new BinTree[elementSpan];
        elements[(int) elementSpan / 2] = this;
        getArr(elements, 0, elementSpan);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append("=".repeat(elementSpan * charWidth)).append("\n");
        int index = 0;
        int level = 0;

        while (level < depth) {
            int increment = (int) Math.pow(2, level + 1);
            index = (int) Math.pow(2, level) - 1;
            while (index < elementSpan) {
                stringBuilder.append(" ".repeat(charWidth * (increment + level)));
                if (elements[index] != null && elements[index].hasItem()) {
                    int length = elements[index].getItem().toString().length();
                    int pre = (length % 2 == 0) ? (charWidth - length) / 2 : (charWidth - length + 1) / 2;

                    stringBuilder.append(" ".repeat(pre)).append(elements[index].getItem()).append(" ".repeat((charWidth - length) / 2));
                } else {
                    stringBuilder.append("#".repeat(charWidth));
                }
                stringBuilder.append(" ".repeat(charWidth * increment));
                index += increment;
            }
            stringBuilder.append("\n");
            level++;
        }
        stringBuilder.append("\t Hier ist oben... \n").append("=".repeat(elementSpan * charWidth)).append("\n");
        return stringBuilder.toString();
    }

    public boolean includes(Object item) {
        if (this.hasItem() && this.getItem() == item) {
            return true;
        }

        return (this.hasLeft() && this.getLeft().includes(item))
                || (this.hasRight() && this.getRight().includes(item));
    }
}// Ende der Klasse BinTree