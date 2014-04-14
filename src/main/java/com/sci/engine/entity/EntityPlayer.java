package com.sci.engine.entity;

import com.sci.engine.graphics.Renderer;
import com.sci.engine.graphics.Texture;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class EntityPlayer extends EntityLiving
{
	protected Texture texture;

	/**
	 * Creates a new {@link EntityPlayer}
	 */
	public EntityPlayer()
	{

	}

	/**
	 * Gets the width of the player's texture
	 * 
	 * @return width (in pixels)
	 */
	public int getWidth()
	{
		if(this.texture == null)
			return 0;
		return this.texture.getWidth();
	}

	/**
	 * Gets the height of the player's texture
	 * 
	 * @return height (in pixels)
	 */
	public int getHeight()
	{
		if(this.texture == null)
			return 0;
		return this.texture.getHeight();
	}

	/**
	 * Renders the player at the specified location
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param {@link Renderer}
	 */
	@Override
	public void render(int x, int y, Renderer renderer)
	{
		renderer.render(x, y, this.texture);
	}

	@Override
	public void update()
	{
		super.update();

		// TODO
	}
}