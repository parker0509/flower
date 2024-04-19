
        if (optionalTodo.isPresent())
            // optionalTodo.isPresent() 는 isPresent는 객체에 값이있는지 확인하는 라이브러리
             {
            ToDo todo = optionalTodo.get();
            toDoRepository.delete(todo);
        }