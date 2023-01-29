public class ese1
{
    public static void main(String args[])
    {
        int len=10;
        int array[] = new int [len];

        System.out.println("l'array contiene i seguenti valori\n");

        for(int i=0;i<len;i++)
        {
            array[i]=1+(int)(Math.random()*11);

            System.out.println(array[i]+"\n");
        }

        SommaPari sommaP = new SommaPari("thread1",array,len);
        SommaDispari sommaD = new SommaDispari("thread2",array,len);

        sommaP.start();
        sommaD.start();
    }
    

    
}

class SommaPari extends Thread
{
    private String name;
    private int[] array;
    private int len;

    public SommaPari(String name , int[] array,int len)
    {
        this.name=name;
        this.array=array;
        this.len=len;
    }

    public void run()
    {
        int somma =0;

        for(int i=0;i<this.len;i++)
        {
            if(i%2==0)
            {
                somma+=array[i];
            }
        }

        System.out.println("la somma dei pari e :"+" "+somma);
    }
}

class SommaDispari extends Thread
{
    private String name;
    private int[] array;
    private int len;

    public SommaDispari(String name , int[] array,int len)
    {
        this.name=name;
        this.array=array;
        this.len=len;
    }

    public void run()
    {
        int somma =0;

        for(int i=0;i<this.len;i++)
        {
            if(i%2!=0)
            {
                somma+=array[i];
            }
        }

        System.out.println("la somma dei dispari e :"+" "+somma);
    }
}