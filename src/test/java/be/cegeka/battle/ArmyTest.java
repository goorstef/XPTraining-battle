package be.cegeka.battle;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArmyTest {

    Soldier soldier1;

    Soldier soldier2;

    Soldier soldier3;

    Soldier soldier4;

    Army army;

    Army enemy;

    @Mock
    private Headquarters headquarterMock;

    @Before
    public void setUp() {
        this.soldier1 = new Soldier("Soldaat");
        this.soldier2 = new Soldier("Soldaat");
        this.soldier3 = new Soldier("Soldaat");
        this.soldier4 = new Soldier("Soldaat");
        this.army = new Army(headquarterMock, "army");
        this.enemy = new Army(headquarterMock, "enemy");
        army.enrollSoldier(soldier1);
        army.enrollSoldier(soldier2);
        enemy.enrollSoldier(soldier3);
        enemy.enrollSoldier(soldier4);
    }

    @Test
    public void enrollInArmyTest() {
        Assertions.assertThat(army.getSoldierList()).contains(soldier1);
    }

    @Test
    public void checkFirstEnlistedSoldier() {
        Assertions.assertThat(army.getFrontMan()).isEqualTo(soldier1);
    }


    @Test
    public void goToWar() {

        army.goToWar(enemy);


        Assertions.assertThat(army.isInWar()).isEqualTo(true);
    }


    @Test
    public void frontManVsFrontManAtLeastOneDies() {
        Soldier frontmanAttacker = army.getFrontMan();
        Soldier frontmanDefender = enemy.getFrontMan();
        War war = new War(army, enemy);

        Assertions.assertThat(frontmanAttacker).isEqualTo(army.getFrontMan());
        Assertions.assertThat(enemy.getSoldierList()).doesNotContain(enemy.getFrontMan());


    }

    @Test
    public void lastManStandingWins() {

        War war = new War(army, enemy);

        Assertions.assertThat(enemy.getSoldierList()).isEmpty();

    }


    @Test
    public void enlistedSoldierGetsIdTest() {
        Army armyTest = new Army(headquarterMock, "armyTest");
        Soldier soldaat = new Soldier("Dummy");
        Mockito.when(headquarterMock.ReportEnlistment(soldaat.getName(), 1)).thenReturn(1);
        armyTest.enrollSoldier(soldaat);

    }

    @Test
    public void soldierDiesReport() {
        Army testEnemy = new Army(headquarterMock, "testEnemy");
        testEnemy.enrollSoldier(new Soldier("Testje"));
        War war = new War(army, testEnemy);

        verify(headquarterMock).ReportCasualty(1);
    }

    @Test
    public void checkRemainingSoldiersInArmy() {
        enemy.removeFrontMan();
        War war = new War(army, enemy);

        verify(headquarterMock).ReportVictory(2, 1);

    }

    @Test
    public void createdArmyGetsIdTest() {
        Army armyTest = new Army(headquarterMock, "armyTest");

        Mockito.when(headquarterMock.ReportArmy(armyTest.getNaam())).thenReturn(1);

    }

    @Test
    public void reportArmyIsInList() {
        Headquarters hq = new Headquarters();
        Army reportedArmy = new Army(hq, "reportedArmy");


        Assertions.assertThat(hq.getArmies()).contains("reportedArmy");
    }

    @Test
    public void reportedEnlistmentInList() {
        Headquarters hq = new Headquarters();
        Army reportedArmy = new Army(hq, "reportedArmy");
        reportedArmy.enrollSoldier(soldier1);

        Map<String, ArrayList<String>> soldatenPerArmies = hq.getSoldiers();
        ArrayList<String> soldaatjes = soldatenPerArmies.get("" + hq.getArmies().indexOf("reportedArmy"));

        Assertions.assertThat(soldaatjes).contains(soldier1.getName());

    }
}
