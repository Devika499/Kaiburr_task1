# Kaiburr Task 1 — Java Backend with REST API (Spring Boot + MongoDB Atlas)

## Candidate Details
**Name:** R Devika  
**Date:** 18 October 2025  
**Task:** Java backend and REST API example

---

## Overview

This project implements a simple **Spring Boot REST API** to manage "Task" objects.  
Each Task can be created, searched, deleted, and executed. When executed, it stores a `TaskExecution` record containing the command output, start time, and end time.

The backend uses **MongoDB Atlas** for data persistence.

![alt text](<SpringBoot.png>)

---

## Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot 4
- **Database:** MongoDB Atlas (Cloud)  
- **Build Tool:** Maven  
- **REST Client:** Postman

---

## Features Implemented

| Endpoint | HTTP Method | Description |
|-----------|--------------|--------------|
| `/tasks` | `GET` | Get all tasks or by ID |
| `/tasks` | `PUT` | Create or update a task |
| `/tasks/{id}` | `DELETE` | Delete a task |
| `/tasks/find?name=xyz` | `GET` | Search tasks by name |
| `/tasks/{id}/execute` | `PUT` | Execute shell command and store TaskExecution |

---

## MongoDB Connection (application.properties)

I used MongoDB Atlas which is primarily an online, a multi-cloud database service by the same people that build MongoDB.
```properties
spring.data.mongodb.uri=<connection_url from MongoDB>
spring.application.name=kaiburr-task
server.port=8080
```
<img width="1882" height="869" alt="image" src="https://github.com/user-attachments/assets/6b37cffa-8029-4269-9e77-0624250de252" />

---

## Outputs after testing the APIs on Postman:

1. GET tasks - Should return all the “tasks” if no parameters are passed. 

![alt text](<GET_tasks.png>)
              When “task” id is passed as a parameter - return a single task or 404 if there’s no such task.
              
![alt text](<Get_by_id.png>) 

2. PUT a task - The “task” object is passed as a json-encoded message body.

![alt text](<PUT_tasks.png>)

3. DELETE a task - The parameter is a task ID.

![alt text](<Delete_by_id.png>)

4. GET (find) tasks by name - The parameter is a string.
   
![alt text](<Get_by_name.png>)

5. PUT a TaskExecution (by task ID) - Execute a shell command. Store a TaskExecution object in the taskExecutions list of a corresponding task. 

![alt text](<PUT_id_execute.png>)
