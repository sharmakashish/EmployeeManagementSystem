package org.ems.entities;

import javax.persistence.*;

@Entity
@Table(name="permissions")
public
class Permission{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Permission() {
    }

    public Permission(Long id, String permission_type) {
        this.id = id;
        this.permission_type = permission_type;
    }

    @Column(name="type")
    private String permission_type;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission_type='" + permission_type + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission_type() {
        return permission_type;
    }

    public void setPermission_type(String permission_type) {
        this.permission_type = permission_type;
    }
}