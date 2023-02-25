package BurgerChallenge;

public class Meal {
    //private String type;
    private String mealSize;

    private double price;

    public Meal() {
        this("Hamburger", "small");
    }

    public Meal(String type, String mealSize) {
        Burger burger = new Burger(type);
        if (!type.equals("Hamburger")) {
            Burger.singleBurgerOrder(burger.getType());
        }
        System.out.print("\tPlease choose drink kind: ");
        String drinkKind = Main.scanner.nextLine();
        Drink drink = new Drink(drinkKind, mealSize);
        System.out.print("\tPlease choose side item kind: ");
        String sideItemKind = Main.scanner.nextLine();
        SideItem sideItem = new SideItem(sideItemKind, mealSize);
        this.price = priceCalculation(type, mealSize);

    }


    private double priceCalculation(String type, String mealSize) {
        if (type.toLowerCase().contains("ham")) {
            price = 8;
        } else if (type.toLowerCase().contains("che")) {
            price = 12;
        } else if (type.toLowerCase().contains("cha")) {
            price = 13;
        }

        if (mealSize.toLowerCase().contains("med")) {
            price += 3.5;
        } else if (type.toLowerCase().contains("lar")) {
            price += 5;
        }

        return price;
    }

    public double getPrice() {
        return price;
    }

}
