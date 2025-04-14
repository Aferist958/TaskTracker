TaskTracker


Описание

Веб-приложение для создание и выполнения задач

Установка

Шаги:

1. Клонируем репозиторий
    ```
   git clone https://github.com/Aferist958/TaskTracker.git
   ```
2. Сборка
    ```
    cd .\tasktracker\ 
    mvn package -DskipTests
   ```
3. Запуск
    Для запуска должен быть включён Docker Desktop
    ```
   docker-compose up --build 
   ```