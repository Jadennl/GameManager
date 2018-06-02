
public class Custom extends PlayerClass {

    public Custom(String pclass, int armor, int mana, int speed, double maxHealth) {
        super(pclass, armor, mana, speed, maxHealth);

    }

    public double calcHeal() {
        if (getStats()[1] > 100) {
            return getMax() * .25;
        } else if (getStats()[1] == 0) {
            return 1.0;
        } else return getMax() * getStats()[1] / 100;
    }
}
