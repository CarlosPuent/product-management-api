# Product Management API

## Project Description
The Product Management API is a comprehensive system designed to manage products, categories, brands, and models for an auto parts sales company. It provides endpoints for CRUD operations on products, categories, brands, and models, with a clean and professional structure that follows best practices and design patterns.

## Features
- Manage Products, Categories, Brands, and Models
- Many-to-Many relationships between Products and Categories, Products and Brands
- RESTful API with detailed endpoints for each operation
- Error handling with custom exceptions and global exception handling
- Data validation using Hibernate Validator
- Swagger documentation for easy API testing and interaction

## Technologies Used
- Java 21
- Spring Boot 3.3.0
- Spring Data JPA
- Hibernate
- MySQL
- MapStruct
- Lombok
- Swagger
- Maven

## Getting Started

### Prerequisites
- JDK 21
- Maven
- MySQL Database

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/CarlosPuent/product-management-api.git
    cd product-management-api
    ```

2. Configure the MySQL database in `application.yml`:
    ```yaml
    spring:
      datasource:
        url: jdbc:mysql://localhost:3306/your_database_name
        username: your_username
        password: your_password
    ```

3. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Documentation
Swagger UI is available for easy testing and interaction with the API.

- [Swagger UI](http://localhost:8080/swagger-ui.html)
- [API Docs](http://localhost:8080/v3/api-docs)

### Usage Examples
#### Create a Product
**Endpoint:** `POST /api/products`

**Example Request URL:**
```plaintext
http://localhost:8080/api/products
Example Request Body:
{
    "name": "Oil Filter",
    "description": "High quality engine oil filter.",
    "price": 17.25,
    "category_ids": [5],
    "brand_ids": [4],
    "models": [
        {
            "name": "Model A",
            "description": "Description for Model A"
        },
        {
            "name": "Model B",
            "description": "Description for Model B"
        },
        {
            "name": "Model C",
            "description": "Description for Model C"
        }
    ],
    "status": "ACTIVE",
    "code": "ELE004"
}
```
#### Update a Product
**Endpoint:** `PUT /api/products/{id}`

**Example Request URL:**
```plaintext
http://localhost:8080/api/products/12
{
    "name": "Oil Filter",
    "description": "High quality engine oil filter.",
    "price": 17.25,
    "category_ids": [5],
    "brand_ids": [4],
    "models": [
        {
            "name": "Model A",
            "description": "Description for Model A"
        },
        {
            "name": "Model B",
            "description": "Description for Model B"
        },
        {
            "name": "Model C",
            "description": "Description for Model C"
        }
    ],
    "status": "ACTIVE",
    "code": "ELE004"
}
```
### Contributing
Feel free to contribute to this project by opening issues and submitting pull requests. Please ensure that your changes are well-tested and follow the existing code style.

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Contact
For any inquiries or feedback, please contact Carlos Puent.
