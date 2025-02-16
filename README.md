# TARATAIKA.COM - Based On Mobile.bg

СУ - ФМИ - Зимен семестър 2024/2025
- Изготвил: Стоян Стоянов Иванов
- Специалност: Информатика, 3 курс
- Факултетен номер: 9MI0400132
- Ръководител на курса: Филип Янков

## Увод
- Проектът е разработван в продължение на един академичен семестър, като в процеса на работа са прилагани различни методологии за проектиране, анализ и имплементация. Изходният код е периодично разширяван и допълван в съответствие с изискванията на възложените задания, като всяка седмица са извършвани подобрения, оптимизации и добавяне на нови функционалности.

## Седмица 1 - Софтуерна архитектура. Какво е Mobile.bg? 
Какво трябва да съдържа приложението?
- Обява - запазване и редактиране;
- Колекция от обяви;
- Спонсорирана обява;
- Отзиви;
- История на цените;

- Филтър;
- Търсене;

- Купувач;
- Продавач;
- Гост;
- Къщи за превозни средства/Dealership;

- Превозни средства;
- Части;
- Услуги;

- Чат (между купувач и продавач).

![Фигура 1.](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/diagram.png)
```yaml
Фигура 1.
```

## Седмица 2 - Потребители
- Repository Pattern е модел за проектиране на софтуер, който действа като междинен слой между бизнес логиката на приложението (UserService) и съхранението на данни (UserRepository);
- Основната му цел е да осигури структуриран и стандартизиран начин за достъп, управление и манипулиране на данни, като същевременно абстрахира детайлите на технологията за съхранение чрез интерфейса UserRepository и неговата имплементация UserRepositoryImplementation;
- В този контекста, UserServiceImplementation действа като посредник, като осигурява методи за добавяне (addUser), изтриване (deleteUser) и търсене на потребители (getUserById), без да се налага директен достъп до вътрешното хранилище (storage);
- Това позволява лесна подмяна или разширение на начина, по който се съхраняват данните (например, вместо HashMap, може да се използва база данни), без да се променя бизнес логиката на приложението;
- Repository Pattern работи като библиотекар между програмата и данните – вместо UserService директно да търси и манипулира потребители, той използва UserRepository, който се грижи за тяхното съхранение и достъп.

## Седмица 3 - Продукти
- Основната идея на тази седмица е тясно свързана с понятието "преизползваемост" на кода. В софтуерното инженерство преизползваемостта играе ключова роля за намаляване на дублирането на код и улесняване на бъдещи модификации. Неформално казано, ако след време се наложи създаването на подобно приложение, но за продажба на друг тип продукти, например козметика, кодът трябва да бъде структуриран така, че 70-80% от вече написаното да може да бъде използвано повторно;
- За постигането на тази цел се прилага принципът на абстракцията и се дефинира основен клас Product, който служи като родител за всички специфични типове продукти. В обектно-ориентираното програмиране това се постига чрез създаване на абстрактен клас или интерфейс, който да дефинира общото поведение на всички продукти;
- Приложението за продажби трябва да поддържа различни видове продукти. Например, в контекста на Mobile.bg, стандартните категории продукти могат да включват: кола, камион, яхта, част, аксесоар и т.н.
Всеки от тези продукти ще наследява Product и ще разширява неговата функционалност със специфични характеристики.

## Седмица 4 - Обява
- Подобно на Седмица 2, тук за "Обява" отново е използван Repository Pattern;
- Repository Pattern осигурява слой между бизнес логиката (ListingService) и съхранението на обяви (ListingRepository), абстрахирайки детайлите на достъпа до данни;
- ListingRepository и неговата имплементация ListingRepositoryImplementation управляват съхранението, добавянето и изтриването на обяви;
- ListingServiceImplementation предоставя методи за манипулация на обяви, като гарантира, че само регистрирани потребители могат да ги добавят или изтриват.

## Седмица 5 - Филтри
- Extractor Pattern се използва за извличане на специфични данни от обект по структуриран и модулен начин.
- В този код той е реализиран чрез интерфейса FieldExtractor<T, V>, който дефинира метод extractValue(T var). FieldExtractor<T, V> интерфейс декларира метод extractValue(T var), който извлича определено поле от даден обект T и го връща като стойност от тип V. Интерфейсът Filter<T> дефинира метода visit(T var), който проверява дали даден обект отговаря на определени критерии.
- В крайна сметка, Filter и FieldExtractor работят заедно, като FieldExtractor първо извлича нужната стойност от обекта, а Filter я използва за валидация или филтриране.

## Седмица 6 - Абонаменти
- Задачата за Седмица 6 е следната:
*Разширете съществуващата система за нотификации, като внедрите правилните и необходими абстракции с оглед на преизползваемост, cohesion и coupling. Потребителите могат да се абонират за обяви, които отговарят на определени условия (напр. "Audi, дизел, 2005-2015"). Когато се създаде обява, отговаряща на зададените условия, трябва да се изпрати съответната нотификация. Трябва да използвате следните три класа без промени:*

```yaml
public class SmsNotifier {
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message); }}
 
public class EmailNotifier {
    public void sendEmail(String email, String title, String message) {
        System.out.println("Sending email to " + email + " with title: " + title + " and message: " + message); }}
 
public class PigeonNotifier {
    public void sendPigeon(String address, Integer pigeonNumber, String message) {
        System.out.println("Sending pigeon to " + address + " with message: " + message); }}
```
> *Solution:* Adapter Pattern & Observer Pattern дават ефективно решение на задачата.
- Adapter Pattern се използва за интеграция на различните видове нотификации (SmsNotifier, EmailNotifier, PigeonNotifier, OnFootNotifier) към общ интерфейс SubscribtionType. Външните класове SmsNotifier, EmailNotifier, PigeonNotifier и OnFootNotifier имат различни методи за изпращане на съобщения (sendSms, sendEmail, sendPigeon, deliverOnFoot). За да се унифицира интерфейсът, са създадени адаптери (SmsSubscribtion, EmailSubscribtion, PigeonSubscribtion, OnFootSubscribtion), които имплементират SubscribtionType. Всеки адаптер преобразува извикванията на update() към съответния метод на оригиналния клас.
- Observer Pattern се използва за управление на абонаментите и автоматично уведомяване на абонатите при нова обява. SubscribtionService играе ролята на Subject (източник на събития), който следи за нови обяви.
SubscribtionRule е връзката между филтър и тип на нотификация. При добавяне на нова обява, SubscribtionService проверява дали някой от абонатите отговаря на критериите и ако да – изпраща нотификация.

## Showcase:
1. Initial Demo - Shows how to add and delete users and listings;
2. Filters Demo - Shows how to filter listings;
3. Subscribtion Demo - Shows how to subscribe to get notifications based on different filters;
4. Listing History Demo - Shows the history of the changes made to a listing;
5. Product History Demo - Shows the history of the changes made to a product and presents a graph;
6. Parser Demo (WIP) - Shows how to search by filters;
7. Console:
- Languages - German and English;
- Registering;
- Logging In;
- Logging Out;
- Adding & Deleting listings when logged in;
- Viewing all listings and all users.

## Patterns:
- User - Repository Pattern;
- Subscribtions - Observer Pattern;
- Products - Factory Pattern;
- Parser - Interpreter Pattern;
- Listings - Repository Pattern;
- Languages - Strategy Pattern;
- History - Memento Pattern;
- Filters - Composite Pattern;
- Commands - Command Pattern;
- Console - OOP Principles.

## Fix:
- Decouple the adding of a listing from Standard Input & Output;
- Add the functionality from the Demo 2, 3, 4, 5 to the Console;
- Fix (and finish) the GUI;
- Fix the parser.

## Fun Fact:
- Името на програмата е базирано на тази песен: [Подуене Блус Бенд - Таратайка](https://www.youtube.com/watch?v=EqRddn_Tq9w)
