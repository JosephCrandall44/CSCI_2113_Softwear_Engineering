/*
 * travlist.h
 *
 *  Created on: Sep 13, 2014
 *      Author: gregory
 */

#ifndef TRAVLIST_H_
#define TRAVLIST_H_

/* Declare the traversable list data structures and functions. */
struct TList {
	struct LNode* first;
	struct LNode* last_left;
};

struct LNode {
	struct LData* data;
	struct LNode* next;
};

/*
 * Empty list: [ ][ ]
 * first --> NULL
 * last_left --> NULL
 *
 * Singleton (left) list: [ A ][ ]
 * first --> A
 * last_left --> A
 *
 * Singleton (right) list: [ ][ B ]
 * first --> B
 * last_left --> NULL
 *
 * Complex list: [ A B ][ C D E ]
 * first --> A
 * last_left --> B
 *
 */

// ==============================================================
// Utility operations
// ==============================================================

// Creates and returns an empty list
struct TList *create_empty_list();

// Clears (empties) the specified list and frees all memory
void clear_list(struct TList *list);

// Swaps the elements in the second half of list1 with
// the elements in the second half of list2
void swap_list_rights(struct TList *list1, struct TList *list2);

// Prints the list to standard output
void print_list(struct TList *list);

// ==============================================================
// Size functions (no side effects)
// ==============================================================

// Returns the size of the left list
int list_left_size(struct TList *list);

// Returns the size of the right list
int list_right_size(struct TList *list);

// ==============================================================
// Insert operation
// ==============================================================

// Adds the specified data to the first position in the right list
void list_insert(struct TList *list, struct LData *data);

// ==============================================================
// Remove operation
// ==============================================================

// Removes and returns the first element in the right list
// Assumes that the right list is not empty
struct LData * list_remove(struct TList *list);

// ==============================================================
// Cursor operations
// ==============================================================

// Resets the cursor to the beginning of the list
void reset_list_cursor(struct TList *list);

// Advances the cursor in the list by one element
// Assumes that the right list is not empty
void advance_list_cursor(struct TList *list);

// Advances the cursor to the end of the list
void advance_list_cursor_to_end(struct TList *list);

#endif /* TRAVLIST_H_ */
