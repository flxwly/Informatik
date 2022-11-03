public class MergeSort {
    public static void main(String[] args) {
        // array zum sortieren erstellen
        int[] arr = {4, 8, 3, 9, 5, 1, 2, 6, 10, 7};
        // array ausgeben
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // mergeSort ausführen
        int[] result = mergeSort(arr, 0, arr.length);
        // sortiertes array ausgeben
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param arr    zu sor tierendes array
     * @param lBound linke grenze des zu betrachtenden bereichs (inklusiv)
     * @param rBound rechte grenze des zu betrachtenden bereichs (exklusiv)
     *               beispiel:
     *               zahlenfolge 0 1 2 3 wird betrachtet
     *               0 ist eine inklusive grenze
     *               4 ist eine exklusive grenze
     * @return
     */
    public static int[] mergeSort(int[] arr, int lBound, int rBound) {
        // überprüfen, ob nur noch ein element übrig ist
        // zb lBound = 0, rBound = 1, also wird nur noch das element 0 betrachtet
        if (rBound - lBound == 1) {
            // neues array mit dem element das übrig ist erstellen und zurückgeben
            // (es geht dahin zurück wo die methode aufgerufen wurde)
            return new int[]{arr[lBound]};
        }
        // variable für die mitte des zu betrachtenden bereichs
        int mid = (rBound - lBound) / 2;
        // sortierte linke hälfte des zu betrachtenden bereichs als array lArr
        int[] lArr = mergeSort(arr, lBound, mid + lBound);
        // sortierte rechte hälfte des zu betrachtenden bereichs als array rArr
        int[] rArr = mergeSort(arr, mid + lBound, rBound);
        // neues array in das lArr und rArr einsortiert werden
        return merge(lArr, rArr);
    }
    public static int[] merge(int []lArr, int [] rArr) {
        int[] result = new int[lArr.length + rArr.length];
        // zeigt auf das element von lArr, das als nächstes in result eingesetzt wird
        int lI = 0;
        // zeigt auf das element von rArr, das als nächstes in result eingesetzt wird
        int rI = 0;
        // zeigt auf die stelle, wo das nächste element in result eingefügt wird
        int resI = 0;
        // solange lI und rI noch auf ein gültiges element zeigen
        while (lI < lArr.length && rI < rArr.length) {
            // wenn das element von lI kleiner als das element von rI ist
            if (lArr[lI] < rArr[rI]) {
                // wird das element von lI in result eingesetzt
                result[resI] = lArr[lI];
                resI++;
                lI++;
            } else {
                // sonst wird das element von rI in result eingesetzt
                result[resI] = rArr[rI];
                resI++;
                rI++;
            }
        }
        // solange lI noch auf ein gültiges element zeigt
        // (die restlichen elemente von lI werden eingefügt)
        while (lI < lArr.length) {
            // das element von lI wird in result eingesetzt
            result[resI] = lArr[lI];
            resI++;
            lI++;
        }
        // solange rI noch auf ein gültiges element zeigt
        // (die restlichen elemente von rI werden eingefügt)
        while (rI < rArr.length) {
            // das element von rI wird in result eingesetzt
            result[resI] = rArr[rI];
            resI++;
            rI++;
        }
        // sortiertes array zurückgeben
        // (es geht dahin zurück wo die methode aufgerufen wurde)
        return result;
    }
}  