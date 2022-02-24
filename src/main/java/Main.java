import utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtils fileUtils = new FileUtils();
        InputStream is = new FileUtils().getFileAsIOStream("a_an_example.in.txt");
        fileUtils.printFileContent(is);
    }
}
