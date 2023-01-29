import java.util.concurrent.*;

public class Mercato
{
    public static void main(String args[])
    {
        ThreadP producer1 = new ThreadP();
        ThreadC consumer1 = new ThreadC();

        producer1.start();
        producer2.start();

    }
}