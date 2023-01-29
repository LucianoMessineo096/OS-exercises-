public class Cliente extends Thread
{
    private int ID;
    private Laboratorio L;
    private int esame;
    private int daChiEStatoServito;

    public Cliente(int ID , Laboratorio L)
    {
        this.ID=ID;
        this.L=L;
        this.esame=(int)(Math.random()*2);
        
    }

    public int getID()
    {
        return this.ID;
    }

    public int getEsame()
    {
        return this.esame;
    }

    public void setServito(int a)
    {
        this.daChiEStatoServito=a;
    } 

    public int getServito()
    {
        return this.daChiEStatoServito;
    } 

    public void run()
    {
        while(true)
        {
            // il cliente entra e si iscrive alla lista prenotazione 

            L.entra(this);

            // una volta entrato attende che un analista lo chiami

            if(this.esame==1)
            {
                //tempo di attesa in sala S


                try
                {
                    Thread.sleep((int)(Math.random()*1001));
                }catch(InterruptedException e){

                    e.printStackTrace();
                }
            }
        }
        
    }
}