package com.sci.engine.graphics;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

	/**
	 * Creates a new font. Called by static factory
	 */
	private Font(int width, int height, char[] characters, Texture texture)
	{
		this.characterWidth = width;
		this.characterHeight = height;
		this.glyphs = new HashMap<Character, Glyph>();

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

	/**
	 * Loads a {@link Font} from an {@link InputStream}.
	 * 
	 * Data Format:
	 * <table>
	 * <tr>
	 * <th>Index</th>
	 * <th>Data</th>
	 * </tr>
	 * <tr>
	 * <td>0</td>
	 * <td>Width</td>
	 * </tr>
	 * <tr>
	 * <td>1</td>
	 * <td>Height</td>
	 * </tr>
	 * <tr>
	 * <td>2... n-1</td>
	 * <td>Characters</td>
	 * </tr>
	 * <tr>
	 * <td>n...</td>
	 * <td>PNG Texture</td>
	 * </tr>
	 * </table>
	 * 
	 * @param inputStream
	 * @return
	 */
	public static Font load(InputStream inputStream)
	{
		try
		{
			int width = inputStream.read();
			int height = inputStream.read();

			List<Character> characters = new ArrayList<Character>();
			while(true)
			{
				int c = inputStream.read();

				if(c == 0xDEADC0DE)
					break;
				else
					characters.add((char) c);
			}

			char[] charArray = new char[characters.size()];
			for(int i = 0; i < characters.size(); i++)
				charArray[i] = characters.get(i);

			Texture texture = Texture.load(inputStream);
			return new Font(width, height, charArray, texture);
		}
		catch(Throwable e)
		{
		}
		return null;
	}
}