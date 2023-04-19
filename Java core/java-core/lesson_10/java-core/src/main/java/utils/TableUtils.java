package utils;

public class TableUtils {
    public static void showBorder(char symbol, int[] widths) {
        StringBuilder border = new StringBuilder("+");
        for (int width : widths) {
            String pattern = "%" + (width + 2) + "c";
            String raw = String.format(pattern, ' ');
            String symbols = raw.replace(' ', symbol);
            border.append(symbols).append('+');
        }
        System.out.println(border);
    }

    public static void showHeader(String[] titles, int[] widths) {
        StringBuilder header = new StringBuilder("|");
        for (int i = 0; i < widths.length; i++) {
            String pattern = " %-" + widths[i] + "s ";
            String title = String.format(pattern, titles[i]);
            header.append(title).append('|');
        }
        System.out.println(header);
    }

    public static void showData(Object[] bodies, int[] widths) {
        StringBuilder row = new StringBuilder("|");
        if (bodies == null) {
            for (int width : widths) {
                String pattern = " %-" + width + "s ";
                String data = String.format(pattern, "NULL");
                row.append(data).append('|');
            }
        } else {
            for (int i = 0; i < widths.length; i++) {
                String pattern = " %-" + widths[i] + "s ";
                String data = String.format(pattern, bodies[i]);
                row.append(data).append('|');
            }
        }
        System.out.println(row);
    }
}
