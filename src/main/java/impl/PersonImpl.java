package impl;

import interfaces.Person;

import java.util.Map;

public class PersonImpl implements Person {

    private String name;

    private Map<String, Integer>  skills;

    private int lastWorkingDay = 0;

    public PersonImpl(String name, Map<String, Integer> skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public Integer hasSkill(String skill) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public boolean amIAvailable(int currentDay) {
        return currentDay >= lastWorkingDay;
    }

    public void hire(int days) {
        lastWorkingDay += days;
    }


}
