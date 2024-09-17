package com.lopan.hiscoreApi.infrastructure.config;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com/lopan/hiscoreApi/infrastructure/mongodb")
public class MongoConfiguration {
}
