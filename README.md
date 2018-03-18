# assignment-3-Gayatri27
assignment-3-Gayatri27 created by GitHub Classroom



Computer Science Department
San Francisco State University
CSC 413  Spring 2018
Assignment 3 - Modify the Parser


GitHub repository link:
https://github.com/sfsu-csc-413-spring-2018/assignment-3-Gayatri27



Compiling and Run instructions

javac lexer/setup/TokenSetup.java
java lexer.setup.TokenSetup
javac compiler/Compiler.java
java compiler.Compiler filename.x



BY

Gayatri Pise	917922296	gpise@mail.sfsu.edu









1.Project Introduction

This assignment is to understand the functioning of parser in the java compilation process. The lexical analyzer reads input characters of the source program and categorize them into sequence of lexical tokens to feed into the parser. Parsing is the process of analyzing a stream of symbols to determine if it conforms to the grammar for the language. Parsers takes the output of the lexical analyzer and operates by analyzing the sequence of tokens. Tokenizing is handled by the Parser. The parser’s output is an abstract syntax tree (AST) representing the abstract syntactic structure of the source code. AST is a representation of the source program in a form that is convenient for subsequent processing. Each node of the tree denotes a construct occurring in the source code.
In this assignment, we are adding additional tokens to perform lexical analysis of the x-language compiler. The list of tokens available to the Lexer are listed in tokens file. Then, we modify the parser to process the additional tokens, add new grammar rules and generate abstract syntax tree.


2. Execution and development environment described 
The Parser is coded in java language. Java is a programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible. JVM is a computing machine which enables the computer to run a Java program. For compiling and execution, Java source code is compiled into bytecode when we use the javac compiler. The bytecode gets saved on the disk with the file extension .class. When the program is to be run, the bytecode is converted using the compiler. The result is machine code which is then fed to the memory and is executed. 

We use the following java development environment for our application.

 

3. Scope of work

The scope of work included the below three requirements for this assignment: -

Requirement	Status
1.	Modify the Parser to accommodate new grammar	          Completed  
2.	Remove debug statements and make output as expected	Completed
3.	Implement the Offset algorithm	Incomplete



4. Command line instructions to compile and execute

javac lexer/setup/TokenSetup.java
java lexer.setup.TokenSetup
javac compiler/Compiler.java
java compiler. Compiler filename.x

Example :-
javac lexer/setup/TokenSetup.java
java lexer.setup.TokenSetup
javac compiler/Compiler.java
java compiler. Compiler sample_files/simple.x

5. Assumptions 

•	The project folder structure remains same as compiling and executing instructions.
•	The number of input files given to the Compiler is one. 
•	The input file provided from command line is available in sample_files folder.
•	TokenSetup is always executed before Compiler.



6. Class diagram with hierarchy


The class diagrams for this assignment is as below:


 


 









7. Implementation decisions

•	The TokenSetup class is responsible for reading tokens from the tokens file and generating TokenType and Tokens classes. TokenType class is a hashmap to map tokens and symbol. Tokens class is the enum of available Tokens.
•	SourceReader class is responsible to read the input file. The file is scanned by a BufferedReader. The position of the Token/Identifier and the line number is saved in the SourceReader. The file printout is also performed by SourceReader.
•	The entry point of the program is the Compiler class which executed the method compileProgram(). It first creates a parser object and validates if the code statements and tokens align to the grammar of the language. The output of the parser is the abstract syntax tree (AST).
•	The AST output from Parser is fed to the the ASTVisitor classes. The subclasses to ASTVisitor are PrintVisitor, CountVisitor, DrawVisitor, OffsetVisitor, DrawOffsetVisitor.
•	PrintVisitor prints the AST output to command prompt, DrawVisitor creates the AST tree on a swing JFrame.  The DrawOffsetVisitor prints the formatted AST output tree on the JFrame.



8. Code Organization

The entire project is organized in the below file structure.



9. Conclusion

•	The Compiler successfully reads file name from the command line and outputs usage if no file name is found.
•	Additional grammar, Types and Identifiers were added to the Parser.
•	The Parser processes “for statement” present in the input and generates corresponding abstract syntax tree (AST).
•	Compiler output was formatted as per the requirement in the assignment.
•	AST is printed on command prompt as well as JFrame.
•	AST output was validated for various input of code snippets.
•	This assignment is completed following the object-oriented concepts.
•	The Offset Algorithm to get the formatted AST was challenging to implement. 
•	This assignment helped me to learn about the concept of inheritance and polymorphism from the ast and visitor packages in the source code. 
