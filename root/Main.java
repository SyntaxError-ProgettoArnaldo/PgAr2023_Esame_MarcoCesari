package root;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import static root.InterazioneUtente.*;

public class Main
{

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException, InterruptedException {


        InterazioneUtente.inizio();
        Giocatore g = new Giocatore(chiediNome());


        Mappa mappa = new Mappa(Mappa.scegliMappa());

        Partita partita = new Partita(g,mappa);
        InterazioneUtente.inizioPartita();
        partita.iniziaPartita();



    }
}
