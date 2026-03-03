# TARATAIKA.BG

- This project was developed as part of the course "Design Patterns" at Sofia University, FMI. It was developed over the course of one academic semester, during which various methodologies for design, analysis and implementation were applied. The code was expanded each week in accordance with the requirements of the assigned tasks with improvements, optimizations and the addition of new functionalities carried out.

## **Week 01** - Software Architecture. What is **Mobile.bg**? 
What should the application include?
- `Listing` (Create and Edit);
- `Collection of listings`;
- `Sponsored listing`;
- `Reviews`;
- `Price history`;
- `Filter`;
- `Search`;
- `Buyer`;
- `Seller`;
- `Guest`;
- `Dealerships`;
- `Vehicles`;
- `Parts`;
- `Services`;
- `Chat` (between `Buyer` and `Seller`).

![figure_1](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/diagram.png)

## **Week 02** - **Users**
- **Repository Pattern** is a design pattern that acts as an intermediary layer between the application's business logic (`UserService`) and the data storage layer (`UserRepository`);
- Its main purpose is to provide a structured and standardized way to access, manage and manipulate data, while abstracting the details of the storage technology through the interface `UserRepository` and its implementation - `UserRepositoryImplementation`. In this context, `UserServiceImplementation` acts as a mediator by providing methods for adding - `addUser`, deleting - `deleteUser`, and retrieving users - `getUserById`, without requiring direct access to the internal storage;
- This allows easy replacement or extension of the way data is stored (for example, instead of a HashMap, a Database can be used) without modifying the application's business logic - it functions like a librarian between the program and the data. Instead of `UserService` directly searching for and manipulating users, it uses `UserRepository`, which is responsible for their storage and access.

## **Week 03** - **Products**
- The main idea of this week is closely related to the concept **reusability**. In software engineering, reusability plays a key role in reducing code duplication and facilitating future modifications. Informally speaking, if at some point it becomes necessary to create a similar application, but for selling a different type of products, for example **cosmetics**, the code should be structured in such a way that **70–80%** of what has already been written can be reused;
- To achieve this goal, the principle of abstraction is applied by defining a base class `Product`, which serves as a parent for all specific product types. In OOP, this is accomplished by creating an abstract class or interface that defines the common behavior of all products;
- The sales application must support different types of products. For example, in the context of `Mobile.bg`, the standard product categories may include: car, truck, yacht, part, accessory, etc. Each of these products will inherit from `Product` and extend its functionality with specific characteristics.

## **Week 04** - **Listing**
- Similar to **Week 02**, the **Repository Pattern** has again been used here for the **Listing**;
- It provides a layer between the business logic and the listing storage, abstracting the details of data access. `ListingRepository` and `ListingRepositoryImplementation` manage the storage, addition and deletion of listings. `ListingService` and `ListingServiceImplementation` provide methods for manipulating listings, ensuring that only registered users can add or delete them.

## **Week 05** - **Filters**
- **Extractor Pattern** is used to retrieve specific data from an object in a structured and modular way;
- In this code, it is implemented through the interface `FieldExtractor`, which defines the method `extractValue(T)` - fetches a specific field from a given object `T` and returns it as a value of type `V`. The interface `Filter` defines the method `visit(T)`, which checks whether a given object meets certain criteria;
- Ultimately, `Filter` and `FieldExtractor` work together, where `FieldExtractor` first extracts the required value from the object and `Filter` then uses it for validation;
- Three specific filters were added: `RangeFilter` - checks whether a field's value falls within a minimum and maximum range, `ExactValueFilter` - checks if a field equals a specific value using exact equality, and `CaseInsensitiveFilter` - checks whether a string field of an object matches a given string, ignoring case.

## **Week 06** - **Subscribtions**
- The task for **Week 06** is as follows: *Extend the existing notification system by implementing the appropriate and necessary abstractions with regard to **reusability**, **cohesion** and **coupling**. Users can subscribe to listings that match specific criteria (e.g., "Audi, diesel, 2005–2015"). When a listing that meets the specified criteria is created, the corresponding notification must be sent. You must use the following three classes without modifications:*

```yaml java
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
#### Solution: **Adapter Pattern** and **Observer Pattern**
- **Adapter Pattern** is used to integrate the different types of notifications - `SmsNotifier`, `EmailNotifier`, `PigeonNotifier` and `OnFootNotifier` - into a common interface, called `SubscribtionType`. These external classes have different methods for sending messages - `sendSms`, `sendEmail`, `sendPigeon` and `deliverOnFoot`, respectively. To unify the interface, adapters have been created - `SmsSubscribtion`, `EmailSubscribtion`, `PigeonSubscribtion` and `OnFootSubscribtion`, which implement `SubscribtionType`. Each adapter converts calls to `update()` into the corresponding method of the original class;
- **Observer Pattern** is used to manage subscriptions and automatically notify subscribers when a new listing is created. `SubscribtionService` plays the role of the `Subject` i.e. `Event source` that monitors new listings. `SubscribtionRule` represents the link between a filter and a notification type. When a new listing is added, `SubscribtionService` checks whether any subscribers match the criteria and, if so, sends a notification.

![subscribtion](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/subscribtion.JPG)

## **Week 07** - **Composite Filters**
- The task for Week 7 is as follows: *Currently, NotificationRule contains an array of rules that NotificationService requires to be fully satisfied before sending a notification. This means that all conditions in the list must be met simultaneously. Clients require the ability to define more complex logical operations between filters in order to set more flexible notification rules. For this purpose, the following types of logical operations must be supported:*
```yaml
> AND filter - the notification is sent if all internal filters are satisfied;
> OR filter - the notification is sent if at least one of the internal filters is satisfied;
> N of M filter - the notification is sent if at least N out of M filters are satisfied.
For example: "I want at least 2 out of 3 to be satisfied – [diesel, Audi, after 2003]".
```
#### Solution: **Composite Pattern**
- **Composite Pattern** is a structural design pattern that allows building hierarchies of objects where individual objects and groups of objects can be treated in the same way. This is achieved by defining a unified interface, in this case `Filter<T>`, which can be implemented both by individual filters - `RangeFilter`, `ExactValueFilter`, `CaseInsensitiveFilter` - and by composite filters. such as `AndFilter`, `OrFilter`, `NotFilter` and `NOfMFilter`:
    - **Component interface** `Filter<T>`: All filters implement the same `Filter` interface, which provides a unified way of working with them;
    - **Leaf Components**: `RangeFilter`, `ExactValueFilter` and `CaseInsensitiveFilter`. These are the basic filters that implement specific filtering logic for a given object;
    - **Composite Components**: `AndFilter` - requires all nested filters to return true in order to return true; `OrFilter` - returns true if at least one nested filter returns true; `NotFilter` - inverts the result of the nested filter; and `NOfMFilter` - returns true if at least n of the nested filters return true.

## **Week 08** - **Listing History**
- **Memento Pattern** is used to store and restore the state of a Listing object. This allows reverting to previous states, enabling undo/redo operations:
    - `ListingOriginator` is responsible for creating snapshots of the current state and can restore a previous state;
    - `ListingMemento` provides a method to retrieve this state - `getListingSnapshot()`;
    - `ListingCaretaker` manages a stack of snapshots, preserving the different states of the `Listing`. It allows going back in history through the method `restoreState(int)`.

![listing_history](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/listing_history.JPG)

## **Week 09** - **User ID Generator**
- **Singleton Pattern** is a design pattern that ensures a class has only one single instance and provides a global point of access to it. It controls access to a shared resource - in this case, each user is assigned a unique number by incrementing the number of the last registered client.

## **Week 10** - **Parser**
- The task for Week 10 is: *Create a class that implements the Searcher interface. This class should accept a collection of listings and a query, and return only those cars that meet the criteria specified in the query. The input is a list of listings, each with certain attributes (e.g. brand, model and etc.) and a query string that describes the search criteria. The following are provided:*
```yaml
> Class QueryParser, which converts the query into Prefix notation;
> Interface Searcher, which must be implemented;
> Class QueryTester, which tests your implementation and provides examples of query syntax.
```
#### Solution: **Interpreter Pattern**
- **Interpreter Pattern** is a behavioral design pattern used to interpret a **domain-specific language** (`DSL`). The main idea is to define a grammar for the language and provide a mechanism to interpret expressions.
    - The `QueryParser` class converts the query into **Reverse Polish Notation** (`RPN`). It splits the query into conditions (e.g. `brand = 'bmw'`) and operators (`|` and `&`). It uses a stack to handle operator precedence and generate a postfix representation of the query;
    - `SearcherImplementation` is the query interpreter. This class uses the output from `QueryParser` and applies the **Interpreter pattern** to objects of type `Listing`;
    - `AndFilter` and `OrFilter` are used to process the `AND` and `OR` operators.

![parser](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/parser.JPG)

## **Week 11** - **Product History**
- **Memento Pattern** is used to store and restore the state of a `Product` object. This allows reverting to previous states - for undo/redo operations;
    - `ProductOriginator` is responsible for creating snapshots of the current state and can restore a previous state;
    - `ProductMemento` provides a method to retrieve this state - `getProductSnapshot()`;
    - `ProductCaretaker` manages a stack of snapshots, preserving the different states of the `Product`. It allows going back in history through the method `restoreState(int)`;
- Additionally, a `ProductGraph` class has been implemented, which generates a linear graph showing the changes in the price of a specific product on given dates. The average price is also displayed.

![product_history](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/product_history.png)

## **Week 12** - **Product Factory**
- **Factory Pattern** provides an interface for creating objects in a superclass, allowing subclasses to determine the type of objects to be created;
    - `Creator`: An interface that declares the “factory” method;
    - `Concrete Creators`: Each concrete creator is responsible for creating a specific product - `CarCreator`, `TruckCreator`, `YachtCreator` and etc.;
    - `Product` and the concrete products from **Week 03**: Define the common characteristics of the objects.

## **Week 13** - **Languages**
- **Strategy Pattern** is a behavioral design pattern that allows defining a family of behaviors in separate classes, which can be interchanged at runtime. It encapsulates multiple algorithms and/or behaviors, called strategies - in this case, the `English` and `German` languages. The client, here the user, can switch between different strategies i.e. languages via the console while using the program;
- `LanguageContext` class delegates the task to a strategy object and holds a reference to it. It acts as an intermediary between the client and the strategy. Essentially, it “pulls” the necessary message to be displayed on the console;
- The `Strategy` interface defines a set of methods that all concrete strategies must implement;
- Since communication between components is **decoupled**, the context does not need to know the exact details of how each strategy performs the task.

![languages](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/languages.png)

## Седмица 14 - Конзола
- Command Paterrn e поведенчески шаблон, който преобразува заявката в самостоятелен обект, наречен команда. С помощта на този шаблон може да се „улови“ всеки компонент на заявката, включително обекта, който притежава метода, параметрите на метода и самия метод;
- Command Interface: Интерфейсът на командата е като наръчник, който всички класове с команди следват;
- Concrete Command Classes: Това са конкретните команди, като например създай обява, изтрий обява, регистрирай потребител и т.н.;
- Invoker: Съдържа препратка към команда, но не навлиза в подробности за това как тя работи. Като бутон – изпълни;
- Receiver: Устройството, което знае как да изпълни действителната операция, свързана с командата – терминала в случая.

![gui](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/gui.png)
```yaml
Фигура 7.
```

## Седмица 15 - Потребителски Интерфейс

![problem](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/problem.png)
```yaml
Фигура 8.
```

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
- Проектът демонстрира ефективното прилагане на различни методологии за проектиране, анализ и имплементация. Основните функционалности включват управление на обяви, филтриране, търсене, история на цените и ролеви модели за различни типове потребители. Използването на различни design patterns осигурява структуриран и стандартизиран подход към управлението на данните, което допринася за по-лесна поддръжка и разширяемост. По този начин проектът не само предлага практическо приложение на теоретични концепции, но и демонстрира значението на добре организираната архитектура. В заключение, разработката подчертава важността на качественото структуриране на софтуерните решения за дългосрочна ефективност и гъвкавост.

## Fix:
- Decouple добавянето на обяви от Standard Input & Output чрез Dependency Injection;
- Да се добавят функционалностите от Demo 2, 3, 4, 5 към Console GUI;
- Да се (до)оправи Parser;
- Да се изнесе ID Generator в отделен модул;
- Да се приложи Console Pattern за Console GUI.

## Използвана Литература
- [Design Patterns](https://refactoring.guru/design-patterns)
- [Screaming Architecture](https://blog.cleancoder.com/uncle-bob/2011/09/30/Screaming-Architecture.html)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [OOP Principles 1](https://github.com/stoyan-stunji/fmi-oop-database)
- [OOP Principles 2](https://github.com/stoyan-stunji/oop-autumn)

## Понятия
- Coupling се отнася до степента на взаимозависимост между софтуерните модули. High Coupling означава, че модулите са тясно свързани, което води до зависимост между тях. Промени в един модул могат да засегнат други модули. Low Coupling означава, че модулите са независими един от друг. Промени в един модул оказват минимално влияние върху останалите.
- Cohesion се отнася до степента, в която елементите в даден модул работят заедно, за да изпълнят единна и добре дефинирана цел. High Cohesion означава, че елементите в модула са тясно свързани и се фокусират върху една конкретна отговорност. Low Cohesion означава, че елементите в модула са слабо свързани и изпълняват множество несвързани задачи, което затруднява поддръжката, разширяването и разбирането на кода.

## Забавен Факт
- Името на програмата е базирано на тази песен: [Подуене Блус Бенд - Таратайка](https://www.youtube.com/watch?v=EqRddn_Tq9w)
  
![poduene](https://github.com/stoyan-stunji/fmi-dp-mobilebg/blob/main/docs/poduene.jpg)
