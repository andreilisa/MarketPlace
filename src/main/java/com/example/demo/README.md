#Rest Api
____
*This repository contains the REST API developed for a marketplace.*

##Development
____
Technologies Used: 
1. Spring Boot 
2. Spring Security 
3. PostgreSQL
4. JPA & Hibernate

API development: Swagger


##URL
*http://localhost:8080/swagger-ui.html*

##Endpoints:
1. Create Product
2. Show Products
3. Edit Product
4. Delete Product
5. List products
6. List my-products
7. Like/Unlike

###Register a new user

*/api/v1/registration*
````
{
"email": "string",
"password": "string",
"username": "string"
}
````
###GET all products 
*/productAll*

page size: the number of products on a given page
##CRUD
In order to be able to use it, all you have to do is log in

###Create a new Products:

*/api/v1/products*


For create a new product you need to  be login
````
{
"name": "string",
"price": 0
}
````
###Show all product by user
Just click run The application has already saved the login user

###Update the product
*/api/v1/products/{id}*

Enter the product id you want to update

Example:  id = 44
````
{
"name": "string",
"price": 0
}
````
###Delete the product

Enter the ID of the product you want to delete

Example : id =  44

##Like/Unlike
*/api/v1/liked/like*

*/api/v1/liked/dislike*

Just enter the ID of the product you want to appreciate. It is not possible to appreciate your own product





