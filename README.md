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

**Dagger2** - is a compile-time framework for dependency injection. It uses no reflection or runtime bytecode generation, does all its analysis at compile-time, and generates plain Java source code.[Сслыка на GitHub](https://github.com/google/dagger). Что такое [dependency injection](https://ru.wikipedia.org/wiki/Внедрение_зависимости)?
Причина применения: Популярное решение для внедрения зависимостей, хорошо знакомое мне из-за чего разработка не замедлялась (небыло необходимости в изучение новых незнакомых интерфейсов). Помогает написать слабую связь между компонентами архитектуры(см. [MVP](https://ru.wikipedia.org/wiki/Model-View-Presenter))

**Moxy** - is a library that allows for hassle-free implementation of the MVP pattern in an Android Application. Without troubles of lifecycle and boilerplate code! [Сслыка на GitHub](https://github.com/Arello-Mobile/Moxy) Описание архитектурного паттерна [MVP](https://ru.wikipedia.org/wiki/Model-View-Presenter)

Причина применения: Библиотека реализующая архитектуру MVP и освобождающая от решения проблем жизненного цикла Android(повороты экрана). Из недостатков - хотелось бы сделать презентер классом обёрнутым в интерфейс.

**GSON** - is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. [Сслыка на GitHub](https://github.com/google/gson)

Причина применения: Хорошо знакомая мне библиотека для разбора JSON. Вероятно не самое модное и не самое дешевое/эффективное решение, но предельно простое.

**Glide** -  is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface. [Ссылка на GitHub](https://github.com/bumptech/glide)

Причина применения: Знакомая мне и удобная библиотека для управления и загрузки изображений из сети в элементы UI. При необходимости можно обеспечить их кэширование, что снизит нагрузку по запросам в сеть.

**Retrofit** - a type-safe HTTP client for Android and Java. [Ссылка на GitHub](https://github.com/square/retrofit)

Причина применения: Хорошо знакомая мне библиотека для работы с REST API. Так же из преимуществ, масса доработак от сообщества, позволяющих расширить функционал.

**RxJavaRetrofitAdapter** - adapter for Retrofit 2. [Ссылка на GitHub](https://github.com/akarnokd/RxJavaRetrofitAdapter)

Причина применения: Для удобного совмещения Retrofit2 с RxJava3 использовал эту библиотеку. В сети уже есть разбор, по которому можно написать это вручную, но для экономии времени использовал готовую адаптацию. Преобразует Call в Obeservable/Single/Maybe/и.т.д.

**RxBinding** - APIs for Android UI widgets from the platform and support libraries. [Ссылка на GitHub](https://github.com/JakeWharton/RxBinding)

Причина применения: Набор удобных утилит для работы с android views в rx-стиле. Из коробки куча полезных функций. В данном случае, применил для наблюдения за полем поиска.

**RxJava3** - is a Java VM implementation of Reactive Extensions: a library for composing asynchronous and event-based programs by using observable sequences. [Ссылка на GitHub](https://github.com/ReactiveX/RxJava)

Причина применения: Ежедневно на текущей позиции мне приходится работать с RxJava, поэтому я решил выбрать эту библиотеку для экономии времени, несмотря на моду на другие решения.

### Справка по markdown
Всю информацию по markdown можно найти [здесь](https://guides.github.com/features/mastering-markdown/)

### Что можно было сделать лучше
* Реализовать другую версию задания с использованием MVVM-архитиктуры и Android Architecture Components  
* Можно было попробовать работу с корутинами в замену RxJava
* Можно было бы вынести текстовые и прочие ресурсы для поддержки локализации
* Можно было бы скрыть за интерфейсом презентер
* С помонью расширений котлина сделать build.gradle.kts нескольки лаконичней
