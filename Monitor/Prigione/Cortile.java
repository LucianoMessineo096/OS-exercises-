import java.util.LinkedList;

public class Cortile
{
    private LinkedList<Detenuto> cortile = new LinkedList<Detenuto>();
    private LinkedList<Detenuto> codaUscita=new LinkedList<Detenuto>();
    private int capienzaMax=5;
    private Detenuto uscito;
    private int countFazione1=0;
    private int countFazione2=0;



    /*********************************************************************************/


    public synchronized void entra(Detenuto detenuto)
    {
        while(cortile.size()==capienzaMax)
        {
            System.out.println("il detenuto : "+" "+detenuto.getID()+" "+"trova il cortile pieno e eattende il turno successivo");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        try
        {
            Thread.sleep((int)(Math.random()*3001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }
        
        if(detenuto.getTipo()==0)
        {
            cortile.add(detenuto);
            System.out.println("il detenuto :"+" "+detenuto.getID()+" "+"e entrato nel cortile");
        }
        else if(detenuto.getTipo()==1 && detenuto.getFazione()==0)
        {
            cortile.add(detenuto);
            countFazione1++;
            System.out.println("il detenuto :"+" "+detenuto.getID()+" "+"e entrato nel cortile");
        }
        else if(detenuto.getTipo()==1 && detenuto.getFazione()==1)
        {
            cortile.add(detenuto);
            countFazione2++;
            System.out.println("il detenuto :"+" "+detenuto.getID()+" "+"e entrato nel cortile");
        }
        else
        {
            System.out.println("ERROR ");
        }
        
        notifyAll();
        
        
    }

    public synchronized void esci(Detenuto detenuto)
    {
        while(cortile.size()>0)
        {
            uscito=cortile.removeFirst();

            codaUscita.add(uscito);

            System.out.println("il detenuto :"+" "+codaUscita.element().getID()+" "+"si trova nella coda di uscita");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        

    }

    
    public synchronized void controlla(Guardia guardia)
    {
        if(countFazione1>countFazione2 && countFazione2!=0)
        {
            System.out.println("la guardia :"+" "+guardia.getID()+" "+"nota che sta per scoppiare una rissa , essa libera il cortile");
            cortile.clear();
            countFazione1=0;
            countFazione2=0;

            notifyAll();

        }
        else if(countFazione2>countFazione1 && countFazione1!=0)
        {
            System.out.println("la guardia :"+" "+guardia.getID()+" "+"nota che sta per scoppiare una rissa , essa libera il cortile");
            cortile.clear();
            countFazione1=0;
            countFazione2=0;

            notifyAll();
        }
        else
        {
            System.out.println("la guardia :"+" "+guardia.getID()+" "+"non ha sedato nessuna rissa in questo turno");
        }
    }

    public synchronized void riportaInCella(Guardia guardia)
    {
        codaUscita.clear();
        notifyAll();
        System.out.println("la guardia :"+" "+guardia.getID()+" "+"ha riportato i detenuti in cella");
    }
    
}