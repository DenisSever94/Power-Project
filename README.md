# My devtools project

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

- **ПРИМЕРЫ:**
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