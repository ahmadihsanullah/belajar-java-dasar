import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;

        //membuka file
        fileInput = new FileInputStream("input.txt");

        //membaca file
        int data = fileInput.read();

        while(data!=-1){
            System.out.println((char) data);
            data = fileInput.read();
        }

        //menutup file
        fileInput.close();

        //menggunakan try finally
        try{
            // Membuka File
            fileInput = new FileInputStream("input2.txt");
            fileOutput = new FileOutputStream("output2.txt");

            //membaca file
            int buffer = fileInput.read();
            while(buffer!=-1){
                fileOutput.write(buffer);
                buffer = fileInput.read();
            }
        }finally {
            if (fileInput != null){
                fileInput.close();
            }

            if (fileOutput != null) {
                fileOutput.close();
            }
        }

        //menggunakan try with resource sehingga close nya otomatis
        try(
                FileInputStream in = new FileInputStream("input.txt");
                FileOutputStream out = new FileOutputStream("output1.txt");
                ) {
            //membaca file
            int buffer = in.read();
            //menulis file ke file baru
            while(buffer!=-1){
                out.write(buffer);
                buffer = in.read();
            }
        }

    }
}
