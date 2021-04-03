package Homework8Re;

public class CatBuilder {
    private String name;
    private int maxRun;
    private int maxJump;

    public void setName(String name) {
        this.name = name;
    }

    public void setMaxRun(int maxRun) {
        this.maxRun = maxRun;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

    public Cat build() {
        return new Cat(name,maxRun,maxJump);
    }
}
