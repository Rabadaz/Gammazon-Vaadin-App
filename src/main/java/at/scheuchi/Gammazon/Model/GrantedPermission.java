package at.scheuchi.Gammazon.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class GrantedPermission implements GrantedAuthority {
    @Id
    @GeneratedValue
    private int id;

    private String permission;

    private String description;


    @Override
    public String getAuthority() {
        return permission;
    }
}
