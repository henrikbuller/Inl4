
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Henrik Büller
 */

public class CharChart {

    /**
     * Reads text files, counts occurences of characters and prints the count of
     * each characters.
     * 
     * @param fileNames to read and count occurences in.
     * 
     * @throws IOException If an input or output exception occurred
     */

    public void occurances(String... fileNames) throws IOException {
        Map<Character, Integer> charMap = new TreeMap<>();

        // Read and count character occurences on all textfiles provided
        for (String file : fileNames) {
            Path textFile = Paths.get(file);

            // Check if file exist
            // if not print error message then continue
            if (!Files.exists(textFile)) {
                System.out.println("File" + textFile + " does not exist ");
                continue;
            }

            try (var reader = Files.newBufferedReader(textFile, Charset.forName("utf-8"))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    char[] charArray = line.replace(" ", "").toCharArray();
                    for (char c : charArray) {
                        if (charMap.containsKey(c)) {
                            // if char exists in charMap, value +1
                            charMap.put(c, charMap.get(c) + 1);
                        } else {
                            // if char doesn't exist in charMap
                            // Add it and set value to 1
                            charMap.put(c, 1);
                        }
                    }
                }

            }
        }
        // Print character occurences
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}
