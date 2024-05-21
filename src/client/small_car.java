package client;

import entities_enum.Color;

public final class  small_car extends Car{

    public small_car() {
        super();
    }

    public small_car(String plate, Color cor, Owner owner, String model) {
        super(plate, cor, owner, model);
    }








    @Override
    public String toString() {
        return "Owner: " + getOwner().getName() + " Cpf: " + getOwner().getCpf() + " Phone: " + getOwner().getPhone() + " - " +
                "Vehicle(small_car): " + getModel() + " Plate: " + getPlate() + " Color: " + getCor().toString();
    }
}
