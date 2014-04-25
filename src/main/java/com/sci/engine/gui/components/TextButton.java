package com.sci.engine.gui.components;

import com.sci.engine.graphics.Font;
import com.sci.engine.graphics.Renderer;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TextButton extends Button {

    private String text;
    protected int textWidth = -1;
    private Font font;

    public TextButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public String getText() {
        return text;
    }

    public Font getFont() {
        return font;
    }

    public int getTextWidth() {
        return textWidth;
    }

    public void setText(String text) {
        this.text = text;
        this.setTextWidth(getFont().getStringWidth(getText()));
    }

    public void setFont(Font font) {
        this.font = font;
        this.setTextWidth(getFont().getStringWidth(getText()));
    }

    public void setTextWidth(int textWidth) {
        this.textWidth = textWidth;
    }

    @Override
    public void render(Renderer renderer, int x, int y) {
        super.render(renderer, x, y);
        if (this.textWidth == -1 && this.font != null) {
            this.textWidth = this.font.getStringWidth(this.text);
        }
        Font font = renderer.getFont();
        renderer.setFont(this.font != null ? this.font : font);
        renderer.drawString(getX() + (getWidth() / 2) - (getTextWidth() / 2), getY() + (getHeight() / 2) - getFont().getCharacterHeight() / 2, getText());
        renderer.setFont(font);
    }
}
