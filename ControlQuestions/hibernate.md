[Вопросы для собеседования](README.md)

# Hibernate
+ [Стратегии наследования Hibernate](#стратегии-наследования-hibernate)
+ [Как сделать составной первичный ключ Hibernate](#как-сделать-составной-первичный-ключ-hibernate)
+ [Какие бывают кеши Hibernate](#какие-бывают-кеши-hibernate)
+ [Расскажите про Persistence Context](#расскажите-про-Persistence-Context)


##Стратегии наследования Hibernate 
Всего таких стратегий 4:

1) Использовать одну таблицу для каждого класса и полиморфное поведение по умолчанию.Аннотация @MappedSuperclass позволяет включать класс и его jpa аннотации в производный класс, не делая базовый класс сущностью. Типичное использование в примере выше — абстрактный базовый класс, несущий в себе суррогатный первичный ключ.

2) Одна таблица для каждого конкретного класса, с полным исключением полиморфизма и отношений наследования из схемы SQL (для полиморфного поведения во время выполнения будут использоваться UNION-запросы). у базового класса в аннотации @Inheritance указывается стратегия strategy = InheritanceType.TABLE_PER_CLASS, а у производных классов опять ничего не указывается.Самое лучше по производительности решение, но теряется возможность обрабатывать данные базовых классов без обхода всех таблиц.

3) Единая таблица для всей иерархии классов. Возможна только за счет денормализации схемы SQL. Определять суперкласс и подклассы будет возможно посредством различия строк.Базовый класс аннотируется аннотацией @Inheritance и, по желанию, @DiscriminatorColumn, в параметрах которой можно задать наименование и тип столбца, в котором будут храниться признаки класса. К производным классам добавляется аннотация @DiscriminatorValue, задающее значение признака класса.

4) Одна таблица для каждого подкласса, где отношение “is a” представлено в виде «has a», т.е. – связь по внешнему ключу с использованием JOIN. в аннотации @Inheritance базового класса указывается другая стратегия strategy = InheritanceType.JOINED, а в производных классах указывать ничего не надо. Этот подход решает проблемы предыдущего, с not null ограничениями и возможные переизбытком индексов, но за счёт выполнения сравнительно медленной операции join при чтении данных производного класса из базы. Раздельный доступ к данным базового и производных классов сохраняется.

[к оглавлению](#hibernate)

## Как сделать составной первичный ключ Hibernate 
Необходимо создать дополнительный класс, содержащий все необходимые первичные ключи и пометить этот класс аннотацией @Embeddable, а затем в классе User обьявить поле этого класса с аннотацией @EmbeddedId

[к оглавлению](#hibernate)

## Какие бывают кеши Hibernate 
Кэш первого уровня (First Level Cache)
Кэш первого уровня – это кэш Сессии (Session), который является обязательным. Через него проходят все запросы. Перед тем, как отправить обхект в БД, сессия хранит объект за счёт своих ресурсов.
В том случае, если мы выполняем несколько обновлений объекта, Hibernate старается отсрочить (насколько это возможно) обновление для того, чтобы сократить количество выполненных запросов. Если мы закроем сессию, то все объекты, находящиеся в кэше теряются, а далее – либо сохраняются, либо обновляются.
Интересно поведение кэша первого уровня при использовании ленивой загрузки. При загрузке объекта методом load() или объекта с лениво загружаемыми полями, лениво загружаемые данные в кэш не попадут. При обращении к данным будет выполнен запрос в базу и данные будут загружены и в объект и в кэш. А вот следующая попытка лениво загрузить объект приведёт к тому, что объект сразу вернут из кэша и уже полностью загруженным.

Кэш второго уровня (Second level Cache)
Кэш второго уровня является необзательным (опциональным) и изначально Hibernate будет искать необходимый обхект в кэше первого уровня. В основном, кэширование второго уровня отвечает за кэширование объектов
Если кэш первого уровня существует только на уровне сессии и persistence context, то кэш второго уровня находится выше — на уровне SessionFactory и, следовательно, один и тот же кэш доступен одновременно в нескольких persistence context. Кэш второго уровня требует некоторой настройки и поэтому не включен по умолчанию. Настройка кэша заключается в конфигурировании реализации кэша и разрешения сущностям быть закэшированными.

Кэш запросов (Query Cache)
В Hibernate предусотрен кэш для запросов и он интегрирован с кэшем кторого уровня. Это требует двух дополнительных физических мест для хранения кэшированных запросов и временных меток для обновления таблицы БД. Этот вид кэширования эффективен только для часто используемых запросов с одинаковыми параметрами.
@Cache это аннотация Hibernate, настраивающая тонкости кэширования объекта в кэше второго уровня Hibernate. Аннотации @Cacheable  достаточно, чтобы объект начал кэшироваться с настройками по умолчанию. При этом @Cache использованная без @Cacheable не разрешит кэширование объекта.

На самом деле, хибернейт сам не реализует кеширование как таковое. А лишь предоставляет структуру для его реализации, поэтому подключить можно любую реализацию, которая соответствует спецификации нашего ORM фреймворка. Из популярных реализаций можна выделить EHCache

[к оглавлению](#hibernate)

## Расскажите про Persistence Context
Persistence Contexts" спецификации JPA, сущности в мире JPA живут в некотором пространстве, которое называется "Контекст персистенции" (или Контексте постоянства, Persistence Context). Но напрямую мы не работаем с Persistence Context. Для этого мы используем Entity Manager или "менеджер сущностей". Именно он знает про контекст и про то, какие там живут сущности. Мы же взаимодействуем с Entity Manager'ом.
Наличие persistence context означает, что для каждой существующей на данный момент сущности существует Session, которая с сущностью связана и следит за её состоянием

Состояния сущностей
Как я уже упомянул, Hibernate наблюдает за прикрепленными сущностями. Но для того чтобы сущность стала обслуживаемой, она должна быть в правильном состоянии.
Сначала мы дадим определения всем состояниям сущности:

New (Transient)
Только созданный объект, который никогда не был связан с сессией Hibernate (так же известной как Persistence Context.) и не маппированный на какую нибудь строку в таблице БД находится в состоянии New (Transient) .

Persistent (Managed)
Персистентная сущность связана со строкой в таблице БД и обслуживается текущим Persistence Context. Любые изменения совершенные с этой сущностью будут обнаружены и распространены в БД ( в течение Session flush-time). С Hibernate мы больше не должны выполнять INSERT/UPDATE/DELETE выражения. Он использует подход transactional write-behind и изменения синхронизируются в самый последний момент, в течении текущего Session flush-time.

Detached
Как только текущий запущенный Persistence Context закрывается все предыдущие обслуживаемые объекты становятся detached. Последующие изменения больше не будут отслеживаться  и не будут происходить автоматическая синхронизация с БД.
Для соединения detached сущности к активной Hibernate Session можно выбрать следующие варианты:

1) Повторное связывание
Hibernate (кроме JPA 2.1) поддерживает повторное присоединение через  Session#update метод.
Hibernate Session может только присоединить один объект сущности для конкретной строки в БД. Это происходит потому что Persistence Context действует как in-memory кэш (кэш первого уровня) и только одно значение (сущность) связано с конкретным ключом (тип сущности и идентификатор в БД).
Сущность может повторно присоединена только если не существует больше никакого другого объекта в JVM (соответсвующий той же строке в БД) уже присоединенного к текущей Hibernate Session.

2) Слияние
Операция слияния копирует состояние  detached сущности (источник) в  обслуживаемый экземпляр сущности (пункт назначения). Если для сущности которая будет сливаться не существует эквивалент в текущей сессии, то одно один экземпляр будет извлечен из БД,
Экземпляр detached объекта будет и дальше оставаться в состоянии detached даже после операции слияния.

Removed 
Хотя стандарт JPA  требует что только обслуживаемые сущности могут быть удалены, Hibernate так же удаляет detached сущности (но только через вызов метода Session#delete).
Удаляемая сущность запланирована для удаления и фактический DELETE запрос к БД будет произведен в течении Session flush-time.

Переходы между состояниями
Для изменения состояний одной сущности нужно использовать один из приведенных интерфейсов управления сущностями:
 - EntityManager
 - Session
Во время flush-time переход материализуется в DML запрос к БД,


[Вопросы для собеседования](README.md)
