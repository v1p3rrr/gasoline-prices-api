# Gasoline Prices API

## Project Overview
The Gasoline Prices API is a Spring Boot-based application made for Hackathon mobile application and designed to track and provide information about gasoline prices across different cities. It offers a RESTful interface for accessing gasoline price data, including historical prices and city-specific details.

## Technology Stack
- Spring Boot
- PostgreSQL/H2
- Lombok
- ModelMapper

## Key Features
- Retrieve a list of cities where gasoline prices are tracked.
- Get gasoline prices for a specific city.
- Fetch gasoline prices for a city within a specified date range.
- Access historical price data for different types of gasoline.

### Accessing the API
- `GET /price/cities`: List all cities.
- `GET /price/{city}`: Get prices for a specific city.
- `GET /price/{city}/date-range/{dateStart}/{dateEnd}`: Get prices for a city within a date range.
- `GET /price/{city}/date/{date}`: Get prices for a city on a specific date.