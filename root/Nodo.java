package root;

import java.util.ArrayList;

public class Nodo
{
    private final int id;
    private final String tipo;
    private final ArrayList<Integer> collegamenti;

    public Nodo(int id, String tipo, ArrayList<Integer> collegamenti) {
        this.id = id;
        this.tipo = tipo;
        this.collegamenti = collegamenti;
    }

    public int getId() {
        return id;
    }





    public ArrayList<Integer> getCollegamenti() {
        return collegamenti;
    }


}
