package BurgerChallenge;

public class Drink extends Size{


    public Drink() {
        super();
    }

    public Drink(String kind, String size) {
        super(kind, size);
    }

    @Override
    public void singleItemOrder(Object object) {
        super.singleItemOrder(object);
    }

    @Override
    public double priceCalculation(Object object, String size) {
        return super.priceCalculation(this, size);
    }
}
