import java.util.Scanner;

public class RecursiveBercabang {
    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        System.out.print("Masukan nilai : ");
        int nilai = inputUser.nextInt();
        int nilaiFibonnaci = fibonnaci(nilai, "daun atas");
        System.out.println("Nilai fibonnaci dari " + nilai +"adalah " + nilaiFibonnaci);

    }

    private static int fibonnaci(int nilai, String daun){
        System.out.println("Daun " + daun);
        System.out.println("Fibonnaci ke " + nilai);
        if(nilai == 0 || nilai == 1){
            return nilai;
        }else{
            return fibonnaci(nilai - 1, "daun kiri") + fibonnaci(nilai -2, "daun kanan");
        }

    }

}
