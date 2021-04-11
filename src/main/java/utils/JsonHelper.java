package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.List;

public class JsonHelper {
    public static <T> List<T> getDataAsList(String file, Class clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<T> lst = mapper.readValue(Paths.get(file).toFile(),
                    mapper.getTypeFactory().constructCollectionType(List.class, clazz));
            return lst;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
