#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Ticket 
{
    int type;
    int ID;
    char *name;
    char *date;
}Ticket;

typedef struct Nodo 
{
    Ticket *ticket; 
    struct Nodo *sig; 
}Nodo;

typedef struct List
{
    int regalados;
    int vendidos;
    Nodo *Nodo; 
    int Long; 
}tList;

void *Begin(tList *list);

tList *Create(tList *list, int ID, int type, char *date, char *name);

Nodo *Cloud(Nodo *list, int ID);

Nodo *Read(Nodo *list, int ID);

void printList(tList *list)
{
    //Mientras que el valor de la lista no sea nulo 
    while (list != NULL)
    {
        //Escarbando entre punteros para obtener los datos
        printf("%d ", list->Nodo->ticket->ID);
        printf("%d ", list->Nodo->ticket->type);
        puts(list->Nodo->ticket->name);
        printf(" ");
        puts(list->Nodo->ticket->date);
        printf("\n");
        //Pasar al siguiente puntero por medio de sig
        list->Nodo = list->Nodo->sig; 
    }
    
}
int main()
{
    tList *list; 
    list = NULL;
    list = Create(list, 1,2,"02/12/2022", "Josue");
    printList(list);

    printList(list);

    return 0; 
}

void *Begin(tList *list)
{
    list->Nodo = NULL;
    list->regalados = 0;
    list->vendidos = 0;
}

tList *Create(tList *list, int ID, int type, char *date, char *name)
{
    Nodo *new_nodo, *new_cloud;
    new_nodo = (Nodo *) malloc(sizeof(Nodo));
    new_cloud = (Nodo *) malloc(sizeof(Nodo));
    new_nodo->ticket->ID = ID;
    new_nodo->ticket->type = type;
    new_nodo->ticket->name = name;
    new_nodo->ticket->date = date;
    //El puntero siguiente apunta a NULL pra que no se genere otro espacio en donde haya un nodo
    //Algo así como marcar que no se siga la lista hasta ahí
    new_nodo->sig = NULL;

    if(list->Nodo == NULL)
    {
        //La lista es nueva y no tiene nada se cambia completamente por la que se generó anteriormente
        list->Nodo = new_nodo;
        if(new_nodo->ticket->type == 0)
        list->regalados++;
        else if(new_nodo->ticket->type == 1)
        list->vendidos++;

        list->Long = 1;
    }
    else
    {
        //Limite de la lista
        if (list->regalados > 50 || list->vendidos > 100 || list->Long > 150)
        {
            printf("Boletos insuficientes");
        }else{
            new_cloud = list->Nodo;
            while (new_cloud != NULL)
            {
            new_cloud = new_cloud->sig;
            }

            if(new_nodo->ticket->type == 0)
            list->regalados++;
            else if(new_nodo->ticket->type == 1)
            list->vendidos++;

            list->Nodo->sig = new_nodo;
        }
        
        return list;    
    }
}

Nodo *Cloud(Nodo *list, int ID)
{
    Nodo *new_list;
    new_list = (Nodo *) malloc(sizeof(Nodo));
    new_list = list;
    return Read(list, ID);
}

Nodo *Read(Nodo *list, int ID)
{
    if(list->ticket->ID == ID)
    return list;

    else
    Read(list->sig, ID);
}