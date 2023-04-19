package com.vti.utils;

import java.util.List;

public class OutputUtils {
    public static void showTable(List<List<Object>> table) {
        int[] widths = measure(table);
        showBorder(widths);
        for (List<Object> row : table) {
            showRow(row, widths);
            showBorder(widths);
        }
    }

    private static int[] measure(List<List<Object>> table) {
        int width = table.get(0).size();
        int height = table.size();
        int[] widths = new int[width];
        int[] lengths = new int[height];
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {
                Object data = table.get(row).get(col);
                int length = data.toString().length();
                lengths[row] = length;
            }
            widths[col] = max(lengths);
        }
        return widths;
    }

    private static int max(int[] array) {
        int candidate = array[0];
        for (int next : array) {
            if (candidate < next) {
                candidate = next;
            }
        }
        return candidate;
    }

    private static void showBorder(int[] widths) {
        StringBuilder border = new StringBuilder();
        border.append('+');
        for (int width : widths) {
            int length = width + 2;
            for (int i = 0; i < length; i++) {
                border.append('-');
            }
            border.append('+');
        }
        System.out.println(border);
    }

    private static void showRow(List<Object> row, int[] widths) {
        StringBuilder content = new StringBuilder();
        content.append('|');
        for (int i = 0; i < widths.length; i++) {
            String pattern = " %-" + widths[i] + "s ";
            String data = String.format(pattern, row.get(i));
            content.append(data).append('|');
        }
        System.out.println(content);
    }
}
