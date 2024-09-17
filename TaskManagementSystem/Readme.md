# Task Management System

## Overview
The Task Management System is designed to help users manage their tasks efficiently. It allows users to create, update, assign, and delete tasks, as well as set reminders. The system also supports searching, filtering, and concurrent access while ensuring data consistency. It is designed to be extensible for future enhancements.

## Features
- Create, update, and delete tasks.
- Each task includes a title, description, due date, priority, and status (e.g., pending, in progress, completed).
- Assign tasks to other users and set reminders.
- Search and filter tasks based on criteria like priority, due date, and assigned user.
- Mark tasks as completed and view task history.
- Concurrent access to tasks with data consistency.
- Designed to be easily extensible for future improvements.

## Components

### 1. **User Class**
Represents a user in the system with properties such as:
- `id`: Unique identifier.
- `name`: User's name.
- `email`: User's email address.

### 2. **TaskStatus Enum**
Defines the possible statuses for a task:
- `PENDING`: The task is yet to be started.
- `IN_PROGRESS`: The task is currently being worked on.
- `COMPLETED`: The task is finished.

### 3. **Task Class**
Represents a task in the system with the following properties:
- `id`: Unique task identifier.
- `title`: The task's title.
- `description`: A brief description of the task.
- `dueDate`: The task's due date.
- `priority`: The task's priority level.
- `status`: Current status of the task (Pending, In Progress, Completed).
- `assignedUser`: The user to whom the task is assigned.

### 4. **TaskManager Class**
The core class of the system that manages all task-related operations. It follows the Singleton pattern to ensure only one instance is running at any time. It uses thread-safe data structures to handle concurrent access:
- **Data Structures**:
  - `ConcurrentHashMap`: For storing tasks in a thread-safe manner.
  - `CopyOnWriteArrayList`: For managing lists of tasks safely during concurrent updates.
- **Methods**:
  - Create, update, delete tasks.
  - Search and filter tasks.
  - Mark tasks as completed.
  - Retrieve task history for users.

### 5. **TaskManagementSystem Class**
The main entry point for the application, demonstrating how the TaskManager can be used to perform task-related operations.