import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // System.out.printf("Hello and welcome!");
        List<String> list = List.of("Ihor", "Ivor", "John", "Wick", "Bob", "Marley", "Koliy", "Olya");
        System.out.println("list = " + list);
        printIndexElement(list);
        System.out.println();
        System.out.println(getIndexElement(list));
        printUperElement(list);




        //printStrings("Ihor", "Ivor", "John", "Wick", "Bob", "Marley","Koliy", "Olya");
        //printUperSort("Ihor", "Ivor", "John", "Wick", "Bob", "Marley", "Koliy", "Olya");
        //formattedNames();

         //printStrings(list);
    }

    public static void printStrings(String... names) {
        IntPredicate isOddIndex = index -> index % 2 == 0;  // створюємо функціонального інтерфейсу, який включає непарні індекси
        List<String> filteredNames = IntStream.range(0, names.length)// генеруємо послідовність індексів від 0 до довжини масиву `names`
                .filter(isOddIndex)      // фільтруємо індекси за допомогою isOddIndex
                .mapToObj(index -> (index + 1) + ". " + names[index]) // перетворюємо індекси на рядки у вказаному форматі ("індекс. ім'я"
                .collect(Collectors.toList()); // Збираємо рядки у список filteredNames

        System.out.println(String.join(", ", filteredNames));
    }
    public static void formattedNames() {
        Collection<String> names = List.of("Ihor", "Ivor", "John", "Wick", "Bob", "Marley","Koliy", "Olya"); //створюємо колекцію імен
        String result = IntStream.range(0, names.size()) // створюємо строку послідовність range  діапазон від 0 до розміру списку
                .filter(index -> index % 2 == 0) // фільтруємо за непарним індексом
                .mapToObj(index -> (index + 1) + ". " + names.toArray()[index]) // Форматуємо рядок "номер. Ім'я"
                .collect(Collectors.joining(", ")); // обєднуємо результат в один рядок з роздільником ", "

        System.out.println(result);
    }
    public static void printUperSort (String... names){
        List<String> uppercaseList = IntStream.range(0, names.length)  // створюємо ліст з строки
                .mapToObj(i -> names[i].toUpperCase())                 // переводимо кожен елемент ліста у верхній регість
                .collect(Collectors.toList());                         // збираємо слова приведені до верхнього регістру у список
        List<String> sortedList = uppercaseList.stream()               // створюємо списк для сортування на основі списка у верхньому регістру
                .sorted((s1, s2) -> s2.compareTo(s1))                  // сортуємо рядки в зворотньому порядку
                .collect(Collectors.toList());                         // створюємо списк на основі відсортованого списка
        String result = IntStream.range(0, sortedList.size())          // створюємо строку на основі відсортованого списку
                .mapToObj(i -> (i + 1) + ". " + sortedList.get(i))     // нумеруємо рядки
                .collect(Collectors.joining(", "));            // добавляємо , і пробіл між словами
        System.out.println(result);                                    // виводимо результат
    }

    public static void printIndexElement(List<String> inputList) {
        IntStream.range(0, inputList.size())
                .filter(index -> index % 2 != 0)
                .forEach(index -> System.out.print(index + ". " + inputList.get(index) + " "));
    }
    public static String getIndexElement(List<String> inputList) {
        return IntStream.range(0, inputList.size())
                .filter(index -> index % 2 != 0)
                .mapToObj(index ->index + ". " + inputList.get(index))
                .collect(Collectors.joining(", "));
    }
    public static void printUperElement(List<String> list) {
        List<String> result = list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(result);
    }

}