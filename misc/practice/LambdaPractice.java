package misc.practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaPractice {

    public static void main(String[] args) {

        // === BASIC FUNCTIONAL INTERFACES ===
        String s = "Hello World";

        Function<String, Integer> function = String::length;
        Consumer<String> consumer = str -> System.out.println(str);
        Supplier<String> supplier = () -> "Hello World";
        Predicate<String> predicate = str -> str.length() > 5;
        UnaryOperator<String> unaryOperator = str -> str.length() > 5 ? "Hello World" : str;
        BinaryOperator<String> binaryOperator = (a, b) -> a + b;
        BiFunction<Integer, Integer, Long> biFunction = (a, b) -> Long.valueOf(a + b);
        BiPredicate<String, String> biPredicate = String::equals;
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + b);

        System.out.println(function.apply(s));
        consumer.accept("String");
        System.out.println(supplier.get());
        System.out.println(predicate.test(s));
        System.out.println(unaryOperator.apply(s));
        System.out.println(binaryOperator.apply("Hello", "World"));
        System.out.println(biFunction.apply(1, 2));
        System.out.println(biPredicate.test("Hello", "World"));
        biConsumer.accept(s, "World");

        // === WORKING WITH PEOPLE LIST ===
        List<Person> people = new ArrayList<>();
        addPeople(people);

        // Sort and filter
        people.sort(Comparator.comparing(Person::getAge));
        people = people.stream()
                .filter(person -> person.getAge() > 30)
                .peek(person -> person.setSalary(person.getSalary() * 2))
                .collect(Collectors.toList());

        people.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));

        Map<Double, Person> salaryMap =
                people.stream().collect(Collectors.toMap(Person::getSalary, Function.identity()));

        // === FLATTEN LIST OF LISTS ===
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8)
        );
        List<Integer> flattened = listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();

        // === GROUPING AND PARTITIONING ===
        people.clear();
        addPeople(people);

        List<String> names = people.stream()
                .collect(Collectors.groupingBy(
                                Person::getSalary,
                                Collectors.mapping(Person::getName, Collectors.toList())
                        )
                )
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Map<Boolean, List<Person>> partition = people.stream()
                .collect(Collectors.partitioningBy(person -> person.getSalary() > 500));

        List<Person> highEarners = partition.get(true);
        List<Person> allPersons = partition.values().stream()
                .flatMap(Collection::stream)
                .toList();

        Map<Integer, List<Person>> groupedByAge =
                people.stream().collect(Collectors.groupingBy(Person::getAge));

        String namesJoined = people.stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                .collect(Collectors.joining(", "));

        // === COMPLEX SORTING (CHAINED COMPARATOR) ===
        people.stream()
                .sorted(
                        Comparator.comparingInt((Person p) -> p.getAge() < 25 ? 1 : 0) // young go last
                                .thenComparing(Person::getName)                     // alphabetical
                                .thenComparing(Comparator.comparing(Person::getSalary).reversed()) // salary desc
                )
                .forEach(System.out::println);

        // === SORTING MAP BY VALUE AND KEY ===
        Map<String, Integer> scores = Map.of("Alice", 5, "Bob", 10, "Charlie", 7);
        List<String> names3 = new ArrayList<>(scores.keySet());

        // Sort by score descending
        names3.sort((a, b) -> scores.get(b).compareTo(scores.get(a)));

        // Alternative: score descending, then name ascending
        names3.sort(
                Comparator.<String, Integer>comparing(scores::get)
                        .reversed()
                        .thenComparing(String::compareTo)
        );

        // === TODO ===
        /*
            Build a mini Sorter utility that takes a List<T> and a Comparator<T> lambda.
            Write a Transformer class that takes a Function<T,R> and applies it to a list.
            Write a Validator<T> class that takes a Predicate<T> and filters invalid entries.
        */
    }

    // === INNER CLASS ===
    static class Person {
        private String name;
        private int age;
        private double salary;

        public Person(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("%s (age=%d, salary=%.2f)", name, age, salary);
        }
    }

    // === UTILITY METHOD ===
    private static void addPeople(List<Person> people) {
        people.add(new Person("Anton", 15, 500));
        people.add(new Person("Misha", 20, 800));
        people.add(new Person("Sasha", 30, 1000));
    }
}
