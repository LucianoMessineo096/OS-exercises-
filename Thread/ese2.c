#include<stdio.h>
#include<unistd.h>
#include<pthread.h>
#include<time.h>


struct thread_args
{
    int *array;
    int len1;
    
}

void* thread1_function(void* parameters);
void* thread2_function(void*parameters);

void createString(int string[] , int integers[] , int characters[]);

int main()
{
    
    int arrayNum[6];
    int arrayChar[4];

    pthread_t thread1_id;
    struct thread_args IntegerThread;
    element.array=arrayNum;
    element.len1=6;
    

    pthread_t thread2_id;
    struct thread_args CharThread;
    element.array=arrayChar;
    element.len2=4;

    int *thread1_returnValue[6];
    char *thread2_returnValue[4];

    pthread_create(&thread1_id,NULL,&thread1_function,&thread1_returnValue);
    pthread_create(&thread2_id,NULL,&thread2_function,&thread2_returnValue);

    pthread_join(&thread1_id , NULL);
    pthread_join(&thread2_id , NULL);

    int string[10];

    createString(string , arrayNum , arrayChar);


}

void* thread1_function(void* parameters)
{
    struct IntegerThread* e = (struct element*) parameters;

    srand(time(NULL));

    for(int i=0 ; i<e->len1 ; i++)
    {
        e->array[i]=rand()%10;
    }

    return NULL;
}

void* thread2_function(void*parameters)
{
    struct CharThread* e = (struct element*) parameters;

    srand(time(0));

    for(int i=0;i<e->len2;i++)
    {
        e->arrayc[i]=97+rand()%26; // genera le lettere da a (97) fino alla z
    }

    return NULL;
}


void createString(int string[] , int integers[] , int characters[])
{
    unsigned int indexInt=0;
    unsigned int indexChar=0;
    unsigned int count=0;
    bool flag=true;

    for(int i=0;i<10;i++)
    {
        if(flag && indexInt<6)
        {
            string[i]=integers[indexInt];
            indexInt++;
            count++;
        }
        else if(!flag && indexChar<4)
        {
            string[i]=characters[indexChar];
            indexChar++;
            count++;
        }
        else
        {
            //errore
        }

        if(count==2)
        {
            count=0;
            flag=!flag;
        }
    }
}