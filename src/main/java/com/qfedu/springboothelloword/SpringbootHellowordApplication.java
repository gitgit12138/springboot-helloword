package com.qfedu.springboothelloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@SpringBootApplication标注在某个类上说明这个类是Springboot的主配置类，springboot就应该运行这个类的main方法来启动Springboot应用
    @SpringBootConfiguration标注在某个类上，表示这是一个springboot的配置类，springboot定义的注解
        @Configuration配置类需要标注这个注解，配置类相当于我们以前在使用SSM时使用的配置文件xml，spring定义的注解，同时配置类也是容器中的一个组件Component

@EnableAutoConfiguration开启自动配置功能。以前需要配置的东西，现在Springboot帮我们自动配置
    @AutoConfigurationPackage自动配置包
        @Import({Registrar.class})Spring的底层注解，给容器中导入一个组件，导入的组件由Registrar.class决定
    所以@AutoConfigurationPackage的作用主配置类所在包及下面所有子包里面的所有组件扫描到Spring容器中，所以假设说我们把
controller放在了com包里，那么是扫描不到了，也就无法执行
    @Import({AutoConfigurationImportSelector.class})给容器中导入组件
        AutoConfigurationImportSelector自动导入哪些组件的选择器。selectImports()方法将所有需要导入的组件以全类名的方式返回，
这些组件就会被导入Spring容器中。最终会给容器中导入非常多的自动配置类(xxxAutoConfiguration)。这些自动配置类的作用就是给容器中导入这个场景需要的所有组件，并配置好所有组件。
有了自动配置类，免去了我们手动编写配置注入功能组件等的工作。
            SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class, beanClassLoader)这个方法的
作用就是让springboot在启动的时候从META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到spring容器中，自动配置类就生效，帮我们进行自动配置工作
以前我们需要自己配置东西，自动配置类都帮我们自动配置了。Javaee的整体解决方案和自动配置都在spring-boot-autoconfigure-2.3.1.RELEASE.jar这个包里

*/
@SpringBootApplication
@RestController
public class SpringbootHellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHellowordApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
