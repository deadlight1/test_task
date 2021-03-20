## TEST TASK
#### Requirements

Тестовое задание: REST API с шифрованием (Middle Java Developer, Конкорд банк)

Необходимо реализовать REST API на Java, позволяющее отправить на него http POST запрос и получить ответ.

1. Endpoint - шифрование запроса.
   Принимает на вход id пользователя, шифрует его ФИО (ФИО брать из бд) и возвращает в ответе.
   Пример запроса BODY:
   {"id": 1}
   Пример ответа BODY:
   {"fio_encr": "sfdjnva9sfv87say9hdfow3"}

2. Endpoint - дешифрование запроса.
   Принимает на вход зашифрованную строку с ФИО, на выходе дешифрованная строка с ФИО.
   Пример запроса BODY:
   {"fio_encr": "sfdjnva9sfv87say9hdfow3"}
   Пример ответа BODY:
   {"fio": "Test Testov"}


Требования:
- Формат запросов POST.
- Запрос и ответ в формате JSON.
- Запрос и ответ необходимо залогировать в отдельный файл, с указанием метки времени.
- Проект должен собираться в war, для установки на Tomcat.
- Подключить к проекту любую бд через Hibernate.
- Создать таблицу с пользователями (id + fio).
- Шифрование и дешифрование AES-256 алгоритмом.


Рекомендуется использовать Maven, Spring/Spring Boot, Log4j/Log4j2. Остальное на усмотрение разработчика. Желательно выполнить максимальное количество требований :)
#### How to test an API
- Run localy
- Go to http://localhost:8080/swagger-ui.html
- Go to usr-controller, open getEncodedUsrById and input 
{
  "id": 1
}
![image](https://user-images.githubusercontent.com/43958636/111880442-6239b600-89b4-11eb-8910-ecef9398f1d2.png)
- To decode the response go to decodeByFioEncr and input response from getEncodedUsrById
![image](https://user-images.githubusercontent.com/43958636/111880527-c2c8f300-89b4-11eb-88a4-49969a6b5c6b.png)

