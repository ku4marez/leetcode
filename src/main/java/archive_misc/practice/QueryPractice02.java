package archive_misc.practice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class QueryPractice02 {

    static List<Department> departments = List.of(
            new Department(1, "Engineering", 100000),
            new Department(2, "HR", 40000),
            new Department(3, "Sales", 70000),
            new Department(4, "Support", 50000)
    );

    static List<Employee> employees = List.of(
            new Employee(1, 1, "Alice", 8000, 29, 9),
            new Employee(2, 1, "Bob", 6000, 34, 7),
            new Employee(3, 1, "Charlie", 9500, 41, 10),
            new Employee(4, 2, "Diana", 4000, 30, 8),
            new Employee(5, 2, "Eve", 3500, 26, 6),
            new Employee(6, 3, "Frank", 7000, 36, 9),
            new Employee(7, 3, "Grace", 6500, 28, 8),
            new Employee(8, 4, "Heidi", 3000, 25, 7),
            new Employee(9, 4, "Ivan", 3200, 39, 5),
            new Employee(10, 4, "Judy", 2800, 45, 6)
    );

    static class Employee {
        private int id;
        private int departmentId;
        private String name;
        private double salary;
        private int age;
        private int performanceScore;

        public Employee(int id, int departmentId, String name, double salary, int age, int performanceScore) {
            this.id = id;
            this.departmentId = departmentId;
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.performanceScore = performanceScore;
        }

        // getters
        public int getId() {
            return id;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public int getPerformanceScore() {
            return performanceScore;
        }
    }

    static class Department {
        private int id;
        private String name;
        private double budget;

        public Department(int id, String name, double budget) {
            this.id = id;
            this.name = name;
            this.budget = budget;
        }

        // getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getBudget() {
            return budget;
        }
    }

    public record DepartmentSummary(
            double avgSalary,
            double avgPerformance,
            long highPerfCount,
            long lowPerfCount
    ) {
    }
}
