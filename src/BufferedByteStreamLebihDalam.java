import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.InvalidMarkException;

public class BufferedByteStreamLebihDalam {
    public static void main(String[] args) throws IOException {
        FileInputStream byteInput2 = new FileInputStream("input.txt");
        BufferedInputStream bufferedInput = new BufferedInputStream(byteInput2);

        bufferedInput.mark(3); // Memanggil mark dengan readlimit 3
        byte[] bytesRead = new byte[5]; // Membaca 5 byte
        bufferedInput.read(bytesRead);

// Pemanggilan reset() akan menyebabkan InvalidMarkException
        try {
            bufferedInput.reset();
            byte[] data = bufferedInput.readAllBytes();
            String dataString = new String(data);
            System.out.println(dataString);
        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            bufferedInput.close();
            byteInput2.close();
        }

    }
}
