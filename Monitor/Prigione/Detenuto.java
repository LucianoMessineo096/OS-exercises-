public class Detenuto extends Thread
{

    private int ID;
    private Cortile cortile;
    private int tipo;
    private int fazione;
    

    public Detenuto(int ID,Cortile cortile)
    {
        super("Detenuto");
        this.ID=ID;
        this.cortile=cortile;
        this.tipo=(int)(Math.random()*2);
        this.fazione=(int)(Math.random()*2);  
    }

    public void run()
    {
        while(true)
        {
            if(this.tipo==0)
            {
                System.out.println("il prigioniero :"+" "+this.ID+" "+"sta per entrare nel cortile");
                cortile.entra(this);
            }
            else if(this.tipo==1 && this.fazione==0)
            {
                System.out.println("il criminale :"+" "+this.ID+" "+"della fazione "+" "+this.fazione+" "+"sta per entrare nel cortile");
                cortile.entra(this);
                
            }
            else if(this.tipo==1 && this.fazione==1)
            {
                System.out.println("il criminale :"+" "+this.ID+" "+"della fazione "+" "+this.fazione+" "+"sta per entrare nel cortile");
                cortile.entra(this);
                
            }
            else
            {
                System.out.println("!!ERROR inserimento");
            }
            

            try
            {
                Thread.sleep((int)(Math.random()*3001));
                System.out.println("il detenuto :"+" "+this.ID+" "+"ha passato il tempo T nel cortile");
            }catch(InterruptedException e ){

                e.printStackTrace();
            }

            System.out.println("il detenuto :"+" "+this.ID+" "+"sta per immettersi nella coda di uscita");
            cortile.esci(this);
        }
        
    }


    public int getID()
    {
        return this.ID;
    }

    public int getTipo()
    {
        return this.tipo;
    }

    public int getFazione()
    {
        return this.fazione;
    }
}