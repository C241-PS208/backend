package com.shavemax.shavemax.repository;

import com.shavemax.shavemax.entity.Token;
import com.shavemax.shavemax.entity.User;
import com.shavemax.shavemax.enums.TokenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByTokenAndTokenType(UUID token, TokenType tokenType);
    Optional<Token> findTokenByUserAndTokenTypeAndExpiredAtIsAfter(User user, TokenType tokenType, Instant time);
}
