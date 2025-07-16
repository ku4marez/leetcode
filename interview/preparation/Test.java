package interview.preparation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
         String banana = "banana";
         char[] bananas = banana.toCharArray();
         List<Character> list = new ArrayList<>();
         for (char c : bananas) {
             list.add(c);
         }
        Map<Character, Long> freq = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);

        String[] words = new String[]{"apple", "pear", "banana", "kiwi"};
        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(words));

        String[] letters = new String[]{"a", "b", "a", "c", "b", "d"};
        List<String> listLetters = Arrays.asList(letters);
        listLetters = listLetters.stream().distinct().toList();
        System.out.println(listLetters);

        String[] wordsArray = new String[]{"one", "two", "three"};
        List<String> listWords = Arrays.asList(wordsArray);
        listWords = listWords.stream().toList().reversed();
        System.out.println(listWords);

        String word = "this is a test this is only a test";
        List<String> listWord = Arrays.asList(word.split(" "));
        Map<String, Long> map = listWord.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);


        String toCleanStr = "  Java,  Lambdas,   STREAMS! ";
        List<String> listStr = Arrays.asList(toCleanStr.split(","));
        List<String> formattedList = listStr.stream()
                .map(s -> s.trim().toLowerCase().replaceAll("[^a-z0-9 ]", ""))
                .toList();

        formattedList.forEach(System.out::println);

        String input = "Programming is awesome!";
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U');
        int count = 0;
        for (char c : input.toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        System.out.println(count);

        String input2 = "Java streams are powerful";
        List<String> input2List = Arrays.asList(input2.split(" "));
        Collections.reverse(input2List);  // This mutates the list
        System.out.println(String.join(" ", input2List));

        List<String> words2 = Arrays.asList("Java", "Python", "Go");
        Map<String, Integer> lengthWords = words2.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(lengthWords);

        int[] arr = {1, 2, 3, 4, 5};
        List<Integer> arrWrapper = Arrays.stream(arr).boxed().toList();
        System.out.println(arrWrapper);
    }
}
