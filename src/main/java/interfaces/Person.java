package interfaces;

public interface Person {

    Integer hasSkill(String skill);

    String getName();

    public boolean amIAvailable(int currentDay);

    public void hire(int days);

}
