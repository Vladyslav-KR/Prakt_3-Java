package Task_4;

import java.util.concurrent.Callable;

public class FactorialTask implements Callable<Long> {
    private int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        return factorial(number);
    }

    private long factorial(int n) {
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}