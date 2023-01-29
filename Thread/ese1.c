#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

void *thread1_function(); 
void *thread2_funtion();

struct thread_args{

    int *array;
    int len;
    int sumPari;
    int sumDispari;
}

int main()
{
    int array[]={1,2,3,4,5,6,7,8,9,10};

    pthread_t thread1_id;
    pthread_t thread2_id;

    struct thread_args element;

    element.array=array;
    element.len=10;
    element.sumPari=0;
    element.sumDispari=0;

    int* thread1_returnValue;
    int* thread2_returnValue;

    pthread_create(&thread1_id,NULL,&thread1_function,&thread1_returnValue); //1. id thread - 2.null-3.funzione -4. valore di ritorno
    pthread_create(&thread2_id,NULL,&thread2_function,&thread2_returnValue);

    pthread_join(thread1_id,(void**) &thread1_returnValue); // 1. id thread - 2. valore di ritorno della funzione corrispondente
    pthread_join(thread2_id,(void**) &thread2_returnValue);

    printf("somma pari %d\n", *thread1_returnValue);
    printf("somma dispari %d\n", *thread2_returnValue);
}

void *thread1_function(*void parameters)
{
    struct element* e = (struct element*) parameters;

    for(int i=0;i<e->len;i++)
    {
        if(i%2==0)
        {
            e->sumPari += e->array[i];
        }
    }

    return (void*) &(e->sumPari);
}

void *thread2_function(*void parameters)
{
    struct element* e = (struct element*) parameters;

    for(int i=0;i<e->len;i++)
    {
        if(i%2==0)
        {
            e->sumDispari += e->array[i];
        }
    }

    return (void*) &(e->sumDispari);
}