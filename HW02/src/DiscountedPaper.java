/**
 * Define the DiscountedPaper class.
 *
 * @author Cliu702
 * @version 1
 */
public class DiscountedPaper extends PaperProduct {
    private double discount;
    private GoldenTicket ticket;

    /**
     * Constructor with 5-args.
     *
     * @param name              String representing the name of the Product
     * @param numberOfSheets    int representing the number of the sheets
     * @param weightOfUnitSheet double representing the weight, in grams, of one sheet of the paper product
     * @param discount          double representing the discount of the paper product
     * @param ticket            GoldenTicket object representing whether this product has a golden ticket attached to it
     */
    public DiscountedPaper(String name, int numberOfSheets, double weightOfUnitSheet,
                           double discount, GoldenTicket ticket) {
        super(name, numberOfSheets, weightOfUnitSheet);
        this.setDiscount(discount);
        this.setTicket(ticket);
    }

    /**
     * Constructor with 2-args.
     *
     * @param name           String representing the name of the Product
     * @param numberOfSheets int representing the number of the sheets
     */
    public DiscountedPaper(String name, int numberOfSheets) {
        this(name, numberOfSheets, 0.25, 15, null);
    }

    /**
     * Constructor with 1-args.
     *
     * @param name String representing the name of the Product
     */
    public DiscountedPaper(String name) {
        this(name, 500, 0.25, 15, null);
    }

    /**
     * Copy Constructor.
     *
     * @param discountedPaper DiscountedPaper representing the DiscountedPaper object to copy
     */
    public DiscountedPaper(DiscountedPaper discountedPaper) {
        super(discountedPaper);
        this.discount = discountedPaper.discount;
        this.ticket = new GoldenTicket(discountedPaper.ticket.getCatchphrase(), discountedPaper.ticket.getDiscount());
    }

    /**
     * Method that calculates the total cost after discount.
     *
     * @return double representing total cost after the discount
     */
    public double discountedCost() {
        double answer;
        if (this.ticket != null) {
            answer = Math.round((super.totalCost() * (1 - this.discount / 100.0)
                    * (1 - this.ticket.getDiscount() / 100.0)) * 100.0) / 100.0;

        } else {
            answer = Math.round((super.totalCost() * (1 - this.discount / 100.0)) * 100.0) / 100.0;
        }
        return answer;
    }

    /**
     * Method that gives information about total cost after discount.
     *
     * @param companyName String representing the name of the company
     * @return String representing information after discount
     */
    public String shipDiscounted(String companyName) {
        return this.ship(companyName)
                + String.format(" The total cost after the discount is %.2f.", this.discountedCost());
    }

    /**
     * Method that reports the discounted information of the product.
     *
     * @return String representing the discounting of this product as an entry for the accounting department
     */
    public String botherAccounting() {
        if (ticket == null) {
            return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\n", this.totalCost())
                    + String.format("Final Cost: %.2f\n", this.discountedCost())
                    + String.format("Original Discount: %.2f%%\n", this.discount)
                    + "Golden Ticket Discount: 0.00%";
        } else {
            return String.format("Discounted Paper Product:\nOriginal Cost: %.2f\n", this.totalCost())
                    + String.format("Final Cost: %.2f\n", this.discountedCost())
                    + String.format("Original Discount: %.2f%%\n", this.discount)
                    + String.format("Golden Ticket Discount: %.2f%%", this.ticket.getDiscount());
        }
    }

    /**
     * Getter for discount variable.
     *
     * @return double representing the discount of the paper product
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Getter for ticket variable.
     *
     * @return GoldenTicket object representing whether this product has a golden ticket attached to it
     */
    public GoldenTicket getTicket() {
        return ticket;
    }

    /**
     * Setter for discount variable.
     *
     * @param discount double representing the discount of the paper product
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 50) {
            this.discount = Math.round(discount * 100.0) / 100.0;
        } else {
            this.discount = 15.0;
        }
    }

    /**
     * Setter for ticket variable.
     *
     * @param ticket GoldenTicket object representing whether this product has a golden ticket attached to it
     */
    public void setTicket(GoldenTicket ticket) {
        this.ticket = ticket;
    }
}
