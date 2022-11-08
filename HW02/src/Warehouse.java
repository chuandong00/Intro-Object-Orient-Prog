/**
 * Define the Warehouse class.
 *
 * @author Cliu702
 * @version 1
 */
public class Warehouse {
    /**
     * Method that test other java classes.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        PaperProduct p1 = new PaperProduct("p1", 400, 0.45);
        PaperProduct p2 = new PaperProduct("p2", 300);
        PaperProduct p3 = new PaperProduct("p3");
        PaperProduct p4 = new PaperProduct(p1);
        GoldenTicket gt1 = new GoldenTicket("no", 27);
        GoldenTicket gt2 = new GoldenTicket("Yes", 35);
        DiscountedPaper dp1 = new DiscountedPaper("dp1", 300, 0.35, 37, gt1);
        DiscountedPaper dp2 = new DiscountedPaper("dp2", 1200);
        DiscountedPaper dp4 = new DiscountedPaper(dp1);
        PhotoPaper pp1 = new PhotoPaper("pp1", 150, 0.65, 70);
        PhotoPaper pp2 = new PhotoPaper("pp2", 150);
        PhotoPaper pp3 = new PhotoPaper("pp3");
        PhotoPaper pp4 = new PhotoPaper(pp3);
        dp1.setTicket(gt2);
        System.out.println(dp1.getTicket().getCatchphrase());
        System.out.println(dp4.getTicket().getCatchphrase());

        //Test ship method
        System.out.println(p1.ship("comp1"));
        System.out.println(p2.paperString());
        System.out.println(dp4.shipDiscounted("comp2"));
        System.out.println(pp3.photoString());
        System.out.println(pp4.shipPhoto("comp3"));

        System.out.println(dp1.botherAccounting());
        System.out.println(dp2.botherAccounting());
        System.out.println(dp4.botherAccounting());
    }

}
