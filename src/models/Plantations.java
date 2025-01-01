package models;

public abstract class Plantations {

    String name;
    int qtdToPlant;
    int sellPrice;
    int currentUnitys = 0;
    private int roundDiference;

    public Plantations(int price, String name, int qtdToPlant) {
        this.sellPrice = price;
        this.name = name;
        this.qtdToPlant = qtdToPlant;
    }

    public void toPlant(Fields field, int currentRound){
        field.ableToPlant = false;

    }



}
