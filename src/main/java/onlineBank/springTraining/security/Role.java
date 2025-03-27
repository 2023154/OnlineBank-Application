package onlineBank.springTraining.security;


//import javax.persistence.CascadeType;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

//import javax.persistence.cascadeType;



@Entity
public class Role {
    @Id
    private int roleId;
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<>();

    public Role() {

    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }


    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String name) {
        this.name = name;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}