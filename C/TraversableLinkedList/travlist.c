/*
 * travlist.c
 */

#include <stdio.h>
#include <stdlib.h>
#include "travlist.h"
#include "listdata.h"

// ==============================================================
// Utility operations
// ==============================================================

struct TList *create_empty_list() {
	struct TList *list = malloc(sizeof(struct TList));
	list->first = NULL;
	list->last_left = NULL;
	return list;
}

void clear_list(struct TList *list) {

	struct LNode * p;
	p = list->first;
	while(p != NULL){
		free(p->data);
		struct LNode * temp = p -> next;
		free(p);
		p = temp;
	}
	free(list);
}

void swap_list_rights(struct TList *list1, struct TList *list2) {

	//struct LNode *temp;
	//temp = list1->last_left->next;
	//list1->last_left->next = list2->last_left->next;
	//list2->last_left->next = temp;

	struct LNode *list1Right;
	struct LNode *list2Right;
	if(list1->last_left != NULL) {
    list1Right = list1->last_left->next;
	} else {
    list1Right = list1->first;
	}
	if(list2->last_left != NULL) {
    list2Right = list2->last_left->next;
	} else {
    list2Right = list2->first;
	}
	if(list1->last_left != NULL) {
    list1->last_left->next = list2Right;
	} else {
    list1->first = list2Right;
	}
	if(list2->last_left != NULL){
    list2->last_left->next = list1Right;
	} else {
    list2->first = list1Right;
	}

	// TODO This code only works when the left portions of both lists have at
	// least one element in them. Modify the implementation so that is works
	// in all cases.
}

void print_list(struct TList *list) {
	struct LNode *left_ptr;
	struct LNode *right_ptr;

	// print left list

	printf("[ ");
	if (list->last_left != NULL ) { // left list is non-empty
		left_ptr = list->first;
		while (left_ptr != list->last_left->next) {
			print_data(left_ptr->data);
			printf(" ");
			left_ptr = left_ptr->next;
		}
	}
	printf("]");

	// print right list

	printf("[ ");
	if (list->first != NULL ) { // at least one element is in the list

		/*
		 * If the left list is empty, the first element in the right list
		 * is the first element in the list. If the left list is not empty,
		 * the first element in the right list is the element just after
		 * the last element in the left list
		 */

		right_ptr =
				(list->last_left == NULL ) ?
						list->first : list->last_left->next;
		while (right_ptr != NULL ) {
			print_data(right_ptr->data);
			printf(" ");
			right_ptr = right_ptr->next;
		}
	}
	printf("]");
}

// ==============================================================
// Size functions (no side effects)
// ==============================================================

int list_left_size(struct TList *list) {

	if(list->last_left == NULL){
	return 0;
	}
	int count = 0;
	struct LNode * p;
	p = list->first;
	while(p != list->last_left->next){
		count ++;
		p = p->next;
	}return count;
}



int list_right_size(struct TList *list) {
	struct LNode * p;
	int count = 0;
	if (list->last_left == NULL){
		p = list->first;
	}
	else{
		p = list->last_left->next;
	}
	while(p != NULL){
		count ++;
		p = p->next;
	}return count;
}

// ==============================================================
// Insert operation
// ==============================================================

void list_insert(struct TList *list, struct LData *dataaa) {

	struct LNode * p = malloc(sizeof(struct LNode));
	p->data = dataaa;
	if (list->last_left != NULL){
		p->next = list->last_left->next;
		list->last_left->next = p;
	}else{
		p->next = list->first;
		list->first = p;
	}
}

// ==============================================================
// Remove operation
// ==============================================================

struct LData *list_remove(struct TList *list) {

	struct LNode * p;
	if (list->last_left != NULL){
		p = list->last_left->next;
		list->last_left->next = p -> next;
	}else{
		p = list->first;
		list -> first = p -> next;
	}
	return p -> data;
}

// ==============================================================
// Cursor operations
// ==============================================================

void reset_list_cursor(struct TList *list) {
	list -> last_left = NULL;
}

void advance_list_cursor(struct TList *list) {
	if (list->last_left != NULL){
		list->last_left = list->last_left->next;
	}else list->last_left = list->first;

}

void advance_list_cursor_to_end(struct TList *list) {
	if(list->last_left == NULL){
		list->last_left = list->first;
	}
	while (list->last_left->next != NULL){
		list->last_left = list->last_left->next;
	}
}





