package BurgerChallenge;

public class Burger {

    private String type;
    private double price;
    private String toppingOne;
    private String toppingTwo;
    private String toppingThree;

    public Burger() {
        this.type = "Hamburger";
        this.price = burgerPrice(type);
    }

    public Burger(String type) {
        this.type = type;
        this.price = burgerPrice(type);
    }

    public Burger(String type, String toppingOne) {
        this(type);
        this.price = price + 0.5;
        this.toppingOne = toppingOne;
    }

    public Burger(String type, String toppingOne,
                  String toppingTwo) {
        this(type, toppingOne);
        this.price = price + 0.5;
        this.toppingTwo = toppingTwo;
    }

    public Burger(String type, String toppingOne,
                  String toppingTwo, String toppingThree) {
        this(type, toppingOne, toppingThree);
        this.price = price + 0.5;
        this.toppingThree = toppingThree;
    }

    public String burgerInitialization(String type){
        if (type.toLowerCase().contains("chee")) {
            setType("Cheese burger");
        } else if (type.toLowerCase().contains("ham")) {
            setType("Hamburger");
        } else if (type.toLowerCase().contains("del")) {
            setType("Deluxe burger");
        } else if (type.toLowerCase().contains("ch")) {
            setType("Charm burger");
        }
        return getType();
    }

    private double burgerPrice(String type) {
        if (type.toLowerCase().contains("chee")) {
            return 5;
        } else if (type.toLowerCase().contains("ham")) {
            return 4.5;
        } else if (type.toLowerCase().contains("del")) {
            return 7.2;
        } else if (type.toLowerCase().contains("ch")) {
            return 6.4;
        }
        return 5.5;
    }

    public static Burger singleBurgerOrder(String type) {
        System.out.print("\tYou can add up to three toppings on the burger." +
                "\n\tWould you like to add any? [Y/N] -> ");
        String toppingConfirmation = Main.scanner.nextLine();
        if (toppingConfirmation.toLowerCase().contains("y")){
            return Toppings.withTopping(type);
        }
        return new Burger(type);
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static class Toppings{
        static int topppingCount = 0;
        static String toppingOne = "";
        static String toppingTwo = "";
        static String toppingThree = "";

        private static Burger withTopping(String type){
            for (int i = 1; i <= 3; i++) {
                System.out.print("\t\tChoose topping No" + i + ": ");
                String currentTopping = Main.scanner.nextLine();
                if (currentTopping.equals("") || currentTopping.toLowerCase().equals("no")) {
                    System.out.println("\tOk, burger will stay with only " + (i - 1) + "toppings.");
                    break;
                }
                topppingCount++;
                System.out.printf("\t\t\tTopping %d -> %s is added%n", i, currentTopping);
                switch (i) {
                    case 1 -> toppingOne = currentTopping;
                    case 2 -> toppingTwo = currentTopping;
                    case 3 -> toppingThree = currentTopping;
                }
            }
            if (topppingCount == 1) {
                return new Burger(type, toppingOne);
            } else if (topppingCount == 2) {
                return new Burger(type, toppingOne, toppingTwo);
            } else {
                return new Burger(type, toppingOne, toppingTwo, toppingThree);
            }
        }
    }
}
