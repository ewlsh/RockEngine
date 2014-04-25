/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rock.entity;

/**
 *
 * @author evan
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
