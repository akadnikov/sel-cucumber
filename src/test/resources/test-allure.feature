#language: ru
Функционал: Тест allure

  @testTag
  Сценарий: Кукумбер1
    То ТЕСТ

  @testTag
  Сценарий: Кукумбер2
    То ТЕСТ

  Сценарий: Сложение одинарное
    Дано первое число 5
    И второе число 5
    Когда я их складываю
    Тогда сумма равна 10

  Структура сценария: Сложение двух чисел
    Дано первое число <первое>
    И второе число <второе>
    Когда я их складываю
    Тогда сумма равна <сумма>

    Примеры: 
      | первое | второе | сумма |
      | 6      | 6      | 12    |
      | 5      | 10     | 15    |

  Структура сценария: Сложение двух чисел еще раз
    Дано первое число <первое>
    И второе число <второе>
    Когда я их складываю
    Тогда сумма равна <сумма>

    Примеры: 
      | первое | второе | сумма |
      | 12     | 5      | 17    |
      | 22     | 11     | 33    |
