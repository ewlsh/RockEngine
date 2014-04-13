package com.sci.engine.interfaces;

import com.sci.engine.graphics.Renderer;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public interface Renderable
{
	/**
	 * Gets the width of this renderable object
	 * 
	 * @return the width (in pixels)
	 */
	public int getWidth();

	/**
	 * Gets the height of this renderable object
	 * 
	 * @return the height (in pixels)
	 */
	public int getHeight();

	/**
	 * Renders this object at the specified coordinates with the specified
	 * renderer
	 * 
	 * @param x
	 *            position (in pixels)
	 * @param y
	 *            position (in pixels)
	 * @param renderer
	 */
	public void render(int x, int y, Renderer renderer);
}