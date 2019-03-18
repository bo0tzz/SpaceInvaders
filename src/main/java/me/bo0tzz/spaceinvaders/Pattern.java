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

    private Pattern(boolean[][] pattern) {
        this.pattern = pattern;
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

    public Pattern windowAt(Coordinate coordinate, int width, int height) {

        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative window size is not allowed");
        }

        boolean[][] window =  new boolean[height][width];

        //For every line in our window
        for (int y = coordinate.getY(); y < coordinate.getY() + height; y++) {
            //Copy the columns in our window to the output array
            int pos = coordinate.getX();
            boolean[] src = pattern[y];
            boolean[] dest = window[y];
            System.arraycopy(src, pos, dest, pos, width);
        }

        return new Pattern(window);

    }

}
