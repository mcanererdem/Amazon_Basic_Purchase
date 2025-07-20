package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementStore {
    private static final String ELEMENTS_PATH = "src/test/resources/element-infos/elements.json";
    private static Map<String, ElementInfo> elementMap;

    static {
        loadElements();
    }

    private static void loadElements() {
        try (FileReader reader = new FileReader(ELEMENTS_PATH)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<ElementInfo>>(){}.getType();
            List<ElementInfo> elements = gson.fromJson(reader, listType);
            elementMap = new HashMap<>();
            for (ElementInfo element : elements) {
                elementMap.put(element.getKey(), element);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load elements.json", e);
        }
    }

    public static ElementInfo getElementInfo(String key) {
        return elementMap.get(key);
    }

    public static By getBy(String key) {
        ElementInfo elementInfo = getElementInfo(key);
        if (elementInfo == null) {
            throw new RuntimeException("Element not found for key: " + key);
        }
        switch (elementInfo.getType()) {
            case "id":
                return By.id(elementInfo.getValue());
            case "css":
                return By.cssSelector(elementInfo.getValue());
            case "xpath":
                return By.xpath(elementInfo.getValue());
            default:
                throw new RuntimeException("Unknown selector type: " + elementInfo.getType());
        }
    }
}
