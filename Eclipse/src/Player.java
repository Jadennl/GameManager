import java.util.*;

public class Player {
    private PlayerClass pClass;
    private String name;
    private int armor, mana, speed;
    private double health;
    private double maxHealth;
    private int maxMana;


    public Player(String name) {
        pClass = new Adventurer();
        armor = pClass.getStats()[0];
        mana = pClass.getStats()[1];
        speed = pClass.getStats()[2];
        maxHealth = pClass.getMax();
        health = maxHealth;
        this.setName(name);
        maxMana = mana;

    }

    public Player(String name, PlayerClass pClass) {
        this.pClass = pClass;
        armor = pClass.getStats()[0];
        mana = pClass.getStats()[1];
        speed = pClass.getStats()[2];
        maxHealth = pClass.getMax();
        health = maxHealth;
        this.setName(name);
        maxMana = mana;

    }

    public double getHealth() {
        return health;
    }

    public void hurt(double amount) {
        if ((int) Math.random() * armor < speed) {
            double dmgMult = (-44.14599735755 + 20.609302638349 * Math.log(armor)) / 100;
            if (dmgMult > 1 || dmgMult < 0) dmgMult = 1;
            double damage = amount * dmgMult;
            damage = (double) Math.round(damage * 100d) / 100d;
            health -= damage;
            System.out.println(name + " took " + damage + " damage");
        } else System.out.println(name + " dodged the attack!");
    }

    public void heal() {
        double rate = pClass.calcHeal();
        double diff = maxHealth - health;
        if (diff == 0) {
            System.out.println(name + " does not need to heal.");
        } else {
            if (mana <= 0) {
                System.out.println(name + " does not have enough mana. Delete this character if they are dead.");
            } else {
                double heall = rate * diff;
                if (heall > maxHealth) heall = maxHealth - heall;
                mana -= (heall);
                if (mana <= 0) {
                    mana = 0;
                    heall = maxMana * heall;
                }
                if (heall > maxHealth) heall = maxHealth - heall;
                heall = (double) Math.round(heall * 100d) / 100d;
                health += heall;
                System.out.println(name + " healed " + heall + " HP and has " + mana + " mana left!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerClass getpClass() {
        return pClass;
    }

    public String toString() {
        if (health > 0) {
            return name + " [" + pClass + "]: " + health + "/" + maxHealth + " HP";
        } else return name + " [" + pClass + "]: **DEAD**";
    }

}
