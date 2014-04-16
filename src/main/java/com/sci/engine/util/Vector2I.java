package com.sci.engine.util;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class Vector2I
{
	private int x;
	private int y;

	/**
	 * Creates a new {@link Vector2I}
	 * 
	 * @param x
	 * @param y
	 */
	public Vector2I(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets this {@link Vector2I}'s x ordinate
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Sets this {@link Vector2I}'s x ordinate
	 */
	public void setX(int x)
	{
		this.x = x;
	}

	/**
	 * Gets this {@link Vector2I}'s y ordinate
	 */
	public int getY()
	{
		return y;
	}

	/**
	 * Sets this {@link Vector2I}'s y ordinate
	 */
	public void setY(int y)
	{
		this.y = y;
	}

	/**
	 * Gets the distance between this {@link Vector2I} and another
	 * 
	 * @param vec
	 * @return
	 */
	public int distance(Vector2I vec)
	{
		return (int) Math.sqrt(Math.pow(vec.x - this.x, 2) + Math.pow(vec.y - this.y, 2));
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result = 31 * result + x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;

		if(getClass() != obj.getClass())
			return false;

		Vector2I other = (Vector2I) obj;

		if(x != other.x)
			return false;
		if(y != other.y)
			return false;

		return true;
	}

	@Override
	public String toString()
	{
		return "Vector2I(" + this.x + ", " + this.y + ")";
	}
}