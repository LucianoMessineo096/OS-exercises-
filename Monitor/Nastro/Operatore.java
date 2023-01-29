public class Operatore extends Thread
{
    private Nastro nastro;
    private int numBagagli;

    public Operatore(Nastro nastro , int numBagagli)
    {
        this.nastro=nastro;
        this.numBagagli=numBagagli;
        
    }

    public void run()
    {
        while(true)
        {
            for(int i=0;i<numBagagli;i++)
            {
                System.out.println("L'operatore sta per caricare il bagaglio");

                nastro.inserisciBagaglio(i);

                try
                {
                    Thread.sleep((int)(Math.random()*1001));
                }catch(InterruptedException e){

                    e.printStackTrace();
                }

                System.out.println("L'operatore ha caricato il bagaglio :"+" "+i);
            }  
        }
          
    }
}