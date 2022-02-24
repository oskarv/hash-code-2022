package impl;

import interfaces.Project;

import java.util.List;
import java.util.Map;


public class ProjectImpl implements Project {

    private int workingDays;

    private int bestBefore;

    private int score;

    private List<String> skillNames;

    private Map<String, Integer> skills;


    public ProjectImpl(int workingDays, int bestBefore, int score) {
        this.workingDays = workingDays;
        this.bestBefore = bestBefore;
        this.score = score;
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
}
