package designPattern.prototypeExercise;

public class Main {
    public static void main(String[] args) {
        EmployeeRecord pesho = new EmployeeRecord(1, "pesho", "more", 150, "Sofia");
        EmployeeRecord peshoClone = pesho;


        Prototype pesho1 = pesho.getClone();


        pesho.showRecord();
    }
}
