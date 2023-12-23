public class KonversiNumber {
    public static void main(String[] args) {
//        Widening Casting (Otomatis) : byte -> short -> int -> long -> float -> double
//        Narrowing Casting (Manual) : double -> float -> long -> int -> char ->  short -> byte

        //otomatis
        byte iniByte = 10;
//        String result = new String(iniByte);
        short iniShort = iniByte;;
        int iniInt = iniShort;
        long iniLong = iniInt;
        float iniFloat = iniLong;
        double iniDouble = iniFloat;

        //manual
        float iniFloat2 = (float) iniDouble;
        long iniLong2 = (long) iniFloat2;
        int iniInt2 = (int) iniLong2;
        short iniShort2 = (short) iniInt2;
        byte iniByte2 = (byte) iniShort2;
    }
}
