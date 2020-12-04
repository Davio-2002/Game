package com.company.models;

import com.company.Informative;

import java.util.Random;

public class Warrior implements Informative {
    static Random random = new Random();

    private String name;
    private int life;
    private int damage;

    public Warrior() {
    }

    public Warrior( String name, int life, int damage ) {
        this.name = name;
        this.life = life;
        this.damage = damage;
    }

    public void wasAttacked( Warrior opponent, Warrior activePlayer ) {
        opponent.setLife(opponent.getLife() - opponent.takeDamageFrom(activePlayer));
        checkIfWarriorIsDead(opponent);
        giveInformation(opponent, activePlayer);
    }

    @Override
    public int takeDamageFrom( Warrior activePlayer ) {
        return activePlayer.getDamage();
    }

    public void checkIfWarriorIsDead( Warrior opponent ) {
        if (opponent.getLife() <= 0) {
            opponent.setLife(0);
            //Dead
        }
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife( int life ) {
        this.life = life;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage( int damage ) {
        this.damage = damage;
    }

    @Override
    public void giveInformation( Warrior opponent, Warrior activePlayer ) {
        System.out.println(opponent.getName() + " was attacked by " + activePlayer.getName());
        System.out.println(opponent.getName() + "'s life remains " + opponent.getLife());
    }
}