public class Guardia extends Thread
{
    private int ID;
    private Cortile cortile;

    public Guardia(int ID , Cortile cortile)
    {
        super("Guardia");
        this.ID=ID;
        this.cortile=cortile;
    }

    public void run()
    {
        while(true)
        {
            
            cortile.controlla(this);

            System.out.println("la guardia :"+" "+this.ID+" "+"sta per riportare i detenuti in cella");
            cortile.riportaInCella(this);
        }
        
    }

    public int getID()
    {
        return this.ID;
    }
}