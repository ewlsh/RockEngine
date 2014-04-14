package com.sci.engine.gui.listeners;

import com.sci.engine.gui.Component;
import com.sci.engine.gui.Listener;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public interface ClickListener extends Listener
{
	public void onClicked(Component component);
}