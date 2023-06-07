package root;

import UnibsLib.AnsiColors;
import UnibsLib.InputData;
import UnibsLib.PrettyStrings;

import java.io.PipedOutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class InterazioneUtente
{
    public static void inizio()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Benvenuto nel magico mondo di ARNALDO-VERSE");
        System.out.println("In questa versione ci sono 3 mappe che puoi giocare, i punti relativi di ogni mappa li puoi accumulare soltanto una volta");
        System.out.println("Ti verranno assegnate 10 vite totali, usale con cautela...");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);

    }
    public static String chiediNome()
    {
        System.out.println("Come prima cosa inserisci il nome del tuo personaggio...");
        return InputData.readNonEmptyString("");
    }
    public static void mostraStat(Giocatore g,int posizione)
    {

        System.out.println(AnsiColors.BLUE);
        System.out.println("Questi sono tuoi valori");
        System.out.println("-------------------------------");
        System.out.println("VITA--> "+g.getVita());
        System.out.println("ATTACCO--> "+g.getAttacco());
        System.out.println("POSIZIONE--> "+posizione);
        System.out.println("-------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void modificatoreVita(int randomNumber)
    {
        if(randomNumber>0)
        {
            System.out.println(AnsiColors.GREEN);
            System.out.println("sei stato fortunato la tua vita sta salendo di "+Math.abs(randomNumber)+"...");
            System.out.println(AnsiColors.RESET);
        }
        if(randomNumber<0)
        {
            System.out.println(AnsiColors.RED);
            System.out.println("sei stato sfortunato la tua vita sta scendendo di "+Math.abs(randomNumber)+"...");
            System.out.println(AnsiColors.RESET);
        }
        else {
            System.out.println("Modificatore nullo");
        }
    }

    public static void modificatoreAttacco(int randomNumber)
    {
        System.out.println();
        if(randomNumber>0)
        {
            System.out.println(AnsiColors.GREEN);
            System.out.println("sei stato fortunato l attacco sale di "+Math.abs(randomNumber));
            System.out.println(AnsiColors.RESET);
        }
        else if(randomNumber<0)
        {
            System.out.println(AnsiColors.RED);
            System.out.println("sei stato sfortunato l attacco scende di "+Math.abs(randomNumber));
            System.out.println(AnsiColors.RESET);
        }
        else
        {
            System.out.println("Modificatore nullo");
        }
    }

    public static void modificatori()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Hai trovato un MODIFICATORE, questo potrebbe andare sia a tuo vantaggio che a tuo discapito");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void mostro()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Hai trovato un MOSTRO, devi affrontarlo per poter andare avanti");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void statInizioScontro(Mostro m, Giocatore g)
    {
        System.out.println("Ti sei imbattuto in un mostro della foresta");
        System.out.println("Giocatore "+g.getNome());
        System.out.println("Vita---> "+g.getVita());
        System.out.println("Attacco---> "+g.getAttacco());
        System.out.println("Mostro");
        System.out.println("Vita---> "+m.getVita());
        System.out.println("Attacco---> "+m.getAttacco());

    }

    public static void chiediMappa() {
        System.out.println();
        System.out.println("Scegli la mappa che vuoi giocare...");
        System.out.println();
    }

    public static void inizioPartita()
    {


        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Buona fortuna, che la partita abbia inizio!");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);



    }

    public static void scelta(ArrayList<Integer> posizioniLibere)
    {
        System.out.println("La scelta tocca a te condottiero, scegli con cautela");
        for (int i = 0; i < posizioniLibere.size(); i++) {
            System.out.print(posizioniLibere.get(i)+"\t");
        }
        System.out.println();

    }

    public static void finePartita()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Hai perso questa battaglia! nessun punto ti è stato asseganto, ritenta");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

}
