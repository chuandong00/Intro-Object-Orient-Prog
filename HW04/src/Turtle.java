/**
 * Define the Turtle class.
 *
 * @author Cliu702
 * @version 1
 */
public class Turtle extends Pet {
    private boolean melonArmor;

    /**
     * 3-args constructor.
     *
     * @param health     int representing the health points for this Pet
     * @param attack     int representing the attack points for this Pet
     * @param melonArmor boolean representing whether this Turtle possesses melon armor
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }

    /**
     * default constructor.
     */
    public Turtle() {
        this(4, 2, true);
    }

    /**
     * Make this Pet attacked by some amount of damage.
     *
     * @param damage int representing the amount of damage this Pet is being attacked for
     */
    @Override
    public void getAttacked(int damage) {
        if (melonArmor) {
            this.melonArmor = false;
            if (damage > 20) {
                super.getAttacked(damage - 20);
            }
        } else {
            super.getAttacked(damage);
        }
    }

    /**
     * Gives a String representing information of this Turtle.
     *
     * @return String representation of a Turtle
     */
    @Override
    public String toString() {
        return "Turtle:" + super.toString() + String.format("/%b", melonArmor);
    }
}
