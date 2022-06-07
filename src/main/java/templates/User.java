package templates;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import role.UserRole;

import java.util.List;
import java.util.UUID;

@Getter

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String username;
    private String password;
    private String id= UUID.randomUUID().toString();
    private Integer age;
    private UserRole role;


    public User(String name, String username, String password, UserRole role) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "\nname=" + name +
                "\nuser name=" + username +
                "\n age=" + age +
                "\n role= " +role+
                "\n id= " +id+

                '}';
    }
}
