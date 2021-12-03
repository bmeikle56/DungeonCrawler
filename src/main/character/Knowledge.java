public class Knowledge implements Tradeable {
    private String description;
    private double price;

    public Knowledge(String str) {
        description = str;
        if (description.equals("Show Final Boss")) {
            price = 500;
        } else if (description.equals("Collect Treasure")) {
            price = 250;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
