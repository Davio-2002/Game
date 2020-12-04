package com.company.models;

public class Swordsman extends Warrior {

    private int armorPercentage;

    public Swordsman() {
    }

    public Swordsman( String name, int life, int damage ) {
        super(name, life, damage);
        this.armorPercentage = getArmorPercentage();
    }

    @Override
    public void wasAttacked( Warrior opponent, Warrior activePlayer ) {
        opponent.setLife(opponent.getLife() - opponent.takeDamageFrom(activePlayer));
        checkIfWarriorIsDead(opponent);
        giveInformation(opponent, activePlayer);
        System.out.println(opponent.getName() + " used armor !! Percentage -> " + getArmorPercentage() + "%");
    }

    @Override
    public int takeDamageFrom( Warrior activePlayer ) {
        setArmorPercentage(random.nextInt(15) + 20);
        return activePlayer.getDamage() * (100 - armorPercentage) / 100;
    }

    public int getArmorPercentage() {
        return armorPercentage;
    }

    public void setArmorPercentage( int armorPercentage ) {
        this.armorPercentage = armorPercentage;
    }
}