/**
 * Define the Hippo class.
 *
 * @author Cliu702
 * @version 1
 */
public class Hippo extends Pet {
    private int buff;

    /**
     * 3-args constructor.
     *
     * @param health int representing the health points for this Pet
     * @param attack int representing the attack points for this Pet
     * @param buff   int representing the buff
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        this.buff = Math.max(buff, 0);
    }

    /**
     * default constructor.
     */
    public Hippo() {
        this(7, 4, 2);
    }

    /**
     * Increase the Hippo’s health and attack by buff.
     */
    public void getBuffed() {
        super.setHealth((super.getHealth() + this.buff));
        super.setAttack((super.getAttack() + this.buff));
    }

    /**
     * Make attack to anotherPet by this Hippo.
     *
     * @param anotherPet Pet that will be attacked by this Hippo
     */
    @Override
    public void attackPet(Pet anotherPet) {
        super.attackPet(anotherPet);
        if (anotherPet.hasFainted()) {
            this.getBuffed();
        }
    }

    /**
     * Gives a String representing information of this Hippo.
     *
     * @return String representation of a Hippo
     */
    @Override
    public String toString() {
        return "Hippo:" + super.toString() + String.format("/%d", this.buff);
    }
}
