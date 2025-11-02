package misc.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class QueryPractice04 {

    static List<User> users = List.of(
            new User(1, "Alice", "USA", List.of(
                    new Order(101, 1, 250.0, "Electronics"),
                    new Order(102, 1, 120.0, "Books")
            )),
            new User(2, "Bob", "Germany", List.of(
                    new Order(103, 2, 400.0, "Sports")
            )),
            new User(3, "Carla", "USA", List.of())
    );

    public static void main(String[] args) {

//        Compute total spend per user
//        → Return Map<String, Double> (userName → totalAmount)
        Map<String, Double> totalSpentPerUser = users.stream().collect(Collectors.groupingBy(
                User::getName,
                Collectors.summingDouble(user -> user.getOrders().stream().flatMapToDouble(order -> DoubleStream.of(order.getAmount())).sum())
        ));
//
//        Find all unique product categories ordered by users from "USA"
//        → Return Set<String>
        Set<String> productCategories = users.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter(user -> user.getCountry().equals("USA"))
                .flatMap(user -> user.getOrders().stream())
                .map(order -> order.getCategory())
                .collect(Collectors.toSet());
//
//        Return top spender user
//        → Find user with highest total order amount
        Optional<User> findUser = users.stream().max(Comparator.comparing(
                user -> user.getOrders().stream().mapToDouble(Order::getAmount).sum()
        ));
//
//        Group orders by category and compute total revenue per category
//        → Return Map<String, Double>
        Map<String, Double> ordersByCategory = users.stream().flatMap(user -> user.getOrders().stream())
                .collect(Collectors.groupingBy(
                                Order::getCategory,
                                Collectors.summingDouble(Order::getAmount)
                        )
                );
//
//        List all users who placed no orders
//        → Return List<User>
        List<User> noOrders = users.stream().filter(user -> user.getOrders().isEmpty()).toList();
    }

    static class User {
        int id;
        String name;
        String country;
        List<Order> orders;

        public User(int id, String name, String country, List<Order> orders) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.orders = orders;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }
    }

    static class Order {
        int id;
        int userId;
        double amount;
        String category;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public Order(int id, int userId, double amount, String category) {
            this.id = id;
            this.userId = userId;
            this.amount = amount;
            this.category = category;
        }
    }
}
