package misc.practice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileParsingPractice {
    public static void main(String[] args) throws IOException {
        printTransactionSummary(Paths.get("misc/file/transactions.csv"));
        printFailedLogin(Paths.get("misc/file/log.txt"));
        printProductPrice(Paths.get("misc/file/products.csv"));
        printUserNames();
        printDuplicateEmails(Paths.get("misc/file/emails.txt"));
        printTopWords(Paths.get("misc/file/article.txt"));
        printTotalSales(Paths.get("misc/file/sales.csv"));
        printValidateCustomers(Paths.get("misc/file/customers.csv"));
        printLogSummary(Paths.get("misc/file/events.log"));
        printStudentGrades(Paths.get("misc/file/grades.csv"));
    }

    private static void printTransactionSummary(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        HashMap<String, Double> transactionSummary = new HashMap<>();
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String userId = parts[0];
            double amount = Double.parseDouble(parts[1]);
            transactionSummary.put(userId, transactionSummary.getOrDefault(userId, 0.0) + amount);
        }
        for (Map.Entry<String, Double> entry : transactionSummary.entrySet()) {
            System.out.println("User ID: " + entry.getKey() + " total amount: " + entry.getValue());
        }
    }

    private static void printFailedLogin(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        HashMap<String, Integer> failedLogin = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String userId = parts[2].substring(parts[2].indexOf("=") + 1);
            String status = parts[4].substring(parts[4].indexOf("=") + 1);
            failedLogin.put(userId, failedLogin.getOrDefault(userId, 0) + (status.equals("FAILED") ? 1 : 0));
        }
        failedLogin.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    private static void printProductPrice(Path path) throws IOException {
        Map<String, Double> productCtgAvgPrice;
        productCtgAvgPrice = Files.lines(path)
                .skip(1)
                .map(

                        line -> {
                            String[] parts = line.split(",");
                            return new Product(Long.valueOf(parts[0]), parts[1], parts[2], parts[3]);
                        }
//                        line -> line.split(",")
                ).collect(Collectors.groupingBy(
//                                product -> val[3],
//                                Collectors.averagingDouble(val -> Double.parseDouble(val[2]))
                                Product::getCategory,
                                Collectors.averagingDouble(val -> Double.parseDouble(val.getPrice()))
                        )
                );
        for (Map.Entry<String, Double> entry : productCtgAvgPrice.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private static void printUserNames() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(new File("misc/file/users.json"), new TypeReference<List<User>>() {
        });
        users.stream().filter(
                user -> user.age > 25 && user.country.equals("CZ")
        ).forEach(user -> System.out.println(user.name));

    }

    private static void printDuplicateEmails(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        HashSet<String> emails = new HashSet<>();
        HashSet<String> duplicateEmails = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            String email = line.trim();
            if (!email.isEmpty()) {
                if (emails.contains(email)) {
                    duplicateEmails.add(email);
                } else {
                    emails.add(email);
                }
            }
        }
        duplicateEmails.forEach(e -> System.out.println(e));
    }

    private static void printTopWords(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        HashMap<String, Integer> countWords = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(Map.Entry.comparingByValue());
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\W+");
            for (String word : parts) {
                countWords.merge(word, 1, Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> entry : countWords.entrySet()) {
            priorityQueue.add(entry);
            if (priorityQueue.size() > 3) {
                priorityQueue.poll();
            }
        }

        String[] res = new String[3];
        int p = 0;
        while (!priorityQueue.isEmpty()) {
            Map.Entry<String, Integer> entry = priorityQueue.poll();
            res[p] = entry.getKey();
            p++;
        }
        for (int i = res.length - 1; i >= 0; i--) {
            System.out.println(res[i]);
        }

        /*
         Or actually simple solution in this case
         countWords.entrySet().stream()
          .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
          .limit(3)
          .forEach(System.out::println);
         */
    }

    private static void printTotalSales(Path path) throws IOException {
        Map<LocalDate, Double> totalSales;
        totalSales = Files.lines(path).map(
                        val -> {
                            String[] parts = val.split(",");
                            return new Sale(
                                    LocalDate.of(Integer.parseInt(parts[0].substring(0, 4)), Integer.parseInt(parts[0].substring(5, 7)), Integer.parseInt(parts[0].substring(8, 10))),
                                    parts[1],
                                    Double.valueOf(parts[2])
                            );
                        }
                )
                .collect(Collectors.groupingBy(
                                Sale::getDate,
                                Collectors.summingDouble(Sale::getPrice)
                        )
                );
        totalSales.entrySet().stream().sorted(Map.Entry.<LocalDate, Double>comparingByValue().reversed()).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    private static void printValidateCustomers(Path path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(path);
        String line;
        reader.readLine();
        HashSet<Object> invalidRows = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String name = parts[1];
            String email = parts[2];

            if (name == null || name.isEmpty()) {
                invalidRows.add(line);
            }

            Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
            Matcher matcher = pattern.matcher(email);
            boolean emailValid = matcher.find();

            if (!emailValid) {
                invalidRows.add(line);
            }

        }
        invalidRows.forEach(e -> System.out.println(e));
    }

    private static void printLogSummary(Path path) throws IOException {
        Map<String, Long> countEvents = Files.lines(path).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );
        countEvents.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    private static void printStudentGrades(Path path) throws IOException {
        Map<String, Double> studentGrades = Files.lines(path).collect(
                Collectors.groupingBy(
                        val -> {
                            String[] parts = val.split(",");
                            return parts[0];
                        },
                        Collectors.averagingDouble(val -> {
                            String[] parts = val.split(",");
                            return Double.parseDouble(parts[1]);
                        })
                )
        );
        studentGrades.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }

    static class Product {
        Long id;
        String name;
        String price;
        String category;

        public Product(Long id, String name, String price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }
    }

    static class Sale {
        LocalDate date;
        String productName;
        Double price;

        public Sale(LocalDate date, String productName, Double price) {
            this.date = date;
            this.productName = productName;
            this.price = price;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    static class User {
        Long id;
        String name;
        Integer age;
        String country;

        public User() {

        }

        public User(Long id, String name, Integer age, String country) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.country = country;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
