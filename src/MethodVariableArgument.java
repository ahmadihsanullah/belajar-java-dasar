public class MethodVariableArgument {
    public static void main(String[] args) {
        int[] values = {80,90,95,88,82};

        MethodVariableArgument.sayCongrats("Ihsan", values);
        sayCongratsWithVariableArguments("Budi", 80,90,100,78,100,99,61);
        sayCongratsWithVariableArguments("Budi", values);
    }

    static void sayCongrats(String name, int[] values){
        int total = 0;
        for(var value : values){
            total+= value;
        }
        int finalValue = total / values.length;

        if(finalValue >= 85){
            System.out.println("Selamat " + name + " Anda Lulus");
        }else{
            System.out.println("Maaf " + name + " Anda Tidak Lulus");
        }
    }

    //method with variable arguments
    static void sayCongratsWithVariableArguments(String name, int... values){
        int total = 0;
        for(var value : values){
            total+= value;
        }
        int finalValue = total / values.length;

        if(finalValue >= 85){
            System.out.println("Selamat " + name + " Anda Lulus");
        }else{
            System.out.println("Maaf " + name + " Anda Tidak Lulus");
        }
    }

}
