package misc;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class QueryPractice03 {

    public static List<Department> departments = List.of(
            new Department(1, "Computer Science", "Engineering"),
            new Department(2, "Mathematics", "Science"),
            new Department(3, "Literature", "Arts")
    );

    public static List<Student> students = List.of(
            new Student(1, "Alice", 3, 3.9, 1),
            new Student(2, "Bob", 2, 3.4, 2),
            new Student(3, "Charlie", 4, 3.1, 1),
            new Student(4, "Diana", 1, 3.7, 3),
            new Student(5, "Eve", 3, 2.9, 2)
    );

    public static List<Course> courses = List.of(
            new Course(1, "Algorithms", 1, 5),
            new Course(2, "Databases", 1, 4),
            new Course(3, "Calculus", 2, 6),
            new Course(4, "Poetry", 3, 3)
    );

    public static class Student {
        private int id;
        private String name;
        private int year;
        private double gpa;
        private int departmentId;

        public Student(int id, String name, int year, double gpa, int departmentId) {
            this.id = id;
            this.name = name;
            this.year = year;
            this.gpa = gpa;
            this.departmentId = departmentId;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public double getGpa() {
            return gpa;
        }

        public int getDepartmentId() {
            return departmentId;
        }
    }

    public static class Department {
        private int id;
        private String name;
        private String faculty;

        public Department(int id, String name, String faculty) {
            this.id = id;
            this.name = name;
            this.faculty = faculty;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getFaculty() {
            return faculty;
        }
    }

    public static class Course {
        private int id;
        private String name;
        private int departmentId;
        private int credits;

        public Course(int id, String name, int departmentId, int credits) {
            this.id = id;
            this.name = name;
            this.departmentId = departmentId;
            this.credits = credits;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public int getCredits() {
            return credits;
        }
    }

    public record DepartmentSummary(
            String depName,
            int nbOfStudents,
            Double avgGpa,
            String label
    ) {
    }

    public static void main(String[] args) {
        // Group students by department and list names in each. groupingBy
        Map<Integer, List<String>> studentsByDep = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartmentId,
                        Collectors.mapping(
                                Student::getName,
                                Collectors.toList()
                        )
                )
        );
        // Compute average GPA per department. averagingDouble
        Map<Integer, Double> avgGpaPerDep = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartmentId,
                        Collectors.averagingDouble(Student::getGpa)
                )
        );
        // Find top student (highest GPA) in each department. groupingBy + maxBy
        Map<Integer, Optional<Student>> studentMaxGpa = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartmentId,
                        Collectors.maxBy(
                                Comparator.comparingDouble(Student::getGpa)
                        )
                )
        );
        // Sort all students by GPA descending, then by name. Comparator chaining
        students = students.stream().sorted(Comparator.comparingDouble(Student::getGpa)).toList().stream().sorted(Comparator.comparing(Student::getName)).toList();
        // Group courses by faculty (join Course → Department). flatMap, collect
        Map<Integer, Department> departmentsById = departments.stream().collect(
                Collectors.toMap(
                        Department::getId,
                        Function.identity()
                )
        );

        Map<String, List<String>> facultyByDeps = courses.stream().collect(
                Collectors.groupingBy(
                        course -> departmentsById.get(course.getDepartmentId()).getFaculty(),
                        Collectors.mapping(
                                Course::getName,
                                Collectors.toList()
                        )
                )
        );

        // Find all departments that have no students. filter + noneMatch or set difference
        List<Department> depsNoStudents = departments.stream().filter(department -> !studentsByDep.containsKey(department.getId())).collect(Collectors.toList());
        // Find the department with the highest average GPA. nested collect + max
        Map<Integer, Optional<Student>> highestAvgGpaPerDep = students.stream()
                .filter(department -> department.getGpa() > avgGpaPerDep.get(department.getId()))
                .collect(
                        Collectors.groupingBy(
                                Student::getDepartmentId,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Student::getGpa)
                                )
                        )
                );
        // Deps with highest avg gpa
        Optional<Map.Entry<Integer, Double>> highestAvgGpa = avgGpaPerDep.entrySet().stream().max(Comparator.comparingDouble(Map.Entry::getValue));
        // Produce a summary report: department name → number of students, average GPA, and "Excellent" / "Average" label (if avgGpa >= 3.5). multi-aggregation + collectingAndThen
        Map<Integer, DepartmentSummary> departmentSummary = students.stream().collect(
                Collectors.groupingBy(
                        Student::getDepartmentId,
                        Collectors.collectingAndThen(
                                Collectors.toList(), list -> {
                                    Integer depId = list.getFirst().getId();
                                    int studentsCount = list.size();
                                    String depName = departmentsById.get(depId).getName();
                                    double avgGpa = list.stream().mapToDouble(Student::getGpa).average().getAsDouble();
                                    String label = avgGpa >= 3.5 ? "Excellent" : "Average";
                                    return new DepartmentSummary(depName, studentsCount, avgGpa, label);
                                }
                        )
                )
        );
    }
}
