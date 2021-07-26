___Rest Api
This repository contains the REST API developed for a marketplace.

___Development
Technologies Used: Spring Boot,Spring Security, PostgreSQL, JPA & Hibernate
API development: Swagger

URL
http://localhost:8080/swagger-ui.html

____Endpoints:
Register a new user
POST   /api/v1/registration

{
"email": "string",
"password": "string",
"username": "string"
}
___GET all products 
GET /productAll

page size: the number of products on a given page
###CRUD
In order to be able to use it, all you have to do is log in
#####Create a new Products:

/api/v1/products


For create a new product you need to  be login

{
"name": "string",
"price": 0
}
___Show all product by user
Just click run The application has already saved the login user

___Update the product
/api/v1/products/{id}

Enter the product id you want to update

Example: 44

and:
{
"name": "string",
"price": 0
}
___Delete the product
Enter the ID of the product you want to delete

Example : 44

___Like/Unlike
/api/v1/liked/like

/api/v1/liked/dislike

Just enter the ID of the product you want to appreciate. It is not possible to appreciate your own product





