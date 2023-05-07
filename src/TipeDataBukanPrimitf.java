public class TipeDataBukanPrimitf {
    public static void main(String[] args) {
            Integer iniInteger = 100;
            Long iniLong = 10000L;

            Byte iniByte = null;
            System.out.println(iniByte);
            iniByte = 100;
            System.out.println(iniByte);

//            primitif <=> non-primitif
            int iniPrimitif = 100;
            Integer iniObject = iniPrimitif;
            short iniShort = iniObject.shortValue();
            System.out.println(iniShort);
            long iniLong2 = iniObject.longValue();
            float iniFloat = iniObject.floatValue();
    }
}
