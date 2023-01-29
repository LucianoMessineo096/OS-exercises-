public class Cliente extends Thread
{
    private int ID;
    private Ufficio ufficio;
    private int tipoOperazione;

    public Cliente(int ID , Ufficio ufficio)
    {
        this.ID=ID;
        this.ufficio=ufficio;
        this.tipoOperazione=(int)(Math.random()*2);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getTipoOp()
    {
        return this.tipoOperazione;
    }

    public void run()
    {
        while(true)
        {
            System.out.println("il cliente :"+" "+this.ID+" "+"sta per entrare nell'ufficio");

            if(this.tipoOperazione==1)
            {
                System.out.println("il cliente :"+" "+this.ID+" "+"deve effettuare un operazione veloce");

                ufficio.entra(this);

                System.out.println("il cliente :"+" "+this.ID+" "+"ha terminato l'operazione e si appresta ad uscire");

                ufficio.esciA(this);
            }
            else
            {
                System.out.println("il cliente :"+" "+this.ID+" "+"deve effettuare una consulenza");

                ufficio.entra(this);

                ufficio.esciB(this);
            }
        }

    }


}