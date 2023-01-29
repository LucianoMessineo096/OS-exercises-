import java.util.Random;

public class ThreadP extends Thread
{
    Risorsa r;

    public ThreadP(Risorsa R)
    {
        this.r=R;
    }

    public void run()
    {
        int Qp;

        Qp=(int)(Math.random()*10+1);

        System.out.println("\n[P] : il mio ID e : "+getName()+"e voglio vendere"+Qp+"quintali..\n");

        r.vendi(Qp);
    }
}