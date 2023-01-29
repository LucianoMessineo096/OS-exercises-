public class Main
{
    public static void main(String args[])
    {
        int numViaggiatori=10;
        int numBagagli=10;
        
        Nastro nastro =new Nastro();

        Viaggiatore viaggiatori[]=new Viaggiatore[numViaggiatori];
        

        for(int i=0;i<numViaggiatori;i++)
        {
            viaggiatori[i]=new Viaggiatore(i,nastro);
            viaggiatori[i].start();

            try
            {
                Thread.sleep((int)(Math.random()*2000));
            }catch(InterruptedException e){

                e.printStackTrace();
            }

        }

        Operatore operatore=new Operatore(nastro , numBagagli);
        operatore.start();
    }
}