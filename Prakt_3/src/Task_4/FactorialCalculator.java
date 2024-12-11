package Task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FactorialCalculator {
    public static void main(String[] args) {
        // Створення пулу потоків
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Масив чисел для обчислення факторіалів
        int[] numbers = {5, 7, 10, 12, 15};

        // Список Future для отримання результатів
        List<Future<Long>> futures = new ArrayList<>();

        // Додавання задач в пул потоків
        for (int num : numbers) {
            FactorialTask task = new FactorialTask(num);
            futures.add(executorService.submit(task)); // submit() повертає Future
        }

        // Очікуємо завершення всіх задач та отримуємо результати
        for (int i = 0; i < numbers.length; i++) {
            try {
                // Отримуємо результат через Future
                Long result = futures.get(i).get();
                System.out.println("Factorial of " + numbers[i] + " is " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Завершення роботи пулу потоків
        executorService.shutdown();
    }
}
