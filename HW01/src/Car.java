public class Car {
    private int year;
    private String make;
    private String model;
    private String color;
    private int conditionCategory;
    private boolean isRestored;

    public Car(int year, String make, String model, String color, int conditionCategory) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.color = color;
        this.conditionCategory = conditionCategory;
        this.conditionCategoryHelper();
        this.isRestored = this.testRestored();
    }

    public Car(int year, String make, String model) {
        this(year, make, model, "blue", 80);
    }

    public Car() {
        this(1960, "Jaguar", "E-Type", "silver", 89);
    }

    public boolean testRestored() {
        if (this.conditionCategory >= 90) {
            return true;
        }
        return false;
    }

    public void conditionCategoryHelper() {
        if (this.conditionCategory <= 100 & this.conditionCategory >= 90) {
            System.out.println("Perfect");
        } else if (this.conditionCategory <= 89 & this.conditionCategory >= 80) {
            System.out.println("Excellent");
        } else if (this.conditionCategory <= 79 & this.conditionCategory >= 70) {
            System.out.println("Fine");
        } else if (this.conditionCategory <= 69 & this.conditionCategory >= 60) {
            System.out.println("Very Good");
        } else if (this.conditionCategory <= 59 & this.conditionCategory >= 50) {
            System.out.println("Good");
        } else if (this.conditionCategory <= 49 & this.conditionCategory >= 40) {
            System.out.println("Driver");
        } else {
            this.conditionCategory = 80;
            System.out.println("Excellent");
        }
    }

    public int getYear() {
        return this.year;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getConditionCategory() {
        return this.conditionCategory;
    }
}


