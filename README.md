# Тестовое задание

Написать приложение - список контактов со следующими возможностями:
- Отображать список контактов
- Возможность добавлять контакт (Имя, Фамилия, Телефон, E-mail)
- Возможность удалять контакт


# Установка и запуск приложения

## Необходимое программное обеспечение
1. Скачайте и установите сервер [Tomcat](http://tomcat.apache.org/download-70.cgi)
2. Скачайте и установите [MySQL](http://www.mysql.com/downloads/)
3. Скачайте и установите [Apache ANT](http://ant.apache.org/bindownload.cgi)

## Сборка и запуск приложения
1. Создайте необходимые таблицы в базе данных используя скрипт `resources/schema.ddl`
2. Измените конфигурационный файл `resources/connection.properties` в соответствии с вашей базой данных
3. Соберите приложение с помощью команды `ant`
4. Скопируйте `build/contacts.war` в директорию `<tomcat_dir>/webapps`
5. Запустите Tomcat: `<tomcat_dir>/bin/startup.bat`
6. Откройте веб браузер и перейдите на [http://localhost:8080/contacts](http://localhost:8080/contacts)
