public class Elettore extends Thread
{
    public Elettore(int ID , Seggio seggio)
    {
        this.ID=ID;
        this.seggio=seggio;
        this.tipo=(int)(Math.random()*3);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getTipo()
    {
        return this.tipo;
    }

    public void run()
    {
        seggio.entra();

        seggio.vota();
    }
}