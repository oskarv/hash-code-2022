package utils;

import impl.PersonImpl;
import impl.ProjectImpl;
import impl.Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class FileUtils {
  public InputStream getFileAsIOStream(final String fileName) {
    InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

    if (ioStream == null) {
      throw new IllegalArgumentException(fileName + " not found.");
    }
    return ioStream;
  }

  public void loadInputParams(InputStream is, List<PersonImpl> people, List<ProjectImpl> projects) throws IOException {
    try (InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {
      String line;

      // first line
      line = br.readLine();
      String[] params = line.split(" ");
      int numberOfContributors = Integer.parseInt(params[0]);
      int numberOfProjects = Integer.parseInt(params[1]);

      for (int i = 0; i < numberOfContributors; i++) {
        line = br.readLine();
        params = line.split(" ");
        String personName = params[0];
        PersonImpl person = new PersonImpl(personName, new HashMap<>());

        int numberOfSkills = Integer.parseInt(params[1]);
        for(int j = 0; j < numberOfSkills; j++) {
          line = br.readLine();
          String[] personSkill = line.split(" ");
          person.getSkills().put(personSkill[0], Integer.parseInt(personSkill[1]));
        }
        people.add(person);
      }

      for (int i = 0; i < numberOfProjects; i++) {
        line = br.readLine();
        params = line.split(" ");
        String projectName = params[0];
        int numberOfRoles = Integer.parseInt(params[4]);
        ProjectImpl project = new ProjectImpl(projectName,
            Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]), numberOfRoles);

        for(int j = 0; j < numberOfRoles; j++) {
          line = br.readLine();
          String[] projectSkill = line.split(" ");
          project.addSkill(projectSkill[0], Integer.parseInt(projectSkill[1]));
        }
        projects.add(project);
      }

      is.close();
    }
  }

  public void createOutputFile(List<Solution> result, String fileName) {
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