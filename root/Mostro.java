package root;

import java.util.Random;

public class Mostro
{
    private int vita = 12;
    private int attacco = 3;

    public Mostro()
    {
        Random random = new Random();
        int randomNumber = random.nextInt(11) - 5;
        this.vita+=randomNumber;
        randomNumber = random.nextInt(5) - 2;
        this.attacco+=randomNumber;
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

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }
    public int togliVita(int q)
    {
        this.vita-=q;
        return this.vita;
    }
}
