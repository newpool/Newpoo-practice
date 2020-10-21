## Newpool社区

## 资料
[Bootstrap](https://v3.bootcss.com/getting-started/)  
[Github OAuth App](https://docs.github.com/cn/developers/apps/creating-an-oauth-app)  
[markdown](https://www.runoob.com/markdown/md-tutorial.html)  
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)  
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#using-theach)
## 工具

## 脚本
```sql
create table user
(
    ID           int auto_increment,
    ACCOUNT_ID   varchar(100) null,
    NAME         varchar(50)  null,
    TOKEN        varchar(36)  null,
    GMT_CREATE   bigint       null,
    GMT_MODIFIED bigint       null,
    constraint USER_ID_uindex
        unique (ID)
);

alter table user
    add primary key (ID);

```
