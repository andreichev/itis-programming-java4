[Список всех вопросов по «Spring Framework»](spring.md)

# Spring Data
+ [Как настраивается соединение с БД в `Spring`?](#как-настраивается-соединение-с-бд-в-spring)
+ [Каким образом можно управлять транзакциями в `Spring?`](#каким-образом-можно-управлять-транзакциями-в-spring)
+ [Как сконфигурировать `JNDI` не через `datasource` в _applicationContext.xml_?](#как-сконфигурировать-jndi-не-через-datasource-в-applicationcontextxml)
+ [Каким образом `Spring` поддерживает `DAO`?](#каким-образом-spring-поддерживает-dao)
+ [Как интегрировать `Spring` и `Hibernate`?](#как-интегрировать-spring-и-hibernate)
+ [Как задаются файлы маппинга `Hibernate` в `Spring`?](#как-задаются-файлы-маппинга-hibernate-в-spring)

## Как настраивается соединение с БД в `Spring`?

Используя `datasource` _"org.springframework.jdbc.datasource.DriverManagerDataSource"_.

[к оглавлению](#spring-data)

## Каким образом можно управлять транзакциями в `Spring?`

Транзакциями в `Spring` управляют с помощью `Declarative Transaction Management`
(программное управление). Используется аннотация `@Transactional` для описания
необходимости управления транзакцией. В файле конфигурации нужно добавить
настройку `transactionManager` для `DataSource`.

[к оглавлению](#spring-data)

## Как сконфигурировать `JNDI` не через `datasource` в _applicationContext.xml_?

Используя _"org.springframework.jndi.JndiObjectFactoryBean"_.

[к оглавлению](#spring-data)

## Каким образом `Spring` поддерживает `DAO`?

`Spring DAO` предоставляет возможность работы с доступом к данным с помощью
технологий вроде `JDBC`, `Hibernate` в удобном виде. Существуют специальные классы:
`JdbcDaoSupport`, `HibernateDaoSupport`, `JdoDaoSupport`, `JpaDaoSupport`.

Класс `HibernateDaoSupport` является подходящим суперклассом для `Hibernate DAO`. Он
содержит методы для получения сессии или фабрики сессий. Самый популярный
метод - `getHibernateTemplate()`, который возвращает `HibernateTemplate`. Этот
темплейт оборачивает checked-исключения `Hibernate` в runtime-исключения,
позволяя вашим `DAO` оставаться независимыми от исключений `Hibernate`.

[к оглавлению](#spring-data)

## Как интегрировать `Spring` и `Hibernate`?

Для интеграции `Hibernate` в `Spring` необходимо подключить зависимости, а так же
настроить файл конфигурации `Spring`. Т.к. настройки несколько отличаются между
проектами и версиями, то смотрите официальную документацию `Spring` и `Hibernate`
для уточнения настроек для конкретных технологий.

[к оглавлению](#spring-data)

## Как задаются файлы маппинга `Hibernate` в `Spring`?

Через _applicationContext.xml_ в _web/WEB-INF_.

[к оглавлению](#spring-data)

[Вопросы для собеседования](README.md)
