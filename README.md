# Product Management API

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Description

A Spring Boot-based Product Management API that provides RESTful endpoints for managing products, categories, brands, and models. Features include CRUD operations, Swagger API documentation for easy testing, and integration with MySQL. Ideal for managing inventory in a scalable and efficient manner.

## Features

- **CRUD Operations**: Manage products, categories, brands, and models.
- **Swagger API Documentation**: Easily test and explore API endpoints.
- **Database Integration**: Uses MySQL for data persistence.
- **Validation**: Includes validation for request data.
- **Error Handling**: Comprehensive error handling and reporting.

## Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Swagger / Springfox**
- **ModelMapper**
- **MapStruct**
- **Lombok**
- **Maven**

## Getting Started

### Prerequisites

- Java 21
- Maven
- MySQL

### Installation

## Usage Examples

Create a Product
Endpoint: POST /api/products

Example Request URL: http://localhost:8080/api/products
POST
Example Request Body:

json

{
    "name": "Oil Filter'",
    "description": "High quality engine oil filter 12345.",
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


Update a Product
Endpoint: PUT /api/products/{id}

Example Request URL: http://localhost:8080/api/products/12
PUT
Example Request Body:

json

{
    "name": "Oil Filter'",
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

1. **Clone the repository:**

   ```bash
   git clone https://github.com/CarlosPuent/product-management-api.git
   cd product-management-api

