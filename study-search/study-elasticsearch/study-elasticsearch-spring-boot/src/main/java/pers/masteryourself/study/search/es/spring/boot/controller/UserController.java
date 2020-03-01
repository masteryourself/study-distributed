package pers.masteryourself.study.search.es.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.masteryourself.study.search.es.spring.boot.entity.UserEntity;
import pers.masteryourself.study.search.es.spring.boot.repository.UserRepository;

import java.util.Optional;

/**
 * <p>description : UserController
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/29 2:04
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/add")
    public UserEntity add(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @RequestMapping("/find")
    public Optional<UserEntity> find(Long id) {
        return userRepository.findById(id);
    }

}
