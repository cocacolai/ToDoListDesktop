package utilities;

import java.net.URL;

public class ResourceUtil {
    
    public static URL getResource(String fileName){
        return ResourceUtil.class.getResource(fileName);
    }

}
