package com.shubham.userservicer2dbc.repository;

import com.shubham.userservicer2dbc.domain.AppUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AppUserRepository extends ReactiveCrudRepository<AppUser, Long> {
}
