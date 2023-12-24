
import java.util.Arrays;

public class OperasiArray {

    public static void main(String[] args) {

        int[] arrayAngka1 = {1,2,3,4,5};

        // merubah array menjadi string
        System.out.println("\nMerubah array menjadi string\n==============");
        printArray(arrayAngka1);

        // mengkopi array
        System.out.println("\nMengkopi array\n==============");
        int[] arrayAngka2 = new int[5];
        printArray(arrayAngka1);
        printArray(arrayAngka2);

        System.out.println("\nmengkopi dengan loop");
        for(int i=0; i < arrayAngka1.length;i++){
            arrayAngka2[i] = arrayAngka1[i];
        }
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka2);
        System.out.println(arrayAngka2);

        System.out.println("\nmengkopi dengan copyOf");
        int[] arrayAngka3 = Arrays.copyOf(arrayAngka1,3);
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka3);
        System.out.println(arrayAngka3);

        System.out.println("\nmengkopi dengan copyOfRange");
        int[] arrayAngka4 = Arrays.copyOfRange(arrayAngka1,2,5);
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka4);
        System.out.println(arrayAngka4);

        // fill array
        System.out.println("\nFill array\n==============");
        int[] arrayAngka5 = new int[10];
        printArray(arrayAngka5);
        Arrays.fill(arrayAngka5,5);
        printArray(arrayAngka5);

        // komparasi array
        System.out.println("\nkomparasi array\n==============");
        int[] arrayAngka6 = {1,2,3,4,9};
        int[] arrayAngka7 = {1,2,3,4,5};

        System.out.println("\nmembandingkan antara dua buah array");
        System.out.println(Arrays.equals(arrayAngka6,arrayAngka7));

        if (Arrays.equals(arrayAngka6,arrayAngka7)){
            System.out.println("array ini sama");
        } else {
            System.out.println("array ini beda");
        }

        System.out.println("\nngecek mana array yang lebih besar");
        System.out.println(Arrays.compare(arrayAngka6,arrayAngka7));

        System.out.println("\nngecek mana index yang berbeda");
        System.out.println(Arrays.mismatch(arrayAngka6,arrayAngka7));

        // sort array
        System.out.println("\nsort array\n==============");
        int[] arrayAngka8 = {1,6,4,5,3,5,2,6};
        printArray(arrayAngka8);
        Arrays.sort(arrayAngka8);
        printArray(arrayAngka8);

        // search array
        System.out.println("\nsearch array\n==============");
        int angka = 3;
        int posisi = Arrays.binarySearch(arrayAngka8,angka);
        System.out.println("angka " + angka + " ada di index " + posisi);

        // tugas -> sort kebalik,
        // operasi tambah antara dua buah array
        // mengabungkan dua buah array,

        //sort kebalik
        System.out.println("\nsort kebalik\n==============");
        int[] arrayAngka9 = new int[arrayAngka8.length];
        for(var i = 0; i < arrayAngka8.length ; i++){
            arrayAngka9[i] = arrayAngka8[arrayAngka8.length - 1 - i];
        }
        printArray(arrayAngka9);

        // operasi tambah antara dua buah array | buat fungsi pake copy of
        System.out.println("\noperasi tambah antara 2 buah array\n==============");
        int[] arrayAngka10 = {1,2,3,4,5,5};
        int[] arrayAngka11 = {6,7,8,9,10};
        int tambahDuaArray = addTwoArray(arrayAngka10, arrayAngka11);
        System.out.println(tambahDuaArray);

        // mengabungkan dua buah array,
        System.out.println("\nmenggabungkan 2 buah array\n==============");
        int[] merge = mergeDuaArray(arrayAngka10, arrayAngka11);
        printArray(merge);

    }

    private static void printArray(int[] dataArray){
        System.out.println("array = " + Arrays.toString(dataArray));
    }

    //penjumlahan 2 array
    private static int addTwoArray(int[] array1, int[] array2){
        var total = 0;
        for(var i = 0; i < array1.length ; i++){
            int lengthArr2 = array2.length -1;
            if(i < lengthArr2){
                total += (array1[i] + array2[i]);
            }
            total += array1[i];
        }
        return total;
    }

    //merge 2 array
    private static int[] mergeDuaArray(int[] array1, int[] array2){
        int[] hasilGabung  = new int[array1.length + array2.length];

        //salin array1
        for(int i = 0; i < array1.length; i++){
            hasilGabung[i] = array1[i];
        }

        //salin array2
        for(int i = 0; i < array2.length; i++){
            hasilGabung[array1.length + i] = array2[i];
        }
        return  hasilGabung;    

    }


}














