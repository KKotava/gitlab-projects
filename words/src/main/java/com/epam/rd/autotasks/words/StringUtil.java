package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringUtil {

    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
//Возвращает количество слов из массива words которые равны sample
//без учета регистра символов, а так же начальных и конечных пробелов.
        if (sample == null || words == null) {
//Если sample равен null, или words имеет значение null
//или пустое значение, необходимо вернуть 0
            return 0;
        }
        int counter = 0;
        sample = sample.trim();
        String[] wordsInProgress = Arrays.copyOf(words, words.length);
        for (int i = 0; i < words.length; i++) {
            if (!wordsInProgress[i].trim().isEmpty()) {
                wordsInProgress[i] = wordsInProgress[i].trim();
                if (wordsInProgress[i].equalsIgnoreCase(sample)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static String[] splitWords(String text) {
//Разделяет строку text на массив слов, используя разделительные символы
        if (text == null || text.trim().isEmpty() || text.matches("[,.;: ?!]+")) {
//Для пустой строки, строки null, и строки,
//состоящей только из разделительных символов, возвращается значение null.
            return null;
        }
        String[] words = text.replaceAll("^\\W+|\\W+$", "").split("\\W+");
        return words;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.trim().isEmpty()) {
            return null;
        }
        String shortPathCase = "^(?<filename>(?:[.]?[\\w !#()-]+)+)?[.]?$";
        String shortPathCase1 = "\\.\\.";
        if (path.matches(shortPathCase) || path.matches(shortPathCase1)) {
            return path;
        }
        String winPat = "^(?<drive>[a-zA-Z]:)?" +
                "(?<path>(?:[\\\\\\\\]?(?:[\\w !#()-]+|[.]{1,2})+)*[\\\\\\\\])?" +
                "(?<filename>(?:[.]?[\\w !#()-]+)+)?[.]?$";
        String linPat = "^(?<root>~)?" +
                "(?<path>(?:/?(?:[\\w !#().-]+|[.]{1,2})+)*/)?" +
                "(?<filename>(?:[.]?[\\w !#().-]+))?[.]?$";

//        ^(?<root>~)?(?<path>(?:/?(?:[\w !#()\-]+|[.]{1,2})+)*/)?(?<filename>(?:[.]?[\w !#().\-]+)_)?[.]?$
       // String unixPath = "/root/logs/end.log";

        String linPatT = "^(~)?(/[^/]*)?(?<filename>(?:[.]?[\\w !#()-]+)+)?[.]?$";
        Pattern windowsPattern = Pattern.compile(winPat, Pattern.CASE_INSENSITIVE);
        Pattern unixPattern = Pattern.compile(linPat, Pattern.CASE_INSENSITIVE);

        if (Pattern.matches(winPat, path)) {
            if (toWin) {
                return path;
            } else {
                path = toUnix(path);
                return path;
            }
        } else if (Pattern.matches(linPat, path)) {
            if (toWin) {
                path = toWindows(path);
                return path;
            } else {
                return path;
            }
        } else return null;

    }


    private static String toWindows (String path) {
        if (path.matches("^~/.*")) {
            Pattern pattern = Pattern.compile("~/");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("C:\\\\User\\\\");
        } else if (path.matches("^~.*")) {
            Pattern pattern = Pattern.compile("~");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("C:\\\\User");
        } else if (path.matches("^/.*")) {
            Pattern pattern = Pattern.compile("/");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("C:\\\\");
        }
        Pattern toReplace = Pattern.compile("/");
        Matcher mat2 = toReplace.matcher(path);
        path = mat2.replaceAll("\\\\");
        return path;
    }
    private static String toUnix (String path) {
        if (path.matches("^C:\\\\User\\\\.*")) {
            Pattern pattern = Pattern.compile("C:\\\\User\\\\");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("~/");
        } else if (path.matches("^C:\\\\User.*")) {
            Pattern pattern = Pattern.compile("C:\\\\User");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("~");
        } else if (path.matches("^C:\\\\.*")) {
            Pattern pattern = Pattern.compile("C:\\\\");
            Matcher matcher = pattern.matcher(path);
            path = matcher.replaceFirst("/");
        }
        Pattern rep2 = Pattern.compile("\\\\");
        Matcher mat2 = rep2.matcher(path);
        path = mat2.replaceAll("/");
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null) {
            return null;
        }
        String result = String.format(Arrays.stream(words)
                .filter(word -> !Objects.isNull(word))
                .filter(word -> word.length() > 0)
                .collect(Collectors.joining(", ")));
        if (result.trim().isEmpty()) {
            return null;
        } else {
            return "[" + result + "]";
        }



/**
//Соединяет слова из массива words и возвращает в виде строки
        if (words == null) {
//Если значение words равно null или является пустым, необходимо вернуть null.
            return null;
        }
        String result = new String();
        for (int i = 0; i < words.length; i++) {
            if (words[i] != null && !words[i].trim().isEmpty()) {
//words могут содержать пустые строки, игнорируйте их,
//то есть не помещайте их в результирующую строку.
                if (i < words.length - 1) {
                    //проверка на пустые элементы до конца массива
 //вместо этого изучила стримы
                    result = result + words[i]  + ", ";
                } else {
                    result = result + words[i];
                }
            }
        }
//Если words содержат только пустые строки, верните null.
        if (result == null || result.trim().isEmpty()) {
            return null;
        } else {
            return "[" + result + "]";
        }
 **/
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS",};
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}