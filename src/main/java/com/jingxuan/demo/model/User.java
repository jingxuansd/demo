package com.jingxuan.demo.model;

import lombok.*;
import org.mapstruct.TargetType;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    private Long uid;

    private String name;

    private String email;

    private String address;

    private BigDecimal amount;
}