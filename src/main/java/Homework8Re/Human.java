package Homework8Re;

public class Human implements Overcoming {
    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    @Override
    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

    @Override
    public boolean run(int distance) {
        if (maxRun >= distance) {
            System.out.println(name + " пробежал дистанцию");
            return true;
        } else {
            System.out.println(name + " не смог пробежать " + distance + "м, устав на " + maxRun);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxJump >= height) {
            System.out.println(name + " перепрыгнул стену");
            return true;
        } else {
            System.out.println(name + " не смог перепрыгнуть через " + height + "м, устав на " + maxJump);
            return false;
        }
    }

}