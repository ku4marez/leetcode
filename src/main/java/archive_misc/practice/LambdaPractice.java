package archive_misc.practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaPractice {

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
