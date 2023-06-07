package root;

public class Scontro
{
    Giocatore g;  //giocatore
    Mostro m;     //mostro

    public Scontro(Giocatore g)
    {
        this.g = g;
        this.m = new Mostro();
    }
    public Scontro(Giocatore g,Boss boss)
    {
        this.g = g;
        this.m = new Mostro(boss.getVita(),boss.getAttacco());
    }

    public boolean scontro()   {
        InterazioneUtente.statInizioScontro(m,g);
        while(true)
        {
            //attacco giocatore
            System.out.println("giocatore scaglia attacco con una potenza di "+g.getAttacco()+"!");
            int vitaRimasta = m.togliVita(g.getAttacco());
            if(vitaRimasta<0)
            {
                //se muore
                System.out.println("Il giocatore ha vinto e il mostro è stato sconfitto");
                return true;
            }
            System.out.println("La vita del mostro diventa: "+vitaRimasta);
            System.out.println("-------------------------------------------------");
            //attacco mostro
            System.out.println("Il mostro scaglia attacco con una potenza di "+m.getAttacco()+"!");
            vitaRimasta = g.togliVita(m.getAttacco());
            if(vitaRimasta<0)
            {
                System.out.println("Il mostro ha vinto e tu sei stato sconfitto");
                return false;
            }
            System.out.println("La tua vita diventa: "+vitaRimasta);
            try {
                Thread.sleep(2000); //delay
            }
            catch (InterruptedException e)
            {
                //errore .sleep
                System.out.println("Errore nella attesa");
            }



        }
    }


}
