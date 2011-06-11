# java4edu - Code samples and small projects to practice the Java programming language

##java-programming-basics
Examples to practice and learn the Java programming language. Try out the most used Features of the Java API. Import the java-programming-basics project in Eclipse and run the *Usage.java classes. Change the code of the examples to try out more and learn to understand the features. 

## VendingMachine and VendingMachineCollection
Two example implementations of a simple vending machine.

At every train station you will find a vending machine which sells drinks, bubble gums and other small products. To practice the java programming language and the object oriented paradigma implement a vending machine which met the following conditions.

- The vending machine sells five different products, each product has name and a price. 
- The products are in a splint. Each splint has an amount of five products and a number to choose the product on the keyboard 
- The vending machine accepts only Coins 1 CHF, 2 CHF, 5 CHF and 10, 20, 50 Rappen (centimes)
- At startup time the vending machine has five pieces of each coin
- The vending machine has display to show the activities and instructions
- After the choice the selled product and the remaining money will ejected in the same output container

Consider the possible use cases and find the classes within the system bounderies. Consider the dynamic flow of the use cases (activity diagrams / flow charts) and find the attributes and methods of the classes.
Finaly implements the classes.

Don't try to code first and then consider the structural system, you will fail! ;-)

In a second step use collections instead of arrays to make the product limit more flexible. (VendingMachineCollection)