# Task 1 – Java Backend and REST API (Kaiburr Assignment)

## Overview
This is a Spring Boot REST API that manages "Task" objects representing shell commands. Each task can be created, viewed, deleted, searched, and executed. Command outputs are stored as TaskExecutions in MongoDB.

## Technologies
- Java 21  
- Spring Boot 3.x  
- MongoDB Atlas  
- Maven

## Running the backend

## How to Run
```bash
mvn clean package
java -jar target/task-runner-0.0.1-SNAPSHOT.jar
```
![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot1.png)

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot2.png)

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot3.png)

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot5.png)

## Features
- Create a new task  
- Get all tasks / get by ID  
- Search by name  
- Execute a task command and store results  
- Delete a task  

## API Endpoints
| Method | Endpoint | Description |
|---------|-----------|-------------|
| PUT | `/api/tasks` | Create task |
| GET | `/api/tasks` | List all tasks |
| GET | `/api/tasks?id={id}` | Get task by ID |
| GET | `/api/tasks/search?name={name}` | Search task by name |
| PUT | `/api/tasks/{id}/execute` | Execute a task command |
| DELETE | `/api/tasks/{id}` | Delete task |


## Creating a new task

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot6.png)

## Listing Tasks by using ID

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot7.png)

## Executing Tasks by using name

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot8.png)

## Updated webpage

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot9.png)

## Deleting a task

![Output Screenshot](https://github.com/Vishalshanmugam/Task1/blob/main/Screenshot/screenshot10.png)

