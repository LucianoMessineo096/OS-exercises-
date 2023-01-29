public class Cliente extends Thread
{
    private int ID;
    private Pizzeria pizzeria;
    private int numPGruppo;

    public Cliente(int ID , Pizzeria pizzeria)
    {
        this.ID=ID;
        this.pizzeria=pizzeria;
        do
        {
            this.numPGruppo=(int)(Math.random()*100%9)+2;

        }while((this.numPGruppo)%2 == 0);
        
    }

    public int getID()
    {
        return this.ID;
    }

    public int getNumPGruppo()
    {
        return this.numPGruppo;
    }

    public void run()
    {
        System.out.println("il cliente :"+" "+this.ID+" "+"sta per entrare con un gruppo di :"+" "+this.numPGruppo+" "+"persone");

        pizzeria.entra(this);

        System.out.println("il cliente :"+" "+this.ID+" "+"e entrato");

        pizzeria.ordina(this);

        System.out.println("il cliente :"+" "+this.ID+" "+"ha ordinato");

        pizzeria.consuma(this);

        System.out.println("il cliente :"+" "+this.ID+" "+"ha consumato");

        pizzeria.esci(this);

        
    }
}