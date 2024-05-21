package client;

import entities_enum.Color;

public class Car {
    private String plate;
    private Color cor;
    private Owner owner;
    private String model;

    public Car(){
    }

    public Car(String plate, Color cor, Owner owner, String model) {
        this.plate = plate;
        this.cor = cor;
        this.owner = owner;
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }


    public Color getCor() {
        return cor;
    }


    public Owner getOwner() {
        return owner;
    }

    public String getModel(){
        return model;
    }


}
