package Skeletons.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final Map<String, Method> NAME_METHOD_MAP = Arrays.stream(BlackBoxInt.class.getDeclaredMethods())
            .peek(method -> method.setAccessible(true))
            .collect(Collectors.toMap(Method::getName, method -> method));

    private static final String END_COMMAND = "END";

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {

        Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor(int.class);
        blackBoxIntConstructor.setAccessible(true);

        BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance(0);

        String input;

        while (!END_COMMAND.equals(input = SCANNER.nextLine())) {
            String[] tokens = input.split("_");

            Method method = NAME_METHOD_MAP.get(tokens[0]);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(tokens[1]));

            Field field = blackBoxInt.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
    }

}
