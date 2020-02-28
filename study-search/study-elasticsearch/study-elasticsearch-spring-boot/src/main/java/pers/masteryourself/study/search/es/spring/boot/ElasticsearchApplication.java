package pers.masteryourself.study.search.es.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author : masteryourself
 * @version : 1.0.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : ElasticsearchApplication
 * @date : 2020/2/29 1:58
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "pers.masteryourself.study.search.es.spring.boot.repository")
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
