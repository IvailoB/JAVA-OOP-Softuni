package Skeletons.barracksWars.interfaces;

import Polymorphism.word.Command;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

	@SuppressWarnings("unchecked")
	Executable interpretCommand(String[] data);

	Executable interpretCommand(String[] data, String commandName);


}
