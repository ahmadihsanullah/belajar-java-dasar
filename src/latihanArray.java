import java.util.Arrays;

public class latihanArray {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {6,7,8,9,10};

        int[] hasilArray = sumTwoArray(array1, array2);
        printArray(hasilArray, "operator 2 array");

        int[] arrayGabungan = mergeTwoArray(array1, array2);
        printArray(arrayGabungan, "operator menggabungkan 2 array");

        int[] array3 = {8,2,3,1,5,8,10,20,18,17};
        printArray(array3, "before sorted");
        // mereverse array
        reverse1(array3);
        printArray(array3, "after reverse with reverse1");
        reverse2(array3);
        printArray(array3, "after reverse with reverse2");

    }

    private static void reverse2(int[] array){
        for (int i = 0; i < array.length /2 ; i++){
            int temp = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = temp;
        }
    }
    private static void reverse1(int[] array){
        //membuat array baru
        Arrays.sort(array);
        int[] arrayBuffer = Arrays.copyOf(array, array.length);
        System.out.println(array);
        System.out.println(arrayBuffer);
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayBuffer[(arrayBuffer.length - 1) - i];
        }
    }

    private static int[] sumTwoArray(int[] array1, int[] array2){
        int[] hasilArray = new int[array1.length];

        for (int i = 0; i < hasilArray.length; i++) {
            hasilArray[i] = array1[i] + array2[i];
        }
        return hasilArray;
    }

    private static int[] mergeTwoArray(int[] array1, int[] array2){
        int[] arrayGabungan = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++){
            arrayGabungan[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++){
            arrayGabungan[i + array2.length] = array2[i];
        }
        return arrayGabungan;
    }
    private static void printArray(int[] array, String message){
        System.out.println(message + " = " + Arrays.toString(array));
    }
}
