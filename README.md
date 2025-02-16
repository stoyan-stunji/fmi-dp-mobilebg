# TARATAIKA.COM - Based On Mobile.bg

СУ - ФМИ - Зимен семестър 2024/2025
- Изготвил: Стоян Стоянов Иванов
- Специалност: Информатика, 3 курс
- Факултетен номер: 9MI0400132
- Ръководител на курса: Филип Янков

## Увод
- Проектът е разработван в продължение на един академичен семестър, като в процеса на работа са прилагани различни методологии за проектиране, анализ и имплементация. Изходният код е периодично разширяван и допълван в съответствие с изискванията на възложените задания, като всяка седмица са извършвани подобрения, оптимизации и добавяне на нови функционалности.

## Седмица 01 - Софтуерна архитектура. Какво е Mobile.bg? 
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

![figure_1](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/diagram.png)
```yaml
Фигура 1.
```

## Седмица 02 - Потребители
- Repository Pattern е модел за проектиране на софтуер, който действа като междинен слой между бизнес логиката на приложението UserService и съхранението на данни UserRepository;
- Основната му цел е да осигури структуриран и стандартизиран начин за достъп, управление и манипулиране на данни, като същевременно абстрахира детайлите на технологията за съхранение чрез интерфейса UserRepository и неговата имплементация UserRepositoryImplementation;
- В този контекста, UserServiceImplementation действа като посредник, като осигурява методи за добавяне - addUser, изтриване - deleteUser, и търсене на потребители - getUserById, без да се налага директен достъп до вътрешното хранилище storage;
- Това позволява лесна подмяна или разширение на начина, по който се съхраняват данните (например, вместо HashMap, може да се използва база данни), без да се променя бизнес логиката на приложението;
- Repository Pattern работи като библиотекар между програмата и данните – вместо UserService директно да търси и манипулира потребители, той използва UserRepository, който се грижи за тяхното съхранение и достъп.

## Седмица 03 - Продукти
- Основната идея на тази седмица е тясно свързана с понятието "преизползваемост" на кода. В софтуерното инженерство преизползваемостта играе ключова роля за намаляване на дублирането на код и улесняване на бъдещи модификации. Неформално казано, ако след време се наложи създаването на подобно приложение, но за продажба на друг тип продукти, например козметика, кодът трябва да бъде структуриран така, че 70-80% от вече написаното да може да бъде използвано повторно;
- За постигането на тази цел се прилага принципът на абстракцията и се дефинира основен клас Product, който служи като родител за всички специфични типове продукти. В обектно-ориентираното програмиране това се постига чрез създаване на абстрактен клас или интерфейс, който да дефинира общото поведение на всички продукти;
- Приложението за продажби трябва да поддържа различни видове продукти. Например, в контекста на Mobile.bg, стандартните категории продукти могат да включват: кола, камион, яхта, част, аксесоар и т.н.
Всеки от тези продукти ще наследява Product и ще разширява неговата функционалност със специфични характеристики.

## Седмица 04 - Обява
- Подобно на Седмица 2, тук за "Обява" отново е използван Repository Pattern;
- Repository Pattern осигурява слой между бизнес логиката ListingService и съхранението на обяви ListingRepository, абстрахирайки детайлите на достъпа до данни;
- ListingRepository и неговата имплементация ListingRepositoryImplementation управляват съхранението, добавянето и изтриването на обяви;
- ListingServiceImplementation предоставя методи за манипулация на обяви, като гарантира, че само регистрирани потребители могат да ги добавят или изтриват.

## Седмица 05 - Филтри
- Extractor Pattern се използва за извличане на специфични данни от обект по структуриран и модулен начин.
- В този код той е реализиран чрез интерфейса FieldExtractor, който дефинира метод extractValue(T). FieldExtractor интерфейс декларира метод extractValue(T), който извлича определено поле от даден обект T и го връща като стойност от тип V. Интерфейсът Filter дефинира метода visit(T), който проверява дали даден обект отговаря на определени критерии.
- В крайна сметка, Filter и FieldExtractor работят заедно, като FieldExtractor първо извлича нужната стойност от обекта, а Filter я използва за валидация или филтриране.

## Седмица 06 - Абонаменти
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
- Adapter Pattern се използва за интеграция на различните видове нотификации - SmsNotifier, EmailNotifier, PigeonNotifier, OnFootNotifier, към общ интерфейс SubscribtionType. Тези външни класове имат различни методи за изпращане на съобщения - sendSms, sendEmail, sendPigeon, deliverOnFoot съответно. За да се унифицира интерфейсът, са създадени адаптери - SmsSubscribtion, EmailSubscribtion, PigeonSubscribtion, OnFootSubscribtion, които имплементират SubscribtionType. Всеки адаптер преобразува извикванията на update() към съответния метод на оригиналния клас.
- Observer Pattern се използва за управление на абонаментите и автоматично уведомяване на абонатите при нова обява. SubscribtionService играе ролята на Subject (източник на събития), който следи за нови обяви.
SubscribtionRule е връзката между филтър и тип на нотификация. При добавяне на нова обява, SubscribtionService проверява дали някой от абонатите отговаря на критериите и ако да – изпраща нотификация.

![subscribtion](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/subscribtion.JPG)
```yaml
Фигура 2.
```

## Седмица 07 - Сложни Филтри
- Задачата за Седмица 7 е следната: *В момента NotificationRule съдържа масив от правила, които NotificationService изисква да бъдат изпълнени изцяло, преди да изпрати нотификация. Това означава, че всички условия в списъка трябва да бъдат изпълнени едновременно. Клиентите изискват възможност за дефиниране на по-сложни логически операции между филтрите, за да могат да задават по-гъвкави правила за нотификации.
За целта трябва да се поддържат следните видове логически операции:*
```yaml
> И (AND) филтър – нотификацията се изпраща, ако всички вътрешни филтри са изпълнени;
> ИЛИ (OR) филтър – нотификацията се изпраща, ако поне един от вътрешните филтри е изпълнен;
> N от M филтър – нотификацията се изпраща, ако поне N от M филтри са изпълнени.
Например: "Искам поне 2 от 3 да са изпълнени – [дизел, Ауди, след 2003]".
```
> *Solution:* Composite Pattern.

- Composite Pattern е структурен шаблон, който позволява да изграждане на йерархии от обекти, където индивидуалните обекти и групите от обекти могат да се третират по един и същи начин. Това се постига чрез дефиниране на унифициран интерфейс, в случая Filter<T>, който може да бъде имплементиран както от отделни филтри - RangeFilter, ExactValueFilter, CaseInsensitiveFilter, така и от композиционни филтри AndFilter, OrFilter, NotFilter, NOfMFilter;
- Компонентен интерфейс (Filter<T>): Всички филтри имплементират един и същ интерфейс Filter, което осигурява унифициран начин за работа с тях;
- Листови компоненти (Leaf Components): RangeFilter, ExactValueFilter и CaseInsensitiveFilter;
Това са основните филтри, които изпълняват конкретна логика за филтриране на даден обект.
- Композитни компоненти (Composite Components): AndFilter – изисква всички вложени филтри да върнат true, за да върне true, OrFilter – връща true, ако поне един от вложените филтри върне true, NotFilter – обръща резултата на вложения филтър, и NOfMFilter – връща true, ако поне n от вложените филтри върнат true.

## Седмица 08 - История на Обява
- Memento Pattern е използван, за да се съхранява и възстановява състоянието на обект от тип Listing. Това позволява връщане към предишни състояния - за операции за undo/redo;
- ListingOriginator отговаря за създаването на моментни снимки на текущото състояние и може да възстановява предишно състояние;
- ListingMemento осигурява метод за извличане на това състояние - getListingSnapshot();
- ListingCaretaker управлява стек от моментни снимки, запазвайки различните състояния на Listing. Позволява връщане назад в историята чрез метода restoreState(int).

![listing_history](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/listing_history.JPG)
```yaml
Фигура 3.
```

## Седмица 09 - ID Генератор
- Singleton Pattern е шаблон, който гарантира, че даден клас има само една единствена инстанция и предоставя глобална точка за достъп до него. Контролира достъпа до споделен ресурс - тук, всеки потребител има уникален номер, инкрементирайки номера на последния регистриран клиент.

## Седмица 10 - Анализатор
- Задачата за Седмица 10 е: *Реализирайте клас, който имплементира интерфейса Searcher. Този клас трябва да приема колекция от обяви и заявка (query) и да връща само тези коли, които отговарят на критериите, зададени в заявката. Входът е списък с обяви, където има определени атрибути (например brand, model и други), и стринг заявка (query string), който описва критериите за търсене. Дадени са:*
```yaml
> Клас QueryParser, който преобразува заявката в Полски запис (Prefix notation);
> Интерфейс Searcher, който трябва да бъде имплементиран;
> Клас QueryTester, който тества вашата имплементация и предоставя примери за синтаксиса на заявките.
```
> *Solution:* Interpreter Pattern.
- Interpreter Pattern е поведенчески шаблон за, който се използва за интерпретиране на домейн-специфичен език (DSL). Основната идея е да се дефинира граматика за езика и да се осигури механизъм за интерпретация на изразите.
- Класът QueryParser преобразува заявката в обратна полска нотация (RPN). Разделя заявката на условия (като brand = 'bmw') и оператори (|, &). Използва стек, за да обработи приоритетите на операторите и да генерира постфиксно представяне на заявката;
- SearcherImplementation – интерпретатор на заявката. Този клас използва резултата от QueryParser и прилага шаблона Interpreter върху обектите от тип Listing.
- За обработка на AND и OR операторите се използват AndFilter и OrFilter.

![parser](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/parser.JPG)
```yaml
Фигура 4.
```

## Седмица 11 - История на Продукт
- Memento Pattern е използван, за да се съхранява и възстановява състоянието на обект от тип Product. Това позволява връщане към предишни състояния – за операции по undo/redo;
- ProductOriginator отговаря за създаването на моментни снимки на текущото състояние и може да възстановява предишно състояние;
- ProductMemento осигурява метод за извличане на това състояние – getProductSnapshot();
- ProductCaretaker управлява стек от моментни снимки, запазвайки различните състояния на Product. Позволява връщане назад в историята чрез метода restoreState(int);
- В допълнение е имплементиран клас ProductGraph, който генерира линейна графика, показваща направените промените в цената на определен продукт на дадена дата. Представен е и средната цена.

![product_history](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/product_history.png)
```yaml
Фигура 5.
```

## Седмица 12 - Фабрика за Продукти
- Factory

## Седмица 13 - Езици
- Strategy

## Седмица 14 - Конзола
- Command

## Седмица 15 - Потребителски Интерфейс

![problem](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/problem.png)

> *Solution:* Dependency Injection.

## Презентиране:
1. Initial Demo - Показва как се добавят и изтриват потребители и обяви;
2. Filters Demo - Показва как се филтрират обяви;
3. Subscribtion Demo - Показва как регистриран потребител се абонира за известия въз основа на различни филтри;
4. Listing History Demo - Показва историята на промените, направени в дадена обява;
5. Product History Demo -  Показва историята на промените, направени в даден продукт, и представя графика;
6. Parser Demo - Показва как се търсят обяви чрез филтри;
7. Console:
- Езици - Немски и Английски;
- Регистриране;
- Влизане в системата;
- Излизане от системата;
- Добавяне и изтриване на обяви, когато потребител е влезъл в системата;
- Преглед на всички обяви и всички потребители.

## Заключение:

## Fix:
- Decouple добавянето на обяви от Standard Input & Output чрез Dependency Injection;
- Да се добавят функционалностите от Demo 2, 3, 4, 5 към Console GUI;
- Да се (до)оправи Parser;
- Да се изнесе ID Generator в отделен модул;
- Да се приложи Console Pattern за Console GUI.

## Използвана Литература
- [Design Patterns](https://refactoring.guru/design-patterns)
- [Screaming Architecture](https://blog.cleancoder.com/uncle-bob/2011/09/30/Screaming-Architecture.html)

## Полезни Понятия
- Coupling се отнася до степента на взаимозависимост между софтуерните модули. High Coupling означава, че модулите са тясно свързани, което води до зависимост между тях. Промени в един модул могат да засегнат други модули. Low Coupling означава, че модулите са независими един от друг. Промени в един модул оказват минимално влияние върху останалите.
- Cohesion се отнася до степента, в която елементите в даден модул работят заедно, за да изпълнят единна и добре дефинирана цел. High Cohesion означава, че елементите в модула са тясно свързани и се фокусират върху една конкретна отговорност. Low Cohesion означава, че елементите в модула са слабо свързани и изпълняват множество несвързани задачи, което затруднява поддръжката, разширяването и разбирането на кода.

## Забавен Факт
- Името на програмата е базирано на тази песен: [Подуене Блус Бенд - Таратайка](https://www.youtube.com/watch?v=EqRddn_Tq9w)
  
![poduene](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/poduene.jpg)
