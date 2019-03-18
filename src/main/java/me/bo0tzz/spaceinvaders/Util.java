package me.bo0tzz.spaceinvaders;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UtilityClass
public class Util {

    private final Pattern allowedCharacterMatcher = Pattern.compile("[^-o\\n]");

    public final boolean[][] EMPTY_PATTERN = new boolean[0][0];

    public boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * This utility method will convert an image such as in the README to an array for use in internal processing.
     * It expects a newline-delimited pattern of - and o characters, such as
     * -o
     * o-
     */
    public boolean[][] imageToPattern(String image) throws ParseException {

        if (isEmpty(image)) {
            throw new ParseException("Empty input", 0);
        }

        //The allowed input characters are - and o, plus \n for delimiting
        Matcher matcher = allowedCharacterMatcher.matcher(image);
        if (matcher.matches()) {
            throw new ParseException("Invalid character in input", matcher.start());
        }

        String[] lines = image.split("\n");

        int width = 0;
        for (String s : lines) {
            int length = s.length();
            if (length > width) {
                width = length;
            }
        }

        if (width == 0) {
            return EMPTY_PATTERN;
        }

        //Initialize the pattern array, height x width
        boolean[][] pattern = new boolean[lines.length][width];

        for (int i = 0; i < lines.length; i++) {
            char[] line = lines[i].toCharArray();
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                pattern[i][j] = c == 'o';
            }
        }

        return pattern;

    }

}
