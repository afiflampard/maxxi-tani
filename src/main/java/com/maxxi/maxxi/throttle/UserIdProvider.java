package com.maxxi.maxxi.throttle;

import java.util.Optional;

import com.maxxi.maxxi.filters.JWTRequestFilter;


public class UserIdProvider {

    public static Optional<String> getCurrentuserId(){
        return Optional.of(JWTRequestFilter.UserClaim);
    }
}
