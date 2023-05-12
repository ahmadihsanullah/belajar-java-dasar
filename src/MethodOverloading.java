public class MethodOverloading {
    public static void main(String[] args) {
        sayHello();
        sayHello("ahmad");
    }

//    Method overloading adalah kemampuan membuat method dengan nama yang sama lebih dari sekali
    static  void sayHello(){
        System.out.println("Hello");
    }

    static  void sayHello(String firstName){
        System.out.println("Hello " + firstName );
    }
}
