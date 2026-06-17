# CreatorStore

A secure and scalable e-commerce backend API built with Java, Spring Boot, PostgreSQL, JWT Authentication, and Role-Based Access Control (RBAC).

## 🚀 Live Demo

### Swagger UI
https://creatorstore.onrender.com/swagger-ui/index.html

### API Base URL
https://creatorstore.onrender.com

---

## 📌 Features

### Authentication & Authorization
- User Registration
- User Login
- JWT Authentication
- Role-Based Access Control (ADMIN / CUSTOMER)

### Product Management
- Create Product (ADMIN only)
- Update Product (ADMIN only)
- Delete Product (ADMIN only)
- Get Product by ID
- Get All Products
- Pagination & Sorting Support

### Order Management
- Create Orders
- View Orders
- Order Ownership Validation
- Customers can only access their own orders
- Admin access to all orders

### Security
- Spring Security
- JWT Token Authentication
- Stateless Session Management
- Protected API Endpoints

### API Documentation
- Swagger/OpenAPI Integration

### Deployment
- Dockerized Application
- Deployed on Render
- PostgreSQL hosted on Supabase

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate

### Database
- PostgreSQL
- Supabase

### Authentication
- JWT (JSON Web Token)

### Documentation
- Swagger / OpenAPI

### Deployment
- Docker
- Render

### Build Tool
- Maven

---

## 📂 Project Structure

```text
src
├── config
├── controllers
├── dto
├── entities
├── exceptions
├── repositories
├── security
├── services
└── resources
```

---

## 🔐 Roles

### ADMIN
- Manage Products
- View All Orders
- Update Products
- Delete Products

### CUSTOMER
- Browse Products
- Create Orders
- View Own Orders Only

---

## 📖 API Endpoints

### Authentication

| Method | Endpoint |
|----------|----------|
| POST | /auth/register |
| POST | /auth/login |

### Products

| Method | Endpoint |
|----------|----------|
| GET | /api/products |
| GET | /api/products/{id} |
| POST | /api/products |
| PUT | /api/products/{id} |
| DELETE | /api/products/{id} |

### Orders

| Method | Endpoint |
|----------|----------|
| POST | /api/orders |
| GET | /api/orders |
| GET | /api/orders/{id} |

---

## 🏗️ Security Architecture

```text
Client
   |
   | JWT Token
   v
JwtAuthenticationFilter
   |
   v
Spring Security
   |
   v
Controller
   |
   v
Service Layer
   |
   v
Repository
   |
   v
PostgreSQL
```

---

## ⚙️ Environment Variables

Create a `.env` file:

```env
DATABASE_URL=your_database_url
DATABASE_USERNAME=your_database_username
DATABASE_PASSWORD=your_database_password
JWT_SECRET=your_secret_key
```

---

## 🚀 Running Locally

### Clone Repository

```bash
git clone https://github.com/shivamjaveri0010/CreatorStore.git
```

### Navigate

```bash
cd CreatorStore
```

### Run Application

```bash
./mvnw spring-boot:run
```

---

## 🌐 Deployment

- Dockerized using Dockerfile
- Hosted on Render
- Database hosted on Supabase

Live URL:

https://creatorstore.onrender.com

Swagger Documentation:

https://creatorstore.onrender.com/swagger-ui/index.html

---

## 👨‍💻 Author

**Shivam Javeri**

GitHub:
https://github.com/shivamjaveri0010

LinkedIn:
https://www.linkedin.com/in/shivam-javeri-433823239?utm_source=share_via&utm_content=profile&utm_medium=member_android

---

## ⭐ Future Improvements

- Unit Testing (JUnit & Mockito)
- Redis Caching
- Kafka Event Streaming
- Payment Gateway Integration
- Microservices Architecture
- CI/CD Pipeline
