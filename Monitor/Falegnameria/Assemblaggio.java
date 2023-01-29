public class Assemblaggio extends Thread
{
    private int ID;
    private Falegnameria falegnameria;
    private int pezziTipo1;
    private int pezziTipo2;
    private int pezziTipo3;
    

    public Assemblaggio(int ID , Falegnameria falegnameria)
    {
        this.ID=ID;
        this.falegnameria=falegnameria;
        this.pezziTipo1=1+(int)(Math.random()*2);
        this.pezziTipo2=1+(int)(Math.random()*2);
        this.pezziTipo3=1+(int)(Math.random()*2);

        
    }

    public int getID()
    {
        return this.ID;
    }

    public int getPezziTipo1()
    {
        return this.pezziTipo1;
    }

    public int getPezziTipo2()
    {
        return this.pezziTipo2;
    }

    public int getPezziTipo3()
    {
        return this.pezziTipo3;
    }


    public void run()
    {
        while(true)
        {
            System.out.println("l'unita di assemblaggio"+" "+this.ID+" "+"he bisogno di :"+" "+this.pezziTipo1+" "+"pezzi di tipo 1"+" "+this.pezziTipo2+" "+"pezzi di tipo 2"+" "+this.pezziTipo3+" "+"pezzi di tipo 3");

            falegnameria.prendi(this);

            falegnameria.assembla(this);
        }
    }
}