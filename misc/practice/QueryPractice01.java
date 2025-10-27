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

    public static void main(String[] args) {
        // Count employees by dep
        Map<Integer, Integer> dptEmployeesCount = new HashMap<>();
        for (Employee employee : employees) {
            dptEmployeesCount.put(employee.departmentId, dptEmployeesCount.getOrDefault(employee.departmentId, 0) + 1);
        }

        // Alternative
        dptEmployeesCount = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartmentId,
                        Collectors.collectingAndThen(
                                counting(),
                                Long::intValue
                        )
                )
        );

        Map<Integer, Integer> dpsEmployeesMoreThanTwo = dptEmployeesCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )
                );

        long employeesNoDep = employees.stream()
                .filter(e -> e.getDepartmentId() == null)
                .count();

        Map<Integer, Integer> departmentAvgSalary = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartmentId,
                                Collectors.collectingAndThen(
                                        Collectors.averagingDouble(Employee::getSalary),
                                        Double::intValue
                                )
                        )
                );

        Set<Integer> departmentsInEmployees = employees.stream()
                .map(Employee::getDepartmentId)
                .collect(Collectors.toSet());

        List<Integer> departmentsNoEmployees = departments.stream()
                .filter(department -> !departmentsInEmployees.contains(department.id))
                .map(Department::getId).toList();

        Map<Integer, Double> departmentMaxSalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartmentId,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                opt -> opt.map(Employee::getSalary).orElse(0.0)
                        )
                ));

        for (Department d : departments) {
            departmentMaxSalary.putIfAbsent(d.getId(), 0.0);
        }

        int dptWithMaxEmployees = dptEmployeesCount.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();

        Map<Integer, Double> departmentsSumSalary = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartmentId,
                                Collectors.summingDouble(Employee::getSalary)
                        )
                );

        Map<Integer, Double> sortedDepartmentsBySalary = departmentsSumSalary.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> a,
                                LinkedHashMap::new
                        )
                );
    }

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
