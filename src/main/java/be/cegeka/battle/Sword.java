package be.cegeka.battle;


public class Sword extends Weapons {

    @Override
    public int getDamage() {
        return 2;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return false;
    }
}
