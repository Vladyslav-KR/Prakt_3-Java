package Task_1;

public class Cashier implements Runnable {
    private String cashierName;

    public Cashier(String cashierName) {
        this.cashierName = cashierName;
    }

    @Override
    public void run() {
        // Симулюємо обслуговування клієнта
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer("Customer " + i);
            System.out.println(cashierName + " обслуговує " + customer.getName());
            try {
                Thread.sleep(1000); // Симулюємо час на обслуговування клієнта
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
