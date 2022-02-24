import impl.PersonImpl;
import impl.ProjectImpl;
import interfaces.Person;
import interfaces.Project;
import utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileUtils fileUtils = new FileUtils();
        InputStream is = new FileUtils().getFileAsIOStream("a_an_example.in.txt");

        List<PersonImpl> people = new ArrayList<>();
        List<ProjectImpl> projects = new ArrayList<>();
        fileUtils.loadInputParams(is, people, projects);
        System.out.println("1");
    }
}
