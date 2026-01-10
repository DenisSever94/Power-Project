# My devtools project
[![Java CI with Checkstyle and JaCoCo](https://github.com/DenisSever94/Devtools-Project/actions/workflows/ci.yml/badge.svg)](https://github.com/DenisSever94/Devtools-Project/actions/workflows/ci.yml)
# Practice Project

# Quick start:

### Через Gradle Tool Window:
Откройте в правой части IDEA вкладку Gradle 
(или Tool View -> Tool Windows -> Gradle)
Разверните дерево проекта devtools -> Task 
Дважды щелкните по нужной задаче:
- **build** -> полная сборка проекта (компиляция, тесты, создание JAR)
- **test** -> запуск всех модульных тестов
- **run** -> запуск основного класса application

### Через Run Anything
- **Нажмите** -> Ctrl + Ctrl дважды в любой части IDE
- **В появившемся окне** введите имя задачи (build, test, run) и нажмите Enter
- **IDEA** выполнит задачу автоматически отрыв окно выполнения
- **Для задачи run** можно использовать зеленую стрелочку рядом ▶️ с объявлением сновного класса и методом main

### Packages
- **Структура пакетов организована по доменному принципу для обеспечения четкой логической организации кода:**
- **ru.mentee.power** корневой пакет проекта

### Table variables
- **String menteeName** Имя ученика работающим над задачами
- **int sprintNumber** Номер текущего спринта 
- **int plannedHoursPerWeek** Количество часов запланированных на рабочую неделю

### Правило readyForSprint()
- **Ученик готов** если количество часов >= 3

### Правило веток
- **master** основная ветка. В нее сливаются только проверенные изменения
- **feature/DVT-X** ветка для разработки новой функциональности, где 'X' это номер задачи

- **Examples:**
- 'master'- стабильная ветка по умолчанию
- 'feature/DVT-3'- ветка для разработки задачи DVT-3

## Сценарий ручной проверки DVT-6

### Запуск приложения
1. Откройте Gradle Tool Window (View → Tool Windows → Gradle)
2. Выполните: devtools → Tasks → application → run
3. Ожидаемый вывод в Run Tool Window:
   Суммарно: пройдено 25 из 36 уроков, осталось 11 уроков

### Запуск тестов
1. Откройте Gradle Tool Window
2. Выполните: devtools → Tasks → verification → test
3. Ожидаемый вывод: BUILD SUCCESSFUL, все тесты зелёные

### Отладка через Debug
1. Установите breakpoint на строке цикла while в ProgressTracker.calculateProgress
2. Запустите Debug: кликните правой кнопкой на main → Debug 'ProgressTracker.main()'
3. Используйте Step Over (F8) для прохождения итераций
4. Проверьте Variables: counter, remainingHours должны изменяться корректно
5. Используйте Evaluate Expression (Alt+F8): вычислите remainingLessons * 2
6. Ожидаемый результат Evaluate: 14 (для completedLessons=5, totalLessons=12)

### Что делать при ошибках
- Если вывод некорректен: проверьте логику цикла через Debug
- Если тесты красные: откройте вывод теста, найдите AssertionError, скорректируйте метод
- Если Debug не останавливается: убедитесь, что breakpoint установлен (красный кружок)

## Кодстайл-гайд проекта devtools

Проект следует правилам Google Java Style Guide с адаптацией.
Автоматическая проверка: ./gradlew checkstyleMain

### 1. Именование методов: camelCase

До:    public void add_student(Student s) { }
После: public void addStudent(Student student) { }

Почему: Java Convention требует camelCase для методов.
Источник: https://google.github.io/styleguide/javaguide.html#s5.3-camel-case

### 2. Пробелы после if/for/while

До:    if(condition) {
После: if (condition) {

Почему: улучшает читаемость, отделяет ключевое слово от выражения.
Источник: Oracle Code Conventions — Whitespace

### 3. Длина строки: максимум 120 символов

До:    public List getStudentsFromSpecificCityWithVeryLongName...
После: public List getStudentsByCity(String city) {

Почему: длинные строки затрудняют чтение в редакторе и при code review.
Источник: https://google.github.io/styleguide/javaguide.html#s4.4-column-limit

### 4. Порядок импортов

До: 
import java.util.List; 
import java.util.ArrayList; 
import java.io.File;

После:
import java.io.File;
import java.util.ArrayList;
import java.util.List;

Почему: алфавитный порядок упрощает поиск импортов.
Источник: IntelliJ IDEA → Code → Optimize Imports

### 5. Фигурные скобки для if

До:    if (condition) doSomething();
После: if (condition) { doSomething(); }

Почему: скобки обязательны даже для однострочных блоков.
Источник: https://google.github.io/styleguide/javaguide.html#s4.1.1-braces-always-used

## Code Review Checklist

Используйте этот чеклист для само-ревью перед запросом ревью у ментора:

### Функциональность
- [ ] Код решает поставленную задачу полностью
- [ ] Обработаны граничные случаи (null, пустые данные, экстремальные значения)
- [ ] Обработка ошибок реализована корректно

### Тесты
- [ ] Добавлены тесты для нового функционала (или обновлены существующие)
- [ ] Все тесты проходят локально: `./gradlew test`
- [ ] Покрыты позитивные и негативные сценарии
- [ ] JaCoCo coverage ≥ 80% для нового кода

### Читаемость и стиль
- [ ] Имена переменных, методов и классов отражают назначение
- [ ] Нет дублирования кода (DRY principle)
- [ ] Checkstyle проходит без ошибок: `./gradlew checkstyleMain`
- [ ] Нет закомментированного кода или отладочного вывода (`System.out.println`)

### Документация
- [ ] README обновлён (если добавлена новая функциональность)
- [ ] Публичные методы имеют JavaDoc (если применимо)
- [ ] Примеры использования актуальны
- [ ] Runbook обновлён (если изменились команды запуска/проверки)

### Производительность и безопасность
- [ ] Нет очевидных проблем производительности
- [ ] Нет хардкода паролей, токенов или конфиденциальных данных

## Примеры Code Review комментариев

### Хорошие комментарии (конструктивные)

**Пример 1:**

**Проблема:** Метод `calculateDiscount` (строка 45) имеет 3 вложенных if-else и 40 строк.
**Почему это важно:** Сложная логика плохо тестируется и тяжело поддерживается.
**Предложение:** Вынести каждое условие в отдельный метод (например, `isEligibleForBonusDiscount()`)
и использовать паттерн Strategy для разных типов скидок.



**Пример 2:**

**Проблема:** Тест `testProcessOrder` (строка 78) проверяет только успешный сценарий.
**Почему это важно:** Не проверена обработка ошибок при недостаточном балансе.
**Предложение:** Добавить тест `testProcessOrder_InsufficientBalance_ThrowsException()`
с использованием `assertThatThrownBy()`.



### Плохие комментарии (неконструктивные)

**Пример 1:**

Этот код ужасен, полностью переписать.


**Почему плохо:** Нет конкретики (что именно плохо), нет предложения (как исправить),
токсичный тон (демотивирует автора).

**Пример 2:**

Здесь лучше использовать Stream API.


**Почему плохо:** Нет объяснения почему лучше, нет примера как переписать,
неясно какую проблему это решает.


## Результаты само-ревью DVT-9

### Найдено и исправлено проблем: 3

#### 1. Проблема в классе StudentList нет метода для поиска студента по имени
**Файл** src/main/java/ru/mentee/power/devtools/student/StudentList.java 

**Суть** есть метод для поиска студента по городу, но нет по имени

**Почему важно** Пользователь может найти студента по имени 

**Как исправить** предлагаю реализовать метод для поиска по имению findStudentByName


#### 2. Нейминг studentList
**Файл** src/main/java/ru/mentee/power/devtools/student/StudentList.java 

**Суть** название переменной в строке 8 "studentList" может быть избыточным так как и класс называется StudentList

**Как исправить** предлагаю переименовать в "students", так будет понятней, что это список студентов и никак не будут
пересекаться с названием класса.


#### 3. Нейминг метода getStudent 
**Файл** src/main/java/ru/mentee/power/devtools/student/StudentList.java 

**Суть** название метода в целом рабочее, но для читабельности и более точного понимания, что делает метод,
а метод именно ищет студента в списке students, предлагаю переименовать на findStudentByCity.

#### Формат сообщения сдачи в Telegram 

- DVT-9: Правила Code Review
- Репозиторий: ССЫЛКА
- Pull Request: ССЫЛКА
- Статус: готова
  @dev_tools



