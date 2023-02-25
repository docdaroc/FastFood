package BurgerChallenge;

public class SideItem extends Size{

    public SideItem() {
        super();
    }

    public SideItem(String kind, String size) {
        super(kind, size);
    }

    @Override
    public void singleItemOrder(Object object) {
        super.singleItemOrder(object);
    }

    @Override
    public double priceCalculation(Object object, String size) {
        return super.priceCalculation(object, size);
    }
}
