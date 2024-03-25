package Products;

import java.math.BigDecimal;

public class Duck extends StuffedAnimal{
    private final String SOUND = "Quack, Quack, Splash!";

    public Duck(String name, String type, BigDecimal price) {
        super(name, type, price);
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
