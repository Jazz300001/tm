database name = task_manager_db  port 3306
i entered the following into mysql command line in order to make a user whihc is also specified in the app properties folder in resources
CREATE DATABASE task_manager_db;
CREATE USER 'task_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON task_manager_db.* TO 'task_user'@'localhost';
FLUSH PRIVILEGES;


/api/goals/
gets all goals
after final slash use id num of goal for put or delete
json for goals 
{
    "userId": 1,
    "title": "Sample Goal",
    "details": "Details about the goal",
    "targetDate": "2024-12-31",
    "status": "in-progress"
}




/api/tasks/
functions same as goal
json for tasks
{
    "goal": {
        "goalId": 1  
    },
    "title": "New Task",
    "details": "Details about the new task",
    "status": "pending"
}
