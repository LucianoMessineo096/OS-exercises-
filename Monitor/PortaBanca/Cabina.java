import java.util.LinkedList;

public class Cabina
{
    private int versoPorta;
    private int capienzaMax=3;
    private int verificaMetallo;
    private Cliente rimosso1 , rimosso2;
    private LinkedList<Cliente> cabina = new LinkedList<Cliente>();
    private LinkedList<Cliente> banca = new LinkedList<Cliente>();


    public synchronized void entra(Cliente cliente)
    {
        while(cabina.size()==capienzaMax)
        {
            try
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"attende che la cabina sia svuoti");

                wait();
            }catch(InterruptedException e){

                e.printStackTrace();   
            }
        }

        versoPorta = versoPorta();

        if(versoPorta==0 /*verso esterno*/)
        {
            cabina.add(cliente);
            System.out.println("il cliente :"+" "+cliente.getID()+" "+"e entrato nella cabina");
            notifyAll();

            verificaMetallo=metaldetector(cliente.getMetallo());

            if(verificaMetallo==0)
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"non porta metalli con se , puo entrare in banca");
                rimosso1 =cabina.removeFirst();
                banca.add(rimosso1);
                notifyAll();
            }
            else
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"ha del metallo con se , non puo entrare");
                cabina.removeFirst();
                notifyAll();
            }


        }
        else
        {
            /*verso interno*/ 

            try
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"attende che il verso della porta sia esterno");

                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
                
            }
            
        }

    }

    public int versoPorta()
    {
        int verso;

        return verso = (int)(Math.random()*2);
    }

    public int metaldetector(int val)
    {
        int valore;
        if(val==0)
        {
            return valore=0;
        }
        else
        {
            return valore=1;
        }
    }


    /************************************************************************************* */

    public synchronized void esci(Cliente cliente)
    {
        while(cabina.size()==capienzaMax)
        {
            try
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"attende che la cabina sia svuoti");

                wait();
            }catch(InterruptedException e){

                e.printStackTrace();   
            }
        }

        versoPorta = versoPorta();

        if(versoPorta==0 /*verso esterno*/)
        {
            

            try
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"attende che il verso della porta sia interno");

                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
                
            }


        }
        else
        {
            /*verso interno*/ 

            rimosso2=banca.removeFirst();
            cabina.add(rimosso2);
            System.out.println("il cliente :"+" "+cliente.getID()+" "+"e entrato nella cabina per uscire");
            notifyAll();

            try
            {
                Thread.sleep((int)(Math.random()*2001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            cabina.removeFirst();

            System.out.println("il cliente :"+" "+cliente.getID()+" "+"e uscito dalla cabina");
            
        }

    }
}