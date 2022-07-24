package SOLID;

import SOLID.products.Product;

import java.util.List;

public class CalorieCalculator {
    private final Printer printer = new Printer();

    private static final String SUM_FORMAT = "Sum: %f";

    private static final String AVERAGE_FORMAT = "Average: %f";

    public double sum(List<Product> products) {
        final double sum = products.stream()
                .mapToDouble(Product::getAmountOfCalories)
                .sum();

        print(SUM_FORMAT, sum);

        return sum;
    }

    public double average(List<Product> products) {
        final double average = sum(products) / products.size();

        print(AVERAGE_FORMAT, average);

        return average;
    }

    public void print(String format, double amount) {
        this.printer.print(format, amount);
    }

}
