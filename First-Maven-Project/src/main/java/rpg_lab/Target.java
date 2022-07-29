package rpg_lab;

public interface Target {
    public abstract int getHealth();

    public abstract void takeAttack(int attackPoints);

    public abstract int giveExperience();

    public abstract boolean isDead();
}
