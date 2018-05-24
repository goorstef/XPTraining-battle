package be.cegeka.battle;


public class BroadAxe extends Weapons {

    private Weapons axe = new Axe();

    @Override
    public int getDamage() {

        return axe.getDamage() + 2;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return true;
    }
}
