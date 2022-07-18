package InterfacesAndAbstraction.multipleImplementation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class[] citizenInterfaces = Citizen.class.getInterfaces(); //3 interfaces!!!

        if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
                && Arrays.asList(citizenInterfaces).contains(Identifiable.class)) { // YES

            Method[] methods = Birthable.class.getDeclaredMethods(); //1 method
            Method[] methods1 = Identifiable.class.getDeclaredMethods();// 1 method
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String id = scanner.nextLine();
            String birthDate = scanner.nextLine();
            Identifiable identifiable = new Citizen(name,age,id,birthDate);
            Birthable birthable = new Citizen(name,age,id,birthDate);
            System.out.println(methods.length);
            System.out.println(methods[0].getReturnType().getSimpleName()); //String
            System.out.println(methods1.length);
            System.out.println(methods1[0].getReturnType().getSimpleName()); //String
        }
    }
}
