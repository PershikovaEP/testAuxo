# Тестовое задание

## Задача

Провести автоматизацию тестирования happy path формы Связаться с нами на сайте https://auxo-it.ru/ 3 разными способами:
* с помощью Selenide
* с помощью Selenium
* используя паттерн Page Object

## Итоги

Была проведена автоматизация тестирования happy path формы связаться с нами 3 разными способами. Во время поиска селекторов для автоматизации был обнаружен дефект: 
* Тройной повтор элементов pop-up Связаться с нами в DOM-дереве и соответственно в index.html.

Данный дефект занесен в issue.
  
В связи с найденным дефектом тест не был пройден. 

Комментарии к коду:
* для заполнения полей ввода input пришлось выбрать абсолютный путь к селектору от начала документа - от тега html,
* более грамотные селекторы были указаны в коде теста в комментариях,
* кнопка Отправить не нажимается в результате перекрытия идентичными элементами, соответственно переход на страницу Успешной отправки данных не произошел.
   
