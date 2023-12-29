import java.util.StringTokenizer;

public class TipeDataString {
    public static void main(String[] args) {
        String firstName = "Ahmad Ihsanullah Rabbani Hanif Hiz Bul Haq";
        String lastName = "Rabbani";
        String[] names = firstName.split(" ");
        StringTokenizer namesWithTokenizer = new StringTokenizer(firstName, " ");
        while(namesWithTokenizer.hasMoreTokens()){
            System.out.println(namesWithTokenizer.nextToken());
        }
        for(String name : names){
            System.out.println(name);
        }

        String cerita = """
                lorem ipsum lorem ipsum lorem ipsum
                lorem ipsum lorem ipsum lorem ipsum
                lorem ipsum lorem ipsum lorem ipsum
                """;
        
        String[] ceritas = cerita.split(" ");
        for(String kata : ceritas){
            System.out.println(kata);
        }

        StringTokenizer sTokenizer = new StringTokenizer(cerita, " ");
        while(sTokenizer.hasMoreTokens()){
            System.out.println(sTokenizer.nextToken());
        }


        System.out.println(firstName);
        System.out.println(lastName);

//        menggabungkan string

        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

    }
}
