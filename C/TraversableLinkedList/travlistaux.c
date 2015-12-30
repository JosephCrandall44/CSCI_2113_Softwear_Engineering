/*
 * travlistaux.c
 */

#include <stdio.h>
#include "listdata.h"
#include "travlist.h"

int left_is_empty(struct TList *list) {
	return (list_left_size(list) == 0);
}

int right_is_empty(struct TList *list) {
	return (list_right_size(list) == 0);

}

void add_last(struct TList *list, struct LData *data) {
	advance_list_cursor_to_end(list);
	list_insert(list, data);
	reset_list_cursor(list);
}

void add_first(struct TList *list, struct LData *data) {
	reset_list_cursor(list);
	list_insert(list, data);
}

void inject(struct TList *list, struct LData *data) {
	list_insert(list, data);
	advance_list_cursor(list);
}

void insert_after(struct TList *list, int n, struct LData *data) {
reset_list_cursor(list);
while (list_left_size(list) != n){
	advance_list_cursor(list);
}
list_insert(list, data);
}

void swap_list(struct TList *list1, struct TList *list2) {
	reset_list_cursor(list1);
	reset_list_cursor(list2);
	swap_list_rights(list1, list2);
}

void insert_list(struct TList *list1, struct TList *list2) {
	advance_list_cursor_to_end(list2);
	swap_list_rights(list1, list2);
	reset_list_cursor(list2);
	swap_list_rights(list1, list2);
}

