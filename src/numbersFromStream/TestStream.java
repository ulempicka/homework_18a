package numbersFromStream;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.iterate(8, number -> number + 1);

        numbers.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return (number > 100) && (number % 5 == 0);
            }
        })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer number) {
                        return number * 3;
                    }
                })
                .limit(10)
                .forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer number) {
                        System.out.println(number);
                    }
                });
    }
}
