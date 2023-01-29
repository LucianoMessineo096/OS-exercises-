import java.util.concurrent.*;

public class ThreadG extends Thread
{
    Risorsa r;

    public ThreadG(Risorsa R)
    {
        this.r=R;
    }

    public void run()
    {
        int Qg;

        Qg=(int)(Math.random()*10+1);

        System.out.println("\n[G] : il mio ID e : "+ getName()+"e voglio acquistare "+Qg+"quintali..\n");

        r.compra(Qg);
    }
}