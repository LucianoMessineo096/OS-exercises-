public class Cliente extends Thread
{
    private int ID;
    private Ufficio ufficio;
    private int tipoOperazione;

    public Cliente(int ID,Ufficio ufficio)
    {
        this.ID=ID;
        this.ufficio=ufficio;
        this.tipoOperazione=(int)(Math.random()*2); // 0 operazione veloce - 1 consulenza
    }


    public void run()
    {
        
        ufficio.entra(this);

        ufficio.esce(this);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getOperazione()
    {
        return this.tipoOperazione;
    }

}