public class Viaggiatore extends Thread
{
    private int ID;
    private Nastro nastro;
    

    public Viaggiatore(int ID , Nastro nastro)
    {
        this.ID=ID;
        this.nastro=nastro;
        
    }

    public int getID()
    {
        return this.ID;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("il viaggiatore :"+" "+this.ID+" "+"sta per prendere il bagaglio dal nastro");

            nastro.prendi(this);

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            System.out.println("il viaggiatore :"+" "+this.ID+" "+"sta per prendere il bagaglio dal nastro");
        }
        
    }
}