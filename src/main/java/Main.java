import impl.HireOption;
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
import java.util.concurrent.atomic.AtomicInteger;

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

        projects.forEach(project -> {
            AtomicInteger membersFound = new AtomicInteger();
            List<String> peopleWorking = new ArrayList<>();
            project.getSkills().forEach((skill, level) -> {
                people.forEach(person -> {
                    if (person.amIAvailable(project.getWorkingDays(), skill, level) == HireOption.ALONE) {
                        person.hire(project, skill, level);
                        peopleWorking.add(person.getName());
                        membersFound.getAndIncrement();
                    }
                });
            });

            if (project.getNumOfRoles() == membersFound.intValue()) {
                result.add(new Solution(project.getName(), peopleWorking));
            }
        });

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
