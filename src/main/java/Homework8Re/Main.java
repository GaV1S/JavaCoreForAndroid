package Homework8Re;

public class Main {

    public static void main(String[] args) {

        CatBuilder newBuildCat = new CatBuilder();
        newBuildCat.setName("Паттерн");
        newBuildCat.setMaxRun(70);
        newBuildCat.setMaxJump(150);
        Cat newCat = newBuildCat.build();

        Overcoming[] hurdlers = new Overcoming[7];
        hurdlers[0] = new Cat("Мурзик", 100, 200);
        hurdlers[1] = new Cat("Нафаня", 50,100);
        hurdlers[2] = new Human("Рада", 150,100);
        hurdlers[3] = new Human("Мира", 200,300);
        hurdlers[4] = new Robot("Алиса", 0,100);
        hurdlers[5] = new Robot("Сири", 200,0);
        hurdlers[6] = newCat;

        Accepting[] hurdles = new Accepting[4];
        hurdles[0] = new Runway("Препятствие 1", 50);
        hurdles[1] = new Runway("Препятствие 2", 120);
        hurdles[2] = new Wall("Препятствие 3", 50);
        hurdles[3] = new Wall("Препятствие 4", 120);

        for (Accepting hurdle : hurdles) {
            System.out.println(hurdle.printOption());
        }
        System.out.println();


        for (Overcoming hurdler : hurdlers) {
            for (Accepting hurdle : hurdles) {
                if (!hurdler.run(hurdle.getOption()) || !hurdler.jump(hurdle.getOption())) { break; }
            }
        }
    }
}
