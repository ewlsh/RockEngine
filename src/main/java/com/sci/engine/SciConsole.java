package com.sci.engine;

import java.util.ArrayList;
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
public abstract class SciConsole implements Runnable {

    private Thread thread;
    private volatile boolean running;
    private boolean ran;
    private double ns;
    private int targetTPS;
    private int tps;
    private int fps;
    private List<Updatable> updatables;

    /**
     * Creates a new game using the specified display
     *
     * @param display
     */
    public SciConsole() {
        this.thread = new Thread(this, "SciConsole-Main");
        this.setTargetTPS(100);
        this.updatables = new ArrayList<Updatable>();
    }

    /**
     * Starts the game
     */
    public synchronized final void start() {
        this.running = true;
       
        this.thread.start();
    }

    /**
     * Stops the game
     */
    public synchronized final void stop() {
        this.running = false;
       
    }

    /**
     * Adds an updatable object
     *
     * @param updatable
     */
    public final void addUpdatable(Updatable updatable) {
        this.updatables.add(updatable);
    }

    /**
     * Removes an updatable object
     *
     * @param updatable
     */
    public final void removeUpdatable(Updatable updatable) {
        this.updatables.remove(updatable);
    }

    @Override
    public final void run() {
        if (!this.ran) {
            this.ran = true;

            long last = System.nanoTime();
            double delta = 0.0;
            int ticks = 0;
            int frames = 0;
            long timer = System.currentTimeMillis();

            this.init();

            while (this.running) {
                long now = System.nanoTime();
                delta += (now - last) / this.ns;
                last = now;

                while (delta >= 1) {
                    for (Updatable u : this.updatables) {
                        u.update();
                    }
                    this.update();
                    delta--;
                    ticks++;
                }

             

                if (System.currentTimeMillis() - timer > 1000) {
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
    public int getTPS() {
        return this.tps;
    }

    /**
     * Get the game's frame rate
     *
     * @return
     */
    public int getFPS() {
        return this.fps;
    }

    /**
     * Gets the game's target tick rate
     *
     * @return
     */
    public int getTargetTPS() {
        return this.targetTPS;
    }

    /**
     * Sets the game's target tick rate
     *
     * @param targetTPS
     */
    public void setTargetTPS(int targetTPS) {
        this.targetTPS = targetTPS;
        this.ns = 1000000000.0 / this.targetTPS;
    }
}