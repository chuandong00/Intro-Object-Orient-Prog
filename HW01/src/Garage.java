public class Garage {
    private GarageOwner theOwner;
    private Car[] carCatalogue;

    public Garage(GarageOwner theOwner, Car[] carCatalogue) {
        this.theOwner = theOwner;
        this.carCatalogue = carCatalogue;
    }

    public Garage() {
        this.theOwner = new GarageOwner("Enzo Ferrari", 35);
        this.carCatalogue = new Car[4];
    }

    public Car addCar(int index, Car car) {
        if (index < 0 || index >= this.carCatalogue.length || car == null) {
            System.out.println("Cannot add a car to this spot.");
            return null;
        }
        if (this.carCatalogue[index] == null) {
            this.carCatalogue[index] = car;
            System.out.printf("A %s %d %s %s was just parked here.\n",
                    car.getColor(), car.getYear(), car.getMake(), car.getModel());
            this.theOwner.setCarsOwned((theOwner.getCarsOwned() + 1));
            return null;
        } else {
            Car oldCar = this.carCatalogue[index];
            this.carCatalogue[index] = car;
            System.out.printf("There was a %s %d %s %s here before.\n",
                    oldCar.getColor(), oldCar.getYear(), oldCar.getMake(), oldCar.getModel());
            return oldCar;
        }
    }

    public Car sellCar(int index) {
        if (index < 0 || index >= this.carCatalogue.length || this.carCatalogue[index] == null) {
            System.out.println("There was no car to sell!");
            return null;
        }
        Car car = this.carCatalogue[index];
        System.out.printf("%s just sold a %s %d %s %s.\n",
                theOwner.getName(), car.getColor(), car.getYear(), car.getMake(), car.getModel());
        this.carCatalogue[index] = null;
        this.theOwner.setCarsOwned((theOwner.getCarsOwned() - 1));
        return car;
    }

    public void showCertainCars(int conditionCategory) {
        for (int i = 0; i < this.carCatalogue.length; i++) {
            if (this.carCatalogue[i] != null && this.carCatalogue[i].getConditionCategory() > conditionCategory) {
                Car car = this.carCatalogue[i];
                System.out.printf("A %s %d %s %s with a condition category of %d.\n",
                        car.getColor(), car.getYear(), car.getMake(), car.getModel(), car.getConditionCategory());
            }
        }
    }

    public GarageOwner getTheOwner() {
        return this.theOwner;
    }

    public Car[] getCarCatalogue() {
        return carCatalogue;
    }
}
