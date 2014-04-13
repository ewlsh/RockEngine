package com.sci.engine.graphics;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Color
{
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color RED = new Color(255, 0, 0);
	public static final Color GREEN = new Color(0, 255, 0);
	public static final Color BLUE = new Color(0, 0, 255);

	private int color;

	/**
	 * Creates a new color with the specified hex color
	 * 
	 * @param color
	 */
	public Color(int color)
	{
		this.color = color;
	}

	/**
	 * Creates a new color with the specified red, green, and blue values Alpha
	 * defaults to 255
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 */
	public Color(int red, int green, int blue)
	{
		this(red, green, blue, 255);
	}

	/**
	 * Creates a new color with the specified red, green, blue, and alpha values
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 */
	public Color(int red, int green, int blue, int alpha)
	{
		this.color = Color.getHex(red, green, blue, alpha);
	}

	/**
	 * Gets the red value of this color
	 * 
	 * @return the red value
	 */
	public int getRed()
	{
		return Color.getRGB(this.color)[0];
	}

	/**
	 * Gets the green value of this color
	 * 
	 * @return the green value
	 */
	public int getGreen()
	{
		return Color.getRGB(this.color)[1];
	}

	/**
	 * Gets the blue value of this color
	 * 
	 * @return the blue value
	 */
	public int getBlue()
	{
		return Color.getRGB(this.color)[2];
	}

	/**
	 * Gets the alpha value of this color
	 * 
	 * @return the alpha value
	 */
	public int getAlpha()
	{
		return Color.getRGBA(this.color)[3];
	}

	/**
	 * Gets the hex value of this color
	 * 
	 * @return the color in hex
	 */
	public int getColor()
	{
		return this.color;
	}

	/**
	 * Converts a RGB value to hex
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @return
	 */
	public static int getHex(int red, int green, int blue)
	{
		return red << 16 | green << 8 | blue;
	}

	/**
	 * Converts a RGBA value to hex
	 * 
	 * @param red
	 * @param green
	 * @param blue
	 * @param alpha
	 * @return
	 */
	public static int getHex(int red, int green, int blue, int alpha)
	{
		return alpha << 24 | red << 16 | green << 8 | blue;
	}

	/**
	 * Converts a hex color to RGB format
	 * 
	 * @param color
	 *            (in hex)
	 * @return array of color values (red, green, blue)
	 */
	public static int[] getRGB(int color)
	{
		int red = (color & 0xff0000) >> 16;
		int green = (color & 0xff00) >> 8;
		int blue = (color & 0xff);
		return new int[]
		{ red, green, blue };
	}

	/**
	 * Converts a hex color to RGBA format
	 * 
	 * @param color
	 *            (in hex)
	 * @return array of color values (red, green, blue, alpha)
	 */
	public static int[] getRGBA(int color)
	{
		int alpha = (color & 0xff000000) >> 24;
		int red = (color & 0xff0000) >> 16;
		int green = (color & 0xff00) >> 8;
		int blue = (color & 0xff);
		return new int[]
		{ red, green, blue, alpha };
	}
}