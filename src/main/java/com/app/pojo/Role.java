package com.app.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", length = 20, unique = true)
    private UserRole role;

    public Role(UserRole role) {
        this.role = role;
    }

    public UserRole getRoleName() {
        return role;
    }
}
