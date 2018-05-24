package be.cegeka.battle;

import org.apache.commons.lang3.StringUtils;

public class Soldier {

    private String name;

    private Weapons weapon;

    public Soldier(String name) {
        if (this.name == null && name != null && name != "" && StringUtils.isNotBlank(name)) {
            this.name = name;

            this.weapon = new BareFist();

        } else {
            throw new IllegalArgumentException("Soldier already has a name!");
        }
    }

    public Soldier(String name, Weapons weapon, boolean isHighlyTrained) {
        if (this.name == null && name != null && name != "" && StringUtils.isNotBlank(name)) {
            this.name = name;


            if (!isHighlyTrained && weapon.isHighlyTrainedWeapon()) {
                throw new IllegalArgumentException("Normal soldiers can't have highly trained weapons!");
            } else {
                this.weapon = weapon;
            }


        } else {
            throw new IllegalArgumentException("Soldier already has a name!");
        }
    }

    String getName() {
        return this.name;
    }

    Weapons getWeapon() {
        return this.weapon;
    }

    public Soldier Fight(Soldier soldier) {
        int damageAttacker = this.weapon.getDamage();
        int damageDefender = soldier.weapon.getDamage();

        if (damageAttacker >= damageDefender) {
            return soldier;
        } else {
            return this;
        }
    }
}
