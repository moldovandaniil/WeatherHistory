This guide is a brief description of how to set up the WeatherHistory project :)

STEP 1.
Have IntelliJ Ultimate installed (or any other IDE that supports Java EE with Tomcat)

STEP 2.
Have Tomcat 9.0 installed.

STEP 3.
Have PostgreSQL installed with the pgAdmin client. Remember the username and password for the login (you will need them further). Create a new database and remember the name, localhost and the port (e.g. jdbc:postgresql://localhost:5432/weather_reports)

STEP 4.
Clone the project in your environment. Access the persistence.xml file and change the jdbc.url, user and password values (from STEP 3).

STEP 5. 
Add the tomcat configuration (if you didn't do it beforehand) and run the project. The home page will be a form which let's you type in the postal code. The postal code should have the USA format (5 numbers), since one of the project's tasks was to validate the input (worldwide postal codes don't have a standard, so I limited it only to the US format).

In case the postal code input was correct, you will be met with another page, which shows the current weather prognosis and the history of the previous requests with the same postal code. Each time you do a new request, it is automatically saved in the database and therefore will be shown in the history.

In the case of a bad input or API fail, you will be met with the respective error messages in the home page.

In the test package, there is a test that mocks the WeatherApiService.

STEP 6.
You can test the endpoints using Postman or another application. The results will be exactly the same as requested.
POST mydomain/weather
{
"postalcode": "123456"
}
Responds with weather condition
GET mydomain/weather/history?postalcode=123456
Responds with all weather conditions fetched for postalcode so far



P.S: The API key and URL are public so they are located in static final variables in the code, so you don't have to worry about them.


