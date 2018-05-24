package be.cegeka.battle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Soldier soldier = new Soldier("a-z");

        assertThat(soldier.getName()).isEqualTo("a-z");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        new Soldier("   ");
    }

    @Test
    public void construction_SoldierWithAxe() {
        Weapons weapon = new Axe();
        Soldier soldier = new Soldier("Henk", weapon);
        assertThat(soldier.getWeapon()).isEqualTo(weapon);
    }

    @Test
    public void construction_SoldierWithNoWeapon_DefaultBareFist() {
        Soldier soldier = new Soldier("Henk");
        assertThat(soldier.getWeapon().getDamage()).isEqualTo(1);
    }

    @Test
    public void construction_SoldierWithSpear() {
        Weapons weapon = new Spear();
        Soldier soldier = new Soldier("Henk", weapon);
        assertThat(soldier.getWeapon()).isEqualTo(weapon);
    }

    @Test
    public void construction_SoldierWithSword() {
        Weapons weapon = new Sword();
        Soldier soldier = new Soldier("Henk", weapon);
        assertThat(soldier.getWeapon()).isEqualTo(weapon);
    }

    @Test
    public void construction_2DifferentSoldiers_DefenderWins() {
        Weapons weaponAttacker = new Sword();
        Soldier attacker = new Soldier("Henk", weaponAttacker);

        Weapons weaponDefender = new Axe();
        Soldier defender = new Soldier("Jef", weaponDefender);

        Soldier loser = attacker.Fight(defender);
        assertThat(loser).isEqualTo(attacker);
    }

    @Test
    public void construction_2EqualSoldiers() {
        Weapons weaponAttacker = new Sword();
        Soldier attacker = new Soldier("Henk", weaponAttacker);

        Weapons weaponDefender = new Sword();
        Soldier defender = new Soldier("Jef", weaponDefender);

        Soldier loser = attacker.Fight(defender);
        assertThat(loser).isEqualTo(defender);
    }

    @Test
    public void construction_2EqualSoldiers_AttackerWins() {
        Weapons weaponAttacker = new Sword();
        Soldier attacker = new Soldier("Henk", weaponAttacker);

        Soldier defender = new Soldier("Jef");

        Soldier loser = attacker.Fight(defender);
        assertThat(loser).isEqualTo(defender);
    }
}