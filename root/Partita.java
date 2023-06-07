package root;

import UnibsLib.InputData;
import java.util.ArrayList;
import java.util.Random;

public class Partita
{


    private int indiceFine;
    private Giocatore giocatore;
    private Mappa mappa;
    private int pos; //posizione del giocatore

    private ArrayList<Integer> posOccupate;
    private ArrayList<Integer> posVicoliCiechi = new ArrayList<>();

    public Partita(Giocatore giocatore,Mappa mappa)  {

        this.giocatore = giocatore;
        this.mappa = mappa;
        this.pos = 1;
        this.posOccupate = new ArrayList<>();
        this.indiceFine = mappa.getMappa().get(mappa.getSize()-1).getId();

    }

    public boolean iniziaPartita() {

        while(true)
        {

            scelta();
            Random random = new Random();
            int randomNumber = random.nextInt(100);

            if(pos == indiceFine) {
                InterazioneUtente.bossFinale();
                Scontro s = new Scontro(giocatore,new Boss());
                if(s.scontro())
                {
                    InterazioneUtente.bossFinaleSconfitto();
                    return true;
                }
                else {
                    InterazioneUtente.bossFinaleNonSconfitto();
                    return false;
                }


            }
            else if(randomNumber >66)
            {
                if(!interazioneGioco())
                {
                    return false;
                }

            }
            else {
                InterazioneUtente.tuttoTace();
            }

        }

    }

    private boolean interazioneGioco() {
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
        if (randomChoice.equals("vita"))
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
        //mostra stat
        InterazioneUtente.mostraStat(giocatore,pos);
        if(posLibere(pos).size()==0)
        {
            //se non ci sono vie di uscita
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

        int scelta;
        do{
            scelta= InputData.readInteger("Inserisci uno di questi numeri: ");
        }while (!posizioniLibere.contains(scelta));
        if(!posOccupate.contains(scelta))
            posOccupate.add(scelta);

        pos=scelta;


    }

    /**
     * Cerca le posizioni che nons ono ancora state toccate
     * @param pos posizione corrente del giocatote
     * @return Arraylist delle posizioni libere
     */
    public ArrayList<Integer> posLibere(int pos)
    {
        ArrayList<Integer> posizioniLibere = new ArrayList<>();

        for (int j = 0; j < mappa.getMappa().get(pos).getCollegamenti().size(); j++)
        {
            if(nonGiaPassato(mappa.getMappa().get(pos).getCollegamenti().get(j)))
            {
                posizioniLibere.add(mappa.getMappa().get(pos).getCollegamenti().get(j));
            }
        }
        return posizioniLibere;

    }


    public boolean nonGiaPassato(int pos)
    {

        return !posOccupate.contains(pos);
    }


}
