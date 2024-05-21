package client;

public class Owner {
    private String name;
    private String cpf;
    private String phone;

    public Owner(){
    }

    public Owner(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhone() {
        return phone;
    }
}
