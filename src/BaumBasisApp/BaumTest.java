package BaumBasisApp;

import org.extraterrestrial.adt.BinTree;
import org.extraterrestrial.adt.DynArray;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.extraterrestrial.kirill.TreeStructure.treeOrder;

public class BaumTest {

    public static BinTree tree = new BinTree();

    public static void main(String[] args) {


        int repetitions = 100;
        long[] list = new long[repetitions];
        long[] arr = new long[repetitions];
        for (int j = 0; j < repetitions; j++) {

            ArrayList<Integer> arrayList = new ArrayList<>();
            long time = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
            list[j] = System.currentTimeMillis() - time;

            time = System.currentTimeMillis();
            DynArray dynArray = new DynArray();
            for (int i = 0; i < 10000; i++) {
                dynArray.append(i);
            }
            arr[j] = System.currentTimeMillis() - time;
        }

        long listTime = 0;
        long arrTime = 0;
        for (int i = 0; i < repetitions; i++) {
            listTime += list[i];
            arrTime += arr[i];
        }

        System.out.println("avg list time: " + listTime / repetitions);
        System.out.println("avg arr time: " + arrTime / repetitions);



        insertTree(tree, 8);
        insertTree(tree, 4);
        insertTree(tree, 12);
        insertTree(tree, 5);
        insertTree(tree, 3);
        insertTree(tree, 13);
        insertTree(tree, 11);
        insertTree(tree, 11);
        insertTree(tree, 11);

        ArrayList<String> a = new ArrayList();

        treeOrder(tree, 2);

        //System.out.println(tree.depth());
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
