#Login-and-Signup-in-Android


**Description**:

I have developed below three modules in android:

- User Signup 
- User Login 
- Initial Setup (Welcome Screen) 

The User Signup module creates a new user in the SQLite database. Once registered, users can login with their credentials. 
After the user logs in, he will be redirected to the initial setup page.

I have made use of following components while developing this project (as per the requirement):

- Toast messages – Used toast messages to display errors (like ‘username and/or password don’t match’, ‘All fields are required’) and success messages like ‘Registration success!!’. 

- TextViews – Used text views as an input fields for Email, Password, Full Name, age and telephone number. 

- ImageButtonView – On click of this component, user gets option to add his recurring bills) please note that storing this bills data in the database is a future scope ). 

- Buttons – Use standard buttons that enables user to sign up, log me and logout from the application. 

- Dialogs- User gets an alert dialog box when the logout button is pressed. On clicking ‘yes’, user is logged out from application. 

- Action Bar – The logout button is placed over the action bar using menu inflater. 

- Fragments – Used fragment to provide a lightweight UI throughout the application (explained later) 

- Activities – Each Activity will hold one fragment (explained later). 

- Intents – used two intents which are intended to load the login fragment and pass data (user information) from the login activity to initial setup activity. 

- SQLite database - The user details are stored and retrieved from a SQLite database.


Components Used:

- Activities
 - LoginActivity
 - SignUpActivity
 - InitialSetupActivity


- Fragments
 - LoginModuleFragment
 - SignUpModuleFragment
 - InitialSetupModuleFragment
 
- Intents
 - LoginIntent (Explicit)
 - InitialSetupIntent(Explicit)

Detailed explanation as to why and where the intents and fragments are used can be found below.

**Workflow**:

1.**Activity#1 – Main Activity** 

The Main Activity is responsible for holding the framelayout. This framelayout stands as a base for storing both the login and signup fragments. 

2.**Intent#1- LoginIntent(Explicit)**

When the onCreate () function of the Main Activity is invoked, an intent is created that is responsible for calling the Login Activity. This new intent simply loads the login activity. This serves as the start point in the application. 

3.**Activity#2 – Login Activity**

The Login Activity is responsible for holding the login fragment. When the onCreate() function for this activity is executed, we can see that the fragment container adds a new fragment to the framelayout as seen above. 

4.**Fragment#1- LoginFragment**

This is a part of the LoginActivity. The Login Fragment consists of Linear layout that is responsible for creating the text views and the login and signup buttons. On clicking signup, the Signup Activity is loaded. 

5.**Activity#2-SignUpActivity** 

Once the onCreate() method is called, the previously called login fragment is replaced by the signup fragment. This is done with the help of fragment manager and fragment transaction.

6.**Fragment#2-SignUpFragment**

This is a part of the SignUpActivity. The sign up fragment consists of components like the fullname, password, age, contact number, etc. These are the EditText data structures. 

7.**SQLite database**

- The SQLite database is used in the Signup and the Login activities. 
- When the user registers, the details are saved in the SQLite database. 
- This data includes the user fullname, password, age, emailed and the contact number. When the user tries to login, a select query is triggered by the LoginActivity which in turn check if the user exists in the database and displays next screen accordingly. 
- The database name is *userdata.db* and the table name is *userdetails*.
- The database file can be located via the Android Device monitor as below: 
- 
<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/db%20file%20location.png" width="300" height="400" style="max-width:100%;">

- **The table schema**
<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/table%20schema.png" width="300" height="400" style="max-width:100%;">

- **Table data**
- <img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/table%20data.png" width="300" height="400" style="max-width:100%;">

8.Once user signs up, the user data is stored in the database and user is redirected back to the
login screen. User will however, get a toast notification saying that the registration was
successful.

9. Finally, user can register with the credentials he has inserted.

10.**Intent#2- InitialSetupActivity(Explicit)**
When the user logs in successfully, it is essential to get certain user records (username in this
case). There is a mechanism to get this data from the database and pass it to the setup
activity. For this purpose, I have used an explicit intent to load the InitialSetupActivity. The
username is passed with the help of “putextra” function.

11.**Activity#3-InitialSetup**
Once the user logs in, the second intent is created. Using the putextra function, the
username is passed to the initialsetup activity. The initialsetup activity will then load the
fragment#3 – The InitialSetupFragment.

12.**Fragment#3-InitialSetupFragment**
This is a part of the InitialSetupActivity. In this final fragment, user can do some initial setups
like:
1. Entering the monthly salary.
2. Adding recurring bills.

**13.The logout actionbar and alert dialog box**
I have created an actionbar using the MenuInflater option. On clicking the logout
button, user gets an alert dialog box. If user selects No, nothing happens. In the other
case, the activity is finished and the user is redirected back to the login page.

**Screenshots of the application:**
Below are the screenshots of the application from the Nexus emulator.

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/Log%20in%20page.png" width="300" height="400" style="max-width:100%;">

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/Sign%20Up%20page.png" width="300" height="400" style="max-width:100%;">

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/ToastMessageSignup.png" width="300" height="400" style="max-width:100%;">

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/Successfully%20Registered.png" width="300" height="400" style="max-width:100%;">

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/WelcomeMessage.png" width="300" height="400" style="max-width:100%;">

<img src="https://github.com/sagardafle/Login-and-Signup-in-Android/blob/master/Screengrabs/LogoutDialog.png" width="300" height="400" style="max-width:100%;">

