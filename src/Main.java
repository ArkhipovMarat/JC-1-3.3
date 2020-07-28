import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Gender.MALE),
                new People("Петя", 23, Gender.MALE),
                new People("Елена", 42, Gender.FEMALE),
                new People("Иван Иванович", 69, Gender.MALE)
        );

        Stream<People> peopleStream1 = peoples.stream();
        peopleStream1.filter(people -> people.getAge()>=18 & people.getAge()<=27)
                .forEach(System.out::println);

        Stream<People> peopleStream2 = peoples.stream();
        OptionalDouble result = peopleStream2.filter(people -> people.getGender()==Gender.MALE)
                .mapToInt(People::getAge)
                .average();
        result.ifPresent(System.out::println);
        // * при описанном случае возникает исключение java.util.NoSuchElementException: No value present - потому что стрим пустой - отсутсвует значение.
        // здесь решение проблемы, через использование типа Optional, который может принимать null, и метода ifPresent

        Stream<People> peopleStream3 = peoples.stream();
        long count = peopleStream3.filter(people -> people.getAge()>=18 & people.getAge()<65)
                .count();
        System.out.println(count);
    }
}
