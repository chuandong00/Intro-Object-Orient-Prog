/**
 * Define the PetBattlefield class.
 *
 * @author Cliu702
 * @version 1
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;

    /**
     * 2-args constructor.
     *
     * @param firstTeam  An array of Pets representing the Pets in team1
     * @param secondTeam An array of Pets representing the Pets in team2
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5 || secondTeam.length > 5) {
            this.firstTeam = new Pet[5];
            this.secondTeam = new Pet[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }

    /**
     * Gives a String representing information of two teams.
     *
     * @return String representation of two teams
     */
    @Override
    public String toString() {
        String finalString = new String("First Team: ");
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null) {
                finalString = finalString.concat("Empty");
            } else {
                finalString = finalString.concat(firstTeam[i].toString());
            }
            if (i == (firstTeam.length - 1)) {
                finalString = finalString.concat(" vs Second Team: ");
            } else {
                finalString = finalString.concat(", ");
            }
        }

        for (int i = 0; i < secondTeam.length; i++) {
            if (secondTeam[i] == null) {
                finalString = finalString.concat("Empty");
            } else {
                finalString = finalString.concat(secondTeam[i].toString());
            }
            if (i != (secondTeam.length - 1)) {
                finalString = finalString.concat(", ");
            }
        }
        return finalString;
    }

    /**
     * Compare each Pet to decide which team is more likely to win solely based on their stats.
     */
    public void compareTeams() {
        int point = 0;
        if (firstTeam.length >= secondTeam.length) {
            for (int i = 0; i < firstTeam.length; i++) {
                if (i >= secondTeam.length) {
                    if (firstTeam[i] != null) {
                        point++;
                    }
                } else {
                    if (firstTeam[i] != null) {
                        point += firstTeam[i].compareTo(secondTeam[i]);
                    } else if (secondTeam[i] != null) { //firstTeam[i] == null && secondTeam[i] != null
                        point -= 1;
                    }
                }
            }
        } else {
            for (int i = 0; i < secondTeam.length; i++) {
                if (i >= firstTeam.length) {
                    if (secondTeam[i] != null) {
                        point++;
                    }
                } else {
                    if (secondTeam[i] != null) {
                        point += secondTeam[i].compareTo(firstTeam[i]);
                    } else if (firstTeam[i] != null) { //firstTeam[i] == null && secondTeam[i] != null
                        point -= 1;
                    }
                }
            }
        }
        if (point > 0) {
            System.out.println("The first team will probably win.");
        } else if (point < 0) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * Start a battle between the two teams to get the winner.
     */
    public void battle() {
        int team1 = 0;
        int team2 = 0;
        while (team1 <= (firstTeam.length - 1) && team2 <= (secondTeam.length - 1)) {
            if (firstTeam[team1] == null && secondTeam[team2] == null) {
                team1++;
                team2++;
                continue;
            } else if (firstTeam[team1] != null && secondTeam[team2] == null) {
                team2++;
                continue;
            } else if (firstTeam[team1] == null && secondTeam[team2] != null) {
                team1++;
                continue;
            }
            int winner = battleHelper(firstTeam[team1], secondTeam[team2]);
            if (winner == 1) {
                secondTeam[team2] = null;
                team2++;
            } else if (winner == 2) {
                firstTeam[team1] = null;
                team1++;
            } else {
                secondTeam[team2] = null;
                firstTeam[team1] = null;
                team1++;
                team2++;
            }
        }

        if (team1 == firstTeam.length && team2 == secondTeam.length) {
            System.out.println("Both teams fainted.");
        } else if (team1 == firstTeam.length && team2 < secondTeam.length) {
            System.out.println("The second team won!");
        } else {
            System.out.println("The first team won!");
        }

    }

    /**
     * Helper method to compete two Pets.
     *
     * @param pet1 Pet representing the first pet
     * @param pet2 Pet representing the second pet
     * @return int representing which pet wins or both fainted
     */
    public int battleHelper(Pet pet1, Pet pet2) {
        while (!pet1.hasFainted() && !pet2.hasFainted()) {
            pet1.attackPet(pet2);
            pet2.attackPet(pet1);
        }
        if (pet1.hasFainted() && pet2.hasFainted()) {
            //both fainted
            return 0;
        } else if (pet1.hasFainted() && !pet2.hasFainted()) {
            //pet1 fainted
            return 2;
        } else { //!pet1.hasFainted() && pet2.hasFainted()
            //pet2 fainted
            return 1;
        }
    }

    /**
     * Test for functionality of class.
     *
     * @param args Array of String
     */
    public static void main(String[] args) {
        Pet pet1 = new Turtle(5, 3, false);
        Pet pet2 = new Turtle();
        Pet pet3 = new Hippo(5, 9, 3);
        Pet pet4 = new Hippo();
        Pet pet5 = new Skunk(4, 6, 3);
        Pet pet6 = new Skunk();
        Pet pet7 = new Turtle(7, 4, true);
        Pet[] team1 = new Pet[]{null, pet1, pet4, null, pet6};
        Pet[] team2 = new Pet[]{pet3, pet2, null, pet7, pet5};
        PetBattlefield petBattlefield = new PetBattlefield(team1, team2);

        System.out.println("------test compareTeams()------------");
        petBattlefield.compareTeams();
        System.out.println("------------test toString()---------------");
        System.out.println(petBattlefield.toString());
        System.out.println("-----------test battle---------------");
        petBattlefield.battle();
        System.out.println(petBattlefield.toString());
        System.out.println(pet3.toString());

        System.out.println("------------test Turtle get attack--------");
        System.out.println("------------use melonArmor---------");
        System.out.println("before damage:");
        System.out.println(pet2.toString());
        pet2.getAttacked(7);
        System.out.println("after damage:");
        System.out.println(pet2.toString());
        System.out.println("--------can't use melonArmor---------");
        System.out.println("before damage:");
        System.out.println(pet7.toString());
        pet7.getAttacked(32);
        System.out.println("after damage:");
        System.out.println(pet7.toString());

        System.out.println("------------test Hippo attackPet------------");
        System.out.println(pet1.toString());
        System.out.println(pet3.toString());
        pet3.attackPet(pet1);
        System.out.println(pet1.toString());
        System.out.println(pet3.toString());

        System.out.println("-----------test Skunk attackPet------------");
        System.out.println(pet5.toString());
        System.out.println(pet4.toString());
        pet5.attackPet(pet4);
        System.out.println(pet5.toString());
        System.out.println(pet4.toString());

        Pet turtle1 = new Turtle(5, 3, false);
        Pet turtle2 = new Turtle();
        Pet hippo1 = new Hippo(5, 9, 3);
        Pet hippo2 = new Hippo();
        Pet skunk1 = new Skunk(4, 6, 3);
        Pet skunk2 = new Skunk();
        Pet turtle3 = new Turtle(7, 4, true);
        Pet[] team3 = new Pet[]{null, turtle1, null, hippo2};
        Pet[] team4 = new Pet[]{null, turtle3, null};
        PetBattlefield petBattlefield2 = new PetBattlefield(team3, team4);
        petBattlefield2.compareTeams();
        PetBattlefield petBattlefield4 = new PetBattlefield(team4, team3);
        petBattlefield4.compareTeams();
        Pet[] team5 = new Pet[]{skunk1, turtle3, null};
        PetBattlefield petBattlefield3 = new PetBattlefield(team3, team5);
        petBattlefield3.compareTeams();
        petBattlefield3.battle();
    }
}
