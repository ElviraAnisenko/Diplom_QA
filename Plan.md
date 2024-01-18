# План автоматизации тестирования

## 1. Перечень автоматизируемых сценариев

_Перед началом выполнения сценариев перейти на страницу сервиса - http://localhost:8080_

***

### 1.1 Переход к форме заполнения данных карты нажатием кнопки "Купить"

1) На странице сервиса нажать на кнопку "Купить".

_Ожидаемый результат_: на странице открывается раздел "Оплата по карте", содержащий форму заполнения данных карты.

***

### 1.2 Переход к форме заполнения данных карты нажатием кнопки "Купить в кредит"

1) На странице сервиса нажать на кнопку "Купить в кредит".

_Ожидаемый результат_: на странице открывается раздел "Кредит по данным карты", содержащий форму заполнения данных карты.

***

### 1.3 Отправка запроса на покупку тура при заполнении полей форм карты валидными данными 

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр; 
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам, 
то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`; 
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам, 
то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос отправлен, появляется всплывающее окно "Успешно операция одобрена банком".

***

### 1.4 Отправка пустого поля "Номер карты" при запросе покупки тура

1) Оставить поле "Номер карты" пустым.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Номер карты" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.5 Отправка пустого поля "Месяц" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Оставить поле "Месяц" пустым.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: `текущий год`, максимальное допустимое значение: `текущий год + 6 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Месяц" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.6 Отправка пустого поля "Год" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Оставить поле "Год" пустым.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Год" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.7 Отправка пустого поля "Владелец" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Оставить поле "Владелец" пустым.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Владелец" подсвечивается красным, под ним появляется надпись "Поле обязательно для заполнения".

***

### 1.8 Отправка пустого поля "CVC/CVV" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Оставить поле "CVC/CVV" пустым.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "CVC/CVV" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.9 Ввод карты со статусом "DECLINED" в поле "Номер карты" при запросе покупки тура 

1) Ввести невалидное значение в поле "Номер карты": 16 значный номер карты со статусом "DECLINED" `4444 4444 4444 4442`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос отправлен, появляется всплывающее окно "Ошибка! Банк отказал в проведении операции.".

***

### 1.10 Ввод карты с количеством символов менее 16 в поле "Номер карты" при запросе покупки тура

1) Ввести невалидное значение в поле "Номер карты": номер с количеством символов от 1 до 15.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Номер карты" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.11 Ввод дополнительной цифры перед номером карты со статусом "APPROVED" в поле "Номер карты" при запросе покупки тура

1) Ввести невалидное значение в поле "Номер карты": любую цифру, а затем 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: В поле "Номер карты" будут отображаться первые 16 символов, остальные будут обрезаны. Запрос отправлен, появляется всплывающее окно "Ошибка! Банк отказал в проведении операции."

***

### 1.12 Ввод дополнительной цифры после номера карты со статусом "APPROVED" в поле "Номер карты" при запросе покупки тура

1) Ввести невалидное значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`, а затем любую цифру.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: В поле "Номер карты" будут отображаться первые 16 символов, остальные будут обрезаны. Запрос отправлен, появляется всплывающее окно "Успешно операция одобрена банком".

***

### 1.13 Ввод невалидных значений (букв,символов) в поле "Номер карты" при запросе покупки тура

1) Ввести в поле значение из букв и символов в количестве 16 значений;

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Номер карты" остается пустым и  подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.14 Ввод номера месяца в формате "м" в поле "Месяц" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести невалидное значение в поле "Месяц": в формате "м" ввод только цифр от 1 до 9.

3) Ввести валидное значение в поле "Год":
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Месяц" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.15 Ввод значения превышающего 12 в поле "Месяц" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести невалидное значение в поле "Месяц":ввод только цифр превышающих число 12.

3) Ввести валидное значение в поле "Год": 
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Месяц" подсвечивается красным, под ним появляется надпись "Неверно указан срок действия карты".

***

### 1.16 Ввод значения "00" в поле "Месяц" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести невалидное значение в поле "Месяц" `00`.

3) Ввести валидное значение в поле "Год":
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Месяц" подсвечивается красным, под ним появляется надпись "Неверно указан срок действия карты".

***

### 1.17 Ввод невалидных значений (букв,символов) в поле "Месяц" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести невалидное значение в поле "Месяц": буквы и символы в количестве 2-х значений;

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: `текущий год`, максимальное допустимое значение: `текущий год + 6 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Месяц" остается пустым и подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.18 Ввод года в формате "г" в поле "Год" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести невалидное значение в поле "Год": цифру в формате "г".

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Год" подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.19 Ввод невалидных значений (букв,символов) в поле "Год" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести невалидное значение в поле "Год": буквы и символы в количестве 2-х значений.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "Год" остается пустым и подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.20 Ввод года в формате "гггг" в поле "Год" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести в формате "гггг" в поле "Год".

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: В поле "Год" будут отображаться первые 2 символа, остальные будут обрезаны. Запрос не отправлен, поле "Год" подсвечивается красным, под ним появляется надпись "Истёк срок действия карты".

***

### 1.21 Ввод истекшего срока действия карты при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести невалидное значение в поле "Год": в формате "гг" ввод только цифр `текущий год-1`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен. Поле "Год" подсвечивается красным, под ним появляется надпись "Истёк срок действия карты".

***

### 1.22 Ввод недействительного срока действия карты при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести невалидное значение в поле "Год": в формате "гг" ввод только цифр `текущий год + 7 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести валидное значение в поле "CVC/CVV": 3-х значный номер.

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен. Поле "Год" подсвечивается красным, под ним появляется надпись "Неверно указан срок действия карты".

***

### 1.23 Ввод невалидных значений (буквы, символы) в поле "CVC/CVV" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": - допустимы любые символы в количестве от 1.

5) Ввести невалидные значения (буквы и символы) в поле "CVC/CVV".

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "CVC/CVV" пустое и подсвечивается красным, под ним появляется надпись "Неверный формат".

***

### 1.24 Ввод 2-значного числа в поле "CVC/CVV" при запросе покупки тура

1) Ввести валидные значение в поле "Номер карты": 16 значный номер карты со статусом "APPROVED" `4444 4444 4444 4441`.

2) Ввести валидное значение в поле "Месяц": в формате "мм" ввод только цифр от 01 до 12.

3) Ввести валидное значение в поле "Год":
- в формате "гг" ввод только цифр;
- минимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или последующим месяцам,
  то `текущий год`, если предыдущим месяцам - то `текущий год + 1 год`;
- максимальное допустимое значение: если месяц окончания действия карты соответствуeт текущему или предыдущим месяцам,
  то `текущий год + 6 лет`, если последующим месяцам - то `текущий год + 5 лет`.

4) Ввести валидное значение в поле "Владелец": допустимы любые символы в количестве от 1.

5) Ввести  2-хзначное число в поле "CVC/CVV".

6) Нажать на кнопку "Продолжить".

_Ожидаемый результат_: Запрос не отправлен, поле "CVC/CVV" подсвечивается красным, под ним появляется надпись "Неверный формат".


## 2. Перечень используемых инструментов с обоснованием выбора.

- IntelliJ IDEA - среда для написания тестов;
- JDK - комплект инструментов для написания тестов на языке Java;
- Gradle - система для автоматизации сборки на языке Java;
- JUnit - для написания тестов для автоматического тестирования;
- Selenide - для тестирования веб-приложения, авоматизация действия веб-браузера;
- Docker - для быстрого развертывания  приложений MySQL, PostgreSQL, Node.js;
- Postman - для тестирования REST API.


## 3. Перечень и описание возможных рисков при автоматизации.

- Так как используются эмуляторы банковских приложений, нет возможности протестировать пользовательские ошибки при введении данных с реальных карт.
На текущий момент все данные карты будут генерироваться независимо друг от друга.
- Для тестирования используются фиксированные номера карт. Если тестовые данные будут изменены разработчиками, необходимо будет переписывать тесты. 
- Тесты будут написаны на Selenide. При изменении архитектуры страницы, текстов всплывающих окон, тесты будут падать. Необходимо будет переписывать автотесты. 


## 4. Интервальная оценка с учетом рисков в часах

- 20 часов, в том числе на риски 4 ч.


## 5. План сдачи работ

24.01.24 - написание автотестов;
27.01.24 - результаты прогонов автотестов.
