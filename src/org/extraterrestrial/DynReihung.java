package org.extraterrestrial;

public class DynReihung {

    public static void main(String[] args) {
        int []noten = {2, 1, 5, 3, 2, 1, 0, 1, 3, 5,5,1,1,4,4,1,4,4,1,6,3,7,4,1,2,3,1};
    }

    public static int[] push_back(int[] arr, int elem) {
        int[] helper = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            helper[i] = arr[i];
        }
        helper[arr.length] = elem;
        return helper;
    };

    public static int[] insert(int[] arr, int index, int elem) {
        int[] helper = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            helper[i] = arr[i];
        }
        helper[index] = elem;
        for (int i = index + 1; i < arr.length + 1; i++) {
            helper[i] = arr[i - 1];
        }

        return helper;
    };

    public static int[] remove(int[] arr, int index) {
        int[] helper = new int[arr.length - 1];
        for (int i = 0; i < index - 1; i++) {
            helper[i] = arr[i];
        }
        for (int i = index + 1; i < arr.length; i++) {
            helper[i - 1] = arr[i];
        }

        return helper;
    };

}
