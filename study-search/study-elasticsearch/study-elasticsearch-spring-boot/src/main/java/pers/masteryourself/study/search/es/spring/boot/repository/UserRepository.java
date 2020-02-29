package pers.masteryourself.study.search.es.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;
import pers.masteryourself.study.search.es.spring.boot.entity.UserEntity;

/**
 * @author : masteryourself
 * @version : 1.0.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : UserRepository
 * @date : 2020/2/29 1:56
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
