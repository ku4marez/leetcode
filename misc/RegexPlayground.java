package misc;

import java.util.*;
import java.util.regex.*;

public class RegexPlayground {

    /* ---------------------- Generic helpers ---------------------- */

    static void debugPrint(List<String> xs) {
        for (String x : xs) {
            String shown = x
                    .replace(" ", "·")
                    .replace("\t", "\\t")
                    .replace("\n", "\\n");
            System.out.println("[" + shown + "] len=" + x.length());
        }
    }

    // Find all matches of a regex in a given input (returns list of matched groups or whole matches)
    public static List<String> findAll(String regex, String input) {
        List<String> res = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            if (matcher.groupCount() > 0) {
                res.add(matcher.group(1));
            } else {
                res.add(matcher.group());
            }
        }
        return res;
    }

    // Find all matches but return each full match (ignores capture groups)
    public static List<String> findAllFull(String regex, String input) {
        List<String> res = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            res.add(matcher.group());
        }
        return res;
    }

    // Full-string validation
    public static boolean matches(String regex, String input) {
        return Pattern.compile(regex).matcher(input).matches();
    }

    // Replace all occurrences
    public static String replaceAll(String regex, String input, String replacement) {
        return Pattern.compile(regex).matcher(input).replaceAll(replacement);
    }

    /* ---------------------- Level 1 – Easy ---------------------- */

    // 1) All digits
    public static List<String> task01_digits(String s) {
        return findAllFull("\\d", s);
    }

    // 2) All lowercase letters
    public static List<String> task02_lowercase(String s) {
        return findAllFull("[a-z]", s);
    }

    // 3) All whitespace characters
    public static List<String> task03_whitespace(String s) {
        return findAllFull("\\s+", s);
    }

    // 4) All occurrences of the word "cat" (case-sensitive)
    public static List<String> task04_cat(String s) {
        return findAllFull("\\b(cat)\\b", s);
    }

    // 5) String contains only digits (validate whole string)
    public static boolean task05_onlyDigits(String s) {
        return matches(s, "\\d");
    }

    // 6) Literal dot '.'
    public static List<String> task06_literalDot(String s) {
        return findAllFull("\\.", s);
    }

    /* ---------------------- Level 2 – Medium ---------------------- */

    // 7) Words starting with capital letters
    public static List<String> task07_capitalizedWords(String s) {
        return findAllFull("\\b[A-Z][a-z]+\\b", s);
    }

    // 8) Extract emails (simple heuristic)
    public static List<String> task08_emails(String s) {
        return findAllFull("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b", s);
    }

    // 9) Sequences of exactly 4 digits
    public static List<String> task09_exact4digits(String s) {
        return findAllFull("\\b\\d{4}\\b", s);
    }

    // 10) Words ending in "ing"
    public static List<String> task10_endingIng(String s) {
        return findAllFull("\\b\\w+[ing]\\b", s);
    }

    // 11) US phone number: (XXX) XXX-XXXX
    public static List<String> task11_usPhone(String s) {
        return findAllFull("\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}", s);
    }

    // 12) Words of length 3–5
    public static List<String> task12_wordsLen3to5(String s) {
        return findAllFull("\\b\\w{3,5}\\b", s);
    }

    // 13) Dates in dd-mm-yyyy (no validation for real calendar)
    public static List<String> task13_dateSimple(String s) {
        return findAllFull("\\b\\d{2}\\-\\d{2}\\-\\d{4}\\b", s);
    }

    // 14) Words that do NOT contain digits
    public static List<String> task14_wordsNoDigits(String s) {
        return findAllFull("\\b[^0-9\\s]+\\b", s);
    }

    /* ---------------------- Level 3 – Hard ---------------------- */

    // 15) Extract domain names from URLs (captures domain as group 1)
    public static List<String> task15_domains(String s) {
        // Matches protocol, optional www, capture domain.tld, then optional path
        return new ArrayList<>();
    }

    // 16) Numbers with optional decimals and optional leading minus
    public static List<String> task16_numbers(String s) {
        return new ArrayList<>();
    }

    // 17) Repeated adjacent words (captures the repeated word)
    public static List<String> task17_repeatedWords(String s) {
        return new ArrayList<>();
    }

    // 18) HTML tags (simple, not a full parser)
    public static List<String> task18_htmlTags(String s) {
        return new ArrayList<>();
    }

    // 19) Everything inside square brackets (capture content between)
    public static List<String> task19_insideBrackets(String s) {
        return new ArrayList<>();
    }

    // 20) Validate IPv4 addresses (0–255 range)
    public static List<String> task20_ipv4All(String s) {
        return new ArrayList<>();
    }

    public static boolean task20_ipv4Valid(String s) {
        return false;
    }

    // 21) Password policy: ≥8, ≥1 upper, ≥1 lower, ≥1 digit, ≥1 special
    public static boolean task21_passwordStrong(String s) {
        return false;
    }

    // 22) Extract Java variable-like identifiers (not keywords — naive)
    public static List<String> task22_identifiers(String s) {
        // Start letter/underscore, then letters/digits/underscore
        return new ArrayList<>();
    }

    // 23) Match JSON keys (very simplified; key in quotes before colon)
    public static List<String> task23_jsonKeys(String s) {
        return new ArrayList<>();
    }

    // 24) Find hashtags
    public static List<String> task24_hashtags(String s) {
        return new ArrayList<>();
    }

    /* ---------------------- Quick demo ---------------------- */

    public static void main(String[] args) {
        System.out.println("== Level 1 ==");
        System.out.println("01 digits            → " + task01_digits("ab12c3"));                     // [1, 2, 3]
        System.out.println("02 lowercase         → " + task02_lowercase("ABCdEf"));                  // [d, f]
        System.out.println("03 whitespace        → " + task03_whitespace("a \t b\nc"));              // [ , \t, \n]
        System.out.println("04 word 'cat'        → " + task04_cat("cat scatter bobcat cat."));       // [cat, cat]
        System.out.println("05 only digits?      → " + task05_onlyDigits("123450"));                 // true
        System.out.println("06 literal dots      → " + task06_literalDot("a.b.c..d"));               // [., ., ., .]

        System.out.println("\n== Level 2 ==");
        System.out.println("07 Capitalized words → " + task07_capitalizedWords("Alice and Bob went to NY")); // [Alice, Bob, NY]
        System.out.println("08 emails            → " + task08_emails("x a@b.com y z@foo.co.uk bad@bad"));    // [a@b.com, z@foo.co.uk]
        System.out.println("09 exactly 4 digits  → " + task09_exact4digits("PIN 1234, code 567, 98765"));     // [1234]
        System.out.println("10 ends with 'ing'   → " + task10_endingIng("coding and running, sing!"));        // [coding, running]
        System.out.println("11 US phone          → " + task11_usPhone("Call (123) 456-7890 or 123-456-7890")); // [(123) 456-7890]
        System.out.println("12 words len 3-5     → " + task12_wordsLen3to5("at home today we code regex"));    // [home, today, we, code, regex? (filtered to 3-5)]
        System.out.println("13 date dd-mm-yyyy   → " + task13_dateSimple("Due 01-09-2025, not 1-9-25"));       // [01-09-2025]
        System.out.println("14 words w/o digits  → " + task14_wordsNoDigits("a1 b two3 four five6 six"));      // [b, four, five, six]

        System.out.println("\n== Level 3 ==");
        System.out.println("15 domains           → " + task15_domains("see https://openai.com/research and http://www.example.org/x"));
        // [openai.com, example.org]
        System.out.println("16 numbers (opt dec) → " + task16_numbers("vals: -1 0 3.14 .5 nope 42 -0.5"));    // [-1, 0, 3.14, 42, -0.5]
        System.out.println("17 repeated words    → " + task17_repeatedWords("hello hello world hi hi"));       // [hello, hi]
        System.out.println("18 HTML tags         → " + task18_htmlTags("<div class='x'><p>t</p></div> <br/>")); // [<div class='x'>, <p>, </p>, </div>, <br/>]
        System.out.println("19 inside [brackets] → " + task19_insideBrackets("keep [this], and [that too]"));  // [this, that too]

        String ipv4Text = "valid 8.8.8.8, 255.255.255.255, bad 999.1.1.1, also 192.168.0.1";
        System.out.println("20 IPv4 (find all)   → " + task20_ipv4All(ipv4Text));                              // [8.8.8.8, 255.255.255.255, 192.168.0.1]
        System.out.println("20 IPv4 (validate)   → " + task20_ipv4Valid("192.168.1.10"));                      // true
        System.out.println("20 IPv4 (validate)   → " + task20_ipv4Valid("256.1.1.1"));                          // false

        System.out.println("21 password strong?  → " + task21_passwordStrong("Aa1!aaaa"));                     // true
        System.out.println("21 password strong?  → " + task21_passwordStrong("weakpass"));                      // false

        String code = "int foo = 1; String _bar2 = \"x\"; private static final int X = 0;";
        System.out.println("22 identifiers       → " + task22_identifiers(code));                               // [int, foo, String, _bar2, private, static, final, int, X]

        String json = "{\"name\": \"Ada\", \"age\": 36, \"isAdmin\": false}";
        System.out.println("23 JSON keys         → " + task23_jsonKeys(json));                                  // [name, age, isAdmin]

        System.out.println("24 hashtags          → " + task24_hashtags("tweet #OpenAI #java_17 #100DaysOfCode")); // [#OpenAI, #java_17, #100DaysOfCode]
    }

}