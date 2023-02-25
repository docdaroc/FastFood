package BurgerChallenge;

public abstract class Size {

    private String kind;
    private String size;
    private double price;


    public Size() {
        this.kind = "";
        this.size = "";
    }

    public Size(String kind, String size) {
        this.kind = kind;
        this.size = size;
    }

    public void singleItemOrder(Object object) {

        System.out.print("\tPlease enter " + object.getClass().getSimpleName().toLowerCase() + " kind: ");
        String kind = Main.scanner.nextLine();
        setKind(kind);
        System.out.print("\tPlease choose size [Small / Medium / Large]: ");
        String size = Main.scanner.nextLine();
        setSize(size);
    }

    public double priceCalculation(Object object, String size){
        switch (size.toLowerCase()) {
            case "small" -> {
                if (object instanceof Drink) {
                    return 1.5;
                }
                return 2.5;
            }
            case "medium" -> {
                if (object instanceof Drink) {
                    return 2;
                }else if (object instanceof SideItem) {
                    return 3.2;
                }else {

                }
            }
            case "large" -> {
                if (object instanceof Drink) {
                    return 2.5;
                } else if (object instanceof SideItem){
                    return 3.5;
                }else {
                    return 10;
                }
            }
        }
        return 0;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKind() {
        return kind;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
