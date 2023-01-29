/*
    Data una stringa str composta da caratteri alfanumerici (senza spazi), si realizzi un programma 
    istanzi due thread:
    • il thread T1 dovrà contare le lettere presenti in str
    • il thread T2 dovrà contare i numeri presenti in str
    esempio:
    str = “tle2s4t”;
    >> T1: str contiene 4 lettere
    >> T2: str contiene 3 numeri
    Se necessario, utilizzare i metodi:
    boolean contains(CharSequence s)
    String substring(int beginIndex, int endIndex

*/

#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

struct thread_args
{
    char *array;
    int len;
    int count;
}

void* thread1_function(void* param);
void* thread2_function(void* param);

int main()
{
    char string[]="ciao23";

    pthread_t thread1_id;

    struct thread_args thread1_args;
    thread1_args.array=string;
    thread1_args.len=6;
    thread1_args.count=0;

    pthread_t thread2_id;

    struct thread_args thread2_args;
    thread2_args.array=string;
    thread2_args.len=6;
    thread2_args.len=0;

    int *thread1_returnValue;
    int *thread2_returnValue;

    pthread_create(&thread1_id,NULL,&thread_function,&thread1_returnValue);
    pthread_create(&thread2_id,NULL,&thread_function,&thread2_returnValue);

    pthread_join(&thread1_id,(void**)thread1_returnValue);
    pthread_join(&thread2_id,(void**)thread2_returnValue);

    printf("la somma delle lettere e : %d\n", thread1_returnValue);
    printf("la somma degli interi e :%d\n", thread2_returnValue);
}


void* thread1_function(void* param)
{
    struct thread1_args* e = (struct thread1_args) param;

    srand(time(NULL));


    for(int i=0;i<e->len;i++)
    {
        if(e->array[i]==random()%11)
        {
            e->count+=1;
        }
    }

    return (void*) &(e->count)
}

void* thread2_function(void* param)
{
    struct thread2_args* e = (struct thread2_args) param;

    srand(time(NULL));


    for(int i=0;i<e->len;i++)
    {
        if(e->array[i]!=random()%11)
        {
            e->count+=1;
        }
    }

    return (void*) &(e->count)
}
