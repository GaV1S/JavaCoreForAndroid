package Homework10.Second;

public class Main {

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();

        myPhoneBook.add("Гаврилов", "89059788431");
        myPhoneBook.add("Гаврилова", "89233438694");
        myPhoneBook.add("Гаврилова", "89069666699");
        myPhoneBook.add("И", "89059668349");

        myPhoneBook.get("Гаврилов");
    }
}

