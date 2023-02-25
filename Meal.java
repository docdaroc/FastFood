package BurgerChallenge;

public class Meal {
     private String type;
     private String size;
     private double price;

     public Meal() {
          this("Hamburger");
     }

     public Meal(String type) {
          Burger burger = new Burger(type);
          if (!burger.getType().equals("Hamburger")){
               Burger.singleBurgerOrder(burger.getType());
              // Burger.Toppings.withTopping(burger.getType());
          }
          System.out.print("\tPlease choose drink kind: ");
          String drinkKind = Main.scanner.nextLine();
          Drink drink = new Drink(drinkKind, "");
          System.out.print("\tPlease choose side item kind: ");
          String sideItemKind = Main.scanner.nextLine();
          SideItem sideItem = new SideItem(sideItemKind, "");
          if (type.toLowerCase().contains("ham")){
               drink.setSize("small");
               sideItem.setSize("small");
               price = 8;
          }else if (type.toLowerCase().contains("che")){

               price = 12;
          }else if (type.toLowerCase().contains("cha")){
               price = 13;
          }else {
               price = 10;
          }
     }

     public double getPrice() {
          return price;
     }

     public void setSize(String size) {
          this.size = size;
     }
}
