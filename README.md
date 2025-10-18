# Kaiburr Task 1 — Java Backend with REST API (Spring Boot + MongoDB Atlas)

## 👩‍💻 Candidate Details
**Name:** R Devika  
**Date:** 17 October 2025  
**Task:** Java backend and REST API example

---

## 📘Overview

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

I used MongoDB Atlas which is primarily an online, a multi-cloud database service by the same people that build MongoDB.
```properties
spring.data.mongodb.uri=<connection_url from MongoDB>
spring.application.name=kaiburr-task
server.port=8080
```
## Outputs after testing the APIs on Postman:
![alt text](<PUT_tasks.png>)
