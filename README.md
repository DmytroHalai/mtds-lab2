# MTDS Lab Work 2

## Brief Description of the Application

This project implements the doubly linked list and its methods using the Node class as the fundamental building block of the list elements and the DoublyLinkedList class as the main structure where everything is gathered and the methods are implemented. Additionally, as a result of refactoring, the code has been simplified and now utilizes an ArrayList for improved efficiency and flexibility.
## Variant Calculation and Description

The variant number is determined by the remainder of dividing the student ID number by 4. For example, for the number 3993:

```
3993 % 4 = 1
```

Here’s how the variant will be described based on this result:

1. If the remainder is 0 — the initial implementation uses a singly linked circular list, and the second implementation is a list based on constructed arrays/lists.
2. If the remainder is 1 — the initial implementation uses a doubly linked list, and the second implementation is a list based on constructed arrays/lists.
3. If the remainder is 2 — the initial implementation uses a list based on constructed arrays/lists, and the second implementation is a singly linked circular list.
4. If the remainder is 3 — the initial implementation uses a list based on constructed arrays/lists, and the second implementation is a doubly linked list.

## Instructions for Building the Project and Running Tests

### Step 1: Clone the Repository

```bash
git clone https://github.com/DmytroHalai/mtds-lab2.git
cd mtds-lab2
```

### Step 2: Build the Project Using Maven

To build the project, use the Maven command:

```bash
mvn clean install
```

### Step 3: Run the Unit Tests

To run the unit tests included in the project, use the following command:

```bash
mvn test
```

This command will automatically run all the tests defined in the project.

## Link to the Commit Where Tests Failed on CI

Here’s the link to the commit where the tests failed:

[Link to the commit with failed tests](https://github.com/DmytroHalai/mtds-lab2/actions/runs/13949010073)

## Conclusions

As a result of testing the project, the following can be noted:

- **Unit tests** detected several issues in the initial implementations that were not noticed during development.
- The tests helped confirm the correctness of the list operations in different scenarios.
- They also provided additional verification for potential memory management issues and list linkage problems.
