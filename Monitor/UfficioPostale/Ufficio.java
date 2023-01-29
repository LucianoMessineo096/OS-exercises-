import java.util.LinkedList;

public class Ufficio
{
    private LinkedList<Cliente> codaA = new LinkedList<Cliente>();
    private LinkedList<Cliente> codaB = new LinkedList<Cliente>();
    private LinkedList<Cliente> codaUscitaA = new LinkedList<Cliente>();
    private LinkedList<Cliente> codaUscitaB = new LinkedList<Cliente>();
    private Cliente rimossoV;
    private Cliente rimossoC;
    private Cliente entratoA;
    private Cliente entratoB;


    private int BMax=9;



    public synchronized void entra(Cliente c)
    {
        
        if(c.getTipoOp()==1)
        {
            codaA.add(c);

            System.out.println("il cliente :"+" "+c.getID()+" "+"e entrato nella coda A");

            notifyAll();
        }
        else
        {

            if(codaB.size()==BMax) 
            {
                System.out.println("la coda B e piena , il cliente :"+" "+c.getID()+" "+"si sposta nella coda A");

                codaA.add(c);

                notifyAll();
            }

            codaB.add(c);

            System.out.println("il cliente :"+" "+c.getID()+" "+"e entrato nella coda B");

            notifyAll();
        }
    }


    public synchronized void esciA(Cliente c)
    {
        codaUscitaA.add(c);

        System.out.println("il cliente :"+" "+c.getID()+" "+"e entrato nella coda di uscita Veloce");

        try
        {
            Thread.sleep((int)(Math.random()*1001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }


        System.out.println("il cliente :"+" "+codaUscitaA.removeFirst().getID()+" "+"e uscito");

        notifyAll();
    }

    public synchronized void esciB(Cliente c)
    {
        codaUscitaB.add(c);

        System.out.println("il cliente :"+" "+c.getID()+" "+"e entrato nella coda di uscita Consulenze");

        try
        {
            Thread.sleep((int)(Math.random()*1001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }


        System.out.println("il cliente :"+" "+codaUscitaB.removeFirst().getID()+" "+"e uscito");

        notifyAll();
    }

    public synchronized void serviClienteV(SportelloVeloce sv)
    {

        while(codaA.size()==0)
        {
            System.out.println("lo sportello veloce attende che vi siano clienti in coda");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }


        System.out.println("lo sportello veloce serve il cliente : "+" "+codaA.getFirst());

        rimossoV = codaA.removeFirst();

        try
        {
            Thread.sleep((int)(Math.random()*2001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        System.out.println("il cliente"+" "+rimossoV.getID()+" "+"e stato servito");
    }

    public synchronized void serviClienteC(SportelloConsulenza sc)
    {

        while(codaB.size()==0)
        {
            System.out.println("lo sportello:"+" "+sc.getID()+" "+"attende che vi siano clienti in coda");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }


        System.out.println("lo sportello:"+" "+sc.getID()+ " serve il cliente : "+" "+codaB.getFirst().getID());

        rimossoC = codaB.removeFirst();

        try
        {
            Thread.sleep((int)(Math.random()*2001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        System.out.println("il cliente"+" "+rimossoC.getID()+" "+"e stato servito");
    }




}