package root;

import java.util.Random;

public class Boss
{
    private int vita = 18;
    private int attacco = 4;

    public Boss()
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



    public int getAttacco() {
        return attacco;
    }


}
