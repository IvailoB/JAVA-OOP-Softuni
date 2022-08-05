package Skeletons.barracksWars;

import Skeletons.barracksWars.core.CommandInterpreterImpl;
import Skeletons.barracksWars.core.Engine;
import Skeletons.barracksWars.core.factories.UnitFactoryImpl;
import Skeletons.barracksWars.data.UnitRepository;
import Skeletons.barracksWars.interfaces.Repository;
import Skeletons.barracksWars.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {

        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        final Engine engine = new Engine(commandInterpreter);

        engine.run();
    }
}