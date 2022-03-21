- Written by Omonigho Egi (egi00002)
- Source code for program are the classes ArrayList.java and LinkedList.java
- Can use main method inside LinkedList.java to test out the methods in both classes
- Assuming for equalto?
- bugs: equalto...
- bugs: add method for arraylist just adds one more element to the list instead of
creating a new array twice its size. I only realized it was supposed to do this
on the last day because it wasn't mentioned in the List interface and so I didn't have
time to implement it
- Also: method sort in LinkedList doesn't do the correct number of iterations to properly
sort the list.
- Most of the methods I wrote worked well with my tests but I couldn't figure out how to
debug them to work for the JUnit tests which are presumably much more strict than the testing
I did in the main method.
- Also just figured out that we were supposed to increment size in each add method
which I didn't do because the way I wrote my add method was wrong
- Also LinkedList rotate method doesn't do the right number of iterations so it
doesn't move the elements
- Problems in my sort() method led to problems in my merge method I think
