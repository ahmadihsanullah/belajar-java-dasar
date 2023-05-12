public class MethodReturnValue {
    public static void main(String[] args) {
        System.out.println(sum(2,2));
        System.out.println(hitung(2,"-",1));
    }

    static int sum(int value1, int value2){
        var total = value1 + value2;
        return total;
    }

    static int hitung(int value1, String operasi, int value2){
        switch (operasi){
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            default:
                return 0;
        }
    }
}
