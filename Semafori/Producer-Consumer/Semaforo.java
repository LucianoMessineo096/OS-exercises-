public class Semaforo
{
    

    public Semaforo()
    {
        
    }

    synchronized public void v()
    {
        
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

        
    }
}