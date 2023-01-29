import java.util.LinkedList;

public class Bagno
{
    private LinkedList<Integer> bagno = new LinkedList<Integer>();
    private int capienzaMax=4;
    private int count=0;

    public synchronized void entraU(Uomo uomo)
    {
        
        if(bagno.size()<capienzaMax)
        {
            System.out.println("il cliente M:"+" "+uomo.getID()+" "+"e entrato nel bagno");
            bagno.add(uomo.getID());
            notifyAll();
            count++;
        }
        else
        {
            System.out.println("il cliente M:"+" "+uomo.getID()+" "+"trova il bagno occupato e attende");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

    }

    public synchronized void esciU(Uomo uomo)
    {
        bagno.removeFirst();
        count--;
        notifyAll();
    }

    public synchronized void entraD(Donna donna)
    {
        if(bagno.size()<capienzaMax)
        {
            System.out.println("il cliente F:"+" "+donna.getID()+" "+"e entrato nel bagno");
            bagno.add(donna.getID());
            notifyAll();
            count++;
        }
        else
        {
            System.out.println("il cliente F:"+" "+donna.getID()+" "+"trova il bagno occupato e attende");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

    }

    public synchronized void esciD(Donna donna)
    {
        bagno.removeFirst();
        count--;
        notifyAll();
    }
}