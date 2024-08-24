# Makersharks Supplier Search API

Welcome to the Makersharks Supplier Search API project! This API allows buyers to search for manufacturers based on customized requirements. This README provides detailed instructions on how to set up, run, and use the API.

## Table of Contents
1. [Project Overview](#project-overview)
2. [Getting Started](#getting-started)
3. [API Endpoints](#api-endpoints)
4. [Running the Application](#running-the-application)
5. [Testing the API](#testing-the-api)
6. [Configuration](#configuration)
7. [Database Initialization](#database-initialization)

## Project Overview

The Makersharks Supplier Search API allows you to retrieve a list of manufacturers based on:
- Location
- Nature of business
- Manufacturing processes

This is a proof-of-concept API built using Spring Boot.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- H2 Database (for development and testing)
- Postman (for sending Requests)

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/yourusername/makersharks-supplier-api.git
    cd makersharks-supplier-api
    ```

2. **Build the Project:**

    ```bash
    mvn clean install
    ```

## API Endpoints

### 1. Query Suppliers

- **URL:** `/api/supplier/query`
- **Method:** `POST`
- **Description:** Retrieves a list of manufacturers based on the provided criteria.
- **Request Headers:**

    ```http
    Content-Type: application/json
    ```

- **Request Body:**

    ```json
    {
        "location": "India",
        "natureOfBusiness": "SMALL_SCALE",
        "manufacturingProcesses": ["_3D_PRINTING"],
        "page": 0,
        "size": 10
    }
    ```

- **Response:**

    ```json
    [
        {
            "supplierId": 1,
            "companyName": "ABC Manufacturing",
            "website": "http://abc.com",
            "location": "India",
            "natureOfBusiness": "SMALL_SCALE",
            "manufacturingProcesses": ["_3D_PRINTING"]
        },
        ...
    ]
    ```

## Running the Application

1. **Run the Spring Boot Application:**

    ```bash
    mvn spring-boot:run
    ```

2. **Access the API:**

    The API will be available at `http://localhost:8080`.

## Testing the API

You can use tools like `curl`, Postman, or any HTTP client to test the API. Here are some example `curl` commands:

### Example `curl` Commands

1. **Query Suppliers:**

    ```bash
    curl -X POST "http://localhost:8080/api/supplier/query" \
    -H "Content-Type: application/json" \
    -d '{
        "location": "India",
        "natureOfBusiness": "SMALL_SCALE",
        "manufacturingProcesses": ["_3D_PRINTING"],
        "page": 0,
        "size": 10
    }'
    ```
    ### Example `PowerShell` Commandd

2. **Query Suppliers:**

    ```bash
    Invoke-RestMethod -Uri "http://localhost:8080/api/supplier/query" `
    -Method Post `
    -Headers @{ "Content-Type" = "application/json" } `
    -Body '{
        "location": "India",
        "natureOfBusiness": "SMALL_SCALE",
        "manufacturingProcesses": ["_3D_PRINTING"],
        "page": 0,
        "size": 10
    }'
    ```

## Configuration

Configuration for the application is specified in the `application.properties` file.

- **Database Configuration:**

    ```properties
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password

    spring.h2.console.enabled=true
    spring.h2.console.path=/h2-console
    ```

- **Logging Level:**

    ```properties
    logging.level.com.makersharks.supplierapi=INFO
    ```

## Database Initialization

The H2 in-memory database is used for development and testing. The schema and initial data are defined in `schema.sql` and `data.sql`.

- **Schema File (`schema.sql`):**

    ```sql
    CREATE TABLE SUPPLIER (
        SUPPLIER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
        COMPANY_NAME VARCHAR(255) NOT NULL,
        WEBSITE VARCHAR(255),
        LOCATION VARCHAR(255) NOT NULL,
        NATURE_OF_BUSINESS VARCHAR(50) NOT NULL
    );

    CREATE TABLE SUPPLIER_PROCESSES (
        SUPPLIER_ID BIGINT NOT NULL,
        PROCESS VARCHAR(50) NOT NULL,
        FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID)
    );
    ```

- **Data File (`data.sql`):**

    ```sql
    INSERT INTO SUPPLIER (COMPANY_NAME, WEBSITE, LOCATION, NATURE_OF_BUSINESS) VALUES ('ABC Manufacturing', 'http://abc.com', 'India', 'SMALL_SCALE');
    INSERT INTO SUPPLIER_PROCESSES (SUPPLIER_ID, PROCESS) VALUES (1, '_3D_PRINTING');

    -- Additional sample data...
    ```


---

If you have any questions or need further assistance, please reach out to the project maintainers.
