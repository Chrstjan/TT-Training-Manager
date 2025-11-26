package export.pdf;
import model.theme.Theme;

public class PdfLayout {
    //Page layout
    public static final float MARGIN = Theme.Layout.MARGIN;
    public static final float CONTENT_WIDTH = 595 - 2 * MARGIN;
    public static final float BASE_LINE_SPACING_FACTOR = Theme.Layout.BASE_LINE_SPACE_FACTOR;
    public static final float EXTRA_LINE_SPACING = Theme.Layout.EXTRA_LINE_SPACE;

    public static final float PADDING_UNIT_VERTICAL = 12f;
    public static final float PADDING_UNIT_HORIZONTAL = 15f;
    public static final float PADDING_EXERCISE_VERTICAL = 10f;
    public static final float PADDING_EXERCISE_HORIZONTAL = 10f;

    //Indentation
    public static final float INDENT_UNIT_LEVEL = PADDING_UNIT_HORIZONTAL;
    public static final float INDENT_EXERCISE_CONTAINER = Theme.Layout.EXERCISE_CONTAINER_INDENT;
    public static final float INDENT_EXERCISE_INTERNAL = PADDING_EXERCISE_HORIZONTAL;
    public static final float INDENT_EXERCISE_BLOCK = Theme.Layout.EXERCISE_BLOCK_INDENT;
    public static final float INDENT_EXERCISE_CONTENT = Theme.Layout.INDENT_EXERCISE_CONTENT;

    //Spacing
    public static final float SPACING_AFTER_TITLE = Theme.Layout.SPACING_AFTER_TITLE;

    //Component styling
    public static final float UNIT_BORDER_RADIUS = Theme.Layout.UNIT_BORDER_RADIUS;
    public static final float EXERCISE_BORDER_RADIUS = Theme.Layout.EXERCISE_BORDER_RADIUS;
    public static final float BORDER_WIDTH = Theme.Layout.BORDER_WIDTH;
}
