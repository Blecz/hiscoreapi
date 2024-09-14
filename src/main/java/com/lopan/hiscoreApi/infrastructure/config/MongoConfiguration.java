package com.lopan.hiscoreApi.infrastructure.config;

import com.lopan.hiscoreApi.infrastructure.mongodb.GameSpringMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = GameSpringMongoRepository.class)
public class MongoConfiguration {
}
