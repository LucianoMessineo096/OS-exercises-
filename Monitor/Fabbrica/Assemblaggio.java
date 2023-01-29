public class Assemblaggio extends Thread
{
    private int ID;
    private Magazzino magazzino;
    private int pezziRichiestiTipo1=0;
    private int pezziRichiestiTipo2=0;
    private int randomico;

    public Assemblaggio(int ID , Magazzino magazzino , int pezziRichiestiTipo1 , int pezziRichiestiTipo2)
    {
        this.ID=ID;
        this.magazzino=magazzino;
        this.pezziRichiestiTipo1=pezziRichiestiTipo1;
        this.pezziRichiestiTipo2=pezziRichiestiTipo2;
    }

    public void run()
    {
        while(true)
        {
            randomico=(int)(Math.random()*3);

            System.out.println("l'unita di assemblaggio :"+" "+this.ID+" "+"deve produrre il prodotto :"+" "+randomico+" "+"il quale richiede :"+" "+this.pezziRichiestiTipo1+" "+"pezzi di tipo 1  e :"+" "+this.pezziRichiestiTipo2+" "+"pezzi di tipo 2");
            System.out.println("l'unita di assemblaggio :"+" "+this.ID+" "+"sta per prendere i pezzi necessari in magazzino");

            magazzino.prendi(this);
        }
        

        
    }

    public int getPezziTipo1Richiesti()
    {
        return this.pezziRichiestiTipo1;
    }

    public int getPezziTipo2Richiesti()
    {
        return this.pezziRichiestiTipo2;
    }

    public int getID()
    {
        return this.ID;
    }


}