package ru.mondayish.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtils {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("native/messages", Locale.US);

    public static String getMessage(String name) {
        return bundle.getString(name);
    }
}
