package com.sci.engine.level;

import java.util.ArrayList;
import java.util.List;
import com.sci.engine.entity.Entity;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.interfaces.Renderable;
import com.sci.engine.interfaces.Updatable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class Level implements Updatable, Renderable
{
	protected List<Entity> entities;
	protected int width;
	protected int height;

	/**
	 * Creates a new level
	 * 
	 * @param width
	 *            (in pixels)
	 * @param height
	 *            (in pixels)
	 */
	public Level(int width, int height)
	{
		this.width = width;
		this.height = height;
		this.entities = new ArrayList<Entity>();
	}

	/**
	 * Spawns an entity into the world
	 * 
	 * @param {@link Entity}
	 */
	public void spawnEntity(Entity entity)
	{
		this.entities.add(entity);
	}

	/**
	 * Gets the width of the level
	 * 
	 * @return width (in pixels)
	 */
	@Override
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Gets the height of the level
	 * 
	 * @return height (in pixels)
	 */
	@Override
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Renders the level
	 * 
	 * <ul>
	 * <li>Renders all entities in the level</li>
	 * </ul>
	 * 
	 * @param x
	 *            (not used)
	 * @param y
	 *            (not used)
	 * @param {@link Renderer}
	 */
	@Override
	public void render(int x, int y, Renderer renderer)
	{
		for(Entity entity : this.entities)
			entity.render(entity.getX(), entity.getY(), renderer);
	}

	/**
	 * Updates the level
	 * 
	 * <ul>
	 * <li>Updates entities all entities in the level, removes ones marked for
	 * removal</li>
	 * </ul>
	 */
	@Override
	public void update()
	{
		for(int index = 0; index < this.entities.size(); index++)
		{
			Entity entity = this.entities.get(index);
			if(entity.isMarkedForRemoval())
			{
				this.entities.remove(index);
				entity.onRemoved();
				continue;
			}
			entity.update();
		}
	}
}