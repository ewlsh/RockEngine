package com.sci.engine.interfaces;

import com.sci.engine.graphics.Renderer;

/**
 * SciEngine
 *
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface Renderable {

    /**
     * Renders this object at the specified coordinates
     *
     * @param {@link Renderer}
     * @param x position (in pixels)
     * @param y position (in pixels)
     */
    public void render(Renderer renderer, int x, int y);
}