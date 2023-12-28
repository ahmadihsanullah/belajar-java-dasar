import java.io.*;

public class CharacterStream {
    public static void main(String[] args) throws IOException {
        //Byte Steam I/O
        FileInputStream fileInputByte = new FileInputStream("input.txt");
        FileOutputStream fileOutputByte = new FileOutputStream("outputBYte.txt");

        //Character Steam I/O
        FileReader fileInputCharacter = new FileReader("input.txt");
        FileWriter fileOutputCharacter = new FileWriter("outputCharacter.txt");

        //membaca file dengan byte stream
        int buffer = fileInputByte.read();
        while(buffer != -1){
            System.out.print((char)buffer);
            fileOutputByte.write(buffer);
            buffer = fileInputByte.read();
        }
        System.out.println("\n");

        //membaca file dengan byte stream
        buffer = fileInputCharacter.read();
        while(buffer != -1){
            System.out.print((char)buffer);
            fileOutputCharacter.write(buffer);
            buffer = fileInputCharacter.read();
        }

        //menutup file
        fileInputByte.close();
        fileOutputByte.close();
        fileInputCharacter.close();
        fileOutputCharacter.close();

        //pada dasarnya menggunakan byte maupun karakter termasuk
        //Unbuffered I/O
        //dimana data akan dimasukan langsung kedalam filenya, sehingga
        // ini tidak efektif karena menggunakan disk
        // baiknya simpan dulu kedalam aplikasi (memori)
        //karena memori lebih cepat


    }
}
