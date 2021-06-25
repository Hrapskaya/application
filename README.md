# application
В проекте используется бд Postgres.
Для подключения необходимо в файле src/main/resources/application.properties
прописать данные доступа к бд:

    spring.datasource.username=username
    spring.datasource.password=password

а также создать базу данных с названием test:

    CREATE DATABASE test;

В файле test_user_accounts.sql данные для создания таблицы и набора данных.
Данные администратора:

    Логин: admin
    Пароль: admin
    
У остальных юзеров пароль: qw12.
    
