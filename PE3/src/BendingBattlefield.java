import java.util.Random;

public class BendingBattlefield {
    public static void main(String[] args) {
        Random rand = new Random();
        int numHeroes = rand.nextInt(51) + 50;
        double boomerangBoost = Math.round((3 + 4 * rand.nextDouble()) * 100.0) / 100.0;
        double averageFirePower, averageFireHealth, averageAlliancePower, averageAllianceHealth;
        averageFirePower =  0.0;
        averageFireHealth = 0.0;
        averageAlliancePower = 0.0;
        averageAllianceHealth = 0.0;
        System.out.println("Selecting " + numHeroes + " heroes.");
        int numFire = 0;
        int numAlliance = 0;
        for (int i = 0; i < numHeroes; i++) {
            BendingType heroType = BendingType.values()[rand.nextInt(5)];
            double health = Math.round((50 + 100 * rand.nextDouble()) * 100.0) / 100.0;
            double power = Math.round((Math.abs(-120 + 80 * rand.nextDouble())) * 100.0) / 100.0;
            if (heroType == BendingType.FIRE) {
                averageFireHealth += health;
                averageFirePower += power;
                numFire++;
            }
            if (heroType == BendingType.NON_BENDER) {
                power *= boomerangBoost;
            }
            if (heroType == BendingType.NON_BENDER || heroType == BendingType.AIR
                    || heroType == BendingType.WATER || heroType == BendingType.EARTH) {
                averageAllianceHealth += health;
                averageAlliancePower += power;
                numAlliance++;
            }
            System.out.println(heroType + " hero has been summoned by his army, adding "
                    + power + " power and " + health + " health to the army.");

        }
        averageFirePower = Math.round(averageFirePower / numFire * 100.0) / 100.0;
        averageFireHealth = Math.round(averageFireHealth / numFire * 100.0) / 100.0;
        averageAlliancePower = Math.round(averageAlliancePower / numAlliance * 100.0) / 100.0;
        averageAllianceHealth = Math.round(averageAllianceHealth / numAlliance * 100.0) / 100.0;
        System.out.println("The Fire Nation has an average of " + averageFirePower
                + " power and " + averageFireHealth + " health.");
        System.out.println("The Alliance has an average of " + averageAlliancePower
                + " power and " + averageAllianceHealth + " health.");
        if ((2 * averageFirePower + 3 * averageFireHealth) <= (2 * averageAlliancePower + 3 * averageAllianceHealth)) {
            System.out.println("The Alliance won!");
        } else {
            System.out.println("The Fire Nation won!");
        }
    }
}
