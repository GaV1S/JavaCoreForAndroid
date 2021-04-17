package Homework6;

public class Animal {
    private String name;
    private int distanceForRun;
    private int distanceForSwim;

    public Animal (String name, int distanceForRun, int distanceForSwim){
        this.name = name;
        this.distanceForSwim = distanceForSwim;
        this.distanceForRun = distanceForRun;
    }

    public String run(int distance) {
        if (this.distanceForRun == 0)
            return (this.name + " не умеет бегать");
        else
            if (distance <= this.distanceForRun)
                return (this.name + " пробежал " + distance + "м");
            else
                return (this.name + " пробежал " + this.distanceForRun + "м и устал");
    }

    public String swim(int distance) {
        if (this.distanceForSwim == 0)
            return (this.name + " не умеет плавать");
        else
            if (distance <= this.distanceForSwim)
                return (this.name + " проплыл " + distance + "м");
            else
                return (this.name + " проплыл " + this.distanceForSwim + "м и устал");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceForRun() {
        return distanceForRun;
    }

    public void setDistanceForRun(int distanceForRun) {
        this.distanceForRun = distanceForRun;
    }

    public int getDistanceForSwim() {
        return distanceForSwim;
    }

    public void setDistanceForSwim(int distanceForSwim) {
        this.distanceForSwim = distanceForSwim;
    }
}