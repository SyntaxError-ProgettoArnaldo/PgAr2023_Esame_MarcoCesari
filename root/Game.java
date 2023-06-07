package root;

import UnibsLib.InputData;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game
{
    private int vite = 10;
    private static final int PUNTI_PARTITA = 200;
    private int punteggio;
    private ArrayList<Mappa> mappeCompletate;

    public Game()
    {
        this.punteggio = 0;
        this.mappeCompletate = new ArrayList<>();
    }

    public void startGame() throws XMLStreamException, FileNotFoundException, InterruptedException {

        InterazioneUtente.inizioGame();
        int continuare;
        do{
            Giocatore g = new Giocatore();
            Mappa mappa = new Mappa(Mappa.scegliMappa());
            Partita partita = new Partita(g,mappa);
            InterazioneUtente.inizioPartita();
            if(partita.iniziaPartita())
            {
                System.out.println("Hai vinto");
                addPunteggio(PUNTI_PARTITA);
                if(!mappeCompletate.contains(mappa))
                    mappeCompletate.add(mappa);
                InterazioneUtente.mostraPunteggio(punteggio);

            }
            else
            {
                InterazioneUtente.persoPartita();
                this.vite--;
            }
            continuare = InputData.readInteger("Vuoi continuare? 1-si  0-ESCI");
        }while(continuare==1);

    }

    public int getPunteggio() {
        return punteggio;
    }

    public void addPunteggio(int q) {
        this.punteggio+=q;
    }
}
