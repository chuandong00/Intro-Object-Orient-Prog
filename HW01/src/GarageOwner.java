public class GarageOwner {
    private String name;
    private int age;
    private int carsOwned;

    public GarageOwner(String name, int age) {
        setName(name);
        setAge(age);
        setCarsOwned(0);
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getCarsOwned() {
        return this.carsOwned;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCarsOwned(int carsOwned) {
        this.carsOwned = carsOwned;
    }
}
