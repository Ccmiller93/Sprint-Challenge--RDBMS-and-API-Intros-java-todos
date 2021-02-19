package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

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
    private Todos todos;

    String incominguser;

    public UserTodos()
    {
    }

    public UserTodos(
            User user,
            Todos todos,
            String incominguser)
    {
        this.user = user;
        this.todos = todos;
        this.incominguser = incominguser;
    }

    public UserTodos(
            User user,
            Todos todos)
    {
        this.user = user;
        this.todos = todos;
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

    public Todos getTodo()
    {
        return todos;
    }

    public void setTodo(Todos todos)
    {
        this.todos = todos;
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
                ((this.todos == null) ? 0 : this.todos.getTodoid()) == ((that.todos == null) ? 0 : that.todos.getTodoid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}