package com.sci.engine.graphics;

import com.sci.engine.interfaces.Renderable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Glyph implements Renderable
{
	protected final int width;
	protected final int height;
	protected final int[] pixels;

	/**
	 * Creates a new {@link Glyph}
	 * 
	 * @param width
	 *            (in pixels)
	 * @param height
	 *            (in pixels)
	 * @param pixels
	 */
	public Glyph(int width, int height, int[] pixels)
	{
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	/**
	 * Gets the width of this {@link Glyph}
	 * 
	 * @return width (in pixels)
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * Gets the height of this {@link Glyph}
	 * 
	 * @return height (in pixels)
	 */
	public int getHeight()
	{
		return height;
	}

	/**
	 * Gets this {@link Glyph}'s pixel array
	 * 
	 * @return int[]
	 */
	public int[] getPixels()
	{
		return pixels;
	}

	@Override
	public void render(int x, int y, Renderer renderer)
	{
		renderer.setPixels(x, y, this.width, this.height, this.pixels);
	}
}