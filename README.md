# springboot的注解
1：@Repository（dao层）和@Controller（controller层）,@Service(service层),@Component的作用差不多，都是把对象交给spring管理，并注册到Bean中。

2：@Configuration与@Componnet的区别
   (1)：@Configuration注解本质上还是@Componnet

   (2): @Configuration中所有带@Bean注解的方法都会被动态代理。

   (3): @Component会当作配置类，但不会为其生成CGLIB代理class.@Configuration也会当作配置类，但会为其生成CGLIB的代理class

   (4): 获取当前类名时使用@Component获取的是当前类名；而@Cofiguration获取的是当前类名+唯一标识（CGLIB代理）

3：@Configuration功能：将想要的组件添加到容器中

4：@SpringBootApplication：表明这是一个SpringBoot应用

5：@Bean：@Bean用于标记在方法上，获取到类的对象并和@Configuration搭配使用。

