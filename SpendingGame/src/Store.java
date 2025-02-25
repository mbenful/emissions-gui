import java.util.ArrayList;

public class Store {
    ArrayList<Item> items;

    public Store() {
        items = new ArrayList<>();
    }

    public void initializeItems() {
        items.add(new Tech("Bugatti", 11000000));
        items.add(new Tech("Startup Series A Funding", 4950000));
        items.add(new Tech("Twitter", 44000000000L));

        items.add(new RealEstate("Central American Island", 4950000));
        items.add(new RealEstate("Hollywood Mansion", 52000000));

        items.add(new Misc("Mona Lisa", 869000000));
        items.add(new Misc("NBA Team", 2400000000L));
        items.add(new Misc("NFL Team", 3000000000L));
    }
}
