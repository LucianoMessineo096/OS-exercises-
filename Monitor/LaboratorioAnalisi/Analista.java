public class Analista extends Thread
{
    private int ID;
    private Laboratorio L;

    public Analista(int ID , Laboratorio L)
    {
        this.ID=ID;
        this.L=L;
    }

    public int getID()
    {
        return this.ID;
    }

    public void run()
    {
        while(true)
        {
            L.serviCliente(this);

            L.controllaSalaS(this);
        }

    }
}