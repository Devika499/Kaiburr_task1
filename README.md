# Kaiburr Task 1 — Java Backend with REST API (Spring Boot + MongoDB Atlas)

## 👩‍💻 Candidate Details
**Name:** R Devika  
**Date:** October 2025  
**Task:** Java backend and REST API example

---

## 📘 Project Overview

This project implements a simple **Spring Boot REST API** to manage "Task" objects.  
Each Task can be created, searched, deleted, and executed. When executed, it stores a `TaskExecution` record containing the command output, start time, and end time.

The backend uses **MongoDB Atlas** for data persistence.

---

## ⚙️ Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot 3.x  
- **Database:** MongoDB Atlas (Cloud)  
- **Build Tool:** Maven  
- **REST Client:** Postman

---

## 🧩 Features Implemented

| Endpoint | HTTP Method | Description |
|-----------|--------------|--------------|
| `/tasks` | `GET` | Get all tasks or by ID |
| `/tasks` | `PUT` | Create or update a task |
| `/tasks/{id}` | `DELETE` | Delete a task |
| `/tasks/find?name=xyz` | `GET` | Search tasks by name |
| `/tasks/{id}/execute` | `PUT` | Execute shell command and store TaskExecution |

---

## 🗄️ MongoDB Connection (application.properties)
```properties
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster1.1qoqukt.mongodb.net/kaiburr?retryWrites=true&w=majority&appName=Cluster1
spring.application.name=kaiburr-task
server.port=8080
![alt text](<PUT_tasks.png>)