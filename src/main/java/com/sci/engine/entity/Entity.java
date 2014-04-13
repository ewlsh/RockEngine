package com.sci.engine.entity;

import com.sci.engine.interfaces.Renderable;
import com.sci.engine.interfaces.Updatable;
import com.sci.engine.level.Level;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class Entity implements Updatable, Renderable
{
	protected Level level;
	protected int x;
	protected int y;
	protected boolean remove;

	/**
	 * Creates a new entity
	 */
	public Entity()
	{
	}

	/**
	 * Creates a new entity at the specified position
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 */
	public Entity(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the entities x position
	 * 
	 * @return x (in pixels)
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * Gets the entities y position
	 * 
	 * @return y (in pixels)
	 */
	public int getY()
	{
		return this.y;
	}

	/**
	 * Sets the entities x position
	 * 
	 * @param x
	 *            (in pixels)
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Sets the entities y position
	 * 
	 * @param y
	 *            (in pixels)
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * Called when the entity is removed from the {@link Level}
	 */
	public void onRemoved()
	{
	}

	/**
	 * Marks the entity L removal from the {@link Level}
	 */
	public void markForRemoval()
	{
		this.remove = true;
	}

	/**
	 * Checks if the entity is marked for removal
	 * 
	 * @return
	 */
	public boolean isMarkedForRemoval()
	{
		return this.remove;
	}
}