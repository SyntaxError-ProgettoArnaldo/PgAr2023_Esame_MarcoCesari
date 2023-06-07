package root;

import UnibsLib.InputData;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Partita
{


    private static final int INIZIO = 0;
    private int indiceFine;
    private Giocatore giocatore;
    private Mappa mappa;

    private int pos; //posizione del giocatore

    private ArrayList<Integer> posOccupate;
    private ArrayList<Integer> posVicoliCiechi = new ArrayList<>();

    public Partita(Giocatore giocatore,Mappa mappa) throws XMLStreamException, FileNotFoundException {

        this.giocatore = giocatore;
        this.mappa = mappa;
        //qui ci sraa la inizializzazione randomica della mappa
        //QUINDI BASE OPPURE LEGGI MAPPA
        this.pos = 0;
        this.posOccupate = new ArrayList<>();
        this.indiceFine = this.mappa.getSize();

    }

    public boolean iniziaPartita() throws InterruptedException {

        while(true)
        {
            scelta();

            if(pos == indiceFine) {
                System.out.println("SEI ALLA FINE");
                break;
            }
            else
            {
                if(!interazioneGioco())
                {
                    return false;
                }

            }

        }

    return true;
    }

    private boolean interazioneGioco() throws InterruptedException {
        String[] options = {"mostro", "modificatori"};

        Random random = new Random();
        int randomIndex = random.nextInt(options.length);
        String randomChoice = options[randomIndex];


        if(randomChoice.equals("modificatori"))
        {
            InterazioneUtente.modificatori();
            modoficatore();
            if(giocatore.getVita()<0)
            {
                return false;
            }
        }
        else
        {
            InterazioneUtente.mostro();
            Scontro s = new Scontro(giocatore);
            if(!s.scontro())
            {
                System.out.println("fine partita!");
                return false;
            }


        }

        return true;
    }

    private void modoficatore()
    {
        String[] options = {"vita", "attacco"};

        Random random = new Random();
        int randomIndex = random.nextInt(options.length);
        String randomChoice = options[randomIndex];
        if (randomChoice == "vita")
        {

            int randomNumber = random.nextInt(16) - 5;
            InterazioneUtente.modificatoreVita(randomNumber);
            giocatore.modVita(randomNumber);
        }
        else
        {
            int randomNumber = random.nextInt(7) - 3;
            InterazioneUtente.modificatoreAttacco(randomNumber);
            giocatore.modAttacco(randomNumber);
        }
    }

    public void scelta()
    {

        InterazioneUtente.mostraStat(giocatore,pos);
        if(posLibere(pos).size()==0)
        {
            System.out.println("sei in un vicolo cieco!");
            posVicoliCiechi.add(pos);
            System.out.println("L unica scelta che hai è tornare indietro!");

            try {
                System.out.println("dalla pos"+pos+" torni alla -->"+posOccupate.get(posOccupate.size() - (1 + posVicoliCiechi.size())));
                pos = posOccupate.get(posOccupate.size() - (1 + posVicoliCiechi.size()));

            }
            catch (IndexOutOfBoundsException e)
            {
                pos = 0;
            }



            return;
        }

        ArrayList<Integer> posizioniLibere = posLibere(pos);

        InterazioneUtente.scelta(posizioniLibere);

        int scelta=0;
        do{
            scelta= InputData.readInteger("Inserisci uno di questi numeri: ");
        }while (!posizioniLibere.contains(scelta));
        if(!posOccupate.contains(scelta))
            posOccupate.add(scelta);

        pos=scelta;


    }

    public ArrayList<Integer> posLibere(int pos)
    {
        ArrayList<Integer> posizioniLibere = new ArrayList<>();

        for (int j = 0; j < mappa.getMappa().get(pos).getCollegamenti().size(); j++)
        {
            if(giaPassato(mappa.getMappa().get(pos).getCollegamenti().get(j)))
            {

                posizioniLibere.add(mappa.getMappa().get(pos).getCollegamenti().get(j));
            }
        }
        return posizioniLibere;

    }


    public boolean giaPassato(int pos)
    {

        return !posOccupate.contains(pos);
    }


}
