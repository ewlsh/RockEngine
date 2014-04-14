package com.sci.engine.gui.components;

import java.awt.event.MouseEvent;
import com.sci.engine.graphics.Color;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.gui.ClickListener;
import com.sci.engine.gui.Component;
import com.sci.engine.gui.Listener;
import com.sci.engine.input.Mouse;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Button extends Component
{
	protected Color background;
	protected Color backgroundHovered;
	protected Color backgroundClicked;
	protected boolean hovered;
	protected boolean clicked;
	protected boolean lastClicked;

	public Button(int x, int y, int width, int height)
	{
		super(x, y, width, height);
		this.background = new Color(200, 200, 200);
		this.backgroundHovered = new Color(150, 150, 150);
		this.backgroundClicked = new Color(100, 100, 100);
	}

	@Override
	public void update()
	{
		int mouseX = Mouse.getX();
		int mouseY = Mouse.getY();
		this.hovered = mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height;
		this.clicked = Mouse.isButtonDown(MouseEvent.BUTTON1);
	}

	@Override
	public void render(int x, int y, Renderer renderer)
	{
		Color color = this.background;
		if(this.hovered)
		{
			color = this.backgroundHovered;
			if(this.clicked)
			{
				color = this.backgroundClicked;
			}
			if(this.lastClicked != this.clicked)
			{
				this.lastClicked = this.clicked;
				if(this.clicked)
				{
					for(Listener listener : this.listeners)
						if(listener instanceof ClickListener)
							((ClickListener) listener).onClicked(this);
				}
			}
		}
		renderer.fillRect(this.x, this.y, this.width, this.height, color);
	}
}