import impl.PersonImpl;
import impl.ProjectImpl;
import impl.Solution;
import utils.FileUtils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
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

        List<Solution> result = new ArrayList<>();

        result.add(new Solution("Name", new ArrayList<>(){{add("Nemanja");}}));

        // write to output file
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("output_" + fileName), StandardCharsets.UTF_8))) {
            writer.write(result.size() + "\n");
            result.forEach(solutionProject -> {
                try {
                    writer.write(solutionProject.getName() + "\n");

                    solutionProject.getParticipants().forEach(person -> {
                        try {
                            writer.write(person + " ");
                        } catch (IOException e) {
                            // no - op
                        }
                    });

                    writer.write("\n");

                } catch (IOException e) {
                   // no - op
                }
            });
        } catch (IOException ex) {
            // no -op
        }
    }
}
