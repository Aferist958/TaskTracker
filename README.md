TaskTracker


Описание

Веб-приложение для создание и выполнения задач

Установка

Шаги:

1. Клонируем репозиторий
    ```
   git clone https://gitlab.com/16791647/tasktracker.git
   ```
2. Сборка
    ```
   mvn package
   ```
3. Запуск
    Для запуска должен быть включён Docker Desktop
    ```
   docker-compose up --build 
   ```