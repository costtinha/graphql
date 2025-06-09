package com.project.graphql.cache;

import com.project.graphql.entity.UserCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("userCacheRepository")
public interface UserCacheRepository extends CrudRepository<UserCache,Integer> {
}
