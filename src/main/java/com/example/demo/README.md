# Rest Api

____
# This repository contains the REST API developed for a marketplace.
____
# Development

Technologies Used:

1. Spring Boot
2. Spring Security
3. PostgreSQL
4. JPA & Hibernate

API development: Swagger

----
## Requirements
For building and running the application you need:
* JDK 1.8
* Maven 
----
## Run the app
1. Fork this repository and clone it
`````
https://github.com/andreilisa/MarketPlace
`````
2. Navigate into the folder
````
cd MarketPlace-master
````
3. Install dependencies
````
mvn install
````
4. Run the project
````
mvn spring-boot:run
````
----
## URL
*http://localhost:8080/swagger-ui.html*

----

## PostgreSQL DB
````
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/web_db
spring.datasource.username=postgres
spring.datasource.password=******
server.port=8080
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.error.whitelabel.enabled=false

````
----
## Endpoints:

1. Create Product
2. Show Products
3. Edit Product
4. Delete Product
5. List products
6. List my-products
7. Like/Unlike
----
## Register a new user

*/api/v1/registration*

````
{
"email": "string",
"password": "string",
"username": "string"
}
````
----
## GET all products

*/productAll*

page size: the number of products on a given page

----
## CRUD
#### In order to be able to use CRUD, all you have to do is login

----
### Create a new Products:

*/api/v1/products*

````
{
"name": "string",
"price": 0
}
````
----
### Show all product by user

Just click run the application has already saved the login user

----
### Update the product

*/api/v1/products/{id}*

Enter the product id you want to update

Example:  id = 44

````
{
"name": "string",
"price": 0
}
````
----
### Delete the product

Enter the product id you want to delete

Example : id = 44

----
## Like/Unlike

*Just enter the ID of the product you want to appreciate. It is not possible to appreciate your own product*

----
*/api/v1/products/like*

*/api/v1/products/dislike*

----




