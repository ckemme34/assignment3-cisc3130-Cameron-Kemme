# CISC 3130 MY9 Data Structures Assignment 3 - C. Kemme

## Introduction
  
  Assignment 3 involves preparing a text file (i.e lyrics, document etc) to analyze the frequency of words in it. 
Within our code, we will be able read from a text file and store the data into a data structure. 
Using a data structure, we will be able to count the frequency of every word in our text file and print out a word frequency list.

## Method
  Although many data structures are suitable for the task; it is optimal to choice a hash map for its efficency whenever possible.
The method I used to carry out this task was to import the lyrics into a hash map. Then, I sorted the hash map via an array list and 
print the number of occurances along with its count. The code involves the use of a scanner to read in the lyrics, an array as an
intermediary structure, two hashmaps, and an array list as an intermediary to the sorted hash map. 

## Compilation

 Example commands for running this file
 *  Compilation:  javac -Xlint wordCount.java
 *  Execution:    java wordCount

## Authors

* **Cameron Kemme**

## Licensing

Songwriters: Austin Richard Post / Carl Austin Rosen / Frank Dukes / Kaan Gunesberk / Louis Bell / William Thomas Walsh / Adam King Feeney
Better Now lyrics © Sony/ATV Music Publishing LLC, Universal Music Publishing Group
