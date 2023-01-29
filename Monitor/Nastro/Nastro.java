import java.util.LinkedList;

public class Nastro
{
    private int capienzaMAX=5;
    private int rimosso;
    private LinkedList<Integer> nastro = new LinkedList<Integer>();

    public synchronized void inserisciBagaglio(int IdBagaglio)
    {
        while(nastro.size()==capienzaMAX)
        {
            System.out.println("l'operatore attende che il nastro si liberi");

            try
            {
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        
        
        nastro.add(IdBagaglio);
        notifyAll();
    
    }

    public synchronized void prendi(Viaggiatore viaggiatore)
    {
        while(nastro.size()==0)
        {
            System.out.println("il viaggiatore :"+" "+viaggiatore.getID()+" "+"attende il proprio bagaglio");

            try
            {
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        if(viaggiatore.getID()==nastro.getFirst())
        {
            rimosso =nastro.removeFirst();

            notifyAll();

            System.out.println("il viaggiatore :"+" "+viaggiatore.getID()+" "+" ha preso il bagaglio :"+" "+rimosso+" "+"dal nastro");
        }
        else if(viaggiatore.getID()!=nastro.getFirst())
        {
            System.out.println("il viaggiatore :"+" "+viaggiatore.getID()+" "+"attende il proprio bagaglio");

            try
            {
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("errore");
        }
    }
}