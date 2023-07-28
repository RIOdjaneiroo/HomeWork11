import java.util.AbstractMap;
import java.util.Iterator;
import java.util.stream.Stream;

public class TaskFifthTwoStream {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        //статичний генеричний метод що приймає два стріми будь якого типу повертає змішаний стрім
        Iterator<T> firstIterator = first.iterator();   // створюємо два ітератори
        Iterator<T> secondIterator = second.iterator(); // для того щоб перебрати вхідні стріми

        return Stream.generate(() -> {          // одразу в ретурні створюємо стрім безкінечного розміру
                    if (firstIterator.hasNext() && secondIterator.hasNext()) {  //якщо є елемент в 1 і 2 стрімі
                        return new AbstractMap.SimpleEntry<>(firstIterator.next(), secondIterator.next());
                        // створюємо новий абстрактний список в який задопомогою SimpleEntry  класу AbstractMap складаємо значення
                    } else {
                        return null;  // якщо один зі списків закінчився виводимо 0
                    }
                }).takeWhile(para -> para != null)  //зупиняємо стрім при першому входженні в Елсе тобто коли немає пари елементу одного зі стрімів
                .map(para -> Stream.of(para.getKey(), para.getValue())) //перетворюємо пари в потік
                .flatMap(w -> w); // зливаемо пари в один потік
    }

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> secondStream = Stream.of(6, 7, 8);
        Stream<String> first1Strim = Stream.of("Kolya","Petya","Taya","Sveta","Nastya");
        Stream<String> second1Strim = Stream.of("Vasya","John","Wil");

        Stream<String> resultStream = zip(first1Strim, second1Strim);
        Stream<Integer> resultStream1 = zip(firstStream, secondStream);
        resultStream1.forEach(System.out::println);
        resultStream.forEach(System.out::println);
    }
}
