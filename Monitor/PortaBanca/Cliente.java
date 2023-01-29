public class Cliente extends Thread
{
    private int ID;
    private Cabina cabina;
    private int metallo;

    public Cliente(int ID , Cabina cabina)
    {
        super("Cliente");
        this.ID=ID;
        this.cabina=cabina;
        this.metallo=(int)(Math.random()*2);
    }

    public void run()
    {
        while(true)
        {
            System.out.println("il cliente :"+" "+this.ID+" "+"sta per entrare in banca");
            cabina.entra(this);

            try
            {
                Thread.sleep((int)(Math.random()*5001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

            System.out.println("il cliente :"+" "+this.ID+" "+"e pronto per uscire");

            cabina.esci(this);

            System.out.println("il cliente :"+" "+this.ID+" "+"e uscito dalla banca");
        }
         
    }

    public int getID()
    {
        return this.ID;
    }

    public int getMetallo()
    {
        return this.metallo;
    }
}