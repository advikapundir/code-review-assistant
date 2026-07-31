<div align="center">

# 🤖 AI Code Review Assistant

### AI-powered code analysis platform built with Spring Boot, React, PostgreSQL, JWT Authentication, and Google's Gemini API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![React](https://img.shields.io/badge/React-Frontend-blue)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![JWT](https://img.shields.io/badge/JWT-Security-red)
![Gemini](https://img.shields.io/badge/Gemini-AI-purple)

</div>

---

## 📖 Overview

The **AI Code Review Assistant** is a full-stack application that enables users to submit source code and receive AI-generated feedback in real time.

The system analyzes code quality, detects potential issues, identifies optimization opportunities, and provides suggestions for improving readability, maintainability, and overall performance.

This project was designed to simulate a production-style architecture by combining authentication, database management, RESTful APIs, and large language model integration.

---

## ✨ Features

- 🔐 Secure user authentication using JWT
- 👤 User registration and login system
- 🤖 AI-powered code analysis using Gemini
- 🗄️ PostgreSQL database integration
- ⚡ Real-time code review generation
- 🔄 RESTful API architecture
- 🎨 Responsive user interface
- 🛡️ Exception handling and validation

---

## 🏗️ System Architecture

```text
                   +--------------------+
                   |   React Frontend   |
                   +--------------------+
                              │
                              ▼
                   +--------------------+
                   |  Spring Boot API   |
                   +--------------------+
                              │
                              ▼
                   +--------------------+
                   | JWT Authentication |
                   +--------------------+
                              │
                              ▼
                   +--------------------+
                   |    Gemini API      |
                   +--------------------+
                              │
                              ▼
                   +--------------------+
                   |    PostgreSQL      |
                   +--------------------+
```

---

## 🛠️ Technology Stack

| Category | Technologies |
|----------|--------------|
| Frontend | React, JavaScript, Axios, CSS |
| Backend | Java, Spring Boot, Hibernate |
| Database | PostgreSQL |
| Security | JWT Authentication |
| AI Integration | Google Gemini API |
| Version Control | Git, GitHub |

---

## 📂 Project Structure

```text
code-review-assistant
│
├── backend
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
├── frontend
│   ├── public
│   ├── src
│   └── package.json
│
├── screenshots
│
├── .env.example
│
└── README.md
```

---

## ⚙️ Installation

### Clone the repository

```bash
git clone https://github.com/advikapundir/code-review-assistant.git
cd code-review-assistant
```

---

### Backend setup

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

---

### Frontend setup

```bash
cd frontend
npm install
npm run dev
```

---

## 🔑 Environment Variables

Create an `.env` file and add the following values:

```env
SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=
GEMINI_API_KEY=
JWT_SECRET=
```

---

## 🔗 API Endpoints

### Authentication

| Method | Endpoint |
|------|------|
| POST | `/api/auth/register` |
| POST | `/api/auth/login` |

---

### Code Review

| Method | Endpoint |
|------|------|
| POST | `/api/review` |

---

## 📸 Screenshots

### 🔹 Registration Page

<img width="693" height="381" alt="image" src="https://github.com/user-attachments/assets/843da6b7-5a0e-4195-ac9e-dec29a5ee551" />


### 🔹 Login Page

<img width="767" height="371" alt="image" src="https://github.com/user-attachments/assets/0a4edd75-802b-459c-b45f-01a4d80a66b1" />


### 🔹 Dashboard

<img width="953" height="436" alt="image" src="https://github.com/user-attachments/assets/db08d479-4b5a-4d11-97d0-487cc9a56039" />


### 🔹 Code Review Interface

<img width="940" height="468" alt="image" src="https://github.com/user-attachments/assets/784c1eaf-41a5-4a54-b1c3-0952fcccc2ff" />


### 🔹 Review Output

<img width="929" height="416" alt="image" src="https://github.com/user-attachments/assets/2d8a740f-d550-42a2-ace0-47405fc4d8f8" />
<img width="926" height="448" alt="image" src="https://github.com/user-attachments/assets/b6f2b777-8b43-4c55-874f-f76e1377cbde" />
<img width="544" height="468" alt="image" src="https://github.com/user-attachments/assets/78393353-fd71-4cd8-8aa6-745d221c648b" />
<img width="932" height="205" alt="image" src="https://github.com/user-attachments/assets/c2def436-a838-45cd-a7e8-290929845dd8" />





## 🚀 Future Enhancements

- Docker support
- Unit testing
- Integration testing
- Role-based access control
- Support for multiple programming languages
- Code complexity analysis

---

## 👩‍💻 Author

**Advika Pundir**

- GitHub: https://github.com/advikapundir
- LinkedIn: https://www.linkedin.com/in/advika-pundir-65514a28b/

---

<div align="center">

⭐ If you found this project useful, consider giving it a star.

</div>
