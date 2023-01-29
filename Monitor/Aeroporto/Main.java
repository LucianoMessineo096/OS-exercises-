public class Main
{
    public static void main(String args[])
    {
        int numViaggiatori=10;
        int numOperatori=5;

        Nastro nastro=new Nastro();

        Viaggiatore viaggiatori[] = new Viaggiatore[numViaggiatori];
        Operatore operatori[] = new Operatore[numOperatori];

        for(int i=0;i<numViaggiatori;i++)
        {
            viaggiatori[i]=new Viaggiatore(i,nastro);
            viaggiatori[i].start();
        }

        for(int j=0;j<numOperatori;j++)
        {
            operatori[j]=new Operatori(j,nastro);
            operatori[j].start();
        }

    }
}