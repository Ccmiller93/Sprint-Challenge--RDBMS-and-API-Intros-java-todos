package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usertodos")
@IdClass(UserTodosId.class)
public class UserTodos extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "todoid")
    @JsonIgnoreProperties(value = "users", allowSetters = true)
    private Todo todo;

    String incominguser;

    public UserTodos()
    {
    }

    public UserTodos(
            User user,
            Todo todo,
            String incominguser)
    {
        this.user = user;
        this.todo = todo;
        this.incominguser = incominguser;
    }

    public UserTodos(
            User user,
            Todo todo)
    {
        this.user = user;
        this.todo = todo;
        this.incominguser = null;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Todo getTodo()
    {
        return todo;
    }

    public void setTodo(Todo todo)
    {
        this.todo = todo;
    }

    public String getIncominguser()
    {
        return incominguser;
    }

    public void setIncominguser(String incominguser)
    {
        this.incominguser = incominguser;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserTodos that = (UserTodos) o;
        return ((this.user == null) ? 0 : this.user.getUserid()) == ((that.user == null) ? 0 : that.user.getUserid()) &&
                ((this.todo == null) ? 0 : this.todo.getTodoid()) == ((that.todo == null) ? 0 : that.todo.getTodoid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}