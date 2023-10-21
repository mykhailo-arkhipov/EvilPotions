public class Ingredient {
    public double price;
    public final Effect[] effects;
    public final String name;

    public Ingredient(String name, Effect[] effects, double price) {
        this.name = name;
        this.effects = effects;
        this.price = price;
    }
}
