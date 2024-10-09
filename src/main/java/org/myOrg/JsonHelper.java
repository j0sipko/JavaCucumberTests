package org.myOrg;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonHelper {
    public static JSONObject getJsonObjectFromResources(String filePath)
    {
        String jsonString = getTextFromResFile(filePath);
        return new JSONObject(jsonString);
    }

    public static String getTextFromResFile(String filePath)
    {
        String text = "";
        try {
            text =  Files.readString(Path.of("src\\main\\resources\\" + filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
