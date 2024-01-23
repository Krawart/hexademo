package com.krawart.hexademo.core.supply.domain;

import com.krawart.hexademo.common.domain.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Getter
@Setter
@ToString
public class Shipment extends Entity<UUID> {

    private String name;

    private String status;

    private String code;
}