public class TipeDataNumber {
    public static void main(String[] args) {
//        tipe data number
//       1. Integer number
        byte iniByte = 100;
        short iniShort = 1000;
        int iniInt = 10000;
        long iniLong = 1000000;
        long iniLong2 = 1000000L;

//        2. Floating point
        float iniFloat = 10.10F;
        double iniDouble = 12.2121;

//        decimal, hexadesimal dan binary
        int decimalInt = 10;
        int hexadecimalInt = 0xFFFFF;
        int binaryInt = 0b10101;

//        underscore untuk pemisah angka yang banyak
        long amount = 1_000_000_000;
        System.out.println(amount);

    }
}
