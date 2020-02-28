package pers.masteryourself.study.search.es.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.masteryourself.study.search.es.spring.boot.entity.UserEntity;
import pers.masteryourself.study.search.es.spring.boot.repository.UserRepository;

import java.util.Optional;

/**
 * @author : masteryourself
 * @version : 1.0.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : UserController
 * @date : 2020/2/29 2:04
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/addUser")
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @RequestMapping("/findUser")
    public Optional<UserEntity> findUser(String id) {
        return userRepository.findById(id);
    }

}
