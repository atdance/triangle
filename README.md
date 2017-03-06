# Checks if three values can represnt the side lengths of a valid triangle. Also determinates which kind of triangle if could be.

## INSTALLATION REQUIREMENTS
Java JVM 8 .

## Frameworks used
- Java SE 8
- Maven & Git
- Junit

## DESIGN
- We do not need a Triangle type as I do not need to operate on it like
 calculating perimeter area or angles. A Triple type is sufficient.
- Use Java SE 8 new constructs but keeping code easy to read.
 
## USAGE
You can run the test cases with JUnit.   

## LIMITATIONS
The field MAX_ALLOWED_LENGTH puts a limit to the maximum allowed length
 of  each candidate side of a triangle.
 
 
## API AND ERRORS
The API consists of the method String triangleType() in class Triple.
The Strings "EQUIL", "ISO", "SCA" are returned to the client if the three input values can validly represent a triangle.
The String "NO_TRIANGLE" is otherwise returned to the client . It is up to the client how to handle this.
