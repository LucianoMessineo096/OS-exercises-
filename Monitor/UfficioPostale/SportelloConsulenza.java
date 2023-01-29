public class SportelloConsulenza extends Thread
{
    private int ID;
    private Ufficio ufficio;

    public SportelloConsulenza(int ID , Ufficio ufficio)
    {
        this.ID=ID;
        this.ufficio=ufficio;
    }

    public int getID()
    {
        return this.ID;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("lo sportello :"+" "+this.ID+" "+"sta per servire i clienti");

            ufficio.serviClienteC(this);
        }
        
    }


}