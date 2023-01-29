public class ThreadP extends Thread
{
    Buffer b;
    
    public ThreadP()
    {

    }

    public void run()
    {
        int value = (int)(Math.random()*1000);

        b.inserisci(value);
    }
}