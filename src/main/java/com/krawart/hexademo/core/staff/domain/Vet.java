package com.krawart.hexademo.core.staff.domain;

import com.krawart.hexademo.shared.domain.AggregateRoot;
import com.krawart.hexademo.shared.domain.value.Email;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Setter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Vet extends AggregateRoot {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private Email email;

    @Column(name = "telephone")
    private String telephone;
}
