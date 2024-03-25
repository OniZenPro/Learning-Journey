package Products;

import java.math.BigDecimal;

public class Penguin extends StuffedAnimal{
    private final String SOUND = "Squawk, Squawk, Whee!";

    public Penguin(String name, String type, BigDecimal price) {
        super(name, type, price);
    }
    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }
    @Override
    public String getItemName() {
        return super.getItemName();
    }
    @Override
    public String getType() {
        return super.getType();
    }
    @Override
    public String getSound() {
        return SOUND;
    }
}
