public class Commissione extends Thread
{
    public Commissione(int ID , Seggio seggio)
    {
        this.ID=ID;
        this.seggio=seggio;
        
    }

    public int getID()
    {
        return this.ID;
    }


    public void run()
    {
        
    }
}