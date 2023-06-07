package root;

public class Main
{
    public static void main(String[] args) {
        InterazioneUtente.inizio();  //crea giocatore
        Game game = new Game();  //inizia il gioco
        game.startGame();
    }
}
