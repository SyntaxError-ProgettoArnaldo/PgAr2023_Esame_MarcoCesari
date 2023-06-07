package root;

import UnibsLib.InputData;

import java.util.ArrayList;


public class Game
{
    private int vite = 10;
    private static final int PUNTI_PARTITA = 200;
    private int punteggio;
    private ArrayList<Integer> idMappeCompletate;

    public Game()
    {
        this.punteggio = 0;
        this.idMappeCompletate = new ArrayList<>();
    }

    public void startGame() {

        InterazioneUtente.inizioGame();
        int continuare;
        do{
            Giocatore g = new Giocatore();
            Mappa mappa = Mappa.scegliMappa();
            Partita partita = new Partita(g,mappa);
            InterazioneUtente.inizioPartita();
            if(partita.iniziaPartita())
            {

                if(!giaCompletata(mappa.getId()))
                {
                    idMappeCompletate.add(mappa.getId());
                    System.out.println("Hai vinto");
                    addPunteggio(PUNTI_PARTITA);
                }
                else
                {
                    System.out.println("Hai vinto ma questa mappa la avevi gia completata");
                }


                InterazioneUtente.mostraPunteggio(punteggio);

            }
            else
            {
                InterazioneUtente.persoPartita();
                this.vite--;
                if(vite==0)
                {
                    InterazioneUtente.fineVite();
                    return;
                }
            }
            continuare = InputData.readInteger("Vuoi continuare? 1-si  0-ESCI");
        }while(continuare==1 );

    }

    private boolean giaCompletata(int id)
    {
        for (int i = 0; i < idMappeCompletate.size(); i++) {
            if(idMappeCompletate.get(i)==id)
                return true;
        }
        return false;
    }


    public int getPunteggio() {
        return punteggio;
    }

    public void addPunteggio(int q) {
        this.punteggio+=q;
    }
}
