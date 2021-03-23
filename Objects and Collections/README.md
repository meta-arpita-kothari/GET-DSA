### Assignement of Objects and Collections

Implement the following programs using existing Java collections.

#### Question 1
Create a custom class say Employee with fields as empId, name and address. Create a collection of this employee class. EmpId of the class will be unique.
* Perform sorting on this collection i.e natural order.
* Perform sorting on this collection based on the employee Name. (ascending order by Employee Name)
* Create a collection for these employees to avoid any duplicate employee entry. (Employees having the same empId will be considered as duplicate.
  If one tries to add the same employee again it should avoid that.)
Note: Add at least 5 employees to the collection. Create a separate program for the above three points.

#### Question 2
Write a method that takes a string and returns the number of unique characters in the string. 
It is expected that a string with the same character sequence may be passed several times to the method. 
Since the counting operation can be time consuming, the methods should cache the results, so that when the method is given a string previously encountered, 
it will simply retrieve the stored result. Use collection and maps where appropriate.

#### Question 3
In Organic Chemistry, we studied compounds that are formed by combining Carbon (C), Hydrogen (H), and Oxygen (O) atoms.  A molecule of a compound is represented using a formula like C(OH)2 which says that the molecule consists of 1 atom of C and 2 atoms each of O and H. The mass of a molecule is computed by adding the mass of all the atoms in the molecule.
For instance molecular mass of C(OH)2  is 12*1+(16+1)*2 = 46.

Write a method that will take the formula of an organic compound as a string, and return its mass. For Example - CHOC(CH3)3 the string provided as input will be “CHOC(CH3)3”. 
Note that the molecule of an organic compound is only limited to atoms of C=12, O=16, H=1.
