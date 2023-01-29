import java.util.LinkedList;

public class Ponte
{
    private LinkedList<Veicolo>ponte=new LinkedList<Veicolo>();
    private int caricoMax=3000;
    private int countPeso=0;
    

    public synchronized void percorri(Veicolo veicolo)
    {
        if(countPeso>caricoMax)
        {
            System.out.println("l'auto :"+" "+veicolo.getID()+" "+"non puo percorrere il ponte , e deve attendere che si liberi");

            try
            {

                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        else
        {
            if(veicolo.getVerso()==0)
            {
                if(ponte.size()>0 && ponte.getFirst().getVerso()==1)
                {
                    System.out.println("l'auto :"+" "+veicolo.getID()+" "+"attende che il ponte si liberi dalle auto che viaggiano nel senso opposto");

                    try
                    {
                        wait();
                    }catch(InterruptedException e){

                        e.printStackTrace();
                    }
                }


                System.out.println("l'auto :"+" "+veicolo.getID()+" "+"sta per percorrere il ponte da A a B");

                ponte.add(veicolo);
                countPeso+=veicolo.getPeso();
                notifyAll();  

                try
                {
                    Thread.sleep((int)(Math.random()*3001));

                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                ponte.removeFirst();
                countPeso-=veicolo.getPeso();

                System.out.println("l'auto :"+" "+veicolo.getID()+" "+"ha attraversato il ponte");
                
            }
            else
            {

                if(ponte.size()>0 && ponte.getFirst().getVerso()==0)
                {
                    System.out.println("l'auto :"+" "+veicolo.getID()+" "+"attende che il ponte si liberi dalle auto che viaggiano nel senso opposto");

                    try
                    {
                        wait();
                    }catch(InterruptedException e){

                        e.printStackTrace();
                    }
                }


                System.out.println("l'auto :"+" "+veicolo.getID()+" "+"sta per percorrere il ponte da B a A");

                ponte.add(veicolo);
                countPeso+=veicolo.getPeso();
                notifyAll();  

                try
                {
                    Thread.sleep((int)(Math.random()*3001));

                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                ponte.removeFirst();
                countPeso-=veicolo.getPeso();

                System.out.println("l'auto :"+" "+veicolo.getID()+" "+"ha attraversato il ponte");
            }
        }

        
    }
}