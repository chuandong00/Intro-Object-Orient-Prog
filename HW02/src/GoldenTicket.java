/**
 * Define the GoldenTicket class.
 *
 * @author Cliu702
 * @version 1
 */
public class GoldenTicket {
    private String catchphrase;
    private double discount;

    /**
     * Constructor with 2-args.
     *
     * @param catchphrase String representing the catchphrase printed on the ticket
     * @param discount    double representing the discount offered by the ticket
     */
    public GoldenTicket(String catchphrase, double discount) {
        this.setCatchphrase(catchphrase);
        this.setDiscount(discount);
    }

    /**
     * Method that gives information of the GoldenTicket.
     *
     * @return String representing the object
     */
    public String ticketString() {
        return String.format("Golden Ticket with a %.2f%% discount! %s", discount, catchphrase);
    }

    /**
     * Getter for catchphrase variable.
     *
     * @return String representing the catchphrase printed on the ticket
     */
    public String getCatchphrase() {
        return this.catchphrase;
    }

    /**
     * Getter for discount variable.
     *
     * @return double representing the discount offered by the ticket
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Setter for catchphrase variable.
     *
     * @param catchphrase String representing the catchphrase printed on the ticket
     */
    public void setCatchphrase(String catchphrase) {
        if (catchphrase == null || catchphrase.isEmpty()) {
            this.catchphrase = "Congrats!";
        } else {
            this.catchphrase = catchphrase;
        }
    }

    /**
     * Setter for discount variable.
     *
     * @param discount double representing the discount offered by the ticket
     */
    public void setDiscount(double discount) {
        if (discount > 0 && discount <= 25) {
            this.discount = Math.round(discount * 100.0) / 100.0;
        } else {
            this.discount = 15.0;
        }
    }
}
