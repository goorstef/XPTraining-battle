package be.cegeka.battle;


public class Trident extends Weapons {

    private Weapons spear = new Spear();

    @Override
    public int getDamage() {

        return spear.getDamage() * 3;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return true;
    }
}
