import java.util.Collection;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // System.out.printf("Hello and welcome!");

        formattedNames();
        printStrings("Ihor", "Ivor", "John", "Wick", "Bob", "Marley","Koliy", "Olya");
        printUperSort("Ihor", "Ivor", "John", "Wick", "Bob", "Marley", "Koliy", "Olya");
    }

    public static void printStrings(String... names) {
        IntPredicate isOddIndex = index -> index % 2 == 0;  // створюємо функціонального інтерфейсу, який перевіряє, чи є індекс непарним
        List<String> filteredNames = IntStream.range(0, names.length)// Згенерувати послідовність індексів від 0 до довжини масиву `names`
                .filter(isOddIndex)      // Відфільтрувати індекси за допомогою `isOddIndex`
                .mapToObj(index -> (index + 1) + ". " + names[index]) // Мапимо індекси на рядки у вказаному форматі ("індекс. ім'я"
                .collect(Collectors.toList()); // Збираємо рядки у список `filteredNames`

        System.out.println(String.join(", ", filteredNames));
    }
    public static void formattedNames() {
        Collection<String> names = List.of("Ihor", "Ivor", "John", "Wick", "Bob", "Marley"); //створюємо колекцію імен
        String result = IntStream.range(0, names.size()) // створюємо строку послідовність range  діапазон від 0 до розміру списку
                .filter(index -> index % 2 == 0) // Фільтруємо за непарним індексом
                .mapToObj(index -> (index + 1) + ". " + names.toArray()[index]) // Форматуємо рядок "номер. Ім'я"
                .collect(Collectors.joining(", ")); // Об'єднуємо результат в один рядок з роздільником ", "

        System.out.println(result);
    }
    public static void printUperSort (String... names){
        List<String> uppercaseList = IntStream.range(0, names.length)  // створюємо ліст з строки
                .mapToObj(i -> names[i].toUpperCase())                 // переводимо кожен елемент ліста у верхній регість
                .collect(Collectors.toList());                         // збираємо слова приведені до верхнього регістру у список
        List<String> sortedList = uppercaseList.stream()               // створюємо списк для сортування на основі списка у верхньому регістру
                .sorted((s1, s2) -> s2.compareTo(s1))                  // Порівнюємо рядки в зворотньому порядку
                .collect(Collectors.toList());                         // створюємо списк на основі відсортованого списка
        String result = IntStream.range(0, sortedList.size())          // створюємо строку на основі відсортованого списку
                .mapToObj(i -> (i + 1) + ". " + sortedList.get(i))     // нумеруємо рядки
                .collect(Collectors.joining(", "));            // добавляємо , і пробіл між словами
        System.out.println(result);                                    // виводимо результат
    }
}