# 📚 JavaSpringBoot - Student Management CRUD API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![REST API](https://img.shields.io/badge/REST-API-blue?style=for-the-badge)

A RESTful API built with Java Spring Boot for managing student records. This API provides complete CRUD (Create, Read, Update, Delete) operations for student management system.

## 🚀 Features

- ✅ Get all students
- ✅ Get student by ID
- ✅ Create new student
- ✅ Update student information (full update)
- ✅ Partial update student information
- ✅ Delete student by ID
- ✅ RESTful API design
- ✅ JSON request/response format

## 🛠️ Technology Stack

- **Java** - Programming Language
- **Spring Boot** - Framework
- **REST API** - Architecture
- **Maven/Gradle** - Build Tool
- **JSON** - Data Format

## 🌐 Base URL

```
http://localhost:8080
```

## 📋 API Endpoints

### Students Manager

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| POST | `/api/students` | Create a new student |
| PUT | `/api/students/{id}` | Update student by ID (full update) |
| PATCH | `/api/students/{id}` | Update student by ID (partial update) |
| DELETE | `/api/students/{id}` | Delete student by ID |

---

## 📖 API Documentation

### 1. Get All Students

**Endpoint:** `GET /api/students`

**Description:** Retrieves a list of all students in the system.

**Response Example:**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "course": "Computer Science"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Smith",
    "email": "jane.smith@example.com",
    "age": 22,
    "course": "Mathematics"
  }
]
```

**Status Codes:**
- `200 OK` - Successfully retrieved students
- `500 Internal Server Error` - Server error

---

### 2. Get Student by ID

**Endpoint:** `GET /api/students/{id}`

**Description:** Retrieves a specific student by their ID.

**Path Parameters:**
- `id` (integer) - The student ID

**Example:** `GET /api/students/1`

**Response Example:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "course": "Computer Science"
}
```

**Status Codes:**
- `200 OK` - Successfully retrieved student
- `404 Not Found` - Student not found
- `500 Internal Server Error` - Server error

---

### 3. Create a New Student

**Endpoint:** `POST /api/students`

**Description:** Creates a new student record in the system.

**Request Body:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "course": "Computer Science"
}
```

**Response Example:**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "age": 20,
  "course": "Computer Science"
}
```

**Status Codes:**
- `201 Created` - Student successfully created
- `400 Bad Request` - Invalid request body
- `500 Internal Server Error` - Server error

---

### 4. Update Student by ID (Full Update)

**Endpoint:** `PUT /api/students/{id}`

**Description:** Updates all fields of an existing student record.

**Path Parameters:**
- `id` (integer) - The student ID

**Example:** `PUT /api/students/2`

**Request Body:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.updated@example.com",
  "age": 21,
  "course": "Software Engineering"
}
```

**Response Example:**
```json
{
  "id": 2,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.updated@example.com",
  "age": 21,
  "course": "Software Engineering"
}
```

**Status Codes:**
- `200 OK` - Student successfully updated
- `404 Not Found` - Student not found
- `400 Bad Request` - Invalid request body
- `500 Internal Server Error` - Server error

---

### 5. Update Partial Student by ID

**Endpoint:** `PATCH /api/students/{id}`

**Description:** Updates specific fields of an existing student record (partial update).

**Path Parameters:**
- `id` (integer) - The student ID

**Example:** `PATCH /api/students/3`

**Request Body (only fields to update):**
```json
{
  "email": "newemail@example.com",
  "age": 23
}
```

**Response Example:**
```json
{
  "id": 3,
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "newemail@example.com",
  "age": 23,
  "course": "Mathematics"
}
```

**Status Codes:**
- `200 OK` - Student successfully updated
- `404 Not Found` - Student not found
- `400 Bad Request` - Invalid request body
- `500 Internal Server Error` - Server error

---

### 6. Delete Student by ID

**Endpoint:** `DELETE /api/students/{id}`

**Description:** Deletes a student record from the system.

**Path Parameters:**
- `id` (integer) - The student ID

**Example:** `DELETE /api/students/1`

**Response Example:**
```json
{
  "message": "Student deleted successfully"
}
```

**Status Codes:**
- `200 OK` or `204 No Content` - Student successfully deleted
- `404 Not Found` - Student not found
- `500 Internal Server Error` - Server error

---

## 🏁 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6+ or Gradle 6.0+
- Spring Boot 2.5+
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd student-management-api
   ```

2. **Build the project**

   Using Maven:
   ```bash
   mvn clean install
   ```

   Using Gradle:
   ```bash
   gradle build
   ```

3. **Run the application**

   Using Maven:
   ```bash
   mvn spring-boot:run
   ```

   Using Gradle:
   ```bash
   gradle bootRun
   ```

4. **Access the API**

   The API will be available at: `http://localhost:8080`

---

## 💻 API Usage Examples

### Using cURL

**Get all students:**
```bash
curl -X GET http://localhost:8080/api/students
```

**Get student by ID:**
```bash
curl -X GET http://localhost:8080/api/students/1
```

**Create a new student:**
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "age": 20,
    "course": "Computer Science"
  }'
```

**Update student:**
```bash
curl -X PUT http://localhost:8080/api/students/2 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.updated@example.com",
    "age": 21,
    "course": "Software Engineering"
  }'
```

**Partial update student:**
```bash
curl -X PATCH http://localhost:8080/api/students/3 \
  -H "Content-Type: application/json" \
  -d '{
    "email": "newemail@example.com"
  }'
```

**Delete student:**
```bash
curl -X DELETE http://localhost:8080/api/students/1
```

---

## 🔧 Environment Variables

The API uses the following environment variables (configured in Postman):

| Variable | Description | Example Value |
|----------|-------------|---------------|
| `baseUrl` | Base URL of the API | `http://localhost:8080` |
| `apiVersion` | API version | `v1` |

---

## 📮 Postman Collection

### Import the Collection

1. Open Postman
2. Click on **Import** button
3. Select the collection JSON file
4. The collection will be imported with all requests

### Setup Environment Variables

1. Create a new environment in Postman
2. Add the following variables:
    - `baseUrl`: `http://localhost:8080`
    - `apiVersion`: `v1`
3. Select the environment before running requests

### Run the Collection

1. Open the collection in Postman
2. Navigate to the **Students manager** folder
3. Select any request and click **Send**
4. View the response in the response panel

### Collection Runner

To run all requests in sequence:
1. Click on the collection name
2. Click **Run** button
3. Select the requests to run
4. Click **Run JavaSpringBoot - Student Management Crud API**

---

## 📁 Project Structure

```
student-management-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── studentmanagement/
│   │   │               ├── controller/
│   │   │               │   └── StudentController.java
│   │   │               ├── model/
│   │   │               │   └── Student.java
│   │   │               ├── repository/
│   │   │               │   └── StudentRepository.java
│   │   │               ├── service/
│   │   │               │   └── StudentService.java
│   │   │               └── StudentManagementApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml (or build.gradle)
└── README.md
```

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 📧 Contact

For questions or support, please contact:
- **Email:** muhammadhamaadlatif@gmail.com
- **GitHub:** [@hamaad-latif](https://github.com/hamaad-latif)

---

## 🙏 Acknowledgments

- Spring Boot Documentation
- Java Community
- Postman API Platform

---

**Made with ❤️ using Java Spring Boot**