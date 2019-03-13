package me.bo0tzz.spaceinvaders;

import java.text.ParseException;

/**
 * This class describes a known space invader pattern
 */
public class Pattern {

    private final boolean[][] pattern;

    public Pattern(String image) throws ParseException {
        this.pattern = Util.imageToPattern(image);
    }

}
