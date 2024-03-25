package Products;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class StuffedAnimal implements Audible{
    private String itemName, type;
    private BigDecimal price;

    private final String SOUND = "";

    public StuffedAnimal(String itemName, String type, BigDecimal price){
        this.itemName = itemName;
        this.type = type;
        this.price = price.setScale(2, RoundingMode.CEILING);
    }

    public String getItemName() {
        return itemName;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public abstract String getSound();
}
