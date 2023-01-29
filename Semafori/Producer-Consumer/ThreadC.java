public class ThreadC extends Thread
{
    Buffer b;

    public ThreadC()
    {

    }

    public void run()
    {
        
        b.leggi();

    }
}