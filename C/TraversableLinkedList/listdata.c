/*
 * listdata.c
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "listdata.h"

struct LData * create_empty_data() {
	struct LData *data; // RIGHT HERE!!!!!!!!! declartion of the pointer data
	data = malloc(sizeof(struct LData));
	data->name = "";
	data->age = 0;
	data->sex = 0;
	return data;
}

struct LData * create_data(char* name, int age, int sex) { //creat_data function expects a pointer to LData to be returned
	struct LData* data; //declartion data is a pointer to LData
	//data = malloc(sizeof(struct LData));
	//(*data).name = ""; //*data is the content pointed to by data, which in this case is the pointer name, which is the adress of "" (empty string) which is assigned by the machine
	data->name = "";
	data->age = 0;
	data->sex = 0;
	return data;
	return NULL;
}

int are_equal_data(struct LData * data1, struct LData * data2) {
	if (strcmp((*data1).name, (*data2).name) && (*data1).age == (*data2).age && (*data1).sex == (*data2).sex) return 1;
	else return 0;
	//return 0;
}

void clear_data(struct LData *data) {
	(*data).name ="";
	(*data).age = 0;
	(*data).sex = 0;
}

void print_data(struct LData *data) {
	char* gender = (data->sex == 0) ? "male" : "female";
	printf("%s-%d-%s", data->name, data->age, gender);//(data->sex == 0) ? "male" : "female"};

}
