package Products;

import java.math.BigDecimal;

public class Cat extends StuffedAnimal{
    private final String SOUND = "Meow, Meow, Meow!";

    public Cat(String itemName, String type, BigDecimal price) {
        super(itemName, type, price);
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
    public BigDecimal getPrice() {
        return super.getPrice();
    }
    @Override
    public String getSound() {
        return SOUND;
    }
}
