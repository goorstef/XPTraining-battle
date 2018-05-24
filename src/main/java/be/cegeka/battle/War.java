package be.cegeka.battle;


public class War {

    private Army attacker;

    private Army defender;


    public War(Army attacker, Army defender) {
        this.attacker = attacker;
        this.defender = defender;
        fightFrontMan();
    }


    public Army getArmy1() {
        return attacker;
    }


    public void setArmy1(Army army1) {
        this.attacker = army1;
    }


    public Army getArmy2() {
        return defender;
    }


    public void setArmy2(Army army2) {
        this.defender = army2;
    }


    private void fightFrontMan() {

        while (alsAttackerEnDefenderLijstNietLeegZijn()) {
            Soldier verlorenSoldaat = attacker.getFrontMan().Fight(defender.getFrontMan());

            if (attacker.getSoldierList().contains(verlorenSoldaat)) {
                attacker.removeFrontMan();
            } else {
                defender.removeFrontMan();
            }
        }

        if (attacker.getSoldierList().size() == 0) {
            defender.reportVictory();
        } else {
            attacker.reportVictory();
        }


    }


    private boolean alsAttackerEnDefenderLijstNietLeegZijn() {
        return !attacker.getSoldierList().isEmpty() && !defender.getSoldierList().isEmpty();
    }


}
