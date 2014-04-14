package com.sci.engine.entity;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public abstract class EntityLiving extends Entity
{
	protected int health;
	protected int maxHealth;

	/**
	 * Creates a new {@link EntityLiving}
	 */
	public EntityLiving()
	{
	}

	/**
	 * Updates this {@link EntityLiving}
	 */
	@Override
	public void update()
	{
		if(this.health < 0)
			this.health = 0;
		if(this.health == 0)
		{
			this.onDeath();
			return;
		}
	}

	/**
	 * Called when this entity dies
	 */
	public void onDeath()
	{
	}

	/**
	 * Gets this {@link EntityLiving}'s health level
	 * 
	 * @return
	 */
	public int getHealth()
	{
		return this.health;
	}

	/**
	 * Gets this {@link EntityLiving}'s maximum health
	 * 
	 * @return
	 */
	public int getMaxHealth()
	{
		return this.maxHealth;
	}

	/**
	 * Sets this {@link EntityLiving}'s health
	 * 
	 * @param health
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}

	/**
	 * Sets this {@link EntityLiving}'s maximum health
	 * 
	 * @param maxHealth
	 */
	public void setMaxHealth(int maxHealth)
	{
		this.maxHealth = maxHealth;
	}
}