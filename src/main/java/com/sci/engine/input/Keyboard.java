package com.sci.engine.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Keyboard
{
	private static boolean[] keys = new boolean[65566];
	private static KeyAdapter adapter = new KeyAdapter()
	{
		@Override
		public void keyPressed(KeyEvent evt)
		{
			Keyboard.keys[evt.getKeyCode()] = true;
		}

		@Override
		public void keyReleased(KeyEvent evt)
		{
			Keyboard.keys[evt.getKeyCode()] = false;
		}
	};

	private Keyboard()
	{
	}

	/**
	 * Check if a key is being held down
	 * 
	 * @param keyCode
	 * @return
	 */
	public static boolean isKeyDown(int keyCode)
	{
		return Keyboard.keys[keyCode];
	}

	/**
	 * Gets the {@link KeyAdapter} of this KeyBoard
	 * 
	 * @return the {@link KeyAdapter}
	 */
	public static KeyAdapter getAdapter()
	{
		return Keyboard.adapter;
	}
}