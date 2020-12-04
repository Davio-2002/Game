package com.company;

import com.company.models.Warrior;

public interface Informative {
    void giveInformation( Warrior opponent, Warrior activePlayer );

    int takeDamageFrom( Warrior activePlayer );
}
