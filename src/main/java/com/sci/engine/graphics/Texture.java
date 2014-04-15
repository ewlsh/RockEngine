package com.sci.engine.graphics;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import com.sci.engine.interfaces.Renderable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Texture implements Renderable
{
	private int width;
	private int height;
	private int[] pixels;

	/**
	 * Creates a new texture with the specified width, height, and pixels.
	 * Called by static factory
	 * 
	 * @param width
	 * @param height
	 * @param pixels
	 */
	private Texture(int width, int height, int[] pixels)
	{
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	/**
	 * Gets the width of this texture
	 * 
	 * @return the width (in pixels)
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Gets the height of this texture
	 * 
	 * @return the height (in pixels)
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Gets this texture's pixel array
	 * 
	 * @return int[]
	 */
	public int[] getPixels()
	{
		return this.pixels;
	}

	/**
	 * Renders this texture at the given x and y (in pixels)
	 * 
	 * @param {@link Renderer} to render with
	 */
	@Override
	public void render(int x, int y, Renderer renderer)
	{
		renderer.setPixels(x, y, this.width, this.height, this.pixels);
	}

	/**
	 * Loads a texture from an InputStream
	 * 
	 * @param {@link InputStream}
	 * @return the loaded {@link Texture} or null
	 */
	public static Texture load(InputStream in)
	{
		try
		{
			BufferedImage image = ImageIO.read(in);
			int width = image.getWidth();
			int height = image.getHeight();
			int[] pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
			return new Texture(width, height, pixels);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}