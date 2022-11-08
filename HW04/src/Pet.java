/**
 * Define the Pet class.
 *
 * @author Cliu702
 * @version 1
 */
public abstract class Pet implements Comparable<Pet> {
    private int health;
    private int attack;

    /**
     * 2-args constructor.
     *
     * @param health int representing the health points for this Pet
     * @param attack int representing the attack points for this Pet
     */
    public Pet(int health, int attack) {
        if (health > 0) {
            this.health = health;
        } else {
            this.health = 1;
        }
        this.attack = Math.max(attack, 0);
    }

    /**
     * Test whether this Pet has fainted.
     *
     * @return boolean representing whether this Pet has fainted
     */
    public boolean hasFainted() {
        return (this.health <= 0);
    }

    /**
     * Make this Pet attacked by some amount of damage.
     *
     * @param damage int representing the amount of damage this Pet is being attacked for
     */
    public void getAttacked(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        this.health -= damage;
    }

    /**
     * Make attack to anotherPet by this pet.
     *
     * @param anotherPet Pet that will be attacked by this Pet
     */
    public void attackPet(Pet anotherPet) {
        anotherPet.getAttacked(this.attack);
    }

    /**
     * Gives a String representing information of this Pet.
     *
     * @return String representation of a Pet
     */
    @Override
    public String toString() {
        return String.format("%d/%d", this.attack, this.health);
    }

    /**
     * Compared this pet with another pet.
     *
     * @param o Pet representing the Pet to be compared to
     * @return int representing whether this Pet is better than the other Pet
     */
    @Override
    public int compareTo(Pet o) {
        if (o == null) {
            return 1;
        }
        if ((this.attack + this.health) > (o.attack + o.health)) {
            return 1;
        } else if ((this.attack + this.health) < (o.attack + o.health)) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Getter for attack.
     *
     * @return int representing the attack points for this Pet
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Getter for health.
     *
     * @return health int representing the health points for this Pet
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter for attack.
     *
     * @param attack int representing the attack points for this Pet
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Setter for health.
     *
     * @param health health int representing the health points for this Pet
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
