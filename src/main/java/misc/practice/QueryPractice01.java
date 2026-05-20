package misc.practice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class QueryPractice01 {

    public static List<Department> departments = List.of(
            new Department(1, "IT"),
            new Department(2, "HR"),
            new Department(3, "Finance"),
            new Department(4, "Marketing"),
            new Department(5, "Support")
    );

    public static List<Employee> employees = List.of(
            new Employee(1, "Anton", 1, 4500),
            new Employee(2, "Maria", 1, 4800),
            new Employee(3, "Oleg", 2, 3500),
            new Employee(4, "Svetlana", 2, 3700),
            new Employee(5, "Ivan", 3, 5200),
            new Employee(6, "Nina", 1, 4600),
            new Employee(7, "Irina", 4, 3900),
            new Employee(8, "Pavel", 4, 4200),
            new Employee(9, "Dmitry", null, 3000),
            new Employee(10, "Elena", 5, 2800)
    );

    static class Employee {
        private int id;
        private String name;
        private Integer departmentId; // nullable
        private double salary;

        public Employee(int id, String name, Integer departmentId, double salary) {
            this.id = id;
            this.name = name;
            this.departmentId = departmentId;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", departmentId=" + departmentId +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class Department {
        private int id;
        private String name;

        public Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Department{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
