package com.sci.engine.interfaces;

import com.sci.engine.graphics.Renderer;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Rotatable {

    /**
     * Renders this object at the specified coordinates rotated at a certain
     * angle
     *
     * @param {@link Renderer}
     * @param x position (in pixels)
     * @param y position (in pixels)
     * @param rotX position (in pixels)
     * @param rotY position (in pixels)
     * @param angle (in degrees)
     * @throws {@link UnsupportedOperationException}
     */
    public void rotatedRender(Renderer renderer, int x, int y, int rotX, int rotY, int angle);
}
