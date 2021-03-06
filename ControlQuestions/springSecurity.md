[Вопросы для собеседования](README.md)

# Spring_Security
+ [Что такое Spring Security?](#что-такое-Spring-Security?)
+ [Как работать со Spring Security?](#как-работать-со-Spring-Security?)
+ [Какая разница между @Secured(…), @PreAuthorize(…)? Какое основное требование для названия ролей в Secured аннотации?](#какая-разница-между-@Secured(…),-@PreAuthorize(…)?-Какое-основное-требование-для-названия-ролей-в-Secured-аннотации?)

## Что такое Spring Security
Проект Spring Security предоставляет широкие возможности для защиты приложения. Кроме стандартных настроек для аутентификации, авторизации и распределения ролей и маппинга доступных страниц, ссылок и т.п., предоставляет защиту от различных вариантов атак (например CSRF). 
Имеет множество различных настроек, но остается легким в использовании.

[к оглавлению](#Spring_Security)

## Как работать со Spring Security? 
Основными блоками Spring Security являются:

1. SecurityContextHolder, чтобы обеспечить доступ к SecurityContext.
2. SecurityContext, содержит объект Authentication и в случае необходимости информацию системы безопасности, связанную с запросом.
3. Authentication представляет принципала (пользователя авторизованной сессии) с точки зрения Spring Security.
4. GrantedAuthority отражает разрешения выданные доверителю в масштабе всего приложения.
5. UserDetails предоставляет необходимую информацию для построения объекта Authentication из DAO объектов приложения или других источника данных системы безопасности.
6. UserDetailsService, чтобы создать UserDetails, когда передано имя пользователя в виде String (или идентификатор сертификата или что-то подобное).
 
Стандартный сценарий аутентификации:
1. Пользователю будет предложено войти в систему с именем пользователя и паролем.
2. Система (успешно) подтверждает, что введен правильный пароль для данного имени пользователя.
3. Получается контекстная информация для данного пользователя (список ролей и т. д.).
4. Для пользователя устанавливается контекст безопасности.
5. Пользователь перенаправляется на выполнение операций, которые могут быть защищены механизмом контроля доступа, который проверяет необходимые разрешения для выполнения операций на основании информации текущего контекста безопасности.

Первые три пункта составляют непосредственно процесс аутентификации, поэтому мы рассмотрим, как это происходит в Spring Security.

Получаются имя пользователя и пароль и объединяются в экземпляр класса UsernamePasswordAuthenticationToken (экземпляр интерфейса Authentication, который мы видели ранее).
Токен передается экземпляру AuthenticationManager для проверки.
AuthenticationManager возвращает полностью заполненный экземпляр Authentication в случае успешной аутентификации.
Устанавливается контекст безопасности путем вызова SecurityContextHolder.getContext().setAuthentication(...), куда передается вернувшийся экземпляр Authentication.
 
[к оглавлению](#Spring_Security)

## Какая разница между @Secured(…), @PreAuthorize(…)? Какое основное требование для названия ролей в Secured аннотации?
Аннотация @Secured используется для указания списка ролей в методе. Следовательно, пользователь может получить доступ к этому методу, только если у него есть хотя бы одна из указанных ролей.
Аналогичная аннотация - RoleAllowed 

Аннотации @ PreAuthorize и @ PostAuthorize обеспечивают контроль доступа на основе выражений. Следовательно, предикаты могут быть написаны с использованием SpEL (Spring Expression Language).

Аннотация @ PreAuthorize проверяет данное выражение перед входом в метод , тогда как аннотация @ PostAuthorize проверяет его после выполнения метода и может изменить результат .
Кроме того, аннотация @ PostAuthorize предоставляет возможность доступа к результату метода.

Пример использования SpeL:
```java
@PreAuthorize("(hasRole(‘ROLE_SPITTER’)  and  #spittle.text.length()  <=  140) or hasRole(‘ROLE_PREMIUM’)")
```
Требование для названия ролей в Secured аннотации - префикс ROLE. Если он не был добавлен, Spring добавит его автоматически.
 
[к оглавлению](#Spring_Security)

[Вопросы для собеседования](README.md)
