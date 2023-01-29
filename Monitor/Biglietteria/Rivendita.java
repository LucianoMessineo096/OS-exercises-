public class Rivendita
{
    private int ID;
    private Biglietteria biglietteria;
    private int numBigliettiEvento1=0;
    private int numBigliettiEvento2=0;
    private int numBigliettievento3=0;

    public Rivendita(int ID , Biglietteria biglietteria)
    {
        this.ID=ID;
        this.biglietteria=biglietteria;
        this.numBigliettiEvento1=40 + (int)(Math.random()*21);
        this.numBigliettiEvento2=40 + (int)(Math.random()*21);
        this.numBigliettievento3=40 + (int)(Math.random()*21);
    }

    public int getNumBigliettiEvento1()
    {
        return this.numBigliettiEvento1;
    }

    public int getNumBigliettiEvento2()
    {
        return this.numBigliettiEvento2;
    }

    public int getNumBigliettiEvento3()
    {
        return this.numBigliettiEvento3;
    }

    public void run()
    {
        biglietteria.vendi(this);
    }
}