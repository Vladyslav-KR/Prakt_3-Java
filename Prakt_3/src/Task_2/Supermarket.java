package Task_2;

public class Supermarket {
    public static void main(String[] args) {
        // Створюємо спільний рахунок
        Account account = new Account(500);

        // Створюємо кілька касирів
        Thread cashier1 = new Thread(new Cashier("Каса 1", account));
        Thread cashier2 = new Thread(new Cashier("Каса 2", account));
        Thread cashier3 = new Thread(new Cashier("Каса 3", account));

        // Запускаємо потоки
        cashier1.start();
        cashier2.start();
        cashier3.start();
    }
}
