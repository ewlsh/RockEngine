package com.sci.engine.util;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class ObjectPool<T>
{
	private long expirationTime;
	private Hashtable<T, Long> locked;
	private Hashtable<T, Long> unlocked;

	/**
	 * Creates a new {@link ObjectPool}
	 * 
	 * @param expirationTime
	 */
	public ObjectPool(long expirationTime)
	{
		this.expirationTime = expirationTime;
		this.locked = new Hashtable<T, Long>();
		this.unlocked = new Hashtable<T, Long>();
	}

	/**
	 * Creates a new T
	 * 
	 * @return
	 */
	protected abstract T create();

	/**
	 * Validates a T
	 * 
	 * @param o
	 * @return
	 */
	protected abstract boolean validate(T o);

	/**
	 * Called when a T expires
	 * 
	 * @param o
	 */
	protected abstract void expire(T o);

	/**
	 * Checks out a T from the pool
	 * 
	 * @return
	 */
	public final synchronized T checkOut()
	{
		long now = System.currentTimeMillis();
		T t;
		if(this.unlocked.size() > 0)
		{
			Enumeration<T> elements = this.unlocked.keys();
			while(elements.hasMoreElements())
			{
				t = elements.nextElement();
				if((now - this.unlocked.get(t)) > this.expirationTime)
				{
					this.unlocked.remove(t);
					this.expire(t);
					t = null;
				}
				else
				{
					if(this.validate(t))
					{
						this.unlocked.remove(t);
						this.locked.put(t, now);
						return t;
					}
					else
					{
						this.unlocked.remove(t);
						this.expire(t);
						t = null;
					}
				}
			}
		}
		t = this.create();
		this.locked.put(t, now);
		return t;
	}

	/**
	 * Checks a T back into the pool
	 * 
	 * @param t
	 */
	public final void checkIn(T t)
	{
		this.locked.remove(t);
		this.unlocked.put(t, System.currentTimeMillis());
	}
}