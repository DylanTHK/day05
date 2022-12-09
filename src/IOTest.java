import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        int size = 0;
        try {
            InputStream is = new FileInputStream("myfile.txt");
            OutputStream os = new FileOutputStream("copy of myfile.txt");
    
            while (true) {
                size = is.read(buffer);
                System.out.println(size);
            }
    

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
}