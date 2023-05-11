package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.UserRoleEntityConverter;
import com.transportation.comfortbus.entity.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role")
    @Convert(converter = UserRoleEntityConverter.class)
    private UserRole role;

    @JsonIgnore
    @OneToMany(mappedBy = "administrator")
    private Set<RideEntity> administratorRides;

    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private Set<RideEntity> driverRides;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<TicketBookingEntity> tickets;


}
