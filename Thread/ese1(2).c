#include<stdio.h>
#include<unistd.h>
#include<pthread.h>

struct thread_args
{
    int* array;
    int len;
    int sumPari;
    int sumDispari;
};

void* t1_func(void* param);
void* t2_func(void* param);

int main()
{
    int array[]={1,2,3,4,5,6,7,8,9};


    pthread_t t1_id;

    struct thread_args t1_args;
    t1_args.array=array;
    t1_args.len=9;
    t1_args.sumPari=0;

    pthread_t t2_id;

    struct thread_args t2_args;
    t2_args.array=array;
    t2_args.len=9;
    t2_args.sumDispari=0;

    int* t1_returnValue;

    int* t2_returnValue;


    pthread_create(&t1_id,NULL,&t1_func,&t1_args);
    pthreat_create(&t2_id,NULL,&t2_func,&t2_args);

    pthread_join(t1_id,(void**) t1_returnValue);
    pthread_join(t2_id,(void**) t2_returnValue);

    return 0;
}

void* t1_func(void* param)
{
    
    struct t1_args* e = (struct t1_args*) param;

    for(int i=0 ; i<e->len ; i++)
    {
        if(i%2==0)
        {
            e->sumPari+= e->array[i];
        }
    }

    return (void*) &(e->sumPari);
}

void* t2_func(void* param)
{
    
    struct t2_args* e = (struct t2_args*) param;

    for(int i=0 ; i<e->len ; i++)
    {
        if(i%2!=0)
        {
            e->sumDispari+= e->array[i];
        }
    }

    return (void*) &(e->sumDispari);
}