# Pizza order management - Order placement API and Manage Inventory APIs



#### Web URL for H2 Database and Swagger UI End Points
For H2 DataBase Console - http://localhost:8181/console

Swagger UI Url for all the API End-points  - http://localhost:8181/swagger-ui.html#/

#### PostMan Request URL (Input test data)
https://www.getpostman.com/collections/df64066eb78853866673

#### Step to run (required gradle install in the machine)
these are the commands needs to run 

$ sudo gradle build --stacktrace
$ sudo gradle bootRun

Or go to the project folder and run these command
$ ./gradlew
$ ./gradlew bootRun

The above command will start the project in machine on port 8181 

#### TroubleShooting - 
1. This project requires Lombok , Please download lombok either for eclipse or intellj as per lombok website

2. gradle build failing test cases - In this scenerio 
Execute the server on one terminal using 'gradle bootRun' on one terminal and run the test cases on another terminal using 'gradle test'

