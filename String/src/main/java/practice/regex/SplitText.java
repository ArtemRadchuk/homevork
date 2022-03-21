package practice.regex;

import antlr.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitText {

    public static void main(String[] args) {
    }

    public static String splitTextIntoWords(String text) {
        String withoutMarks = "";
        String withoutMarks2 = "";
        withoutMarks = text.replaceAll("[,.;:0-9]", "");
        withoutMarks2 = withoutMarks.replaceAll("-", " ");
        String[] substring = withoutMarks2.split(" ");
        int max = substring.length;
        String out = "";
        for (int numberOfString = 0; numberOfString < max; numberOfString++) {
            out = out + substring[numberOfString] + "\n";
        }
        return out;
    }
}

