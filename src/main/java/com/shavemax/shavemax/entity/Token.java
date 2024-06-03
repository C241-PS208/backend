package com.shavemax.shavemax.entity;

import com.shavemax.shavemax.enums.TokenType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "token")

public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID token;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    //TODO ENUM TOKEN TYPE
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private Instant issuedAt;

    private Instant expiredAt;
}
