public class Bacchetta
{

    public int bacchettaNum;
    private boolean bacchettaLibera;

    public Bacchetta(int ID)
    {
        this.bacchettaNum=ID;
        bacchettaLibera=true;

    }

    public synchronized void prende()
    {
        while(!bacchettaLibera)
        {
            try
            {
                System.out.println(Thread.currentThread().getName()+"aspetta la bacchetta"+bacchettaNum);
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()+"prende la bacchetta"+bacchettaNum);
        bacchettaLibera=false;
    }

    public synchronized void rilascia()
    {
        System.out.println(Thread.currentThread().getName()+"rilascia la bacchetta"+bacchettaNum);
        notifyAll();
    }
}