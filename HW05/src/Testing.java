public class Testing{
        public static void main(String[] args) {

                Cake dessert6 = new Cake("macaron", 3.0, "vanilla");
                Cake dessert7 = new Cake("apple", 15.0, "choco");
                Cake dessert8 = new Cake("pudding", 1.0, "straw");
                Cake dessert9 = new Cake("ice cream", 2.0, "pudding");
                Cake dessert10 = new Cake("caramel", 25.0, "cream");
                Store store3 = new Store("name");
                store3.addDessert(dessert6);
                store3.addDessert(dessert7);
                store3.addDessert(dessert8);
                store3.addDessert(dessert9);
                store3.addDessert(dessert10);
                store3.sortStore();
                System.out.println(store3.getDesserts());
                /**
                Cake cake1 = new Cake("orange", 1.0, "vanilla");
                Cake cake2 = new Cake("vanilla");
                IceCream icecream1 = new IceCream("apple", 1.0, 3, true);
                IceCream icecream2 = new IceCream();
                IceCream icecream3 = new IceCream("cookie", 5.0, 3, true);
                IceCream icecream4 = new IceCream();
//                Dessert dessert1 = new Dessert("caramel", 3.0);
//                Dessert dessert2 = new Dessert();
//                Dessert dessert3 = new Dessert("z", 3.0);
                Store store1 = new Store("The Store");
                Store store2 = new Store("The Second Store");

                //cake
                System.out.println(cake1.toString());
                System.out.println(cake1.equals(cake2));

                //ice cream
                System.out.println(icecream1.toString());
                System.out.println(icecream2.toString());
                System.out.println(icecream1.equals(icecream2));

                //dessert
//                System.out.println(dessert2.toString());
//                System.out.println(dessert1.equals(dessert2));
//                System.out.println(dessert1.compareTo(dessert2)); //should return -1
//                System.out.println(dessert1.compareTo(dessert3)); //equal

                //store
                System.out.println(store1.getDesserts());

                store1.addDessert(icecream3);
                store1.addDessert(cake1);
                store1.addDessert(cake2);
                System.out.println(store1.getDesserts()); //should have three desserts

                store1.removeDessert(icecream1); //null
                System.out.println(store1.getDesserts());

                store1.removeDessert(icecream3);//ok
                System.out.println(store1.getDesserts());

                System.out.println(store1.findDessert(cake1)); //finds
                System.out.println(store1.findDessert(cake2)); //null

                store1.sortStore();
                store1.checkStore(icecream1);

                //---
                store2.addDessert(icecream1);
                store2.addDessert(cake1);
                store2.addDessert(cake2);
                //---
                //Bob
                System.out.println(Bob.compareStores(store1, store2));
                System.out.println(Bob.shop(store2, cake1)); //true
                System.out.println(Bob.shop(store2, icecream1)); //false

                //sort
//                Dessert dessert6 = new Dessert("macaron", 3.0);
//                Dessert dessert7 = new Dessert("apple", 15.0);
//                Dessert dessert8 = new Dessert("pudding", 1.0);
//                Dessert dessert9 = new Dessert("ice cream", 2.0);
//                Dessert dessert10 = new Dessert("caramel", 25.0);
//                Store store3 = new Store("name");
//                store3.addDessert(dessert6);
//                store3.addDessert(dessert7);
//                store3.addDessert(dessert8);
//                store3.addDessert(dessert9);
//                store3.addDessert(dessert10);
//                store3.sortStore();
                 */
        }
}