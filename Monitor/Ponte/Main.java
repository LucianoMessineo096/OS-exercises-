public class Main
{
    public static void main(String args[])
    {
        int numVeicoli=10;

        Ponte ponte =new Ponte();

        Veicolo veicoli[]=new Veicolo[numVeicoli];

        for(int i=0;i<numVeicoli;i++)
        {
            veicoli[i]=new Veicolo(i,ponte);

            veicoli[i].start();
        }
    }
}