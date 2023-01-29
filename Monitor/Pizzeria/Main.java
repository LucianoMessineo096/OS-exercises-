public class Main
{
    public static void main(String args[])
    {
        int numClienti=5;
        //int numCamerieri=2;

        Pizzeria pizzeria = new Pizzeria();

        Cliente clienti[] = new Cliente[numClienti];
        //Cameriere camerieri[] = new Cameriere[numCamerieri];

        for(int i=0 ; i<numClienti ;i++)
        {
            clienti[i] = new Cliente(i,pizzeria);
            clienti[i].start();

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

        }

        /*
        for(int j=0;j<numCamerieri;j++)
        {
            camerieri[j]=new Cameriere(j,pizzeria);
            camerieri[j].start();
        }

        */
    }
}