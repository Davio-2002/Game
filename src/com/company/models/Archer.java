package com.company.models;

public class Archer extends Warrior {

    boolean counterAttack = false;
    int xDamage;

    public Archer() {
    }

    public Archer( String name, int life, int damage ) {
        super(name, life, damage);
    }

    @Override
    public void wasAttacked( Warrior opponent, Warrior activePlayer ) {
        int chance = random.nextInt(2000);

        opponent.setLife(opponent.getLife() - opponent.takeDamageFrom(activePlayer));
        if (chance < 100) {
            setxDamage(random.nextInt(2) + 2);
            activePlayer.setLife(activePlayer.getLife() - getxDamage() * activePlayer.getDamage());
            counterAttack = true;
        }
        checkIfWarriorIsDead(opponent);
        giveInformation(opponent, activePlayer);
    }

    @Override
    public int takeDamageFrom( Warrior activePlayer ) {
        return super.takeDamageFrom(activePlayer);
    }

    @Override
    public void giveInformation( Warrior opponent, Warrior activePlayer ) {
        System.out.println(opponent.getName() + "was attacked " + activePlayer.getName());
        System.out.println(opponent.getName() + " remains " + opponent.getLife());
        if (counterAttack) {
            System.out.println("Protection !! Bullseye !! " + getxDamage() + " damage");
        }
    }

    public int getxDamage() {
        return xDamage;
    }

    public void setxDamage( int xDamage ) {
        this.xDamage = xDamage;
    }
}
