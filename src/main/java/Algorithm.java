import impl.HireOption;
import impl.PersonImpl;
import impl.ProjectImpl;
import impl.Solution;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {

    private List<ProjectImpl> activeProjects = new ArrayList<>();

    private List<Solution> solutions = new ArrayList<>();

    private List<ProjectImpl> allProjects;

    private List<PersonImpl> allPersons;

    public Algorithm(List<ProjectImpl> allProjects, List<PersonImpl> allPersons) {
        this.allProjects = allProjects;
        this.allPersons = allPersons;
    }

    private  ProjectImpl chooseBestProject() {
        Collections.shuffle(allProjects);
        return allProjects.get(0);
    }

    private List<PersonImpl> chooseBestPpl(ProjectImpl project, Integer currentDay) {
        List<PersonImpl> hiredPpl = new ArrayList<>();
        project.getSkillNames().forEach((skill) -> {
                    int level = project.getSkills().get(skill);
                    PersonImpl p = allPersons.stream().filter(person -> person.amIAvailable(currentDay, skill, level) == HireOption.ALONE).findFirst().orElse(null);
                    if (p == null) {
                        hiredPpl.forEach(PersonImpl::finishProject);
                        throw new RuntimeException("Kita");
                    }
                    hiredPpl.add(p);
                    p.hire(project, skill, level);
                }
        );
        return hiredPpl;
    }

    public void releasePeopleFromProjects(int currentDay) {
        List<ProjectImpl> endedProjects = activeProjects.stream().filter(
                x -> x.getStartDate() + x.getWorkingDays() <= currentDay
        ).collect(Collectors.toList());

        System.out.println(endedProjects);


        for (int i=0; i< endedProjects.size(); i++){
            List<PersonImpl> hiredPeople = endedProjects.get(i).getHiredPeople();
            for (int j=0; j<hiredPeople.size(); j++){
                hiredPeople.get(j).finishProject();
            }
        }

    }

    public List<Solution> result() {
        int currentDay = 0;

        while(!allProjects.isEmpty() && currentDay < 100) {
            ProjectImpl project = chooseBestProject();
            activeProjects.add(project);
            List<PersonImpl> bestPpl;
            System.out.println(currentDay);
            try {
                chooseBestPpl(project, currentDay);
            } catch (RuntimeException e) {
                currentDay += 1;
                releasePeopleFromProjects(currentDay);
                continue;
            }
            solutions.add(new Solution(project.getName(),project.getHiredPeople().stream().map(PersonImpl::getName).collect(Collectors.toList()) ));
            allProjects.remove(project);
            currentDay += 1;
            releasePeopleFromProjects(currentDay);
        }

        return  solutions;
    }



}
