package milton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class testMain {
    
    public static void main(String[] args) {
        String path = "./new.csv";
        
        try {
            File file = new File(path);
            file.createNewFile();
        } catch (IOException e) {
            e.getMessage();
        } 
    }
}
