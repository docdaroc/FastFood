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

    public static Burger singleBurgerOrder() {
        System.out.print("\tPlease choose a burger type - available choices are:" +
                "\n\t\t- Hamburger\n\t\t- Cheese burger" +
                "\n\t\t- Deluxe burger\n\t\t- Charm burger\n\tEnter your choise: ");
        String type = Main.scanner.nextLine();
        System.out.print("\tWould you like any toppings? [Y/N] -> ");
        String toppingConfirmation = Main.scanner.nextLine();
        if (toppingConfirmation.toLowerCase().contains("y")){
            return Toppings.withTopping(type);
        }
        return new Burger(type);
    }

    public double getPrice() {
        return price;
    }

    public static class Toppings{
        static int topppingCount = 0;
        static String toppingOne = "";
        static String toppingTwo = "";
        static String toppingThree = "";

        public static Burger withTopping(String type){
            for (int i = 1; i <= 3; i++) {
                System.out.print("\t\tChoose a topping: ");
                String currentTopping = Main.scanner.nextLine();
                if (currentTopping.equals("") || currentTopping.toLowerCase().equals("no")) {
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
