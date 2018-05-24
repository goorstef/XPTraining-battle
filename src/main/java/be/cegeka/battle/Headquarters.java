package be.cegeka.battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Headquarters implements IHeadquarters {

    ArrayList<String> armies = new ArrayList<>();

    Map<String, ArrayList<String>> soldiers = new HashMap<String, ArrayList<String>>();


    public Map<String, ArrayList<String>> getSoldiers() {
        return soldiers;
    }

    public ArrayList<String> getArmies() {
        return armies;
    }

    @Override
    public int ReportEnlistment(String soldierName, int armyIdentifier) {
        if (soldiers.get("" + armyIdentifier) == null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(soldierName);
            soldiers.put("" + armyIdentifier, temp);
        } else {
            soldiers.get("" + armyIdentifier).add(soldierName);
        }


        return this.soldiers.get("" + armyIdentifier).lastIndexOf(soldierName);
    }

    @Override
    public void ReportCasualty(int soldierId) {
        throw new UnsupportedOperationException("implement me (after test)");
    }

    @Override
    public void ReportVictory(int remainingNumberOfSoldiers, int armyIdentifier) {
        throw new UnsupportedOperationException("implement me (after test)");
    }

    @Override
    public int ReportArmy(String armyName) {
        this.armies.add(armyName);

        return this.armies.size() - 1;
    }

}
