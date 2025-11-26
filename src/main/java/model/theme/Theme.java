package model.theme;

import java.awt.Color;

public class Theme {

    public static class Colors {
        //Brand Colors
        public static final Color BLUE =
            hexToColor("#1d3a8f");
        public static final Color ORANGE =
            hexToColor("#ff7b29");

        //Background Colors
        public static final Color BG_LIGHT = hexToColor("#f5f5f0"); // Light Grey
        public static final Color BG_DARK = hexToColor("#2a2a2a"); // Deep Charcoal

        //Text Colors
        public static final Color TXT_PRIMARY = hexToColor("#333333");
        public static final Color TXT_SECONDAY = hexToColor("#666666");

        //PDF Text Shades
        public static final Color TXT_DARKEST = hexToColor("#111111");
        public static final Color TXT_DARKER = hexToColor("#1a1a1a");
        public static final Color TXT_DARK = hexToColor("#222222");
        public static final Color TXT_MEDIUM = hexToColor("#555555");
        public static final Color TXT_LIGHT = hexToColor("#666666");
        public static final Color TXT_LIGHTER = hexToColor("#777777");

        //Components
        public static final Color UNIT_BG = hexToColor("#f9f9f9");
        public static final Color EXERCISE_BG = hexToColor("#ffffff");
        public static final Color SEPERATOR = hexToColor("#e0e0e0");
    }

    /*
     * Method to convert hex values into a Java Color Object
     * @param The hex color string (e.g, "FFFFFF")
     * @return A Java Color Object
     */
    public static Color hexToColor(String hex) {
        hex = hex.replace("#", "");
        if (hex.length() != 6) return Color.BLACK;

        try {
            return new Color(
                Integer.valueOf(hex.substring(0, 2), 16),
                Integer.valueOf(hex.substring(2, 4), 16),
                Integer.valueOf(hex.substring(4, 6), 16)
            );
        }
        catch (NumberFormatException e) {
            System.err.println("Invalid hex color format: " + hex + ". Using black");
        }
    }

    //Typography
    public static class Fonts {
        //JavaFX Font Names
        public static final String HEADER_FONT = "Baskerille, 'Times New Roman', serif";
        public static final String BODY_FONT = "Lato, 'Segoe UI'";

        //Font sizes
        public static final float TITLE_SIZE = 26;
        public static final float SUB_TITLE_SIZE = 20;
        public static final float UNIT_HEADER_SIZE = 20;
        public static final float UNIT_WEEKDAY_SIZE = 14;
        public static final float UNIT_DESC_SIZE = 16;
        public static final float EXERCISE_NAME_SIZE = 14;
        public static final float EXERCISE_DESC_SIZE = 12;
        public static final float EXERCISE_DETAILS_SIZE = 11;
        public static final float PLACEHOLDER_SIZE = 11;
    }

    //Java Layout Consts
    public static class Layout {
        //Page Layout
        public static final float MARGIN = 50;
        public static final float BASE_LINE_SPACE_FACTOR = 1.3f;
        public static final float EXTRA_LINE_SPACE = 1.5f;

        //Spacing
        public static final float SPACING_AFTER_TITLE = 10;
        public static final float SPACING_AFTER_PRE_DESC = 15;
        public static final float SPACING_SEP = 12;

        public static final float SPACING_BETWEEN_UNITS = 20;
        public static final float SPACING_AFTER_UNIT_HEADER = 4;
        public static final float SPACING_AFTER_UNIT_WEEKDAY = 8;
        public static final float SPACING_AFTER_UNIT_DESC = 12;


        public static final float SPACING_BEFORE_EXERCISES = 10;
        public static final float SPACING_BETWEEN_EXERCISES = 15;
        public static final float SPACING_AFTER_EXERCISE_NAME = 3;
        public static final float SPACING_AFTER_EXERCISE_DESC = 6;

        //Indentations
        public static final float UNIT_INDENT_LEVEL = 15;
        public static final float EXERCISE_CONTAINER_INDENT = 15;
        public static final float EXERCISE_INTERNAL_INDENT = 10; //Internal padding inside container
                                                                 //
        public static final float EXERCISE_BLOCK_INDENT = EXERCISE_CONTAINER_INDENT;
        public static final float INDENT_EXERCISE_CONTENT = EXERCISE_CONTAINER_INDENT;

        //Components Styling
        public static final float UNIT_BORDER_RADIUS = 5;
        public static final float EXERCISE_BORDER_RADIUS = 3;
        public static final float BORDER_WIDTH = 1;
    }
}
