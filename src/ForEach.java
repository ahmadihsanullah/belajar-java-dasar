public class ForEach {
    public static void main(String[] args) {
        String[] names = {
                "Ahmad", "Ihsanullah", "Rabbani"
        };

        for(var i = 0; i< names.length ; i++){
            System.out.println(names[i]);
        }

        System.out.println("FOR EACH");
        for(var name : names){
            System.out.println(name);
        }
    }
}
