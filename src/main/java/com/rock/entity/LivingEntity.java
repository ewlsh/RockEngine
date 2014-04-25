package com.rock.entity;

/**
 * SciEngine: RockEngine Fork
 *
 * @author rockon999
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LivingEntity extends Entity {

    private double health;
    private double maxHealth;

    public LivingEntity(int id) {
        super(id);
    }

    public LivingEntity(int id, int x, int y) {
        super(id, x, y);
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public void onDeath() {
    }

    @Override
    public void update() {
        if (this.health <= 0) {
            this.health = 0;
            this.onDeath();
        }
    }
}
