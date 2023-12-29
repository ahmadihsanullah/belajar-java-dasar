import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerAndStringTokenizer {
    public static void main(String[] args) throws IOException {
        FileReader fileInput = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);

        Scanner scanner = new Scanner(bufferedReader);
        // ini untuk cek ada kata selanjutnya atau tidak
        System.out.println(scanner.hasNext()); // true

        // untuk membaca kata, dengan pemisah/delimeter spasi
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());
        System.out.println(scanner.next());        
        System.out.println(scanner.next());

        System.out.println(scanner.hasNext()); // false

        // Menggunakan delimiter tertentu
        FileReader fileInput2 = new FileReader("input2.txt");
        bufferedReader = new BufferedReader(fileInput2);
        bufferedReader.mark(200);

        scanner = new Scanner(bufferedReader);
        scanner.useDelimiter(",");

        System.out.println("\n");
        System.out.println(scanner.next());
        
        // while (scanner.hasNext()) {
        //     System.out.println(scanner.next());
        // }

        //menggunakan string tokenizer
        
        bufferedReader.reset();
        String data = bufferedReader.readLine();

        StringTokenizer stringTokenizer = new StringTokenizer(data, ",");

        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

        data = bufferedReader.readLine();
        
        StringTokenizer sTokenizer = new StringTokenizer(data, ",");
         while (sTokenizer.hasMoreTokens()) {
            System.out.println(sTokenizer.nextToken());
        }

    }
}
