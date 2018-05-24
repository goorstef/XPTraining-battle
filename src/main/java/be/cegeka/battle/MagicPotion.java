package be.cegeka.battle;


public class MagicPotion extends Weapons {

    @Override
    public int getDamage() {
        return 10;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return true;
    }
}
