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

    public Mostro(int vita, int attacco)
    {
        this.vita = vita;
        this.attacco = attacco;
    }

    public int getVita() {
        return vita;
    }


    public int getAttacco() {
        return attacco;
    }


    public int togliVita(int q)
    {
        this.vita-=q;
        return this.vita;
    }
}
