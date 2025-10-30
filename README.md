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
<img width="1897" height="85" alt="screenshot1" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

<img width="1897" height="85" alt="screenshot2" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

<img width="1897" height="85" alt="screenshot3" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

<img width="1897" height="85" alt="screenshot5" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

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

<img width="1897" height="85" alt="screenshot6" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

## Listing Tasks by using ID

<img width="1897" height="85" alt="screenshot7" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

## Executing Tasks by using name

<img width="1897" height="85" alt="screenshot8" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

## Updated webpage

<img width="1897" height="85" alt="screenshot9" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

## Deleting a task

<img width="1897" height="85" alt="screenshot10" src="https://github.com/user-attachments/assets/7545ac69-b2d1-4d5b-a156-794fdf214c92" />

