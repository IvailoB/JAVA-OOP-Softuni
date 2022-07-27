package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.interfaces.Executable;

public abstract class Command implements Executable {
    private final String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }

}
