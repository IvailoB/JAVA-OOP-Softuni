package fairyShop.repositories;

import fairyShop.models.BaseHelper;
import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;

public class HelperRepository implements Repository<Helper>{

    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    @Override
    public Collection<Helper> getModels() {
        return helpers;
    }

    @Override
    public void add(Helper helper) {

    }

    @Override
    public boolean remove(Helper helper) {
        return false;
    }

    @Override
    public Helper findByName(String name) {
        return null;
    }
}
