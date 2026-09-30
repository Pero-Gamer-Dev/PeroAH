package com.peroah.util;

public class Text {
    public static String color(String text) {
        return text.replace("&", "§");
    }

    public static String decolor(String text) {
        return text.replace("§", "&");
    }

    public static String stripColor(String text) {
        return text.replaceAll("[§&][0-9a-fk-or]", "");
    }
}
