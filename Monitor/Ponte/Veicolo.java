public class Veicolo extends Thread
{
    private int ID;
    private Ponte ponte;
    private int versoPercorrenza;
    private int peso;
    public Veicolo(int ID,Ponte ponte)
    {
        super("Veicolo");
        this.ID=ID;
        this.ponte=ponte;
        this.versoPercorrenza=(int)(Math.random()*2);
        this.peso = 1000+(int)(Math.random()*401);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getVerso()
    {
        return this.versoPercorrenza;
    }

    public int getPeso()
    {
        return this.peso;
    }

    public void run()
    {
        
            
        ponte.percorri(this);

        
        
    }
}