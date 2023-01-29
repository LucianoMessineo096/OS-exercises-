import java.util.LinkedList;

public class Sala
{

    private LinkedList<Cliente> salaAttesa = new LinkedList<Cliente>();
    private LinkedList<Cliente> divano = new LinkedList<Cliente>();
    private int MAX1=5;
    private int MAX2=3;
    private int countSalaAttesa=0;
    private int countDivano=0;
    private Cliente salaARimosso;
    private Cliente divanoRimosso;

    public synchronized void entra(Cliente cliente)
    {
        if(divano.size()==MAX1)
        {
            if(salaAttesa.size()==MAX2)
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"se ne va ");
            }
            else
            {
                System.out.println("il cliente :"+" "+cliente.getID()+" "+"attende in sala d'attesa");

                salaAttesa.add(cliente);
                countSalaAttesa++;

                notifyAll();

                try
                {
                    wait();
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                
            }
            
        }
        else if(salaAttesa.size()>0 && divano.size()<MAX1)
        {
            
            System.out.println("il cliente :"+" "+cliente.getID()+" "+"si accomoda nel divano");

            salaARimosso=salaAttesa.removeFirst();
            countSalaAttesa--;

            divano.add(salaARimosso);
            countDivano++;
            notifyAll();

            try
            {
                 wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        
        }
        else if(salaAttesa.size()==0 && divano.size()==0)
        {
            System.out.println("il cliente :"+" "+cliente.getID()+" "+"si siede nel divano");

            divano.add(cliente);
            countDivano++;
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
            //Errore
        }
    }

    public synchronized void serviCliente(Barbiere barbiere)
    {
        if(divano.size()>0)
        {
            System.out.println("il barbiere :"+" "+barbiere.getID()+" "+"sta per servire il cliente :"+" "+divano.getFirst().getID());

            divanoRimosso = divano.removeFirst();
            countDivano--;
            notifyAll();

            try
            {
                Thread.sleep((int)(Math.random()*3001));
                
            }catch(InterruptedException e){

                e.printStackTrace();
            }


            System.out.println("il barbiere :"+" "+barbiere.getID()+" "+"ha terminato con il cliente :"+" "+divanoRimosso.getID());

            System.out.println("il cliente :"+" "+divanoRimosso.getID()+" "+"paga ed esce");

            
        }
        else
        {
            System.out.println("il barbiere :"+" "+barbiere.getID()+" "+"attende che arrivino clienti");

            try
            {
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }
        
    }
}