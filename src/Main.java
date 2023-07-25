import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // System.out.printf("Hello and welcome!");
        formattedNames();
    }
    public static void formattedNames() {
        Collection<String> names = List.of("Ihor", "Ivor", "John", "Wick", "Bob", "Marley"); //створюємо колекцію імен
        String result = IntStream.range(0, names.size()) // створюємо строку послідовність range  діапазон від 0 до розміру списку
                .filter(index -> index % 2 == 0) // Фільтруємо за непарним індексом
                .mapToObj(index -> (index + 1) + ". " + names.toArray()[index]) // Форматуємо рядок "номер. Ім'я"
                .collect(Collectors.joining(", ")); // Об'єднуємо результат в один рядок з роздільником ", "

        System.out.println(result);
    }
}