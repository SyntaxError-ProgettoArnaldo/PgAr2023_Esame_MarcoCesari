package root;

public class Scontro
{
    Giocatore g;
    Mostro m;

    public Scontro(Giocatore g)
    {
        this.g = g;
        this.m = new Mostro();
    }

    public boolean scontro() throws InterruptedException {
        InterazioneUtente.statInizioScontro(m,g);
        while(true)
        {
            System.out.println("giocatore scaglia attacco con una potenza di "+g.getAttacco()+"!");
            int vitaRimasta = m.togliVita(g.getAttacco());
            if(vitaRimasta<0)
            {
                System.out.println("Il giocatore ha vinto e il mostro è stato sconfitto");
                return true;
            }
            System.out.println("La vita del mostro diventa: "+vitaRimasta);
            System.out.println("-------------------------------------------------");
            System.out.println("Il mostro scaglia attacco con una potenza di "+m.getAttacco()+"!");
            vitaRimasta = g.togliVita(m.getAttacco());
            if(vitaRimasta<0)
            {
                System.out.println("Il mostro ha vinto e tu sei stato sconfitto");
                return false;
            }
            System.out.println("La tua vita diventa: "+vitaRimasta);
            Thread.sleep(2000);


        }
    }


}
