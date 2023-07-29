import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;


public class TaskFourRandomStream {
    private long a, c, m;   // оголошуємо змінні
    private AtomicLong x;    //змінні для генерації послідовних випадкових чисел (типу)  класу AtomicLong
    // має ряд корисних методів, що нам допоможуть наприклад getAndIncrement

    public TaskFourRandomStream() {
        this.a = 25214903917L;      //  тут ми ініціалізуємо статичні змінні щоб
        this.m = (1L << 48);        // створювалися при створенні класу
    }

    public TaskFourRandomStream withSeed(long c) {
        this.c = c; // встановлюємо параметра c з аргумента метода
        x = new AtomicLong(System.nanoTime() + c); //встановлюємо Х створючи обєкт AtomicLong зі значенням System.nanoTime() + c
        return this;
    }

    public Stream<Long> next() { // метод класу для визначееня наступного значення
        return Stream.generate(() -> {  //створюємо стрім
            long result = (a * x.getAndIncrement() + c) % m; // результат = формула з методом getAndIncrement
            return result;  // виводимо результат
        });
    }

    public static void main(String[] args) {
        TaskFourRandomStream randomStrim = new TaskFourRandomStream().withSeed(2); // створюємо обєкт нашого класу і встановлюємо початкове значення seedа

        Stream<Long> randomStream = randomStrim.next();  //обчислюємо наступне значення потоку

        // виводимо перших 10 випадкових чисел
        randomStream.limit(10).forEach(System.out::println);
    }
}

