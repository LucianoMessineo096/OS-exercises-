public class Barbiere extends Thread
{
    private int ID;
    private Sala sala;

    public Barbiere(int ID,Sala sala)
    {
        super("Barbiere");
        this.ID=ID;
        this.sala=sala;
    }

    public int getID()
    {
        return this.ID;
    }

    public void run()
    {
        System.out.println("il barbiere :"+" "+this.ID+" "+"e pronto per servire i clienti");

        sala.serviCliente(this);
    }
}