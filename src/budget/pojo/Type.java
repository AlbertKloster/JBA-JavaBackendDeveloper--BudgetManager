package budget.pojo;

public class Type {
    private final String type;
    private final double price;

    public Type(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
