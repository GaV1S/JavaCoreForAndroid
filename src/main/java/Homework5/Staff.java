package Homework5;

public class Staff {

    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double wages;
    private int age;

    public Staff(String fullName, String position, String email, String phone, double wages, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.wages = wages;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getWages() {
        return wages;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", wages=" + wages +
                ", age=" + age +
                '}';
    }
}
