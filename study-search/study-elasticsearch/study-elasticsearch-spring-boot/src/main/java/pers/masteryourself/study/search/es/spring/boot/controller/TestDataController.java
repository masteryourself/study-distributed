package pers.masteryourself.study.search.es.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.masteryourself.study.search.es.spring.boot.entity.UserEntity;
import pers.masteryourself.study.search.es.spring.boot.repository.UserRepository;

import java.util.Random;
import java.util.UUID;

/**
 * @author : masteryourself
 * @version : 1.0.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 测试数据
 * @date : 2020/2/29 2:22
 */
@RestController
@RequestMapping(value = "test")
public class TestDataController {

    @Autowired
    private UserRepository userRepository;

    private int[] age = new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    @RequestMapping("/insert")
    public String insert() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            UserEntity user = new UserEntity();
            user.setId((long) i);
            user.setAge(age[random.nextInt(10)]);
            user.setName(UUID.randomUUID().toString().substring(0, 5));
            user.setSex(i / 2);
            userRepository.save(user);
        }
        return "success";
    }

}
