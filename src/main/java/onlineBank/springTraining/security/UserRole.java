package onlineBank.springTraining.security;

import jakarta.persistence.*;
import onlineBank.springTraining.entity.User; // ✅ Importing your own User entity

/**
 * Represents the mapping between a User and a Role.
 * This is a join entity in a many-to-many relationship modeled as two many-to-ones.
 */
@Entity
@Table(name = "user_role") //Maps this class to the 'user_role' table
public class UserRole {

    // Primary key of this entity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    // Many UserRoles can be associated with one User
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") //Foreign key column in user_role table
    private User user;

    // Many UserRoles can be associated with one Role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id") //Foreign key column in user_role table
    private Role role;

    // Default constructor required by JPA
    public UserRole() {}

    // Constructor to easily create a UserRole
    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    // Getters and setters
    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
