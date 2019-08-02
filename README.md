 
# Weather REST API
REST API developed in Java with Spring Boot in order to provide information on weather information.

## Summary

This API was all developed in Java 8 and Spring Boot in order to demonstrate an application example where, from the name of a city look for weather's information regarding that city based on the following metrics:
- Average of daily (06:00 - 18:00) and nightly (18:00 - 06:00) temperatures in Celsius for the next 3 days from today's date.
- Average of pressure for the next 3 days from today's date.

## API documentation and Test of user
I have used Swagger2 from maven dependency for documentation of API.
To check maven, once application is up then go to console and hit url 'http://localhost:8080/weather/swagger-ui.html', where you find Forecast controller and click on that.
Now click on 'try-it-out'. Enter city name as you want.
For example city 'Ahmedabad' as per below response.

```
[
  {
    "date": "2018-11-04",
    "daily": 10.65,
    "nightly": 9.65,
    "pressure": 10.31
  },
  {
    "date": "2018-11-05",
    "daily": 12.58,
    "nightly": 9.52,
    "pressure": 11.05
  },
  {
    "date": "2018-11-06",
    "daily": 13.71,
    "nightly": 11.76,
    "pressure": 12.74
  },
  {
    "date": "2018-11-07",
    "daily": 13.84,
    "nightly": 13.53,
    "pressure": 13.68
  }
]
```
As you can see, the return is a list of objects with information from the next three days (including current). This information is:
- `date`: Reference date.
- `daily`: Average of daily (06:00 - 18:00).
- `nightly`: Average of nightly (18:00 - 06:00).
- `pressure`: Average pressure on day.

**_ps. temperatures in Celsius_**

This test can also be performed by a specific tool for REST calls, in my case I used Postman. The API test linke we developed is obtained by the code below:
```
curl -X GET 
"http://localhost:8080/weather/forecast/city?city=Ahmedabad" 
-H "accept: application/json"
```

# Run and Test
The maven version used was 3.5.3 and the commands for testing, compiling, installing, cleaning, package, etc. are those used by maven. Follow the documentation: https://maven.apache.org/guides/getting-started

`ex. Test = mvn test`

