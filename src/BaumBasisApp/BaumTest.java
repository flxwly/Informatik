package BaumBasisApp;

import org.extraterrestrial.adt.BinTree;

public class BaumTest {

    public static BinTree tree = new BinTree();

    public static void main(String[] args) {

        insertTree(tree, 8);
        insertTree(tree, 4);
        insertTree(tree, 12);
        insertTree(tree, 5);
        insertTree(tree, 3);
        insertTree(tree, 13);
        insertTree(tree, 11);

        System.out.println(tree.depth());
        System.out.println(tree);

    }

    public static void insertTree(BinTree b, int wert) {
        if (!b.hasItem())
            b.setItem(wert);
        else {
            if (wert <= (int) b.getItem()) {
                if (b.hasLeft()) {
                    insertTree(b.getLeft(), wert);
                } else {
                    b.setLeft(new BinTree());
                    b.getLeft().setItem(wert);
                }
            } else {
                if (b.hasRight()) {
                    insertTree(b.getRight(), wert);
                } else {
                    b.setRight(new BinTree());
                    b.getRight().setItem(wert);
                }
            }
        }
    }
}
