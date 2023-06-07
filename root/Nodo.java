package root;

import java.util.ArrayList;

public class Nodo
{
    private int id;
    private String tipo;
    private ArrayList<Integer> collegamenti;

    public Nodo(int id, String tipo, ArrayList<Integer> collegamenti) {
        this.id = id;
        this.tipo = tipo;
        this.collegamenti = collegamenti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Integer> getCollegamenti() {
        return collegamenti;
    }

    public void setCollegamenti(ArrayList<Integer> collegamenti) {
        this.collegamenti = collegamenti;
    }
}
