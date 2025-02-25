import java.util.Random;

public class RealEstate extends Item {
    public RealEstate(String name, long price) {
        super(name, applyDiscount(price));
    }

    private static long applyDiscount(long price) {
        Random random = new Random();
        double discount = 1 - (random.nextInt(14) + 4) / 100.0;
        return (long) (price * discount);
    }
}
