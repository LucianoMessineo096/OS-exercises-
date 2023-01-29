public class Cliente extends Thread
{
    private int ID;
    private Sala sala;

    public Cliente(int ID ,Sala sala)
    {
        super("Cliente");
        this.ID=ID;
        this.sala=sala;
    }

    public int getID()
    {
        return this.ID;
    }

    public void run()
    {
        System.out.println("il cliente :"+" "+this.ID+" "+"sta per entrare in sala ");

        sala.entra(this);
        


        


    }
}