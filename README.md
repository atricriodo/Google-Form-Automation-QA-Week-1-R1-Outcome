# **<span style="text-decoration:underline;">QA Assignment - Automate Google Forms</span>**


### **Introduction**

Automate and fill a google form.

[Template link](https://docs.google.com/spreadsheets/d/19kyX9JoKm2pJON4qpD1yHI_i_rGQIc7LbM-2yO8832g/edit#gid=0)


### **Scenario**



1. Navigate to [this google form](https://forms.gle/wjPkzeSEk1CM7KgGA).

2. Fill in your name in the 1st text box

3. Write down “I want to be the best QA Engineer! **1710572021**'' where _1710572021_ is variable - needs to be the current epoch time. Read more about it [here](https://www.epochconverter.com/#:~:text=days%2C%20hours%2C%20minutes-,What%20is%20epoch%20time%3F,-The%20Unix%20epoch).

4. Enter your Automation Testing experience in the next radio button

5. Select Java, Selenium and TestNG from the next check-box

6. Provide how you would like to be addressed in the next dropdown

7. Provided the current date minus 7 days in the next date field, it should be dynamically calculated and **not** hardcoded.

8. Provide the current time (Keeping in mind AM/PM) in the next field

9. Try going to another website (amazon.in) and you will find the pop up as follows. Click on **cancel**.

10. Submit the form

11. Print the message upon successful completion

### **Validations**



* Ensure your code is properly commented - **We will check the code quality**.
* Ensure you push your code after each step mentioned prior - **We will check each commit**
* Ensure each of the following are separate methods with wrappers - **We will check modularity**
    * Filling in text boxes
    * Ticking a check-box or radio button
    * Selecting from dropdown
    * Filling the date field
    * Filling the time field
    * Handling alert


### **Follow up Questions**



* How did you calculate the EPOCH time within the code?
* How did you handle drop-downs in the given assignment?
* How did you parse the date and time in the given assignment?
* How did you handle the alert in the given assignment?