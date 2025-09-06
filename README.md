# Fitness-microservice-Gemini

# Fitness-Microservice-Gemini

**AI-powered fitness tracking platform built with Spring Boot microservices, RabbitMQ, and Google Gemini.**

---

## 📌 Overview

Fitness-Microservice-Gemini is a **cloud-native fitness application** designed using **microservices architecture**.  
It enables users to log workout activities, which are processed asynchronously via RabbitMQ, enriched with **AI insights from Google Gemini**, and then made available to the client via a unified API gateway and frontend React SPA.

---

## 🏗️ Architecture & Tech Stack

### Microservices
- **Gateway Service** – Spring Cloud Gateway with JWT authentication (Keycloak).  
- **User Service** – Manages user registration, login, and profile data.  
- **Activity Service** – Logs fitness activities, persists them in DB, and publishes events to RabbitMQ.  
- **AI Service** – Consumes messages from RabbitMQ, calls Gemini API, and enriches activities with recommendations.  
- **Config Server** – Centralized configuration management.  
- **Eureka Server** – Service discovery and registry.  
- **Frontend (React + Vite)** – User interface for registering, logging activities, and viewing AI-powered feedback.

### Tech Stack
- **Backend**: Java 21, Spring Boot 3.4.x, Spring WebFlux, RabbitMQ  
- **Databases**: PostgreSQL, MongoDB  
- **Auth**: Keycloak + JWT  
- **Frontend**: React 18 (Vite + Tailwind)  
- **AI**: Google Gemini API  
- **DevOps**: Docker, Docker Compose, Maven  

---

## ✨ Features

- 🔑 **Secure Authentication** with JWT (Keycloak)  
- 🏋️ **User Activity Logging** with persistence  
- 📨 **Asynchronous Event Handling** via RabbitMQ  
- 🤖 **AI-powered Feedback** using Google Gemini  
- ⚙️ **Centralized Config & Service Discovery**  
- 🖥️ **Responsive Frontend** built with React  

---

## ⚡ Prerequisites

Before running the project, ensure you have:

- [JDK 21+](https://adoptium.net/)  
- [Maven 3.9+](https://maven.apache.org/)  
- [Node.js 20+ / pnpm](https://nodejs.org/)  
- [Docker & Docker Compose](https://docs.docker.com/)  
- Google **Gemini API Key** ([AI Studio](https://aistudio.google.com/))  
- Keycloak setup (for authentication)  

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/Aishanya12/Fitness-microservice-Gemini.git
cd Fitness-microservice-Gemini
2. Build Services
bash
Copy code
./mvnw clean package -DskipTests
3. Configure Environment Variables
Create a .env file in the project root:

env
Copy code
GEMINI_API_KEY=your_api_key_here
4. Run with Docker Compose
bash
Copy code
docker compose up -d
🌐 Service Endpoints
API Gateway → http://localhost:8080

Frontend → http://localhost:5173

RabbitMQ Dashboard → http://localhost:15672

Eureka Dashboard → http://localhost:8761

Keycloak Admin → http://localhost:8081 (if configured)

🛠️ Frontend Development
To run the frontend in dev mode:

bash
Copy code
cd fitness-app-frontend
pnpm install
pnpm dev
🧪 Testing
Import the provided Postman Collection (postman test cases.json)

Sample test APIs:

POST /auth/register → User registration

POST /auth/login → Authentication & JWT generation

POST /api/activities → Log fitness activity

GET /api/activities/{id} → Fetch AI-enriched results

⚙️ Configuration
Variable	Description
GEMINI_API_KEY	Google Gemini API key (mandatory)
DB_URL	Database connection string
RABBIT_HOST	RabbitMQ host (default: localhost)
KEYCLOAK_URL	Keycloak auth server URL

🔄 Architecture Flow
text
Copy code
Client → Gateway → Activity Service → RabbitMQ → AI Service → Gemini API
         ↓                                         ↑
     User Service  ←──────────── Database ─────────┘
🐞 Troubleshooting
Issue	Solution
Database not connecting	Check Docker logs and DB container health
403 Unauthorized	Re-login and verify JWT from Keycloak
No AI response	Verify Gemini API key and request format
RabbitMQ not working	Ensure port 5672 is free and container is healthy

