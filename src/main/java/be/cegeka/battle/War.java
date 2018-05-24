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

        while (!attacker.getSoldierList().isEmpty() && !defender.getSoldierList().isEmpty()) {

            // voorwaarden wie wint of verliest
            defender.removeFrontMan();
        }


        if (attacker.getSoldierList().size() == 0) {
            defender.reportVictory();
        } else {
            attacker.reportVictory();
        }


    }


}
