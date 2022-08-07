package fairyShop.models;

public class PresentImpl implements Present {

    private String name;
    private int energyRequired;

    public PresentImpl(String name, int energyRequired) {
        this.name = name;
        this.energyRequired = energyRequired;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergyRequired() {
        return energyRequired;
    }

    @Override
    public boolean isDone() {
        if (energyRequired == 0) {
            return true;
        }
        return false;
    }

    public void setEnergyRequired(int energyRequired) {
        this.energyRequired = energyRequired;
    }

    @Override
    public void getCrafted() {
        energyRequired -= 10;
        if (energyRequired < 0) {
            setEnergyRequired(0);
        }
    }
}
