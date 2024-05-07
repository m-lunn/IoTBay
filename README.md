# Branch Summary (so far)
* The structure of the project has been overhauled by creating subfolders to hold related files for better file management (e.g. model for javabeans files, controller for servlets, etc.).

* The servlet ConnServlet has been added and is initalised during the first launch of index.jsp to pass the DBManager class into the session. 
The DBManager class contains SQL queries that can be used throughout the entire project to save the hassle of rewriting the same queries in different parts of the project.

* The login and register jsp + servlet files have been modified to handle bad inputs during registration and login, introducing a new Utils class in the controller subfolder. Utils contains Regex pattern matching for this purpose.

* Customer and Staff subclasses of User have been added to the model. The database schema SQL file and relevant jsp files have been modified to account for customer/staff. Landing page now checks if the user is customer or staff and displays content accordingly. 

* Added the ability to log in as a system admin (email: "root", password: "iotbay").
