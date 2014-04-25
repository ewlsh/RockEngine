package com.sci.engine.gui;

import java.util.ArrayList;
import java.util.List;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.interfaces.Renderable;
import com.sci.engine.interfaces.Updatable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class Component implements Updatable, Renderable
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected List<Listener> listeners;

	/**
	 * Creates a new Component at the specified coordinates with the spcified
	 * width and height
	 * 
	 * @param x
	 *            (in pixels)
	 * @param y
	 *            (in pixels)
	 * @param width
	 *            (in pixels)
	 * @param height
	 *            (in pixels)
	 */
	public Component(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.listeners = new ArrayList<Listener>();
	}

	/**
	 * Adds a {@link Listener} to this {@link Component}
	 * 
	 * @param {@link Listener}
	 */
	public void addListener(Listener listener)
	{
		this.listeners.add(listener);
	}

	/**
	 * Removes a {@link Listener} from this {@link Component}
	 * 
	 * @param {@link Listener}
	 */
	public void removeListener(Listener listener)
	{
		this.listeners.remove(listener);
	}

	/**
	 * Gets this component's x position
	 * 
	 * @return x (in pixels)
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * Gets this component's y position
	 * 
	 * @return y (in pixels)
	 */
	public int getY()
	{
		return this.y;
	}

	/**
	 * Gets this component's width
	 * 
	 * @return width (in pixels)
	 */
	public int getWidth()
	{
		return this.width;
	}

	/**
	 * Gets this component's height
	 * 
	 * @return height (in pixels)
	 */
	public int getHeight()
	{
		return this.height;
	}

	/**
	 * Sets this component's x ordinate
	 * 
	 * @param x
	 *            (in pixels)
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Sets this component's y ordinate
	 * 
	 * @param y
	 *            (in pixels)
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * Sets this component's width
	 * 
	 * @param width
	 *            (in pixels)
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * Sets this component's height
	 * 
	 * @param height
	 *            (in pixels)
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}

}