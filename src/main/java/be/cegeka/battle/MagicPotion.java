package be.cegeka.battle;


public class MagicPotion extends Weapons {

    private int damage = 10;

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public boolean isHighlyTrainedWeapon() {

        return true;
    }

    public void setDamage(int opponentDamage) {
        if (opponentDamage % 2 == 0) {
            damage = 10;
        } else {
            damage = 0;
        }
    }

}
