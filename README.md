# CafePunch
CSIT314 Project - cafe management system

How to run locally?

1. Go to https://spring.io/tools
2. Choose the tools you want to download (I am using Spring Tool for Visual Studio Code) and install the tools
3. Download & Install MAMP
4. Once install, check the port number for your sqlServer (MAMP>Preferences>Ports) Eg. MYSQL Port 3306
5. Open the project in your IDE tools (eg. Visual Studio Code)
6. Change to your port number at the application.properties (eg. spring.datasource.url=jdbc:mysql://localhost:3306/cafePunchDB)
7. Make Sure your MAMP mySQL server is running
8. Import the sql script(cafepunchdb.sql) into your db.
9. Try to Run the Program
