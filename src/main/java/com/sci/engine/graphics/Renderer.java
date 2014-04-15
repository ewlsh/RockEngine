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
	private Font font;
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
		this.image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
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
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
				this.setPixel(x + i, y + j, color);
			}
		}
	}

	/**
	 * Draws a string at the specified location using the {@link Renderer}'s
	 * {@link Font}
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param str
	 */
	public void drawString(int x, int y, String str)
	{
		switch (this.font.getCharCase())
		{
		case UPPER:
			str = str.toUpperCase();
			break;
		case BOTH:
			break;
		case LOWER:
			str = str.toLowerCase();
			break;
		}

		for(int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if(c < 0)
				continue;
			int xx = x + this.font.getCharacterWidth() * i;
			Glyph glyph = this.font.getGlyph(c);
			if(glyph != null)
				glyph.render(xx, y, this);
		}
	}

	/**
	 * Renders the renderable object at the specified coordinates
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
				this.setPixel(xx, yy, new Color(pixels[i + j * width]));
			}
		}
	}

	/**
	 * Sets a pixel to the specified color
	 * 
	 * @param the
	 *            x ordinate of the pixel
	 * @param the
	 *            y ordinate of the pixel
	 * @param the
	 *            {@link Color} to set the pixel to
	 */
	public void setPixel(int x, int y, Color color)
	{
		this.setPixel(x + y * this.width, color);
	}

	/**
	 * Sets a pixel to the specified color
	 * 
	 * @param index
	 * @param {@link Color}
	 */
	public void setPixel(int index, Color color)
	{
		if(index < 0 || index >= this.pixels.length)
			return;

		int n = color.getColor();
		int nAlpha = (n & 0xff000000) >> 24;
		int o = this.pixels[index];
		

		if(nAlpha < 255)
		{
			//Cr = Cs + Cd * (1 - As)
			n = n + o * (1 - nAlpha);
		}

		this.pixels[index] = n;
	}

	/**
	 * Copies the renderer pixels to the renderer image pixels
	 */
	public void copy()
	{
		System.arraycopy(this.pixels, 0, this.imagePixels, 0, this.pixels.length);
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

	/**
	 * Sets this {@link Renderer}'s {@link Font}
	 * 
	 * @param {@link Font}
	 */
	public void setFont(Font font)
	{
		this.font = font;
	}

	/**
	 * Gets this {@link Renderer}'s {@link Font}
	 * 
	 * @return {@link Font}
	 */
	public Font getFont()
	{
		return this.font;
	}
}