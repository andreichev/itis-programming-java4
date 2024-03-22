# Используем ServletContainerInitializer вместо web.xml
Как стартует SpringWebMvc, если мы не регистрируем DispatcherServlet в web.xml?
При помощи Service Provider tomcat загружает реализацию ServletContainerInitializer и вызывает OnStartup. [Документация Service Provider](https://docs.oracle.com/javase/6/docs/technotes/guides/jar/jar.html#Service%20Provider). 
SpringWebMvc имеет свою реализацию SpringServletContainerInitializer.
SpringServletContainerInitializer ищет реализацию интерфейса WebApplicationInitializer и использует ее для инициализации приложения на Spring.
Таким образом приложение на servlet api инициализирует Spring.