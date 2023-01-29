public class Main
{
    public static void main(String args[])
    {
        int numClienti=10;
        int numBarbieri=3;

        Sala sala = new Sala();

        Cliente clienti[]=new Cliente[numClienti];
        Barbiere barbieri[]=new Barbiere[numBarbieri];

        for(int i=0;i<numClienti;i++)
        {
            clienti[i]=new Cliente(i,sala);
            clienti[i].start();
        }

        for(int j=0;j<numBarbieri;j++)
        {
            barbieri[j]=new Barbiere(j,sala);
            barbieri[j].start();
        }
    }
}