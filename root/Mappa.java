package root;

import UnibsLib.Menu;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Mappa
{
    private ArrayList<Nodo> mappa;

    public Mappa(ArrayList<Nodo> mappa) throws XMLStreamException, FileNotFoundException {
        this.mappa = mappa;

    }

    public Mappa() throws XMLStreamException, FileNotFoundException {
        this.mappa =new ArrayList<>();

    }
    private ArrayList<Nodo> creaMappaCasuale() throws XMLStreamException, FileNotFoundException {
        String[] options = {"BASE","XML"};
        Random random = new Random();
        int randomIndex = random.nextInt(options.length);
        String randomChoice = options[randomIndex];
        System.out.println(randomChoice);
        if(randomChoice.equals("BASE"))
        {
            return creaMappaBase();
        }
        else if(randomChoice.equals("XML"))
        {
            int randomNumber = random.nextInt(2);
            return Xml.leggiMappe().get(randomNumber);
        }
        return null;
    }

    public static ArrayList<Nodo> scegliMappa() throws XMLStreamException, FileNotFoundException {
        InterazioneUtente.chiediMappa();
        String[] options = {"BASE","XML-1","XML-2"};

        Menu m1 = new Menu("Scegli la mappa",options);
        int scelta = m1.choose();

        if(scelta==1)
        {
            return creaMappaBase();
        }
        else if(scelta==2)
        {
            return Xml.leggiMappe().get(0);
        }
        else
        {
            return Xml.leggiMappe().get(1);
        }
    }

    public ArrayList<Nodo> getMappa (){
        return this.mappa;
    }
    public int getSize()
    {
        return this.mappa.size();
    }


    public static ArrayList<Nodo> creaMappaBase()
    {
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

    public ArrayList<Nodo> creaMappaXML()
    {
        return null;
    }

    public Nodo getNodo(int id)
    {
        for (int i = 0; i < mappa.size(); i++) {
            if(mappa.get(i).getId()==id)
                return mappa.get(i);
        }
        return null;
    }


    public void stampaMappa()
    {
        for (int i = 0; i < mappa.size(); i++) {
            System.out.println("Sei in posizione "+mappa.get(i).getId()+" ("+mappa.get(i).getTipo()+") ");
            if(mappa.get(i).getCollegamenti().size()==0)
            {
                continue;
            }
            System.out.print("Puoi andare nelle posizioni: ");

            for (int j = 0; j < mappa.get(i).getCollegamenti().size(); j++) {
                System.out.print(mappa.get(i).getCollegamenti().get(j));
            }
            System.out.println();
        }
    }
}
