#Teratext API

Command line application that allows several operations against a teratext database.
For example:

1. Counting records based on a query given by the user
2. Read a value and print it  based on a query given by the user
3. Update property for record in database
4. Delete a record in database
5. Counting records based on a query given by the user


##compile
``mvn clean package -P loc``

choose the profile after -P from:

*  loc
*  dev
*  test
*  prod

if you don't have teratext installed in your local computer you may skip tests:

``mvn clean package -P loc -Dmaven.test.skip=true``

##run
``java -jar target/teratext-api-v1.0-jar-with-dependencies.jar``

(change v0.1 to the actual version in the pom file)

##test
``mvn clean test``