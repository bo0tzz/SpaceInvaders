package me.bo0tzz.spaceinvaders;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;

import static org.junit.Assert.assertArrayEquals;

public class UtilTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testNullInput() throws ParseException {

        exception.expect(ParseException.class);
        exception.expectMessage("Empty input");

        Util.imageToPattern(null);

    }

    @Test
    public void testEmptyInput() throws ParseException {

        exception.expect(ParseException.class);
        exception.expectMessage("Empty input");

        Util.imageToPattern("");

    }

    @Test
    public void testIllegalCharacterInput() throws ParseException {

        exception.expect(ParseException.class);
        exception.expectMessage("Invalid character in input");

        Util.imageToPattern("a");

    }

    @Test
    public void testZeroWidthInput() throws ParseException {

        boolean[][] pattern = Util.imageToPattern("\n");
        assertArrayEquals(Util.EMPTY_PATTERN, pattern);

    }

    @Test
    public void testValidInputs() throws ParseException {

        String dashesInput = "-----";
        boolean[][] expectedDashes = new boolean[1][5];
        boolean[][] dashesPattern = Util.imageToPattern(dashesInput);
        assertArrayEquals(expectedDashes, dashesPattern);

        String dotsInput = "ooooo";
        boolean[][] expectedDots = {{true, true, true, true, true}};
        boolean[][] dotsPattern = Util.imageToPattern(dotsInput);
        assertArrayEquals(expectedDots, dotsPattern);

        String mixedInput = "-o-o-";
        boolean[][] expectedMixed = {{false, true, false, true, false}};
        boolean[][] mixedPattern = Util.imageToPattern(mixedInput);
        assertArrayEquals(expectedMixed, mixedPattern);

        String newLinesInput = "oo-oo\n-ooo-\n--o--";
        boolean[][] expectedNewLines = {
                {true, true, false, true, true},
                {false, true, true, true, false},
                {false, false, true, false, false}
        };
        boolean[][] newLinesPattern = Util.imageToPattern(newLinesInput);
        assertArrayEquals(expectedNewLines, newLinesPattern);

    }

}
