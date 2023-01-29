public class Gruppo extends Thread
{
    private int ID;
    private Stabilimento stabilimento;
    private int abbonamento;
    private int numGruppo;

    public Gruppo(int ID , Stabilimento stabilimento)
    {
        this.ID=ID;
        this.stabilimento=stabilimento;
        this.abbonamento=(int)(Math.random()*2);
        this.numGruppo=(int)(Math.random()*4);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getAbbonamento()
    {
        return this.abbonamento;
    }

    public int getNumGruppo()
    {
        return this.numGruppo;
    }

    public void run()
    {
        

        if(this.abbonamento==1)
        {
            System.out.println("il gruppo :"+" "+this.ID+" "+"abbonato da :"+" "+this.numGruppo+" "+"persone sta per entrare");
            entraCodaAbbonati(this);
        }
        else
        {
            System.out.println("il gruppo :"+" "+this.ID+" "+"da :"+" "+this.numGruppo+" "+"persone sta per entrare");
            entraCoda(this);
        }
    }
}