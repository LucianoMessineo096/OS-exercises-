public class Semaforo
{
    private int value;

    public Semaforo(int initial)
    {
        this.value=initial;
    }

    synchronized public void v()
    {
        ++value;
        notify();
    }

    synchronized public void p() throws InterruptedException
    {
        while(value==0)
        {
            try
            {
                wait();
            }catch(InterruptedException e){

            }
        }

        value--;
    }
}