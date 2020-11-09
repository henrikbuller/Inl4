import java.io.IOException;

public class CharApp {
    public static void main(String[] args) throws IOException {
        var charList = new CharChart();

        // Sends filenames to method occurances
        charList.occurances(args);

    }
}
