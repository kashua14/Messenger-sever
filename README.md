# Realtime Messaging App API

This project uses spring-boot framework and it is basically a back-end project. 

Incase you want to have some visual on the this API then I will suggest you go to [Realtime-Messaging-App-UI](https://github.com/kashua14/MESSENGER). In that repo you will have the UI that is implemented in ReactJS.

## How to Set it up

- First clone the repo onto your machine.
- Open the cloned folder from your favourite editor (Mine is eclipse).
- ## For Eclipse IDE Users: 
    - After lauching your IDE, select `File` in the top left corner of the IDE.
    - In the drop down list select `import..` an dialog will appear.
    - In the dialog select `Existing Maven Projects`, then click on the `Next >` button.
    - Browse to the folder which contains the cloned repo after which click on the `Finish` button at the bottom of the dialog.
    - Open your [Xampp](https://www.apachefriends.org/index.html) and start your Apache and MySQL servers from the Xampp control panel.
    - Navigate to your PHPMyAdmin and create a database where your data will be stored.
    - Navigate to the `application.properties` file found in the `src/main/resources` folder. 
    - Change the following lines of code to your appropriate configurations.
        ```
        spring.datasource.url= jdbc:mysql://localhost:3306/<database-name>?useSSL=false&serverTimezone=Africa/Kampala&useLegacyDatetimeCode=false
        spring.datasource.username= // username of your database E.g. root 
        spring.datasource.password= // password of your database E.g. leave it blank incase you don't have one 
        ```

    - Right click on the root folder and select  `Run As`  then select `Java Application`.
    - Vola!  🎉🎉 you application should be up and running now you can use either [Postman](https://www.postman.com/) or [Paw](https://paw.cloud/) to make requests to the API you have created.

### Note: 
- Replace `<database-name>` in the database url field with the name of your database you created earlier on in the steps.
- The Eclipse IDE used when creating this readme is Eclipse IDE for Java Developers (includes Incubating components)
Version: 2020-12 (4.18.0)
Build id: 20201210-1552
