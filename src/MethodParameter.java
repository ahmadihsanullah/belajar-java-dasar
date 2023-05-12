public class MethodParameter {
    public static void main(String[] args) {
        sayHello("Ahmad", "Ihsan");
        sayHello("Hanif", "Hizbulhaq");
        sayHello("Raihan", "Rizki");
    }

    static void sayHello(String fistName, String lastName){
        System.out.println("Hello " + fistName + " " + lastName);
    }
}
