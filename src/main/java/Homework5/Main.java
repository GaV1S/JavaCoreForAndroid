package Homework5;

public class Main {

    public static void main (String[] args) {
        Staff[] staff = new Staff[5];

        staff[0] = new Staff("Andreev Andrey Andreevich", "Electrician", "Andreev@ya.ru", "89132356589",72549.00, 37);
        staff[1] = new Staff("Vlasov Nikita Ivanovich", "Labourer", "Vlasom@bk.ru", "89059666609",12870.00, 21);
        staff[2] = new Staff("Petrov Maxim Nikolaevich", "Engineer", "Petrov@gmail.com", "89233438694",27650.00, 29);
        staff[3] = new Staff("Andruhovich Mihail Nikolaevich", "Mechanic", "and1force@gmail.com", "899058766654",55432.00, 40);
        staff[4] = new Staff("Ivanova Ksenia Pavlovna", "Secretary", "ksu.ra", "89069666699",46732.00, 46);

        final int maxAge = 40;
        for (Staff staffI : staff) {
            if (staffI.getAge() >= maxAge) {
                System.out.println(staffI);
            }
        }
    }
}