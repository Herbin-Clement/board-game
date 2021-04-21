package game.utils;

public class ColorText {
    public static String black = "\u001B[30m";
    public static String red = "\u001B[31m";
    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String blue = "\u001B[34m";
    public static String magenta = "\u001B[35m";
    public static String cyan = "\u001B[36m";
    public static String lightGray = "\u001B[37m";
    public static String darkGray = "\u001B[90m";
    public static String lightRed = "\u001B[91m";
    public static String lightGreen = "\u001B[92m";
    public static String lightYellow = "\u001B[93m";
    public static String lightBlue = "\u001B[94m";
    public static String lightMagenta = "\u001B[95m";
    public static String lightCyan = "\u001B[96m";
    public static String white = "\u001B[97m";

    public static String printBGColor(String s, String color) {
        return String.format("%s%s%s", color, s, ColorText.black);
    }
}