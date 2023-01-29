public class Uomo extends Thread
{
    private int ID;
    private Bagno bagno;
    private int priorita;

    public Uomo(int ID,Bagno bagno)
    {
        this.ID=ID;
        this.bagno=bagno;
        this.priorita=0;
    }

    public int getID()
    {
        return this.ID;
    }

    public int getPriorita()
    {
        return this.priorita;
    }

    public void run()
    {
        System.out.println("il cliente M :"+" "+this.ID+" "+"sta per accedere al bagno");

        bagno.entraU(this);

        System.out.println("il cliente M :"+" "+this.ID+" "+"sta usando il bagno");

        try
        {
            Thread.sleep((int)(Math.random()*3001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        bagno.esciU(this);

        System.out.println("il cliente M :"+" "+this.ID+" "+"e uscito dal bagno");


    }
}