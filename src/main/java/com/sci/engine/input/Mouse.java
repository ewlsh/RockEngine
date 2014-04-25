package com.sci.engine.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * SciEngine
 *
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class Mouse {

    private static int mouseX;
    private static int mouseY;
    private static boolean[] buttons = new boolean[64];
    private static MouseAdapter adapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent evt) {
            Mouse.buttons[evt.getButton()] = true;
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            Mouse.buttons[evt.getButton()] = false;
        }
    };
    private static MouseMotionAdapter motionAdapter = new MouseMotionAdapter() {
        @Override
        public void mouseMoved(MouseEvent evt) {
            Mouse.mouseX = evt.getX();
            Mouse.mouseY = evt.getY();
        }

        @Override
        public void mouseDragged(MouseEvent evt) {
            Mouse.mouseX = evt.getX();
            Mouse.mouseY = evt.getY();
        }
    };

    private Mouse() {
    }

    /**
     * Gets the mouse's x position
     *
     * @return
     */
    public static int getX() {
        return Mouse.mouseX;
    }

    /**
     * Gets the mouse's y position
     *
     * @return
     */
    public static int getY() {
        return Mouse.mouseY;
    }

    /**
     * Check if a mouse button is being held down
     *
     * @param buttonId
     * @return
     */
    public static boolean isButtonDown(int buttonId) {
        return Mouse.buttons[buttonId];
    }

    /**
     * Gets the {@link MouseAdapter}
     *
     * @return
     */
    public static MouseAdapter getAdapter() {
        return Mouse.adapter;
    }

    /**
     * Gets the {@link MouseMotionAdapter}
     *
     * @return
     */
    public static MouseMotionAdapter getMotionAdapter() {
        return Mouse.motionAdapter;
    }
}