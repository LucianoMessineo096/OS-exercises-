import java.util.LinkedList;

public class Pizzeria
{
    private LinkedList<Cliente> codaEntrata = new LinkedList<Cliente>();
    private LinkedList<Cliente> tavolo1 = new LinkedList<Cliente>();
    private LinkedList<Cliente> tavolo2 = new LinkedList<Cliente>();
    private LinkedList<Cliente> tavolo3 = new LinkedList<Cliente>();
    private LinkedList<Cliente> tavoloComunitario = new LinkedList<Cliente>();

    private int dimT1 =2;
    private int dimT2 =4;
    private int dimT3 =6;
    private int dimTC =20;

    public synchronized void entra(Cliente c)
    {
        if(codaEntrata.size()==10 && tavolo1.size()==dimT1 && tavolo2.size()==dimT2 && tavolo3.size()==dimT3 && tavoloComunitario.size()==dimTC)
        {
            System.out.println("il cliente : "+" "+c.getID()+" "+"attende che vi sia posto");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        if(c.getNumPGruppo()==2)
        {
            for(int i=0;i<dimT1;i++)
            {
                tavolo1.add(c);
            }

            dimT1=0;

            System.out.println("il cliente : "+" "+c.getID()+" "+"si e seduto al tavolo da 2 posti con il suo gruppo");

            notifyAll();
        }
        else if(c.getNumPGruppo()==4)
        {
            for(int i=0;i<dimT2;i++)
            {
                tavolo2.add(c);
            }
            dimT2=0;

            System.out.println("il cliente : "+" "+c.getID()+" "+"si e seduto al tavolo da 4 posti con il suo gruppo");

            notifyAll();
        }
        else if(c.getNumPGruppo()==6)
        {
            for(int i=0;i<dimT3;i++)
            {
                tavolo3.add(c);
            }

            dimT3=0;

            System.out.println("il cliente : "+" "+c.getID()+" "+"si e seduto al tavolo da 6 posti con il suo gruppo");

            notifyAll();
        }
        else if(c.getNumPGruppo()==10 || c.getNumPGruppo()==8)
        {
            for(int i=0;i<dimTC;i++)
            {
                tavoloComunitario.add(c);
            }

            dimTC = dimTC - tavoloComunitario.size();

            System.out.println("il cliente : "+" "+c.getID()+" "+"si e seduto al tavolo da 20 posti con il suo gruppo");

            notifyAll();
        }
        else
        {
            System.out.println("errore");
        }
    }

    public synchronized void ordina(Cliente c)
    {
        System.out.println("il cliente :"+" "+c.getID()+" "+"sta ordinando");

        try
        {
            Thread.sleep((int)(Math.random()*2001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }
    }

    public synchronized void consuma(Cliente c)
    {
        System.out.println("il cliente :"+" "+c.getID()+" "+"sta sta consumando");

        try
        {
            Thread.sleep((int)(Math.random()*2001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }
    }

    public synchronized void esci(Cliente c)
    {
        if(c.getNumPGruppo()==2)
        {
            for(int i=0;i<dimT1;i++)
            {
                tavolo1.removeFirst();
            }

            dimT1=2;

            System.out.println("il cliente : "+" "+c.getID()+" "+"e il suo gruppo hanno liberato il tavolo da 2");

            notifyAll();
        }
        else if(c.getNumPGruppo()==4)
        {
            for(int i=0;i<dimT2;i++)
            {
                tavolo2.removeFirst();
            }

            dimT2=4;

            System.out.println("il cliente : "+" "+c.getID()+" "+"e il suo gruppo hanno liberato il tavolo da 4");

            notifyAll();
        }
        else if(c.getNumPGruppo()==6)
        {
            for(int i=0;i<dimT3;i++)
            {
                tavolo3.add(c);
            }

            dimT3=6;

            System.out.println("il cliente : "+" "+c.getID()+" "+"e il suo gruppo hanno liberato il tavolo da 6");

            notifyAll();
        }
        else if(c.getNumPGruppo()==10 || c.getNumPGruppo()==8)
        {
            
            for(int i=0;i<dimTC;i++)
            {
                tavoloComunitario.removeFirst();
            }

            dimTC = dimTC + tavoloComunitario.size();

            System.out.println("il cliente : "+" "+c.getID()+" "+"e il suo gruppo hanno liberato il tavolo da 20");

            notifyAll();
        }
        else
        {
            System.out.println("errore");
        }
    }

}