package com.company.models;

public class Magician extends Warrior {

    private int ricochetDamage;

    public Magician() {
    }

    public Magician( String name, int life, int damage ) {
        super(name, life, damage);
        this.ricochetDamage = getRicochetDamage();
    }

    @Override
    public void wasAttacked( Warrior opponent, Warrior activePlayer ) {
        int chance = random.nextInt(40) + 20;
        opponent.setLife(opponent.getLife() - opponent.takeDamageFrom(activePlayer));
        checkIfWarriorIsDead(opponent);
        giveInformation(opponent, activePlayer);
        if (chance < 34) {
            System.out.println("Harry potter used ricochet !! Percentage -> " + returnAbsorbedDamage(activePlayer) + "%");
            activePlayer.setLife(activePlayer.getLife() - returnAbsorbedDamage(activePlayer));
        }
    }

    public int returnAbsorbedDamage( Warrior activePlayer ) {
        return activePlayer.getDamage() * getRicochetDamage() / 100;
    }

    @Override
    public int takeDamageFrom( Warrior activePlayer ) {
        setRicochetDamage(random.nextInt(15) + 18);
        return activePlayer.getDamage() * (100 - getRicochetDamage()) / 100;
    }

    public int getRicochetDamage() {
        return ricochetDamage;
    }

    public void setRicochetDamage( int ricochetDamage ) {
        this.ricochetDamage = ricochetDamage;
    }
}