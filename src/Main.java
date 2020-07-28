import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Иванов", "Петров", "Сидоров");
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            peoples.add(new People(names.get(
                    new Random().nextInt(names.size())),
                    new Random().nextInt(100),
                    Gender.randomGender()));
        }

        long startTime = System.nanoTime();

        Stream<People> peopleStream1 = peoples.stream();
        long count = peopleStream1.filter(people -> people.getAge()>=18 & people.getAge()<=27)
                .count();
        System.out.println(count);

        Stream<People> peopleStream2 = peoples.stream();
        OptionalDouble result = peopleStream2.filter(people -> people.getGender()==Gender.MALE)
                .mapToInt(People::getAge)
                .average();
        result.ifPresent(System.out::println);

        Stream<People> peopleStream3 = peoples.stream();
        long count2 = peopleStream3.filter(people -> people.getAge()>=18 & people.getAge()<65)
                .count();
        System.out.println(count2);

        long stopTime = System.nanoTime();
        double processTime = (double) (stopTime - startTime) / 1_000_000_000.0;
        System.out.println("Process time: " + processTime + " s");
    }
}
