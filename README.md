API ENDPOINTS

1) List all todos that are created.
    GET: /api/todos

2) Allows to edit a specific todo
    PUT: /api/todos/edit/{id}
    body:
         {
            "todoName": "Sample todo",
            "isCompleted": false
          }
   
3) Allows to complete a specific todo 
    PUT: /api/todos/complete/{id}



ADDITIONAL
4) For adding todos
   POST: /api/todos
   body:
         {
            "todoName": "Sample todo",
            "isCompleted": false
          }
