public class Produzione extends Thread
{
    private int ID;
    private Magazzino magazzino;
    private int tipoPezzo;

    public Produzione(int ID,Magazzino magazzino)
    {
        this.ID=ID;
        this.magazzino=magazzino;
        this.tipoPezzo=(int)(Math.random()*2);
    }

    public void run()
    {
        while(true)
        {
            System.out.println("l'unità di produzione :"+" "+this.ID+" "+"sta per iniziare a produrre il pezzo :"+" "+this.tipoPezzo);

            magazzino.produci(this);

            System.out.println("l'unità di produzione :"+" "+this.ID+" "+"sta per stoccare il pezzo :"+" "+this.tipoPezzo+" "+"nel magazzino");

            magazzino.stocca(this);
        }
        

        
    }

    public int getID()
    {
        return this.ID;
    }

    public int getTipoPezzo()
    {
        return this.tipoPezzo;
    }
    
}