public class Buffer 
{
    private int dim=10;
    private int array[] = new int[];

    Semaforo sMutex = new Semaforo();
    //Semaforo sProducer = new Semaforo();
    //Semaforo sConsumer = new Semaforo();

    public Buffer()
    {
        
    }

    public void inserisci(int value)
    {
        try
        {
            sMutex.p();

            array[0]=value;

            System.out.println("[P] : ho inserito il valore : "+" "+array[0]);

            sMutex.v();

        }catch(InterruptedException e){

        }
    }

    public void leggi()
    {
        sMutex.p();

        System.out.println("[C] : sto leggendo dal buffer : "+" "+array[0]);

        sMutex.v();
    }
}