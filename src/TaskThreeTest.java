import java.util.Arrays;
import java.util.stream.Collectors;

public class TaskThreeTest {
    public static void main(String[] args) {
        String[] array = {"1, 2, 7", "4, 5", "0, 6"}; //дано масив строк в якій масив чисел
        String result = Arrays.stream(array)  // створюємо результуючу строку
                .flatMap(s -> Arrays.stream(s.split(", ")))// flatMap для отримання колекції чисел з масиву масивів
                .map(Integer::parseInt) // перетворюємо рядки на числа
                .sorted() // відсортувати числа
                .map(Object::toString) // перетворити числа на рядки
                .collect(Collectors.joining(", ")); // збираємо рядок з числами, делімітер комами

        System.out.println(result); // виводим результат
    }
}
