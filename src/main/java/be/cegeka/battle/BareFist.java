package be.cegeka.battle;


public class BareFist extends Weapons {

    @Override
    public int getDamage() {
        return 1;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return false;
    }
}
