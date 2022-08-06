package designPattern.prototypeExercise;

class EmployeeRecord implements Prototype{
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String address;
    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "EmployeeRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Prototype getClone() {
        return new EmployeeRecord(this.id, this.name, this.designation, this.salary, address);
    }


}