package root;

import UnibsLib.AnsiColors;
import UnibsLib.InputData;
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



    public static void mostraPunteggio(int punteggio)
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Ciao avventuriero");
        System.out.println("IL TUO PUNTEGGIO: "+punteggio);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void persoPartita()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Hai perso la battaglia guerriero!");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void inizioGame() {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("Combatti con onore");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void tuttoTace()
    {
        System.out.println("Sei fortunato, qui tutto tace, puoi continuare");
    }

    public static void bossFinale()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("SEI ALLA FINE");
        System.out.println("ORA DOVRAI SCONTRARTI CON IL BOSS FINALE");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }

    public static void bossFinaleSconfitto()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("COMPLIMENTI HAI SCONFITTO IL BOS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }
    public static void bossFinaleNonSconfitto()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("NON SEI STATO ABBASTANZA DEGNO");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }



    public static void fineVite()
    {
        System.out.println(AnsiColors.RED);
        System.out.println("------------------------------------------------------------------LA DIREZIONE----------------------------------------------------------------------");
        System.out.println("HAI FINITO LE TUE 10 VITE");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(AnsiColors.RESET);
    }
}
