public class Donna extends Thread
{
    private int ID;
    private Bagno bagno;
    private int priorita;

    public Donna(int ID,Bagno bagno)
    {
        this.ID=ID;
        this.bagno=bagno;
        this.priorita=1;
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
        System.out.println("il cliente F :"+" "+this.ID+" "+"sta per accedere al bagno");

        bagno.entraD(this);

        System.out.println("il cliente F :"+" "+this.ID+" "+"sta usando il bagno");

        try
        {
            Thread.sleep((int)(Math.random()*3001));
        }catch(InterruptedException e){

            e.printStackTrace();
        }

        bagno.esciD(this);

        System.out.println("il cliente F :"+" "+this.ID+" "+"e uscito dal bagno");


    }
}