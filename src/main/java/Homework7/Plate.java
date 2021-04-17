package Homework7;

public class Plate {
    private int foodValue;

    public Plate (int foodValue) {this.foodValue = foodValue;}

    public boolean decreaseFood (int countEaterFood) {
        if (hasEnoughFood(countEaterFood)) {
            foodValue -= countEaterFood;
            return true;
        }

        return false;
    }

    private boolean hasEnoughFood(int requiredCountFood) {
        return foodValue >= requiredCountFood;
    }

    public void info() {
        System.out.println("plate: " + foodValue);
    }

    public void addFood(int countFood) {
        foodValue += countFood;
        System.out.println("Было добавлено еды: " + countFood);
    }
}
