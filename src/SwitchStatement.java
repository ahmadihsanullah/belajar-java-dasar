public class SwitchStatement {
    public static void main(String[] args) {
        var nilai = "A";

        switch (nilai){
            case "A":
                System.out.println("Anda lulus dengan baik");
                break;
            case "B":
            case "C":
                System.out.println("Nilai anda cukup baik");
                break;
            case "D":
                System.out.println("Anda tidak lulus");
                break;
            default:
                System.out.println("Mungkin anda salah jurusan");
        }

        //switch lambda
        String ucapan;
        switch (nilai){
            case "A" -> ucapan = "Anda lulus dengan baik";
            case "B", "C" -> ucapan = "Nilai anda cukup baik";
            case "D" -> ucapan = "Anda tidak lulus";
            default -> ucapan = "Mungkin anda salah jurusan";
        }

        System.out.println(ucapan);

        // switch dengan yield, java v14+
        ucapan = switch (nilai){
            case "A":
                yield "Anda lulus dengan baik";
            case "B", "C":
                yield  "Nilai anda cukup baik";
            case "D":
                yield "Anda tidak lulus";
            default:
                yield "Mungkin anda salah jurusan";
        };

        System.out.println(ucapan);
    }
}
