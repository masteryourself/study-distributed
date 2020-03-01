package pers.masteryourself.study.search.es.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * <p>description : ElasticsearchApplication
 * {@link EnableElasticsearchRepositories} 扫描 spring-data-elasticsearch 的包
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/2/29 2:04
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "pers.masteryourself.study.search.es.spring.boot.repository")
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
