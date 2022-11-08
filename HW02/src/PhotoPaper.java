/**
 * Define the PhotoPaper class.
 *
 * @author Cliu702
 * @version 1
 */
public class PhotoPaper extends PaperProduct {
    private double glossiness;

    /**
     * Constructor with 3-args.
     *
     * @param name              String representing the name of the Product
     * @param numberOfSheets    int representing the number of the sheets
     * @param weightOfUnitSheet double representing the weight, in grams, of one sheet of the paper product
     * @param glossiness        double representing the glossiness of the paper product
     */
    public PhotoPaper(String name, int numberOfSheets, double weightOfUnitSheet, double glossiness) {
        super(name, numberOfSheets, weightOfUnitSheet);
        this.setGlossiness(glossiness);
    }

    /**
     * Constructor with 2-args.
     *
     * @param name           String representing the name of the Product
     * @param numberOfSheets int representing the number of the sheets
     */
    public PhotoPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25, 70);
        //super(name, numberOfSheets);
    }

    /**
     * Constructor with 1-args.
     *
     * @param name String representing the name of the Product
     */
    public PhotoPaper(String name) {
        this(name, 500, 0.25, 70);
    }

    /**
     * Copy constructor.
     *
     * @param photoPaper PhotoPaper representing the PhotoPaper object to copy
     */
    public PhotoPaper(PhotoPaper photoPaper) {
        super(photoPaper);
        this.glossiness = photoPaper.glossiness;
    }

    /**
     * Method that gives information of the Object.
     *
     * @return String representing the Object
     */
    public String photoString() {
        return String.format("%.2f%% glossy and %s", this.glossiness, this.paperString());
    }

    /**
     * Method that gives shipping information.
     *
     * @param companyName String representing the name of the company
     * @return String representing shipping information
     */
    public String shipPhoto(String companyName) {
        return String.format("Paper is %.2f%% glossy. ", this.glossiness) + this.ship(companyName);
    }

    /**
     * Getter for glossiness variable.
     *
     * @return double representing the glossiness of the paper product
     */
    public double getGlossiness() {
        return this.glossiness;
    }

    /**
     * Setter for glossiness variable.
     *
     * @param glossiness double representing the glossiness to set
     */
    public void setGlossiness(double glossiness) {
        if (glossiness >= 0 && glossiness <= 100) {
            this.glossiness = Math.round(glossiness * 100.0) / 100.0;
        } else {
            this.glossiness = 70.0;
        }

    }
}
