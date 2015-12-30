/*
 * listtest.c
 */

#include <stdio.h>
#include "listdata.h"
#include "travlist.h"
// #include "travlistaux.h"

int main() {

	struct LData *d0 = create_empty_data();
	struct LData *d1 = create_data("Alice", 20, 1);
	struct LData *d2 = create_data("Bob", 23, 0);
	struct LData *d3 = create_data("Carol", 25, 1);
	struct LData *d4 = create_data("Dan", 21, 0);
	struct LData *d5;

	printf("\n");
	printf("empty data\n");
	printf("expect: -0-male\n");
	printf("actual: "); print_data(d0); printf("\n");

	printf("\n");
	printf("non-empty data\n");
	printf("expect: Alice-20-female\n");
	printf("actual: "); print_data(d1); printf("\n");

	struct TList *s0 = create_empty_list();

	printf("\n");
	printf("empty list\n");
	printf("expect: [ ][ ]\n");
	printf("actual: "); print_list(s0); printf("\n");

	printf("\n");
	printf("left size of empty list\n");
	printf("expect: 0\n");
	printf("actual: %d\n", list_left_size(s0));

	printf("\n");
	printf("right size of empty list\n");
	printf("expect: 0\n");
	printf("actual: %d\n", list_right_size(s0));

	list_insert(s0, d1);

	printf("\n");
	printf("print singleton list (right)\n");
	printf("expect: [ ][ Alice-20-female ]\n");
	printf("actual: "); print_list(s0); printf("\n");

	advance_list_cursor(s0);

	printf("\n");
	printf("print singleton list (left)\n");
	printf("expect: [ Alice-20-female ][ ]\n");
	printf("actual: "); print_list(s0); printf("\n");

	list_insert(s0, d2);
	list_insert(s0, d3);

	printf("\n");
	printf("print list after inserts\n");
	printf("expect: [ Alice-20-female ][ Carol-25-female Bob-23-male ]\n");
	printf("actual: "); print_list(s0); printf("\n");

	d5 = list_remove(s0);

	printf("\n");
	printf("print list after remove\n");
	printf("expect: [ Alice-20-female ][ Bob-23-male ]\n");
	printf("actual: "); print_list(s0); printf("\n");

	printf("\n");
	printf("print data after remove\n");
	printf("expect: Carol-25-female\n");
	printf("actual: "); print_data(d5); printf("\n");

	printf("\n");

	return 0;
}
