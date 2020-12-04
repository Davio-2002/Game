package com.company;

import com.company.models.Archer;
import com.company.models.Magician;
import com.company.models.Swordsman;
import com.company.models.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        Magician magician = new Magician("Magician Harry Potter", 710, 50);
        Archer archer = new Archer("Archer Robin Hood", 850, 65);
        Swordsman swordsman = new Swordsman("Swordsman Lancelot du Lac", 1200, 32);

        ArrayList<Warrior> warriors = new ArrayList<>();

        warriors.add(magician);
        warriors.add(archer);
        warriors.add(swordsman);

        System.out.println("______________________________________________________________________");

        System.out.println("Name -> Harry Potter, life -> 710, gives damage -> 50, Randomly absorbs damage and gives it back !!");
        System.out.println("Name -> Archer Robin Hood, life -> 850, gives damage -> 65,Counterattacks (2, 3, or 4)x damage randomly !!");
        System.out.println("Name -> Swordsman Lancelot du Lac, life -> 1200, gives damage -> 32, Uses Holy Defense ✞ !!\n");

        System.out.print("Choose first warrior (1 for magician, 2 for archer, 3 for swordsman) -> ");
        int warriorNumber1 = scanner.nextInt();
        switch (warriorNumber1) {
            case 1 -> System.out.println("You chose a magician");
            case 2 -> System.out.println("You chose an archer");
            case 3 -> System.out.println("You chose a swordsman");
        }
        System.out.print("Choose second warrior (1 for magician, 2 for archer, 3 for swordsman) -> ");
        int warriorNumber2 = scanner.nextInt();
        switch (warriorNumber2) {
            case 1 -> System.out.println("You chose a magician");
            case 2 -> System.out.println("You chose an archer");
            case 3 -> System.out.println("You chose a swordsman");
        }

        System.out.println();
        System.out.println("LETS GO !!");

        System.out.println("______________________________________________________________________");

        Warrior warrior1 = warriors.get(warriorNumber1 - 1);
        Warrior warrior2 = warriors.get(warriorNumber2 - 1);

        while (true) {
            warrior1.wasAttacked(warrior1, warrior2);
            System.out.println();
            if (warrior1.getLife() <= 0) {
                System.out.println(warrior2.getName() + " wins !!");
                break;
            } else if (warrior2.getLife() <= 0) {
                System.out.println(warrior1.getName() + " wins !!");
                break;
            }
            warrior2.wasAttacked(warrior2, warrior1);
            System.out.println();
        }
    }
}