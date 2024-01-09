import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BufferedCharStream{
    public static void main(String[] args) throws IOException {
        //membaca file
        FileReader fileInput = new FileReader("inputBufferedReader.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);
        bufferedReader.mark(200);
        // membaca ke dalam string
        String data = bufferedReader.readLine();
        System.out.println(data);
        
        //membaca kedalam char
        bufferedReader.reset();
        char[] dataChar = new char[data.length()];
        bufferedReader.read(dataChar,0,data.length());
        System.out.println(Arrays.toString(dataChar));

        //membaca baris
        bufferedReader.reset();
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());

        //menulis file
        FileWriter fileOutput = new FileWriter("outputBufferedCharStream.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileOutput);

        bufferedReader.reset();
        String baris1 = bufferedReader.readLine();

        System.out.println(baris1);
        bufferedWriter.write(baris1, 0, baris1.length());//baru dimasukan ke memori belum ke file yang dituju
        bufferedWriter.flush();

        // menambah new line, enter;
        bufferedWriter.newLine();

        String baris2 = bufferedReader.readLine();
        bufferedWriter.write(baris2,0,baris2.length());
        bufferedWriter.flush();

        String baris3 = "ahmad ihsanullah";
        bufferedWriter.write(baris3,0,baris3.length());
        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();
        fileInput.close();
        fileOutput.close();

    }
}






























