package milton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        
        String fileName = args[0];
        String line;
        Integer totalWords = 0;
        HashMap<String, Integer> wordHistogram = new HashMap<String, Integer>();
        
        System.out.println("Processing " + fileName);
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fileReader);
            
            for (int i = 0; i < 100; i++) {
                line = reader.readLine();
                // additional condition to limit lines to 100
                if (null == line || (i > 100)) {
                    break;
                }

                // prints each sentence our
                // System.out.printf("%d: %s\n", i, line);
                
                // generate array of words
                String[] words = line.trim().toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
                totalWords += words.length;

                // Generating word histogram hashmap
                for (String word : words) {
                        // Adds one to specific key count
                    if (wordHistogram.containsKey(word)) {
                        Integer wordCount = wordHistogram.get(word);
                        wordCount++;
                        wordHistogram.put(word, wordCount);
                    } else {
                        // Adds new entry
                        wordHistogram.put(word, 1);
                    }
                }
            }
            // Close the file when done
            fileReader.close();
            reader.close();
            
            System.out.printf("The number of words in first 100 lines: %d\n", totalWords);

            int i = 0;
            // print wordHistogram hashmap
            for (Map.Entry<String, Integer> entry : wordHistogram.entrySet()) {
                i++;
                System.out.printf("%d. %s - %d\n", i, entry.getKey(), entry.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}