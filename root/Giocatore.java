package root;


public class Giocatore
{

    public final int VITA = 20;
    public final int ATTACCO = 5;

    private int vita;
    private int attacco;

    public Giocatore()
    {
        this.vita = VITA;
        this.attacco = ATTACCO;
    }




    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getAttacco() {
        return attacco;
    }
    public int togliVita(int q)
    {
        this.vita-=q;
        return this.vita;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public boolean modVita(int randomNumber)
    {
        this.vita = this.vita+randomNumber;
        if(this.vita<=0)
            return false;
        return true;
    }

    public void modAttacco(int randomNumber)
    {
        if(this.attacco+randomNumber<=0) {
            this.attacco = 0;
            return;
        }
        this.attacco = this.attacco+randomNumber;
    }
}
