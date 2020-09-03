package chapter8.session3;

public class FieldHasNoPolymorphic {
    static class Father {
        public int money = 1;
        public Father() {
            money = 2;
            showMeTheMoney();
        }
        public void showMeTheMoney() {
            System.out.println("father, money: " + money);
        }
    }

    static class Son extends Father {
        public int money = 3;
        public Son() {
            money = 4;
            showMeTheMoney();
        }
        public void showMeTheMoney() {
            System.out.println("son, money: " + money);
        }
    }

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("money: " + guy.money);
        guy.showMeTheMoney();
    }
}
