public class Sportello extends Thread
{
    private int ID;
    private Ufficio ufficio;
    private int operazione;

    public Sportello(int ID,Ufficio ufficio)
    {
        this.ID=ID;
        this.ufficio=ufficio;
        this.operazione=(int)(Math.random()*2);
    }

    public void run()
    {
        ufficio.serviCliente(this);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getOP()
    {
        return this.operazione;
    }
}