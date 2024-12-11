package Task_3;

import java.util.concurrent.ConcurrentHashMap;

public class PrimeTask implements Runnable {
    private int number;
    private ConcurrentHashMap<Integer, Boolean> resultMap;

    public PrimeTask(int number, ConcurrentHashMap<Integer, Boolean> resultMap) {
        this.number = number;
        this.resultMap = resultMap;
    }

    @Override
    public void run() {
        boolean isPrime = isPrime(number);
        resultMap.put(number, isPrime);  // Збереження результату в ConcurrentHashMap
    }

    // Метод для перевірки простоти числа
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}