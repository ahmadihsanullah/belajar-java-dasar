import java.util.Arrays;

public class OperasiMatrix {
    public static void main(String[] args) {
        int[][] martix1 = {
                {1, 2, 3},
                {4, 5, 6},
        };

        int[][] martix2 = {
                {11,12,13},
                {14,15,16},
        };

        //menjumlahkan 2 buah matrix
        int[][] hasilTambah = tambahMatrix(martix1, martix2);
        printArray(hasilTambah);

        //perkalian matrix

        int[][] matrixA = {
                {2,4,3},
                {2,3,3},
                {5,7,3}
        };
        int[][] matrixB = {
                {2},
                {4},
                {5},
        };


        int[][] hasilKali = kaliMatric(matrixA, matrixB);
        printArray(hasilKali);

    }

    private static int[][] kaliMatric(int[][] matrixA, int[][] matrixB){
        int baris_matrixA = matrixA.length;
        int kolom_matrixA = matrixA[0].length;

        int baris_matrixB = matrixB.length;
        int kolom_matrixB = matrixB[0].length;

        //jika a . b  maka jumlah baris akan mengikuti matrix a, kolom
        // akan mengikuti matrix b

        if(kolom_matrixA != baris_matrixB){
            System.out.println("baris dan kolom tidak sesuai");
        }
        int[][] hasil = new int[baris_matrixA][kolom_matrixB];
        int buffer;
        for (int i = 0; i < baris_matrixA ; i++) {
            for (int j = 0; j < kolom_matrixB; j++) {
                buffer = 0;
                for(int k = 0; k <kolom_matrixA;k++){
                    buffer+= (matrixA[i][k] * matrixB[k][j]);
                }
                hasil[i][j] = buffer;
            }
        }
        return hasil;
    }

    private static int[][] tambahMatrix(int[][] matrix1, int[][] matrix2){
        //menjumlahkan 2 buah matrix
        int baris_matrix1 = matrix1.length;
        int kolom_matrix1 = matrix1[0].length;

        int baris_matrix2 = matrix2.length;
        int kolom_matrix2 = matrix2[0].length;
        int[][] hasil = new int[baris_matrix1][kolom_matrix1];

        if(baris_matrix1 == baris_matrix2 && kolom_matrix1 == kolom_matrix2){
            for(int i = 0; i < baris_matrix1;i++){
                for(int j = 0; j < kolom_matrix2;j++){
                    hasil[i][j] = matrix1[i][j]+ matrix1[i][j];
                }
            }
        }else{
            System.out.print("baris dan kolom tidak sesuai");
        }

        return hasil;
    }

    private static void printArray(int[][] array){
        int baris = array.length;
        int kolom = array[0].length;
        for(int i=0; i<baris; i++){
            System.out.print("[");
            for (int j=0; j<kolom; j++){
                System.out.print(array[i][j]);
                if (j < (kolom - 1)) {
                    System.out.print(",");
                }else{
                    System.out.print("]");
                }
            }
            System.out.print("\n");
        }
    }

}
