/*
 * listdata.h
 */

#ifndef LISTDATA_H_
#define LISTDATA_H_

struct LData {
	char* name;
	int age;
	int sex; /* 0 = male, 1 = female */
};

// Creates and returns an empty data record
// name = "", age = 0, sex = 0, and email = ""
struct LData *create_empty_data();

// Creates and returns a data record with the specified values
struct LData *create_data(char *name, int age, int sex);

// Resets the information in data to default values (see create_empty_data)
void clear_data(struct LData *data);

// Checks if the two data structures are equal (if all fields except email are equal)
int are_equal_data(struct LData *data1, struct LData *data2);

// Prints the data in the form: name-age-sex
// sex should be printed as "male" or "female"
// Example: "Joe-20-male"
void print_data(struct LData *data);

#endif /* LDATA_H_ */
