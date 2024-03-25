package Products;

import java.math.BigDecimal;

public class Pony extends StuffedAnimal{

    private final String SOUND = "Neigh, Neigh, Yay!";
    public Pony(String name, String type, BigDecimal price){
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
