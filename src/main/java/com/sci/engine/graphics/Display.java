package com.sci.engine.graphics;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class Display
{
	protected List<Runnable> closeListeners;

	public Display()
	{
		this.closeListeners = new ArrayList<Runnable>();
	}

	/**
	 * Gets the width of this display
	 * 
	 * @return the width (in pixels)
	 */
	public abstract int getWidth();

	/**
	 * Gets the height of this display
	 * 
	 * @return the height (in pixels)
	 */
	public abstract int getHeight();

	/**
	 * Gets the {@link Graphics} to render onto
	 * 
	 * @return
	 */
	public abstract Graphics getDrawGraphics();

	/**
	 * Shows the rendered graphics onto the {@link Display}
	 */
	public abstract void show();

	/**
	 * Call before any rendering is done to ensure {@link Display} is ready for
	 * rendering
	 */
	public abstract void start();

	/**
	 * Call to shut the {@link Display} down
	 */
	public abstract void stop();

	/**
	 * Adds a listener for Display shutdown
	 */
	public final void addCloseListener(Runnable runnable)
	{
		this.closeListeners.add(runnable);
	}
}