import java.util.LinkedList;

public class Laboratorio
{
    /*************************************************************** */
    private LinkedList<Cliente> ListaP = new LinkedList<Cliente>();
    private LinkedList<Cliente> SalaS = new LinkedList<Cliente>();
    private Cliente rimossoT;
    private Cliente rimossoA;
    private Cliente rimossoS;

    /****************************************************************** */

    public synchronized void entra(Cliente c){


        ListaP.add(c);

        notifyAll();

        System.out.println("il cliente"+" "+c.getID()+" "+"e entrato in lista");
    }

    public synchronized void serviCliente(Analista a)
    {
        if(ListaP.size()==0 && SalaS.size()==0)
        {
            try
            {
                System.out.println("l'analista"+" "+a.getID()+" "+"non trova nessuno in laboratorio e attende");
                wait();
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }


        if(ListaP.getFirst().getEsame()==0)
        {
            //l'analista prende il cliente che deve fare il tampone ed esegue 

            rimossoT = ListaP.removeFirst();

            rimossoT.setServito(a.getID());

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            System.out.println("l'analista:"+" "+a.getID()+" "+"ha eseguito il tampone al cliente:"+" "+rimossoT+" "+"il quale esce");
        }
        else if(ListaP.getFirst().getEsame()!=0)
        {
            rimossoA = ListaP.removeFirst();

            rimossoA.setServito(a.getID());

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            System.out.println("l'analista:"+" "+a.getID()+" "+"ha eseguito il tampone al cliente:"+" "+rimossoA+" "+"che entra in sala S");

            SalaS.add(rimossoA);

        }
        else
        {
            //nulla
        }
    }

    public synchronized void controllaSalaS(Analista a)
    {
        if(SalaS.size()==0)
        {
            System.out.println("l'analista:"+" "+a.getID()+" "+"controlla la sala , nota che e vuota e continua con gli altri clienti");
        }
        else
        {
            if(a.getID()==SalaS.getFirst().getServito())
            {
                rimossoS = SalaS.removeFirst();

                System.out.println("il cliente"+" "+rimossoS+" "+"esce dalla sala S");
            }
            else
            {
                System.out.println("l'analista non trova il cliente servito in sala S e continua");
            }
        }
    }
}