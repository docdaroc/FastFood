package BurgerChallenge;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean quit = false;
        double price = 0.0;

        System.out.print("\t\t| Welcome to Bill's Burger! |\n\t\t" +
                "----------------------------\n\t" +
                "What would your order be?\n");
        availableOptions();
        while (!quit) {
            System.out.print("\n\tEnter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("\t------------------------------------");
            while (choice < 1 || choice > 4) {
                System.out.print("\tPlease enter a proper choice [1-4]" +
                        "\n\tEnter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\t------------------------------------");
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("\tPlease choose a burger type - available choices are:" +
                            "\n\t\t- Hamburger\n\t\t- Cheese burger" +
                            "\n\t\t- Deluxe burger\n\t\t- Charm burger\n\tEnter your choice [by kind of burger]: ");

                    String type = Main.scanner.nextLine();
                    Burger burger = Burger.singleBurgerOrder(type);
                    System.out.println("\t" + burger.burgerInitialization(type) + " in the " +
                            "order...");
                    price += burger.getPrice();
                }

                case 2 -> {
                    Drink drink = new Drink();
                    drink.singleItemOrder(drink);
                    price += drink.priceCalculation(drink, drink.getSize());

                }
                case 3 -> {
                    SideItem sideItem = new SideItem();
                    sideItem.singleItemOrder(sideItem);
                    price += sideItem.priceCalculation(sideItem, sideItem.getSize());
                    //price += sideItem.getPrice();
                }
                case 4 -> {
                    System.out.print("\tChoose your menu - available options are:\n\t1) Basic menu:\n\t\t-Hamburger (no toppings)\n\t\t-small drink" +
                            "\n\t\t-small side item\n\t2) Cheeseburger menu\n\t\t-Cheeseburger (toppings included)\n\t\t-drink (size by choice)" +
                            "\n\t\t-side item (size by choice)\n\t3) Charming menu\n\t\t-Charmburger (toppings included)\n\t\t-drink (size by choice)" +
                            "\n\t\t-side item (size by choice)\n\tEnter your choice [1-3]: ");

                    int menuChoice = scanner.nextInt();
                    scanner.nextLine();
                    String size;
                    switch (menuChoice) {
                        case 1 -> {
                            System.out.println("\tBasic menu - ordered");
                            price += new Meal().getPrice();
                        }
                        case 2 -> {
                            size = sizeOfMeal();
                            System.out.println("\tCheese menu - ordered as " + size.toLowerCase());
                            price += new Meal("Cheeseburger", size).getPrice();

                        }
                        case 3 -> {
                            size = sizeOfMeal();
                            System.out.println("\tCharm menu ordered");
                            price += new Meal("Charm", size).getPrice();
                        }
                        default -> {
                            System.out.println("\tWe have only 3 menus you can order from...");
                        }

                    }

                }
                case 5 -> availableOptions();
                case 0 -> quit = true;
            }
            System.out.print("\t__________________________________\n\t" +
                    "Would you like anything else? [Y/N]-> ");

            String input = scanner.nextLine();
            System.out.println("\t__________________________________");
            if (input.toLowerCase().contains("n")) {
                System.out.println("\tYour order is " + price + "$, please!");
                quit = true;
                break;
            }
            availableOptions();
        }
    }

    public static void availableOptions() {

        System.out.print("\tAvailable options are [1-4]:\n\t\t" +
                "1) Single burger\n\t\t" +
                "2) Single drink\n\t\t" +
                "3) Single side item\n\t\t" +
                "4) Menu / Meal order containing burger, drink and side item");
    }

    private static String sizeOfMeal(){
        System.out.print("\tWhich size of the menu would you like? [small / large]\n\t" +
                "Enter your choice: ");
        String choosenSize = Main.scanner.nextLine();
        return choosenSize;
    }


}
