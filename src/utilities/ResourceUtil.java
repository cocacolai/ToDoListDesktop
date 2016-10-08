package utilities;

import java.net.URL;

public abstract class ResourceUtil {
    
    public static URL getResourceURL(String fileName) {
        return ResourceUtil.class.getResource(fileName);
    }

}
