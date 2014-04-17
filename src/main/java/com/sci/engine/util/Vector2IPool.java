package com.sci.engine.util;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public class Vector2IPool extends ObjectPool<Vector2I>
{
	private Vector2IPool(long expirationTime)
	{
		super(expirationTime);
	}

	@Override
	protected Vector2I create()
	{
		return new Vector2I();
	}

	@Override
	protected boolean validate(Vector2I o)
	{
		o.setX(0);
		o.setY(0);
		return false;
	}

	@Override
	protected void expire(Vector2I o)
	{
		
	}
}