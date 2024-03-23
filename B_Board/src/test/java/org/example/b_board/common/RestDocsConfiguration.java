package org.example.b_board.common;

import org.springframework.boot.test.autoconfigure.restdocs.RestDocsMockMvcConfigurationCustomizer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentationConfigurer;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

/*
* default로 생성되는 rest docs snippet은 보기에 그리 좋지 않아서
* rest docs customize하는 걸 추가해준다.
*
* */
@TestConfiguration
public class RestDocsConfiguration {

    @Bean
    public RestDocsMockMvcConfigurationCustomizer restDocsMockMvcConfigurationCustomizer(){
        return configurer -> configurer.operationPreprocessors().withRequestDefaults(prettyPrint())
                .withResponseDefaults(prettyPrint());
    }

}
