package com.rock.entity;

import com.sci.engine.interfaces.Updatable;
import com.sci.engine.util.AABB;
import com.sci.engine.util.Vector2I;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Entity implements Updatable {

    private Vector2I position;
    private AABB boundingBox;
    private final int id;

    public Entity(int id) {
        this.id = id;
        this.position = new Vector2I();
        this.boundingBox = new AABB();
    }

    public Entity(int id, int x, int y) {
        this.id = id;
        this.position = new Vector2I(x, y);
        this.boundingBox = new AABB();
    }

    @Override
    public void update() {
    }

    public int getId() {
        return id;
    }

    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Vector2I getPosition() {
        return position;
    }

    public AABB getBoundingBox() {
        return boundingBox;
    }
}
