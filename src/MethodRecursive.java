public class MethodRecursive {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialWithRecursive(5));
        loop(10000);
    }

    static int factorial(int value){
        int result = 1;

        for(var counter = 1 ; counter <= value; counter++){
            result *= counter;
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
}
