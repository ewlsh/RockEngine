package com.sci.engine.graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;
import com.sci.engine.interfaces.Renderable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Renderer
{
	private int width;
	private int height;
	private int[] pixels;
	private int[] imagePixels;
	private BufferedImage image;

	public Renderer(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.pixels = new int[this.width * this.height];
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		this.imagePixels = ((DataBufferInt) this.image.getRaster().getDataBuffer()).getData();
		this.image.setAccelerationPriority(1f);
	}

	/**
	 * Clears the renderer to black
	 */
	public void clear()
	{
		this.clear(Color.BLACK);
	}

	/**
	 * Clears the renderer to the specified color
	 * 
	 * @param {@link Color}
	 */
	public void clear(Color color)
	{
		Arrays.fill(this.pixels, color.getColor());
	}

	/**
	 * Fills a rectangle
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param width
	 *            (in pixels)
	 * @param height
	 *            (in pixels)
	 * @param {@link Color}
	 */
	public void fillRect(int x, int y, int width, int height, Color color)
	{
		for(int j = 0; j < height; j++)
		{
			int start = x + (j + y) * this.width;
			Arrays.fill(this.pixels, start, start + width, color.getColor());
		}
	}

	/**
	 * Renders a renderable object at the specified location
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param {@link Renderable}
	 */
	public void render(int x, int y, Renderable renderable)
	{
		renderable.render(x, y, this);
	}

	/**
	 * Sets the pixels at the specified location
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param pixels
	 */
	public void setPixels(int x, int y, int width, int height, int[] pixels)
	{
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				int xx = x + i;
				int yy = y + j;
				this.pixels[xx + yy * this.width] = pixels[i + j * width];
			}
		}
	}

	/**
	 * Copies the renderer pixels to the renderer image pixels
	 */
	public void copy()
	{
		for(int i = 0; i < this.pixels.length; i++)
			this.imagePixels[i] = this.pixels[i];
	}

	/**
	 * Gets the width of the renderer
	 * 
	 * @return the width (in pixels)
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Gets the width of the renderer
	 * 
	 * @return the height (in pixels)
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Gets the rendered image
	 * 
	 * @return {@link BufferedImage}
	 */
	public BufferedImage getImage()
	{
		return this.image;
	}
}