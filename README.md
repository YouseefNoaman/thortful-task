# thortful-task
Task for a senior software engineer


To run the spring boot app use the command: docker-compose up --build -d
To stop it use: docker compose down

The docker compose contains the spring boot app & zipkin for visibility.

Access swagger: http://localhost:8080/swagger-ui.html

Access zipkin: http://127.0.0.1:9411/


Design choices:

USED advice API: https://api.adviceslip.com/#endpoint-search

Used reactive programming to develop the call to the advice API, as from my interview and what I learned, something scalable and serves lots of users concurrently is needed, and also the API call is about getting data, so this seemed like a perfect fit to use reactive programming, coupled with caching, I find this solution to help with the cases we talked about.
