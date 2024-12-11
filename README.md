# MOBILE.BG

СУ - ФМИ - Зимен семестър 2024/2025
- Изготвил: Стоян Стоянов Иванов
- Специалност: Информатика, 3 курс
- Факултетен номер: 9MI0400132
- Ръководител на курса: Филип Янков

# 1.	Увод

1.1. Описание и идея на проекта

Основната идея на проекта е разработката на програма, която поддържа основните функция на Mobile.bg, но на ниско ниво. Състои от серии от обяви, като всяка обява има няколко основни характеристики, позволяващи да се извършват действия върху тях от съответните потребители. Обявата е организирана така, че да използва записи и полета, за да може данните да се използват по-лесно и по-ефективно.  

1.2. Цел и задачи на разработката 

Целта на този проект е да се реализира система, управляваща обяви за различни продукти. Нужно е да се осъществят методите: добавяне на таблица от регистриран потребител, премахване на обява от регистриран потребител, получаване на списък от обяви, отговарящи на определен филтър, добавяне на потребител, премахване на потребител, търсене на потребител по идентификационен номер, възможност за създаване на абонамент, който да изпраща определен тип съобщение на абоната като е нужно да се използват и да не се променят долните ограничения:

```yaml
public class SmsNotifier {
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + " with message: " + message); }}
 
public class EmailNotifier {
    public void sendEmail(String email, String title, String message) {
        System.out.println("Sending email to " + email + " with title: " + title + " and message: " + message);}}
 
public class PigeonNotifier {
    public void sendPigeon(String address, Integer pigeonNumber, String message) {
        System.out.println("Sending pigeon to " + address + " with message: " + message);}}
```
 
Една от основните задачи на програмата е съхранението на големи количества данни в структуриран формат и  предоставянето на механизми за съхранение и организация на тези данни, позволяващи бърз достъп и ефективност при търсенето и обработката им. Осъществява се контрол на достъпа до данните, защита на данните от неправомерен достъп и осигуряване на цялостност и съответствие на данните. Друга важна задача е предоставянето на възможност за извличането на специфична информация от базата данни за анализ, отчетност и вземане на решения. Това позволява откриването на тенденции, генерирането на отчети и вземането на решения на базата на наличните данни.

1.3. Структура на документацията

Документацията започва с анализ на задачата и подходът за решение. След това е представено кратко описание на класовете, които са създадени за решение на задачата. Завършва се с идеи за бъдещи подобрения. 

