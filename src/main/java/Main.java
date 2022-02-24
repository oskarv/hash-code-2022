import impl.PersonImpl;
import impl.ProjectImpl;
import impl.Solution;
import utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtils fileUtils = new FileUtils();
        String fileName = "a_an_example.in.txt";
        InputStream is = new FileUtils().getFileAsIOStream(fileName);

        List<PersonImpl> people = new ArrayList<>();
        List<ProjectImpl> projects = new ArrayList<>();
        Collections.shuffle(projects);

        fileUtils.loadInputParams(is, people, projects);
        System.out.println("Input file loaded");

        Algorithm algorithm = new Algorithm(projects, people);

        List<Solution> result = algorithm.result();

        new FileUtils().createOutputFile(result, fileName);
    }
}
