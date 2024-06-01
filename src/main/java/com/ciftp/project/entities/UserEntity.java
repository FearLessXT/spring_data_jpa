package com.ciftp.project.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15)
    private String msisdn;

    @Column
    private String password_hash;

    @Column
    private String accountId;

    @Column
    private String kvcLimit;

    @Column
    private String kvcStatus;

    @Column
    private String fullname;

    @Column
    private String gender;

    @Column
    private String status;

    @Column(name = "created_at", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @ManyToMany
    @JoinTable(name="user_roles",
            joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name="role_id",referencedColumnName = "id"))
    private List<UserRoleEntity> roles;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {}
}
