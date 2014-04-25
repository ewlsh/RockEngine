package com.sci.engine.util;

/**
 * SciEngine: RockEngine Fork
 *
 * @author sci4me
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class AABB {

    protected int minX;
    protected int minY;
    protected int maxX;
    protected int maxY;

    /**
     * Creates a new {@link AABB}
     */
    public AABB() {
    }

    /**
     * Creates a new {@link AABB} with the specified min and max x and y
     *
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     */
    public AABB(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Sets the bounds of this {@link AABB}
     *
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     */
    public void setBounds(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * Adds to the bounds of this {@link AABB}
     *
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     */
    public void expand(int minX, int minY, int maxX, int maxY) {
        this.minX += minX;
        this.minY += minY;
        this.maxX += maxX;
        this.maxY += maxY;
    }

    /**
     * Subtracts from the bounds of this {@link AABB}
     *
     * @param minX
     * @param minY
     * @param maxX
     * @param maxY
     */
    public void contract(int minX, int minY, int maxX, int maxY) {
        this.minX -= minX;
        this.minY -= minY;
        this.maxX -= maxX;
        this.maxY -= maxY;
    }

    /**
     * Checks if this {@link AABB} intersects with another
     *
     * @param aabb
     * @return
     */
    public boolean intersects(AABB aabb) {
        return this.intersectsX(aabb) && this.intersectsY(aabb);
    }

    /**
     * Checks if this {@link AABB} intersects on the X coordinate with another
     *
     * @param aabb
     * @return
     */
    public boolean intersectsX(AABB aabb) {
        return aabb.maxX >= this.minX && aabb.minX <= this.maxX;
    }

    /**
     * Checks if this {@link AABB} intersects on the Y coordinate with another
     *
     * @param aabb
     * @return
     */
    public boolean intersectsY(AABB aabb) {
        return aabb.maxY >= this.minY && aabb.minY <= this.maxY;
    }

    /**
     * Checks if a {@link Vector2I}'s x is within this {@link AABB}'s min and
     * max x
     *
     * @param vec
     * @return
     */
    public boolean isVecInX(Vector2I vec) {
        if (vec == null) {
            return false;
        }
        return vec.getX() >= this.minX && vec.getY() <= this.maxX;
    }

    /**
     * Checks if a {@link Vector2I}'s y is within this {@link AABB}'s min and
     * max y
     *
     * @param vec
     * @return
     */
    public boolean isVecInY(Vector2I vec) {
        if (vec == null) {
            return false;
        }
        return vec.getY() >= this.minY && vec.getY() <= this.maxY;
    }

    /**
     * Checks if a {@link Vector2I} is inside this {@link AABB}
     *
     * @param vec
     * @return
     */
    public boolean contains(Vector2I vec) {
        return this.isVecInX(vec) && this.isVecInY(vec);
    }

    /**
     * Gets this {@link AABB}'s min x
     *
     * @return
     */
    public int getMinX() {
        return minX;
    }

    /**
     * Sets this {@link AABB}'s min x
     *
     * @return
     */
    public void setMinX(int minX) {
        this.minX = minX;
    }

    /**
     * Gets this {@link AABB}'s min y
     *
     * @return
     */
    public int getMinY() {
        return minY;
    }

    /**
     * Sets this {@link AABB}'s min y
     *
     * @return
     */
    public void setMinY(int minY) {
        this.minY = minY;
    }

    /**
     * Gets this {@link AABB}'s max x
     *
     * @return
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * Sets this {@link AABB}'s max x
     *
     * @return
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * Gets this {@link AABB}'s max x
     *
     * @return
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * Sets this {@link AABB}'s max y
     *
     * @return
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + this.maxX;
        result = 31 * result + this.maxY;
        result = 31 * result + this.minX;
        result = 31 * result + this.minY;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        AABB other = (AABB) obj;

        if (this.maxX != other.maxX) {
            return false;
        }
        if (this.maxY != other.maxY) {
            return false;
        }
        if (this.minX != other.minX) {
            return false;
        }
        if (this.minY != other.minY) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "AABB(" + this.minX + "-" + this.maxX + ", " + this.minY + "-" + this.maxY + ")";
    }
}