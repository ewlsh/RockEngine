package com.sci.engine.graphics;

import java.util.HashMap;
import java.util.Map;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Font
{
	protected Map<Character, Glyph> glyphs;
	protected int characterWidth;
	protected int characterHeight;
	protected CharCase charCase;

	/**
	 * Creates a new font. Called by static factory
	 */
	public Font(int width, int height, char[] characters, Texture texture)
	{
		this.characterWidth = width;
		this.characterHeight = height;
		this.glyphs = new HashMap<Character, Glyph>();
		this.charCase = CharCase.BOTH;

		int[] pixels = texture.getPixels();
		int x = 0;
		int y = 0;
		int xMax = texture.getWidth() / this.characterWidth;
		int yMax = texture.getHeight() / this.characterHeight;
		int charIndex = 0;

		while(charIndex < characters.length)
		{
			int[] glyphPixels = new int[this.characterWidth * this.characterHeight];

			for(int i = 0; i < this.characterWidth; i++)
			{
				for(int j = 0; j < this.characterHeight; j++)
				{
					int pIndex = (x * this.characterWidth + i) + (y * this.characterWidth + i) * texture.getWidth();
					int gIndex = i + j * this.characterWidth;
					glyphPixels[gIndex] = pixels[pIndex];
				}
			}

			this.glyphs.put(characters[charIndex], new Glyph(this.characterWidth, this.characterHeight, glyphPixels));

			charIndex++;
			if(x < xMax)
			{
				x++;
			}
			else
			{
				x = 0;
				if(y < yMax)
				{
					y++;
				}
				else
				{
					if(charIndex != characters.length) { throw new AssertionError(); }
				}
			}
		}
	}

	/**
	 * Gets this {@link Font}'s character case mode
	 * 
	 * @return {@link CharCase}
	 */
	public CharCase getCharCase()
	{
		return charCase;
	}

	/**
	 * Sets this {@link Font}'s character case mode
	 * 
	 * @param {@link CharCase}
	 */
	public void setCharCase(CharCase charCase)
	{
		this.charCase = charCase;
	}

	/**
	 * Get the texture to render for this character
	 * 
	 * @param character
	 * @return {@link Texture}
	 */
	public Glyph getGlyph(char c)
	{
		return this.glyphs.get(c);
	}

	/**
	 * Gets the width of any character in this {@link Font}
	 * 
	 * @return width (in pixels)
	 */
	public int getCharacterWidth()
	{
		return this.characterWidth;
	}

	/**
	 * Gets the height of any character in this {@link Font}
	 * 
	 * @return height (in pixels)
	 */
	public int getCharacterHeight()
	{
		return this.characterHeight;
	}

	/**
	 * Gets the width of a string
	 * 
	 * @param string
	 * @return width (in pixels)
	 */
	public int getStringWidth(String str)
	{
		return str.length() * this.characterWidth;
	}

	public static enum CharCase
	{
		UPPER, BOTH, LOWER;
	}
}