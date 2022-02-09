[Список всех вопросов по «Spring Framework»](spring.md)

# Spring Web
+ [Как добавить поддержку `Spring` в Web-приложение?](#как-добавить-поддержку-spring-в-web-приложение)
+ [Можно ли использовать `xyz.xml` вместо `applicationContext.xml`?](#можно-ли-использовать-xyzxml-вместо-applicationcontextxml)
+ [В чем различие между `web.xml` и `Spring Context - servlet.xml`?](#в-чем-различие-между-webxml-и-spring-context-servletxml)

## Как добавить поддержку `Spring` в Web-приложение?

Достаточно просто указать `ContextLoaderListener` в _web.xml_ файле приложения.

[к оглавлению](#spring-web)

## Можно ли использовать `xyz.xml` вместо `applicationContext.xml`?

`ContextLoaderListener` - это `ServletContextListener`, который инициализируется когда
ваше web-приложение стартует. По-умолчанию оно загружает файл _WEBINF/applicationContext.xml_. Вы можете изменить значение по-умолчанию, указав
параметр `contextCongLocation`

[к оглавлению](#spring-web)

## В чем различие между `web.xml` и `Spring Context - servlet.xml`?

`web.xml` — Метаданные и конфигурация любого веб-приложения, совместимого с _Java EE_. _Java EE_ стандарт для веб-приложений.

`servlet.xml` — файл конфигурации, специфичный для `Spring Framework`.

[к оглавлению](#spring-web)