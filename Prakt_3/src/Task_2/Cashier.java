package Task_2;

public class Cashier implements Runnable {
    private String cashierName;
    private Account account;

    public Cashier(String cashierName, Account account) {
        this.cashierName = cashierName;
        this.account = account;
    }

    @Override
    public void run() {
        // Кожен касир намагається поповнити та зняти гроші
        account.deposit(100); // Поповнюємо рахунок на 100
        account.withdraw(50); // Знімаємо 50
        account.withdraw(200); // Спроба зняти більше, ніж на рахунку
    }
}
