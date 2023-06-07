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

        Game game = new Game();
        game.startGame();





    }
}
