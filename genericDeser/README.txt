CS542 Design Patterns
Fall 2016
PROJECT <5> README FILE

Due Date: <Thursday, December 15, 2016>
Submission Date: <Monday, December 12, 2016>
Grace Period Used This Project: <2> Days
Grace Period Remaining: <3> Days
Author(s): <Yunpeng Ge>
e-mail(s): <yge6@binghamton.edu>


PURPOSE:

  Learn comparing objects in Java and Java reflection.

PERCENT COMPLETE:

  I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:

  I believe there should not be anything uncompleted.

BUGS:

  None.

FILES:

  /src/genericDeser/driver/
  Driver.java

  /src/genericDeser/fileOperations/
  FileProcessor.java

  /src/genericDeser/util/
  First.java
  Second.java
  Logger.java
  PopulateObjects.java

  build.xml

  README.txt

DATA STRUCTURE:
  HashMap. As we need to count the number of unique objects and total number of objects, HashMap is a good choice to store these objects. The key of HashMap can store the object and the value of HashMap can count the number of the object.

TIME COMPLEXITY:
  O(n).

SPACE COMPLEXITY:
  O(n).

SAMPLE OUTPUT:

  [a…@a…-mac:~/…/bin]$ ant run -Darg0=input-1.txt -Darg1=0  

  Buildfile: /Users/aofengg/Documents/workspace/genericDeser/build.xml

  prepare:

  genericDeser:
    [javac] Compiling 1 source file to /Users/aofengg/Documents/workspace/genericDeser/BUILD/classes

  jar:
      [jar] Building jar: /Users/aofengg/Documents/workspace/genericDeser/BUILD/jar/genericDeser.jar

  run:
     [java] Number of unique First objects: 4952
     [java] Total Number of First objects: 4952
     [java] Number of unique Second objects: 5018
     [java] Total Number of Second objects: 5048

  BUILD SUCCESSFUL
  Total time: 1 second

TO COMPILE:

  ant genericDeser

TO RUN:

  ant run -Darg0=input-1.txt -Darg1=0 

ACKNOWLEDGEMENT:

  I finished this project totally by myself.
