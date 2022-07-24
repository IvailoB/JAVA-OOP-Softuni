package SOLID.products;

public abstract class Drink {
    private final double density;
    private final double milliliters;

    protected Drink(double density, double milliliters) {
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return this.milliliters;
    }

    public double getDensity() {
        return this.density;
    }

    double getDrinkAmountInLiters() {
        return (1000 / this.getMilliliters()) * this.getDensity();
    }

}
