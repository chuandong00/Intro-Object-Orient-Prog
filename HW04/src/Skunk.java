/**
 * Define the Skunk class.
 *
 * @author Cliu702
 * @version 1
 */
public class Skunk extends Pet {
    private int numSpray;

    /**
     * 3-args constructor.
     *
     * @param health   int representing the health points for this Pet
     * @param attack   int representing the attack points for this Pet
     * @param numSpray int representing the number of times the Skunk can spray
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        this.numSpray = Math.max(numSpray, 0);
    }

    /**
     * default constructor.
     */
    public Skunk() {
        this(5, 3, 1);
    }

    /**
     * Spray anotherPet by this Skunk.
     *
     * @param anotherPet Pet that will be sprayed by this Skunk
     */
    public void sprayPet(Pet anotherPet) {
        anotherPet.setAttack((anotherPet.getAttack() * 2 / 3));
        anotherPet.setHealth((anotherPet.getHealth() * 2 / 3));
        this.numSpray--;
    }

    /**
     * Make attack to anotherPet by this Skunk.
     *
     * @param anotherPet Pet that will be attacked by this Skunk
     */
    @Override
    public void attackPet(Pet anotherPet) {
        if (this.numSpray > 0) {
            this.sprayPet(anotherPet);
        }
        super.attackPet(anotherPet);
    }

    /**
     * Gives a String representing information of this Skunk.
     *
     * @return String representation of a Skunk
     */
    @Override
    public String toString() {
        return "Skunk:" + super.toString() + String.format("/%d", this.numSpray);
    }
}
