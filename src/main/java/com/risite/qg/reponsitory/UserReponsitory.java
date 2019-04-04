package com.risite.qg.reponsitory;

import com.risite.qg.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserReponsitory extends MongoRepository<User, String> {

}
