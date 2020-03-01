package pers.masteryourself.study.search.es.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import pers.masteryourself.study.search.es.spring.boot.entity.UserEntity;

/**
 * <p>description : UserRepository
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/29 2:04
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
