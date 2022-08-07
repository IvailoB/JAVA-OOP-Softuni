package fairyShop.models;

public class InstrumentImpl  implements  Instrument{

    private int power;

    public InstrumentImpl(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void use() {

    }

    @Override
    public boolean isBroken() {
        return false;
    }
}
