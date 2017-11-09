package model;

public class Veiculo {

    private Integer _id;

    private String marca;
    private String modelo;
    private int hp;

    public Veiculo(String marca, String modelo, int hp){
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }

    public Veiculo(int _id, String marca, String modelo, int hp){
        this._id = _id;
        this.marca = marca;
        this.modelo = modelo;
        this.hp = hp;
    }

    public Integer getId(){
        return _id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "Veículo: "+_id+"\t"+marca+"\t"+modelo+"\t"+hp;
    }
}
