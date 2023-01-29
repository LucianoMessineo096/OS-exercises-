public class Main
{
    public static void main(String args[])
    {
        int numAnalisti=5;
        int numClienti=10;

        Laboratorio L = new Laboratorio();

        Cliente clienti[] = new Cliente[numClienti];
        Analista analisti[] = new Analista[numAnalisti];

        for(int i=0;i<numClienti;i++)
        {
            clienti[i]=new Cliente(i,L);
            clienti[i].start();

            try
            {
                Thread.sleep(1001);
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        for(int j=0;j<numAnalisti;j++)
        {
            analisti[j]=new Analista(j,L);
            analisti[j].start();

            try
            {
                Thread.sleep(1001);
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }


    }
}