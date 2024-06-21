# Assignment: Spring Data Jpa with MySql

In this assignment, you will create a Spring Boot application that utilizes Spring Data JPA and MySQL to perform CRUD (Create, Read, Update, Delete) operations on a simple entity called "Product." You will be provided with the necessary dependencies and a basic project structure, and your task is to implement the missing components, write RESTful API endpoints, and test the application.

## Instructions:

### 1. Project Setup:

You will receive a starter project with a basic pom.xml file and a Spring Boot application structure.
- Add the required dependencies for mysql connector and data jpa.
- Ensure that you have Java 17 installed on your system.
### 2. Database Configuration:

Create a MySQL database for the application.
Update the application.properties file with the appropriate database connection details.
### 3. Entity Class:

Create an entity class named "Product" with the following attributes:
- id (auto-generated)
- name (String)
- price (double)
### 4. Repository Interface:

Create a repository interface for the "Product" entity by extending the Spring Data JPA JpaRepository. Also create custom query to find all products having price less than specified price given by user. This interface will provide basic CRUD methods.
### 5. Service Class:

Implement a service class for "Product" with the following methods:
- getAllProducts: Retrieve all products from the database.
- getAllProductsHavingPriceLessThan: Retrieve all products from the database having price less than some specified price given by user.
- getProductById: Retrieve a product by its ID.
- saveProduct: Save a new product and return the same product as response.
- updateProduct: Update an existing product by its ID and return the same as response.
- deleteProduct: Delete a product by its ID and return the response as "Product Deleted".

### 6. Controller:

Create a RESTful controller for the "Product" entity and return response as ResponseEntity.
- Define the following endpoints and methods:
- GET /products: Retrieve a list of all products.
- GET /products/{price}: Retrieve a list of all products having price less than specified price.
- GET /products/{id}: Retrieve a product by its ID.
- POST /products: Create a new product.
- PUT /products/{id}: Update an existing product.
- DELETE /products/{id}: Delete a product by its ID.

Use a tool like Postman or CURL to test your API endpoints.