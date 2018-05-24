package be.cegeka.battle;

import java.util.ArrayList;

public class Army {

    private ArrayList<Soldier> soldierList = new ArrayList<>();

    private boolean isInWar;

    private Soldier frontMan;

    private Headquarters headquarter;

    private String naam;

    public Army(Headquarters headquarter, String naam) {
        this.headquarter = headquarter;
        this.naam = naam;
        this.headquarter.ReportArmy(naam);
    }

    public void enrollSoldier(Soldier soldier) {
        this.soldierList.add(soldier);
        this.assignFrontMan();
        this.headquarter.ReportEnlistment(soldier.getName(), 0);
    }


    public ArrayList<Soldier> getSoldierList() {
        return soldierList;
    }


    public String getNaam() {
        return naam;
    }

    public void setInWar(boolean isInWar) {
        this.isInWar = isInWar;
    }

    public Soldier getFrontMan() {
        return frontMan;
    }

    public void assignFrontMan() {
        if (this.soldierList.size() != 0) {
            this.frontMan = this.soldierList.get(0);
        }
    }

    public void goToWar(Army enemy) {

        War war = new War(this, enemy);

        this.setInWar(true);
        enemy.setInWar(true);
    }

    public boolean isInWar() {
        return this.isInWar;
    }

    public void removeFrontMan() {
        this.soldierList.remove(0);
        this.headquarter.ReportCasualty(1);
    }


    public void reportVictory() {
        this.headquarter.ReportVictory(this.soldierList.size(), 1);
    }


}
