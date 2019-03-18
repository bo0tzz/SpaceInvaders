package me.bo0tzz.spaceinvaders;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URL;

/**
 * This class will load Patterns from resource files
 */
@UtilityClass
public class ResourceLoader {

    public String loadAsString(String resourceName) throws IOException {
        URL url = Resources.getResource(resourceName);
        return Resources.toString(url, Charsets.UTF_8);
    }

}
