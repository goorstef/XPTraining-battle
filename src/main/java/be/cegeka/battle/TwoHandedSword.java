package be.cegeka.battle;


public class TwoHandedSword extends Weapons {

    @Override
    public int getDamage() {
        return 5;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return false;
    }
}
