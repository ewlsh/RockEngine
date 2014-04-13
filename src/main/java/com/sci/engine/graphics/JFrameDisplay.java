package com.sci.engine.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class JFrameDisplay extends Display
{
	private JFrame frame;
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	private Graphics graphics;

	/**
	 * Creates a new JFrame dispaly with the specified width and height
	 * 
	 * @param width
	 * @param height
	 */
	public JFrameDisplay(int width, int height)
	{
		this("SciEngine", width, height);
	}

	/**
	 * Creates a new JFrame display with the specified width, height, and title
	 * 
	 * @param title
	 * @param width
	 * @param height
	 */
	public JFrameDisplay(String title, int width, int height)
	{
		this.frame = new JFrame();
		this.frame.setSize(width, height);
		this.frame.setResizable(false);
		this.frame.setLocationRelativeTo(null);
		this.frame.setTitle(title);
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent evt)
			{
				for(Runnable runnable : JFrameDisplay.this.closeListeners)
					runnable.run();
			}
		});
		this.canvas = new Canvas();
		this.canvas.setSize(width, height);
		this.frame.add(this.canvas);
	}

	@Override
	public int getWidth()
	{
		return this.frame.getWidth();
	}

	@Override
	public int getHeight()
	{
		return this.frame.getHeight();
	}

	@Override
	public Graphics getDrawGraphics()
	{
		if(this.bufferStrategy == null)
		{
			this.canvas.createBufferStrategy(3);
			this.bufferStrategy = this.canvas.getBufferStrategy();
		}
		if(this.graphics == null)
			this.graphics = this.bufferStrategy.getDrawGraphics();
		return this.graphics;
	}

	@Override
	public void show()
	{
		this.graphics.dispose();
		this.bufferStrategy.show();
	}

	@Override
	public void start()
	{
		this.frame.setVisible(true);
	}

	@Override
	public void stop()
	{
		this.frame.setVisible(false);
		this.frame.dispose();
	}
}