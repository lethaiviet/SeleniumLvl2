package utils;

import java.util.HashMap;

public class CacheHelper {
    private static ThreadLocal<HashMap<String, Object>> CURRENT_CONTEXT = ThreadLocal.withInitial(HashMap::new);

    public static <T> T getValue(String key, Class<T> type) {
        return type.cast(CURRENT_CONTEXT.get().get(key));
    }

    public static void setValue(String key, Object value) {
        CURRENT_CONTEXT.get().put(key, value);
    }
}
