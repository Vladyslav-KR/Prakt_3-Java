package Task_2;

public class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    // Синхронізований метод для поповнення рахунку
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Поповнення на " + amount + " грн. Баланс: " + balance);
        }
    }

    // Синхронізований метод для зняття грошей з рахунку
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Знято " + amount + " грн. Баланс: " + balance);
        } else {
            System.out.println("Недостатньо коштів для зняття " + amount + " грн.");
        }
    }

    public double getBalance() {
        return balance;
    }
}