package by.AndreiKviatkouski.domain;

import by.AndreiKviatkouski.console.exception.AddRoleException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
    private static long incId = 1;
    private long id = incId++;

    private String firstName;
    private String lastName;
    private String email;
    public Set<Role> roles = new HashSet<>();
    private Telephone telephone;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public Set<Role> getRoles() {
        return roles;
    }


    public void addRole(Role role) throws AddRoleException {
        for (Role r : this.roles) {
            if (r.getLevel() == role.getLevel())
                throw new AddRoleException("Invalid Role");
        }
        this.roles.add(role);
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, Telephone telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }

    public User(long id, String firstName, String lastName, String email, Role... roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles.addAll(Arrays.asList(roles));
    }


    public User(long id, String firstName, String lastName, String email, Telephone telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(roles, user.roles) &&
                Objects.equals(telephone, user.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, roles, telephone);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", telephone=" + telephone +
                '}';
    }
}
