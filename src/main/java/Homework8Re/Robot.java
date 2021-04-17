package Homework8Re;

public class Robot implements Overcoming {
    private String name;
    private int maxRun;
    private int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
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
            System.out.println("Робот " + name + " пробежал дистанцию");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог пробежать " + distance + "м, устав на " + maxRun);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (maxJump >= height) {
            System.out.println("Робот " + name + " перепрыгнул стену");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть через " + height + "м, устав на " + maxJump);
            return false;
        }
    }

}