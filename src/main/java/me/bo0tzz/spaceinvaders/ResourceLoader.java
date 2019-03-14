package me.bo0tzz.spaceinvaders;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

/**
 * This class will load Patterns from resource files
 */
public class ResourceLoader {

    public static String loadAsString(String resourceName) throws IOException {
        URL url = Resources.getResource(resourceName);
        return Resources.toString(url, Charsets.UTF_8);
    }

}
