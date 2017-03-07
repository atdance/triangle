# Checks if three values can represent the side lengths of a valid triangle. Also determinates which kind of triangle it could be.

## INSTALLATION REQUIREMENTS
Java JVM 8 .

## FRAMEWORKS USED
- Java SE 8
- Maven & Git
- Junit

## DESIGN
- We do not need a Triangle type as I do not need to operate on it like
 calculating perimeter area or angles. A Triple type is sufficient.
- Use Java SE 8 new constructs but keeping code easy to read.
-  The test cases as well comments in the source code constitute a manual for other programmers.
 
## USAGE
You can run the test cases with JUnit.   

## LIMITATIONS
The field MAX_ALLOWED_LENGTH puts a limit to the maximum allowed length
 of  each candidate side of a triangle.
 
 
## API AND ERRORS
The API consists of the method String triangleType() in class Triple.
The Enum Type and Enum Error are also part of the API.
- The Strings of Enum Type "EQUIL", "ISO", "SCA" are returned to the client if the three input values can validly represent a triangle.
- The String "NO_TRIANGLE" or OUT_OF_RANGE is otherwise returned to the client. It is up to the client how to handle this.
- each enum contains messages. The client can decide to present these messages to users. 
