import java.util.LinkedList;

public class Biglietteria
{
    private int numMAXBigliettiEvento1=50;
    private int numMAXBigliettiEvento2=50;
    private int numMAXBigliettiEvento3=50;

    public synchronized void acquista(Cliente c)
    {
        if(c.getNumEvento()==1)
        {
            System.out.println("il cliente :"+" "+c.getID()+" "+"ha acquistato i biglietti per l'evento 1");
        }
        else if(c.getNumEvento()==2)
        {
            System.out.println("il cliente :"+" "+c.getID()+" "+"ha acquistato i biglietti per l'evento 2");
        }
        else if(c.getNumEvento()==3)
        {
            System.out.println("il cliente :"+" "+c.getID()+" "+"ha acquistato i biglietti per l'evento 3");
        }
        else
        {
            //error
        }
    }

    public synchronized void vendi(Rivendita r)
    {

    }
}