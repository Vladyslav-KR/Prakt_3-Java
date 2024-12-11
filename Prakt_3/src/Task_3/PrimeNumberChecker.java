package Task_3;

import java.util.concurrent.*;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        // Створення пулу потоків
        ExecutorService executorService = Executors.newFixedThreadPool(10); // пул з 10 потоків

        // Створення ConcurrentHashMap для збереження результатів
        ConcurrentHashMap<Integer, Boolean> resultMap = new ConcurrentHashMap<>();

        // Масив чисел для перевірки на простоту
        int[] numbers = {1, 2, 3, 4, 5, 10, 17, 18, 19, 25, 29, 35};

        // Додавання задач в пул потоків
        for (int num : numbers) {
            executorService.submit(new PrimeTask(num, resultMap)); // Завдання для кожного числа
        }

        // Завершення роботи пулу потоків
        executorService.shutdown();

        try {
            // Очікування завершення всіх задач
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        // Виведення результатів
        for (int num : numbers) {
            System.out.println(num + " is prime: " + resultMap.get(num));
        }
    }
}