package me.bo0tzz.spaceinvaders;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Sets;

import java.text.ParseException;
import java.util.Set;
import java.util.stream.Stream;

/**
 * This class describes a known space invader pattern
 */
public class Pattern {

    private final boolean[][] pattern;

    public Pattern(String image) throws ParseException {
        this.pattern = Util.imageToPattern(image);
    }

    public int height() {
        return pattern.length;
    }

    public int width() {
        return pattern[0].length;
    }

    public Stream<Coordinate> coordinateStream() {

        Set<Integer> xCoords = ContiguousSet.closed(0, this.width());
        Set<Integer> yCoords = ContiguousSet.closed(0, this.height());

        return Sets.cartesianProduct(xCoords, yCoords).stream()
                .map(list -> new Coordinate(list.get(0), list.get(1)));

    }

}
