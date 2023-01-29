public class Main
{
    public static void main(String args[])
    {
        int numSportelliConsulenza=9;
        int numClienti=20;

        Ufficio ufficio = new Ufficio();

        SportelloConsulenza sportelliC[] = new SportelloConsulenza[numSportelliConsulenza];
        Cliente clienti[] = new Cliente[numClienti];

        for(int i=0;i<numClienti;i++)
        {
            clienti[i]=new Cliente(i,ufficio);
            clienti[i].start();

            try
            {
                Thread.sleep((int)(Math.random()*1001));
            }catch(InterruptedException e){

                e.printStackTrace();
            }
        }

        for(int j=0;j<numSportelliConsulenza;j++)
        {
            sportelliC[j]=new SportelloConsulenza(j,ufficio);
            sportelliC[j].start();
        }

        SportelloVeloce sportelloV = new SportelloVeloce(ufficio);
    }
}