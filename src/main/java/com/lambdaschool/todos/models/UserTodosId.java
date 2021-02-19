package com.lambdaschool.todos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserTodosId implements Serializable {

    private long user;

    private long todos;

    public UserTodosId()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getTodos()
    {
        return todos;
    }

    public void setTodos(long todo)
    {
        this.todos = todo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
//         boolean temp = (o.getClass() instanceof Class);
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserTodosId that = (UserTodosId) o;
        return user == that.user &&
                todos == that.todos;
    }

    @Override
    public int hashCode()
    {
        return 27;
    }
}