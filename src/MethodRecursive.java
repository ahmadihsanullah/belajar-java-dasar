import java.util.Scanner;

public class MethodRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialWithRecursive(5));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Nilai : ");
        var nilai = scanner.nextInt();
        int jumlah = jumlahNilai(nilai);
        System.out.println("Jumlah nilai : " + jumlah);

        int jumlahFactorial = factorialKeDua(nilai);
        System.out.println("jumlah Factorial : " + jumlahFactorial);
//        loop(10000); stack overflow
    }

    static int factorial(int value){
        int result = 1;

        for(var counter = 1 ; counter <= value; counter++){
            result *= counter;
        }

        for (var counter = value; counter >= 1; counter-- ){
            result*= counter;
        }
        return  result;
    }

    static int factorialWithRecursive(int value){
        if(value == 1){
            return  1;
        }
        return value * factorialWithRecursive(value - 1);
    }

    /**
     * Walaupun recursive method itu sangat menarik, namun kita perlu berhati-hati
     * Jika recursive terlalu dalam, maka  akan ada kemungkinan  terjadi error StackOverflow,
     * yaitu error dimana stack method terlalu banyak di Java
     */

    static void loop(int value){
        if(value == 0 ){
            System.out.println("SELESAI");
        }else{
            System.out.println("loop ke - " + value);
            loop(value - 1);
        }
    }

    private static int jumlahNilai(int value){
        if(value == 0){
            return value;
        }
        return value + jumlahNilai(value - 1);
    }

    private static int factorialKeDua(int value){
        if(value == 1){
            return value;
        }
        return value * factorialKeDua(value - 1);
    }

}
