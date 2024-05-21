package client;

import entities_enum.Color;

public final class average_car extends Car {

    public average_car() {
        super();
    }

    public average_car(String plate, Color cor, Owner owner, String model) {
        super(plate, cor, owner, model);
    }


    @Override
    public String toString() {
        return "Owner: " + getOwner().getName() + " Cpf: " + getOwner().getCpf() + " Phone: " + getOwner().getPhone() + " - " +
                "Vehicle(average_car): " + getModel() + " Plate: " + getPlate() + " Color: " + getCor().toString();
    }
}

