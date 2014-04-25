/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sci.engine.gui.components;

/**
 *
 * @author evan
 */
public class TextButton extends Button {

    private String text;

    public TextButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public String getText() {
        return text;
    }
}
