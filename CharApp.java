import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CharApp {
    public static void main(String[] args) throws IOException {
        // Adds args (filenames) to list
        List<String> fileNames = Arrays.asList(args);

        var charList = new CharChart();

        // Sends filenames to method occurances
        charList.occurances(fileNames.toArray(new String[fileNames.size()]));

    }
}
