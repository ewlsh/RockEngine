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

public abstract class GUI implements Updatable, Renderable
{
	protected List<Component> components;

	public GUI()
	{
		this.components = new ArrayList<>();
	}

	/**
	 * Adds a {@link Component} to this GUI
	 * 
	 * @param {@link Component}
	 */
	public void add(Component component)
	{
		this.components.add(component);
	}

	/**
	 * Removes a {@link Component} from this GUI
	 * 
	 * @param {@link Component}
	 */
	public void remove(Component component)
	{
		this.components.remove(component);
	}

	/**
	 * Updates this GUI
	 * 
	 * <ul>
	 * <li>Updates this {@link GUI}'s {@link Component}s</li>
	 * </ul>
	 */
	@Override
	public void update()
	{
		for(Component component : this.components)
			component.update();
	}

	/**
	 * Renders this GUI
	 * 
	 * <ul>
	 * <li>Renders this {@link GUI}'s {@link Component}s</li>
	 * </ul>
	 */
	@Override
	public void render(Renderer renderer, int x, int y)
	{
		for(Component component : this.components)
			component.render(renderer, x, y);
	}
}