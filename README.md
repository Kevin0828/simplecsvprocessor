# CSV Client Processor - README

## Overview

This project implements a CSV processor for processing client data into an in-memory H2 database. The system reads a CSV file containing structured client data, validates and transforms it, and stores it across multiple normalized tables (e.g., Client, Address, Contact, etc.). It also provides RESTful APIs to insert, retrieve, and update client records.

---

## Project Structure

```
├── src
│   ├── controller
│   ├── service
│   ├── repository
│   ├── model
│   ├── config
│   └── util
├── resources
│   └── clients.csv
└── README.md
```

---

## Features

### SIMPLECSV-1: Project Setup (1 day)

* Create Spring Boot project using Gradle.
* Add dependencies: Spring Web, Spring Data JPA, H2, Apache Commons CSV, Lombok.
* Configure H2 database in `application.properties`.
* Enable H2 web console for easy data inspection.

### SIMPLECSV-2: Define Data Models (1 day)

* Create entity classes:

    * `Client`: Represents a client with attributes like name, email, and phone.
    * `Address`: Linked to `Client`, stores street, city, state, and zip.
    * `Contact`: Optional secondary contact info.
    * `Company`: Represents the client’s associated business.
* Apply JPA annotations for table mappings and relationships.

### SIMPLECSV-3: Repositories (0.5 day)

* Create Spring Data JPA repositories for each entity.

### SIMPLECSV-4: Service Layer (0.5 day)

* Implement service layer methods:

    * Save clients with nested data.
    * Fetch client(s) with joins.
    * Update client or related data like address.
* Handle basic validation and business logic.

### SIMPLECSV-5: CSV Processing with Apache Commons CSV (1 day)

* Parse CSV file using Apache Commons CSV.
* Map CSV rows to DTOs.
* Perform data validation (e.g., required fields, proper formatting).
* Convert validated DTOs into entity objects.

### SIMPLECSV-6: CSV Upload Endpoint (1 day)

* `POST /clients/upload`
* Accepts multipart CSV file.
* Processes file, validates rows, stores valid entries in DB.
* Returns summary of inserted and failed rows.

### SIMPLECSV-7: Insert and Retrieve Clients (1 day)

* `POST /clients`: Add a single client with nested address/contact.
* `GET /clients`: Retrieve all clients.
* `GET /clients/{id}`: Retrieve one client by ID, with nested details.

### SIMPLECSV-8: Update APIs (1 day)

* `PUT /clients/{id}`: Full update of a client.
* `PATCH /clients/{id}/address`: Update only the address.
* Handles field-level validation and returns updated entity.

### SIMPLECSV-9: Testing and Cleanup (1 day)

* Create integration and unit tests.
* Validate endpoints with Postman.
* Finalize documentation and sample CSV.

---

## API Documentation

### 1. **Upload CSV**

`POST /clients/upload`

* Request: `multipart/form-data` with CSV file
* Response: Summary of inserted and failed records

### 2. **Insert Single Client**

`POST /clients`

* Body: JSON object with client data
* Response: Inserted client object

### 3. **Get All Clients**

`GET /clients`

* Response: List of all clients

### 4. **Get Client by ID**

`GET /clients/{id}`

* Response: Client data with nested related entities

### 5. **Update Client Info**

`PUT /clients/{id}`

* Body: JSON with new client info
* Response: Updated client object

### 6. **Update Address**

`PATCH /clients/{id}/address`

* Body: Partial JSON with address fields
* Response: Updated address

---

## Future Enhancements

* Persist data to PostgreSQL or MySQL
* Add audit logging
* Add Swagger UI for documentation
* Add security layer (Spring Security + JWT)

---

## Tech Stack

* Java 17+
* Spring Boot
* H2 Database
* Apache Commons CSV
* Gradle
* Postman (for API testing)

---

## How to Run

```bash
gr ./gradlew clean build
gr ./gradlew bootRun
```

H2 Console: `http://localhost:8080/h2-console`
JDBC URL: `jdbc:h2:mem:testdb`
