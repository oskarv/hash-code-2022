package impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProjectImpl {

    private int workingDays;
    private int bestBefore;
    private int score;
    private int numOfRoles;
    private List<String> skillNames = new ArrayList<>();
    private Map<String, Integer> skills = new HashMap<>();
    private String name;
    private List<PersonImpl> hiredPeople = new ArrayList<>();
    private int startDate;

    public ProjectImpl(String name, int workingDays, int score, int bestBefore, int numOfRoles) {
        this.name = name;
        this.workingDays = workingDays;
        this.score = score;
        this.bestBefore = bestBefore;
        this.numOfRoles = numOfRoles;
    }



    public void addSkill(String skillName, int skillLevel) {
        skills.put(skillName, skillLevel);
        skillNames.add(skillName);
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getSkillNames() {
        return skillNames;
    }

    public void setSkillNames(List<String> skillNames) {
        this.skillNames = skillNames;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfRoles() {
        return numOfRoles;
    }

    public void setNumOfRoles(int numOfRoles) {
        this.numOfRoles = numOfRoles;
    }

    public List<PersonImpl> getHiredPeople() {
        return hiredPeople;
    }

    public void setHiredPeople(List<PersonImpl> hiredPeople) {
        this.hiredPeople = hiredPeople;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
}
