/*
 * travlistaux.h -- contains auxiliary operations for travlist.h
 */

#ifndef TRAVLISTAUX_H_
#define TRAVLISTAUX_H_

// Checks if the left part of the list is empty
int left_is_empty(struct TList *list);

// Checks if the right part of the list is empty
int right_is_empty(struct TList *list);

// Adds the specified data to the end of the list and resets the cursor
void add_last(struct TList *list, struct LData *data);

// Adds the specified data to the beginning of the list and resets the cursor
void add_first(struct TList *list, struct LData *data);

// Adds the specified data to the end of the left list
void inject(struct TList *list, struct LData *data);

// Adds the specified data just after the n-th element in the list
// Assumes that there are at least n elements in the list
void insert_after(struct TList *list, int n, struct LData *data);

// Swap all the elements of two lists and reset their cursors
void swap_list(struct TList *list1, struct TList *list2);

// Insert all the elements from list2 into list1 at the cursor position
// list2 becomes empty and the length of the left part of list1 is unchanged
// Assumes that the left part of list2 is empty
// Example: (input) list1 = [ A B C ][ D E F ] list2 = [ ][ X Y Z ]
// Example: (output) list1 = [ A B C ][ X Y Z D E F ] list2 = [ ][ ]
void insert_list(struct TList *list1, struct TList *list2);

#endif /* TRAVLIST_H_ */
