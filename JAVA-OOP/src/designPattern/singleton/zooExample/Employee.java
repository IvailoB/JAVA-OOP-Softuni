package designPattern.singleton.zooExample;

public class Employee {
    public void feedAnimals() {
        Zoo.getInstance().getAnimals().keySet().forEach(k -> System.out.println("Feeding animal " + k));
        // iterate over all animals and feed them
    }
}
