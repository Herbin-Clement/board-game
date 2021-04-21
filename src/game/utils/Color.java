package game.utils;

public class Color {
    public static String bg_black = "\u001B[40m";
    public static String bg_red = "\u001B[41m";
    public static String bg_green = "\u001B[42m";
    public static String bg_yellow = "\u001B[43m";
    public static String bg_blue = "\u001B[44m";
    public static String bg_magenta = "\u001B[45m";
    public static String bg_cyan = "\u001B[46m";
    public static String bg_lightGray = "\u001B[47m";
    public static String bg_default = "\u001B[49m";
    public static String bg_darkGray = "\u001B[100m";
    public static String bg_lightRed = "\u001B[101m";
    public static String bg_lightGreen = "\u001B[102m";
    public static String bg_lightYellow = "\u001B[103m";
    public static String bg_lightBlue = "\u001B[104m";
    public static String bg_lightMagenta = "\u001B[105m";
    public static String bg_lightCyan = "\u001B[106m";
    public static String bg_white = "\u001B[107m";
    public static String t_black = "\u001B[30m";
    public static String t_red = "\u001B[31m";
    public static String t_green = "\u001B[32m";
    public static String t_yellow = "\u001B[33m";
    public static String t_blue = "\u001B[34m";
    public static String t_magenta = "\u001B[35m";
    public static String t_cyan = "\u001B[36m";
    public static String t_lightGray = "\u001B[37m";
    public static String t_default = "\u001B[39m";
    public static String t_darkGray = "\u001B[90m";
    public static String t_lightRed = "\u001B[91m";
    public static String t_lightGreen = "\u001B[92m";
    public static String t_lightYellow = "\u001B[93m";
    public static String t_lightBlue = "\u001B[94m";
    public static String t_lightMagenta = "\u001B[95m";
    public static String t_lightCyan = "\u001B[96m";
    public static String t_white = "\u001B[97m";

    public static String stringWithColor(String s, String color) {
        if (color.startsWith("\u001B[4") || color.startsWith("\u001B[10")) {
            return String.format("%s%s%s", color, s, Color.bg_default);
        } else {
            return String.format("%s%s%s", color, s, Color.t_default);
        }
    }

    public static String stringWithColor(String s, String bg_color, String t_color) {
        return String.format("%s%s%s%s%s", bg_color, t_color, s, Color.bg_default, Color.t_default);
    }
}