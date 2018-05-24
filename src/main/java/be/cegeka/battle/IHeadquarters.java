package be.cegeka.battle;


public interface IHeadquarters {

    int ReportEnlistment(String soldierName, int armyIdentifier);

    int ReportArmy(String armyName);

    void ReportCasualty(int soldierId);

    void ReportVictory(int remainingNumberOfSoldiers, int armyIdentifier);

}
