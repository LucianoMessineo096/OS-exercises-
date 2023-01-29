public class Produzione extends Thread
{
    private int ID;
    private Falegnameria falegnameria;
    private int tipoPezzo;

    public Produzione(int ID , Falegnameria falegnameria)
    {
        this.ID=ID;
        this.falegnameria=falegnameria;
        this.tipoPezzo=1+ (int)(Math.random()*3);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getTipoPezzo()
    {
        return this.tipoPezzo;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("l'unita di produzione :"+" "+this.ID+" "+"sta per produrre il pezzo");

            falegnameria.produci(this);

            
        }
    }
}