# sber_mega_market
<h1 >Проект по автоматизации тестирования для <a href="https://sbermegamarket.ru/">SberMegaMarket</a></h1>

## Содержание

* <a href="#description">Описание</a>
* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#selenoidvideo">Пример прогона теста в Selenoid</a>
* <a href="#browserstackvideo">Пример прогона теста в Browserstack</a>

<a id="description"></a>

## Описание

Данный проект состоит из автоматизированных:

* UI-тестов для веб-приложения [sbermegamarket.ru](https://sbermegamarket.ru)

<a id="tools"></a>

## Технологии и инструменты

<p align="center">
<img width="5%" title="IntelliJ IDEA" src="images/logo/IntelliJ_IDEA.png">
<img width="5%" title="Java" src="images/logo/Java_logo.png">
<img width="5%" title="Selenide" src="images/logo/Selenide.png">
<img width="5%" title="Selenoid" src="images/logo/Selenoid.png">
<img width="5%" title="Allure Report" src="images/logo/AllureReports.png">
<img width="5%" title="Gradle" src="images/logo/Gradle.png">
<img width="5%" title="JUnit5" src="images/logo/JUnit5.png">
<img width="5%" title="GitHub" src="images/logo/GitHub.png">
<img width="5%" title="Jenkins" src="images/logo/Jenkins.png">
<img width="5%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="5%" title="REST Assured" src="images/logo/RestAssured.png">
<img width="5%" title="Android Studio" src="images/logo/AndroidStudio.svg">
<img width="5%" title="Appium" src="images/logo/Appium.svg">
<img width="5%" title="Appium Inspector" src="images/logo/Inspector.png">
<img width="5%" title="Browserstack" src="images/logo/Browserstack.svg">
<img width="5%" title="Telegram" src="images/logo/Telegram.svg">
</p>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>, применены различные
библиотеки и фреймворки.

Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами
в <code>Telegram</code> после завершения прогона.
В качестве системы управления тестированием выбран <code>Allure TestOps</code>.

Allure-отчет включает в себя:

* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

### Для UI-тестов

* при написании использован фреймворк [Selenide](https://selenide.org/)
* запуск осуществляется локально или с помощью [Selenoid](https://aerokube.com/selenoid/).

<a id="cases"></a>

## Реализованные проверки

### Автоматизированные проверки UI

- [ ] Проверка поиска товара
- [ ] Проверка очистки строки поиска
- [ ] Проверка присутствиея на главной странице названия логотипа

### Мануальные проверки

- [ ] Фильтрация товара в расширенном фильтре

<a id="console"></a>

## Запуск тестов

### Локальный запуск тестов

#### Для UI-тестов

```
./gradlew clean ui_tests -Denv=local
```

#### Для API-тестов

```
./gradlew clean api_tests 
```

#### Для MOBILE-тестов

```
./gradlew clean mobile_tests -DdeviceHost=emulator
```

### Удаленный запуск тестов

Выбираем опции Gradle в зависимости от типа запускаемых тестов: 
* UI-тесты запускаем с передачей <code>BROWSER_PLATFORM</code>, <code>BROWSER_VERSION</code>, 
<code>BROWSER_SIZE</code>, <code>REMOTE_URL</code>
* API-тесты запускаем без параметризации
* Mobile-тесты запускаем с `deviceHost` (`browserstack`)

```
bash run.sh [api_tests|ui_tests|mobile_tests]
```

Для запуска тестов локально или удалённо, требуется указать вид теста первым параметром. Далее, с помощью переменных
окружения (см. ниже), сконфигурировать запуск тестов.

> `${BROWSER}` - комбинация браузера и версии (_по умолчанию - <code>chrome 100.0</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1366x768</code>_).
>
> `${REMOTE_URL}` - адрес удаленного сервера, на котором будут запускаться тесты.

Например, для запуска API-тестов:

```
bash run.sh api_tests
```

Для запуска UI-тестов локально:

```
BROWSER="chrome 112.0" BROWSER_SIZE="1920x1080" bash run.sh ui_tests
```

Для запуска UI-тестов удалённо:

```
BROWSER="chrome 112.0" BROWSER_SIZE="1920x1080" REMOTE_URL="http://selenium.webdriver.tld:4444/wd/hub" bash run.sh ui_tests
```

<a id="jenkins"></a>

## Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/017-maryregen-java-automation-tests-for-hh/)

1. Для запуска сборки необходимо перейти в раздел **Собрать с параметрами**
2. Запуская ui-тесты, необходимо указать параметры для сборки (путем выбора из списка или прямым указанием значения) и
   в <code>TEST_TYPE</code> выбрать ui-tests.
3. Запуская api-тесты или mobile-тесты, можно оставить все предзаполненные поля, поменяв <code>TEST_TYPE</code>
   соответственно на api_tests или mobile_tests.
4. Нажать кнопку **Собрать**.

<p align="center">
<img src="images/screenshots/JenkinsJob.png"/></a>
</p>

<a id="allure"></a>

## Отчеты в [Allure Report](https://jenkins.autotests.cloud/job/017-maryregen-java-automation-tests-for-hh/16/allure/)

### Прохождение UI-тестов

<p align="center">
<img src="images/screenshots/AllureSuitsUI.png">
</p>

### Прохождение API-тестов

<p align="center">
<img src="images/screenshots/AllureSuitsApi.png">
</p>

### Прохождение mobile-тестов

<p align="center">
<img src="images/screenshots/AllureSuitsMobile.png">
</p>

<a id="testops"></a>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1846/dashboards)

### Прохождение UI-тестов

<p align="center">
<img src="images/screenshots/TestOpsLaunchUI.png">
</p>

### Пример мануального тест-кейса

<p align="center">
<img src="images/screenshots/TestOpsManualCases.png">
</p>

### Прохождение API-тестов
<p align="center">
<img src="images/screenshots/TestOpsLaunchApi.png">
</p>

### Прохождение mobile-тестов

<p align="center">
<img src="images/screenshots/TestOpsLaunchMobile.png">
</p>

<a id="jira"></a>

## Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-514)

<p align="center">
<img src="images/screenshots/JiraIssue.png">
</p>

<a id="telegram"></a>

## Уведомления в Telegram с использованием бота

### Уведомление о прохождении UI-тестов

<p align="center">
<img src="images/screenshots/TelegramBotUI.png">
</p>

### Уведомление о прохождении API-тестов

<p align="center">
<img src="images/screenshots/TelegramBotApi.png">
</p>

### Уведомление о прохождении mobile-тестов

<p align="center">
<img src="images/screenshots/TelegramBotMobile.png">
</p>

<a id="selenoidvideo"></a>

## Пример прогона UI-теста в Selenoid

К каждому тесту в отчете прилагается видео.
<p align="center">
  <img src="images/video/VideoGif.gif">
</p>

<a id="browserstackvideo"></a>

## Пример прогона mobile-теста в Browserstack

К каждому тесту в отчете прилагается видео.
<p align="center">
  <img src="images/video/MobileVideoGif.gif">
</p>
