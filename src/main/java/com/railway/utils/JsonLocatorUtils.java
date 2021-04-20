package com.railway.utils;

import java.util.Map;
import java.util.Optional;

public class JsonLocatorUtils {
    private final static String jsonPath = "src/test/resources/locators/locators.json";
    private static Map<String, Map<String, String>> elements;

    static {
        elements = JsonHelper.getData(jsonPath);
    }

    /**
     * This method is used for getting the specified locator from json file based on
     * page name. (e.g: LoginPage)
     *
     * @param name:
     * @return
     */
    public static String get(String name) {
        String pageName = getCallerClassName();
        Map<String, String> elementsInPage = elements.get(pageName);
        if (elementsInPage == null) {
            throw new RuntimeException(
                    String.format("Cannot find page '%s' from file: %s. Please check", pageName, jsonPath));
        }

        String locator = elementsInPage.get(name);
        if (locator == null) {
            System.out.println(String.format("Page name: %s - element name: %s", pageName, name));
            throw new RuntimeException(
                    String.format("Cannot find web element '%s' from file: %s. Please check", name, jsonPath));
        }

        return locator;
    }

    /**
     * This method is used for getting specified locator from json file from any
     * page
     *
     * @param name
     * @return
     */
    public static String getAny(String name) {
        Optional<Map<String, String>> result = elements.values().stream().filter(x -> x.get(name) != null).findFirst();
        if (!result.isPresent()) {
            throw new RuntimeException(
                    String.format("Cannot find web element '%s' from file: %s. Please check", name, jsonPath));
        }

        return result.get().get(name);
    }

    private static String getCallerClassName() {
        StackTraceElement[] stElements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stElements.length; i++) {
            StackTraceElement ste = stElements[i];
            if (!ste.getClassName().equals(JsonLocatorUtils.class.getName())
                    && ste.getClassName().indexOf("java.lang.Thread") != 0) {
                return ste.getClassName().substring(ste.getClassName().lastIndexOf('.') + 1); // strip the package name
            }
        }
        return null;
    }
}
