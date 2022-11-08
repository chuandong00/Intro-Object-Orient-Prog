/**
 * Define the PaperProduct class.
 *
 * @author Cliu702
 * @version 1
 */
public class PaperProduct {
    private final String name;
    private int numberOfSheets;
    private final double weightOfUnitSheet;
    private static int totalProductsToShip = 10;
    public static final double COST_PER_GRAM = 0.025;

    /**
     * Constructor with 3-args.
     *
     * @param name              String representing the name of the Product
     * @param numberOfSheets    int representing the number of the sheets
     * @param weightOfUnitSheet double representing the weight, in grams, of one sheet of the paper product
     */
    public PaperProduct(String name, int numberOfSheets, double weightOfUnitSheet) {
        if (name == null || name.isEmpty()) {
            this.name = "A4";
        } else {
            this.name = name;
        }

        this.setNumberOfSheets(numberOfSheets);

        if (weightOfUnitSheet < 0) {
            this.weightOfUnitSheet = 0.25;
        } else {
            this.weightOfUnitSheet = Math.round(weightOfUnitSheet * 100.0) / 100.0;
        }
    }

    /**
     * Constructor with 2-args.
     *
     * @param name           String representing the name of the Product
     * @param numberOfSheets int representing the number of the sheets
     */
    public PaperProduct(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25);
    }

    /**
     * Constructor with 1-args.
     *
     * @param name String representing the name of the Product
     */
    public PaperProduct(String name) {
        this(name, 500, 0.25);
    }

    /**
     * Copy constructor.
     *
     * @param paperProduct PaperProduct representing the PaperProduct object
     */
    public PaperProduct(PaperProduct paperProduct) {
        this.name = new String(paperProduct.name);
        this.numberOfSheets = paperProduct.numberOfSheets;
        this.weightOfUnitSheet = paperProduct.weightOfUnitSheet;
    }

    /**
     * Method that calculates the total weight.
     *
     * @return double representing the total weight
     */
    public double totalWeight() {
        return Math.round(this.weightOfUnitSheet * this.numberOfSheets * 100.0) / 100.0;
    }

    /**
     * Method that calculates the total cost.
     *
     * @return double representing the total cost
     */
    public double totalCost() {
        return Math.round(this.totalWeight() * PaperProduct.COST_PER_GRAM * 100.0) / 100.0;
    }

    /**
     * Method that show a PaperProduct object.
     *
     * @return String representing the object
     */
    public String paperString() {
        return String.format("%.2fg of %s for $%.2f", this.totalWeight(), name, this.totalCost());
    }

    /**
     * Method that provides shipping information.
     *
     * @param companyName String representing name of the company
     * @return String representing the shipping information
     */
    public String ship(String companyName) {
        if (PaperProduct.totalProductsToShip != 0) {
            PaperProduct.totalProductsToShip--;
            return String.format("Shipped %.2fg of %s for $%.2f to %s", this.totalWeight(),
                    name, this.totalCost(), companyName);
        } else {
            return "Cannot ship ant item, Warehouse is empty!";
        }
    }

    /**
     * Getter for name variable.
     *
     * @return String representing name of the PaperProduct
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for numberOfSheets variable.
     *
     * @return int representing number of sheets of the PaperProduct
     */
    public int getNumberOfSheets() {
        return numberOfSheets;
    }

    /**
     * Getter for weightOfUnitSheet variable.
     *
     * @return double representing weight of one sheet
     */
    public double getWeightOfUnitSheet() {
        return weightOfUnitSheet;
    }

    /**
     * Getter for totalProductsToShip variable.
     *
     * @return int representing number of product to ship
     */
    public static int getTotalProductsToShip() {
        return totalProductsToShip;
    }

    /**
     * Setter for NumberOfSheets.
     *
     * @param sheets int representing new number of sheets
     */
    public void setNumberOfSheets(int sheets) {
        if (sheets < 0) {
            this.numberOfSheets = 500;
        } else {
            this.numberOfSheets = sheets;
        }
    }
}
