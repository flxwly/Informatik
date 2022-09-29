package org.extraterrestrial.kirill;

import org.extraterrestrial.adt.BinTree;
import org.extraterrestrial.adt.Queue;

import java.util.ArrayList;

public class TreeStructure {
    public BinTree tree;
    public int layer;
    public BinTree parent;
    public int pos;


    TreeStructure(BinTree _tree, int _layer, BinTree _parent) {
        tree = _tree;
        layer = _layer;
        parent = _parent;
    }

    public static void treeOrder(BinTree _B, int _f) {
        Queue q = new Queue();
        BinTree temp = _B;
        ArrayList<TreeStructure> Arr = new ArrayList<>();
        int t = 0;
        int maxLayer = -1;

        Arr.add(new TreeStructure(temp, 0, null));
        q.enqueue(_B);
        while (!q.isEmpty()) {
            temp = (BinTree) q.dequeue();
            //TODO efficiency
            for (TreeStructure el : Arr) {
                if (el.tree == temp) t = el.layer;
            }

            maxLayer = t > maxLayer ? t + 1 : maxLayer;

            if (temp.hasLeft()) {
                Arr.add(new TreeStructure(temp.getLeft(), t + 1, temp));
                q.enqueue(temp.getLeft());
            }
            if (temp.hasRight()) {
                Arr.add(new TreeStructure(temp.getRight(), t + 1, temp));
                q.enqueue(temp.getRight());
            }
        }

        int factor = _f;

        Arr.get(0).pos = maxLayer * 2 * factor;

        t = 0;

        for (TreeStructure el : Arr) {
            if (el.parent == null) {
            } else if (el.parent.getLeft() == el.tree) {
                for (TreeStructure _el : Arr) {
                    if (_el.tree == el.parent) t = _el.pos;
                }
                el.pos = (t - (maxLayer - el.layer + 1)) * factor;
            } else if (el.parent.getRight() == el.tree) {
                for (TreeStructure _el : Arr) {
                    if (_el.tree == el.parent) t = _el.pos;
                }
                el.pos = (t + (maxLayer - el.layer + 1)) * factor;
            }
        }

        t = 0;

        String s = "";
        String space = " ";
        for (TreeStructure el : Arr) {
            if (t != el.layer) {
                System.out.println(s);
                s = " ";
            }
            t = el.layer;

            s += space.repeat(el.pos - s.length());
            s += el.tree.getItem();
        }
        System.out.println(s);

    }
}