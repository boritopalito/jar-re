package nl.xx1.jarre.gui;

import java.awt.*;
import javax.swing.*;

public class CompoundIcon implements Icon {
    private final Icon icon1;
    private final Icon icon2;

    public CompoundIcon(Icon icon1, Icon icon2) {
        this.icon1 = icon1;
        this.icon2 = icon2;
    }

    /**
     * Draw the icon at the specified location.  Icon implementations
     * may use the Component argument to get properties useful for
     * painting, e.g. the foreground or background color.
     *
     * @param c a {@code Component} to get properties useful for painting
     * @param g the graphics context
     * @param x the X coordinate of the icon's top-left corner
     * @param y the Y coordinate of the icon's top-left corner
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon1.paintIcon(c, g, x, y);
        icon2.paintIcon(c, g, x + icon1.getIconWidth() + 2, y);
    }

    /**
     * Returns the icon's width.
     *
     * @return an int specifying the fixed width of the icon.
     */
    @Override
    public int getIconWidth() {
        return icon1.getIconWidth() + icon2.getIconWidth() + 2;
    }

    /**
     * Returns the icon's height.
     *
     * @return an int specifying the fixed height of the icon.
     */
    @Override
    public int getIconHeight() {
        return Math.max(icon1.getIconHeight(), icon2.getIconHeight());
    }
}
