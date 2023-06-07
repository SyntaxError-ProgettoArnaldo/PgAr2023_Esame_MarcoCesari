package root;

import UnibsLib.Menu;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mappa
{
    private ArrayList<Nodo> mappa;
    private int id;





    public Mappa(){
        this.mappa =new ArrayList<>();

    }

    public static Mappa scegliMappa()  {
        Mappa m = new Mappa();
        InterazioneUtente.chiediMappa();
        String[] options = {"BASE","XML-1","XML-2"};  //opzioni delle mappe

        Menu m1 = new Menu("Scegli la mappa",options);
        int scelta = m1.choose();

        m.setId(scelta);
        try{
            if(scelta==1)
            {
                //mappa base
                m.setMappa(creaMappaBase());
            }
            else if(scelta==2)
            {
                //XML-1
                m.setMappa(Xml.leggiMappe().get(0));
            }
            else
            {
                //XML-2
                m.setMappa(Xml.leggiMappe().get(1));
            }
        }
        catch (FileNotFoundException | XMLStreamException e)
        {
            //ERROR
            System.out.println("Errore nella lettua del file");
        }

        return m;
    }

    private void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public ArrayList<Nodo> getMappa (){
        return this.mappa;
    }
    public int getSize()
    {
        return this.mappa.size();
    }

    public void setMappa(ArrayList<Nodo> mappa) {
        this.mappa = mappa;
    }

    public static ArrayList<Nodo> creaMappaBase()
    {
        //CREZIONE MANUALE MASSA DI BASE(allenamento)
        ArrayList<Nodo> map = new ArrayList<>();
        ArrayList<Integer> link = new ArrayList<>();
        link.add(1);
        map.add(new Nodo(0,"INIZIO",link));
        link = new ArrayList<>();
        link.add(2);
        link.add(3);
        map.add(new Nodo(1,"INTERMEDIO",link));
        link = new ArrayList<>();
        link.add(4);
        map.add(new Nodo(2,"INTERMEDIO",link));
        map.add(new Nodo(3,"INTERMEDIO",link));
        link = new ArrayList<>();
        link.add(5);
        map.add(new Nodo(4,"INTERMEDIO",link));
        link = new ArrayList<>();
        link.add(6);
        map.add(new Nodo(5,"INTERMEDIO",link));
        link = new ArrayList<>();
        map.add(new Nodo(6,"FINE",link));
        return map;
    }







}
