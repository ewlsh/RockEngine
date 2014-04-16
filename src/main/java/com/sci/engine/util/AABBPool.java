package com.sci.engine.util;

/**
 * SciEngine
 * 
 * @author sci4me
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

public final class AABBPool extends ObjectPool<AABB>
{
	public static AABBPool create(long expirationTime)
	{
		return new AABBPool(expirationTime);
	}
	
	private AABBPool(long expirationTime)
	{
		super(expirationTime);
	}

	@Override
	protected AABB create()
	{
		return new AABB();
	}

	@Override
	protected boolean validate(AABB o)
	{
		o.setBounds(0, 0, 0, 0);
		return true;
	}

	@Override
	protected void expire(AABB o)
	{
	}
}