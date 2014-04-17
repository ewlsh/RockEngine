package com.sci.engine.graphics;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	private BufferedImage image;

	/**
	 * Creates a new texture with the specified width, height, and pixels.
	 * Called by static factory
	 * 
	 * @param width
	 * @param height
	 * @param pixels
	 */
	private Texture(int width, int height, int[] pixels, BufferedImage image)
	{
		this.width = width;
		this.height = height;
		this.pixels = pixels;
		this.image = image;
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
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 */
	@Override
	public void render(Renderer renderer, int x, int y)
	{
		renderer.setPixels(x, y, this.width, this.height, this.pixels);
	}

	/**
	 * Renders a rotated version of this texture at x and y (in pixels)
	 * 
	 * @param {@link Renderer}
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param rotX
	 *            (in pixels)
	 * @param rotY
	 *            (in pixels)
	 * @param angle
	 *            (in degrees)
	 */
	@Override
	public void renderRotated(Renderer renderer, int x, int y, int rotX, int rotY, int angle)
	{
		if(angle == 0)
		{
			renderer.setPixels(x, y, this.width, this.height, this.pixels);
			return;
		}
		double radians = Math.toRadians(angle);
		AffineTransform transform = AffineTransform.getRotateInstance(radians, rotX, rotY);
		AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage image = op.filter(this.image, null);
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		renderer.setPixels(x, y, image.getWidth(), image.getHeight(), pixels);
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
			return new Texture(width, height, pixels, image);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}