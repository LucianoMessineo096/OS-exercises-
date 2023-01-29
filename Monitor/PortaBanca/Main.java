public class Main
{
    public static void main(String args[])
    {
        int numClienti=9;

        Cabina cabina = new Cabina();

        Cliente clienti[]=new Cliente[numClienti];


        for(int i=0;i<numClienti;i++)
        {
            clienti[i]=new Cliente(i,cabina);
            clienti[i].start();
        }
    }
}