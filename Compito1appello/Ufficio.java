import java.util.LinkedList;

public class Ufficio
{
    private LinkedList<Cliente>codaVeloce=new LinkedList<Cliente>();
    private LinkedList<Cliente>codaConsulenza=new LinkedList<Cliente>();
    private LinkedList<Cliente>codaUscita=new LinkedList<Cliente>();
    private int lenConsulenza=5;
    private boolean sportelloOccupato=false;
    private int  rimossoV;
    private int  rimossoC;
    private Cliente uscitoC;
    private Cliente uscitoV;

    /*****************************************************************/ 

    public synchronized void entra(Cliente cliente)
    {
        System.out.println("il cliente :"+cliente.getID()+"sta entrando in ufficio");

        if(cliente.getOperazione()==0)
        {
            System.out.println("il cliente"+cliente.getID()+"deve effettuare un operazione veloce");

            codaVeloce.add(cliente);

            notifyAll();

            try
            {
                wait();

            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("il cliente"+cliente.getID()+"deve effettuare una consulenza");

            if(codaConsulenza.size()<lenConsulenza)
            {
                System.out.println("il cliente"+cliente.getID()+"attende in coda");

                codaConsulenza.add(cliente);

                notifyAll();

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                
            }
            else
            {
                System.out.println("il cliente"+cliente.getID()+"trova la coda piena e opta per un operazione veloce");

                codaVeloce.add(cliente);
                notifyAll();

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

        }
    }


    public synchronized void esce(Cliente cliente)
    {
        if(cliente.getOperazione()==0)
        {
            System.out.println("il cliente"+cliente.getID()+"con operazione veloce esce");

            codaUscita.removeFirst();

            notifyAll();
        }
        else
        {
            System.out.println("il cliente"+cliente.getID()+"che ha effettuato la consulenza esce ");

            codaUscita.removeFirst();

            notifyAll();
        }
    }



    public synchronized void serviCliente(Sportello sportello)
    {
        
        if(sportello.getOP()==0)
        {
            
            System.out.println("lo sportello"+sportello.getID()+"sta per effettuare operazioni veloci");

            if(codaVeloce.size()==0)
            {
                System.out.println("lo sportello"+sportello.getID()+"attende che arrivi un cliente dalla coda");

                try
                {
                    wait();
                    
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }


            if(codaVeloce.getFirst().getOperazione()==0)
            {
                System.out.println("lo sportello"+sportello.getID()+"sta servendo il cliente"+codaVeloce.getFirst().getID());

                uscitoV=codaConsulenza.getFirst();
                rimossoV=codaConsulenza.getFirst().getID();

                try
                {
                    Thread.sleep((int)(Math.random()*1001));
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                codaVeloce.removeFirst();
                notifyAll();

                System.out.println(" il cliente"+rimossoV+"ha terminato l'operazione e sta per uscire");

                codaUscita.add(uscitoV);
            }        
            
            
        }
        else
        {
            System.out.println("lo sportello"+sportello.getID()+"sta per effettuare consulenze");

            if(codaConsulenza.size()==0)
            {
                System.out.println("lo sportello"+sportello.getID()+"attende che arrivi un cliente dalla coda");

                try
                {
                    wait();
                    
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }

            if(codaConsulenza.getFirst().getOperazione()==1)
            {
                System.out.println("lo sportello"+sportello.getID()+"sta servendo il cliente"+codaConsulenza.getFirst().getID());

                uscitoC=codaConsulenza.getFirst();
                rimossoC=codaConsulenza.getFirst().getID();

                try
                {
                    Thread.sleep((int)(Math.random()*1001));
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                codaConsulenza.removeFirst();
                sportelloOccupato=true;
                notifyAll();

                System.out.println(" il cliente"+rimossoC+"ha terminato l'operazione e sta per uscire");
                codaUscita.add(uscitoC);
            }        
            
        }


        
    }




}