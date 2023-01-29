// 1acquista da una rivendita un massimo di biglietti
//2 timbra biglietto 

/*********************************************************** */
public class Cliente
{
    private int ID;
    private Biglietteria biglietteria;
    private int numEvento;
    private int numBiglietti;

    public Cliente(int ID , Biglietteria biglietteria)
    {
        this.ID=ID;
        this.biglietteria=biglietteria;
        this.numEvento=1+(int)(Math.random()*2);
        this.numBiglietti=1+(int)(Math.random()*3);
    }

    public int getNumEvento()
    {
        return this.numEvento;
    }

    public int getID()
    {
        return this.ID;
    }

    public int getNumBiglietti()
    {
        return this.numBiglietti;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("il cliente :"+" "+this.ID+" "+"sta per acquistare :"+" "+this.numBiglietti+" "+"per l'evento :"+" "+this.numEvento);

            biglietteria.acquista(this);

            System.out.println("il cliente :"+" "+this.ID+" "+"ha acquistato i biglietti");

            
        }
        
    }
}