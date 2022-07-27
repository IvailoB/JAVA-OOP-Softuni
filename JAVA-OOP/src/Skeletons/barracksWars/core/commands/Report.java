package Skeletons.barracksWars.core.commands;

import Skeletons.barracksWars.annotation.Inject;
import Skeletons.barracksWars.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }

}
