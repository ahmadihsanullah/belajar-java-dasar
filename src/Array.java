public class Array {
    public static void main(String[] args) {
        String[] stringArray;
        stringArray = new String[3];

        stringArray[0] = "Ahmad";
        stringArray[1] = "Ihsanullah";
        stringArray[2] = "Rabbani";

        System.out.println(stringArray[0]);
        System.out.println(stringArray[1]);
        System.out.println(stringArray[2]);

        stringArray[0] = "Budi";

        System.out.println(stringArray[0]);

//      Iniatilizer Array
        String[] namaNama = {
                "ahmad", "ihsanullah", "rabbani"
        };
        //di Java data didalam array tidak bisa dihapus
        //opsi lain dengan mengubahnya mmenjadi null atau 0
        namaNama[0] = null;

        int[] arrayInt = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        long[] arrayLong = {
                10L, 20L, 30L
        };
        arrayLong[0] = 0;

        System.out.println(arrayLong.length);

        //array didalam array
        String[][] members = {
                {"ahmad","ihsanullah"},
                {"hanif", "hizbulhaq"},
                {"raihan", "rizki"}
        };

        //access members, array in array
        System.out.println(members[0][1]);
        System.out.println(members);

    }
}
