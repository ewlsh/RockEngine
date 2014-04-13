package com.sci.engine;

import java.util.List;
import com.sci.engine.graphics.Display;
import com.sci.engine.graphics.Renderer;
import com.sci.engine.interfaces.Updatable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class SciGame implements Runnable
{
	private Thread thread;
	private volatile boolean running;
	private boolean ran;

	private double ns;
	private int targetTPS;
	private int tps;
	private int fps;

	private List<Updatable> updatables;

	private Display display;
	private Renderer renderer;

	/**
	 * Creates a new game using the specified display
	 * 
	 * @param display
	 */
	public SciGame(Display display)
	{
		this.display = display;
		this.renderer = new Renderer(this.display.getWidth(), this.display.getHeight());
		this.thread = new Thread(this, "SciGame-Main");
		this.display.addCloseListener(new Runnable()
		{
			@Override
			public void run()
			{
				SciGame.this.stop();
			}
		});
		this.setTargetTPS(100);
	}

	/**
	 * Starts the game
	 */
	public synchronized final void start()
	{
		this.running = true;
		this.display.start();
		this.thread.start();
	}

	/**
	 * Stops the game
	 */
	public synchronized final void stop()
	{
		this.running = false;
		this.display.stop();
	}

	/**
	 * Adds an updatable object
	 * 
	 * @param updatable
	 */
	public final void addUpdatable(Updatable updatable)
	{
		this.updatables.add(updatable);
	}

	/**
	 * Removes an updatable object
	 * 
	 * @param updatable
	 */
	public final void removeUpdatable(Updatable updatable)
	{
		this.updatables.remove(updatable);
	}

	@Override
	public final void run()
	{
		if(!this.ran)
		{
			this.ran = true;

			long last = System.nanoTime();
			double delta = 0.0;
			int ticks = 0;
			int frames = 0;
			long timer = System.currentTimeMillis();

			this.init();
			
			while(this.running)
			{
				long now = System.nanoTime();
				delta += (now - last) / this.ns;
				last = now;

				while(delta >= 1)
				{
					this.update();
					delta--;
					ticks++;
				}

				this.render(this.renderer);
				frames++;
				this.renderer.copy();
				this.display.getDrawGraphics().drawImage(this.renderer.getImage(), 0, 0, null);
				this.display.show();

				if(System.currentTimeMillis() - timer > 1000)
				{
					timer += 1000;
					this.tps = ticks;
					this.fps = frames;
					ticks = 0;
					frames = 0;
				}
			}
			
			this.shutdown();
		}
	}

	/**
	 * Initializes the game
	 */
	public abstract void init();

	/**
	 * Updates the game
	 */
	public abstract void update();

	/**
	 * Renders the game
	 * 
	 * @param renderer
	 */
	public abstract void render(Renderer renderer);

	/**
	 * Called when the game shuts down
	 */
	public abstract void shutdown();

	/**
	 * Gets the game's tick rate
	 * 
	 * @return
	 */
	public int getTPS()
	{
		return this.tps;
	}

	/**
	 * Get the game's frame rate
	 * 
	 * @return
	 */
	public int getFPS()
	{
		return this.fps;
	}

	/**
	 * Gets the game's target tick rate
	 * 
	 * @return
	 */
	public int getTargetTPS()
	{
		return this.targetTPS;
	}

	/**
	 * Sets the game's target tick rate
	 * 
	 * @param targetTPS
	 */
	public void setTargetTPS(int targetTPS)
	{
		this.targetTPS = targetTPS;
		this.ns = 1000000000.0 / this.targetTPS;
	}
}