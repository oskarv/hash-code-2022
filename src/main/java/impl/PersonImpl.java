package impl;


import java.util.Map;

public class PersonImpl {

    private String name;

    private Map<String, Integer>  skills;

    private int lastWorkingDay = 0;

    private ProjectImpl currentProject;

    private String currentSkill;

    private Integer currentLevel;

    public PersonImpl(String name, Map<String, Integer> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return null;
    }

    public HireOption amIAvailable(int currentDay, String skill, int requiredLevel) {
        if (currentDay <= lastWorkingDay && skills.getOrDefault(skill, 0) < requiredLevel - 1) {
            return HireOption.NONE;
        }

        if(skills.getOrDefault(skill, 0) == requiredLevel - 1) {
            return HireOption.INTER;
        }

        return HireOption.ALONE;
    }

    public void hire(ProjectImpl project, String skill, int requiredLevel) {
        lastWorkingDay += project.getWorkingDays();
        currentProject = project;
        currentLevel = requiredLevel;
        currentSkill = skill;
    }

    public boolean canIBeMentor(String skill, int requiredLevel) {
        return skills.getOrDefault(skill, 0) >= requiredLevel;
    }

    public void finishProject() {
        Integer currentLevel = skills.getOrDefault(currentSkill, 0);
        if (currentLevel <= currentProject.getSkills().get(currentSkill)) {
            skills.put(currentSkill, currentLevel + 1);
        }
        this.currentProject = null;
    }


    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

}
