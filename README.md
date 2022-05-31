# Weather API

The application shows weather in one or more entered cities.


## Functionality  
- SpringBoot.
- Search and display temperature, city , country and weather information in the UI. 
- Error Handling 
- Fault tolerance (ConnectTimeout Time-out in case of API takes more time to respond)
- Junit testing
- Logging 

## Java
1. Java 11
2. Maven 



## Api endpoints
Http GET endpoints:
1. http://localhost:8080/rest/v1/weather-info/city?name=Stockholm

2. Response body

``` 
{
    "id": 2673730,
    "temperature": -1.64,
    "country": "SE",
    "city": "Stockholm",
    "weather": "Clouds"
}
```

