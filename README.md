# DictionaryTask
Реализовать приложение для поиска переводов слов в словаре, состоящее из двух экранов:
* Экран, содержащий форму поиска слова и таблицу отображения результатов
* Экран, отображающий подробную информацию о слове (текст, перевод и картинка, остальные поля по желанию), открывается по нажатию на ячейку в таблице с результатами поиска
Загрузку данных о словах производить при помощи публичного API, документация находится [здесь](https://dictionary.skyeng.ru/doc/api/external)

## Дополнение
Для Android использовать Kotlin
* К коду приложить Readme, где коротко описывается как собрать и запустить код
* Результат выполнения загрузить на любой Git-хостинг и прислать ссылку, zip-файлы и прочие форматы не принимаются
* Использование сторонних библиотек разрешается, в этом случае в Readme нужно указать зачем она используется
* Приложение должно корректно обрабатывать повороты экрана
* К приложению должен быть написан хотя бы 1 юнит-тест
* Реализованная функциональность должна быть максимально близка к production-состоянию
* UI приложения должен соответствовать гайдлайнам платформы.

# Используемые библиотек

**Dagger2** - is a compile-time framework for dependency injection. It uses no reflection or runtime bytecode generation, does all its analysis at compile-time, and generates plain Java source code.[Сслыка на GitHub](https://github.com/google/dagger). [Что такое dependency injection?](https://ru.wikipedia.org/wiki/Внедрение_зависимости)
**Moxy** - is a library that allows for hassle-free implementation of the MVP pattern in an Android Application. Without troubles of lifecycle and boilerplate code! [Сслыка на GitHub](https://github.com/Arello-Mobile/Moxy) [Описание архитектурного паттерна MVP](https://ru.wikipedia.org/wiki/Model-View-Presenter)
**GSON** - is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. [Сслыка на GitHub](https://github.com/google/gson)
**Glide** -  is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface. [Ссылка на GitHub](https://github.com/bumptech/glide)

### Справка по markdown
Всю информацию по markdown можно найти [здесь](https://guides.github.com/features/mastering-markdown/)