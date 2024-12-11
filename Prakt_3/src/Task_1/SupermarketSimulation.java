package Task_1;

public class SupermarketSimulation {
    public static void main(String[] args) {
        // Створюємо кілька кас і запускаємо їх
        Thread cashier1 = new Thread(new Cashier("Каса 1"));
        Thread cashier2 = new Thread(new Cashier("Каса 2"));
        Thread cashier3 = new Thread(new Cashier("Каса 3"));

        cashier1.start();
        cashier2.start();
        cashier3.start();

        try {
            // Чекаємо, поки всі потоки завершаться
            cashier1.join();
            cashier2.join();
            cashier3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Всі клієнти обслужені.");
    }
}

