# Adapter Design Pattern (Java)

## Overview

The **Adapter Pattern** is a **Structural Design Pattern** that allows two incompatible interfaces to work together by acting as a bridge between them.

It converts the interface of an existing class into another interface that the client expects, allowing classes with incompatible interfaces to collaborate without modifying their source code.

---

## Problem Statement

Suppose your application works with a `Printer` interface.

```java
public interface Printer {
    void print(String text);
}
```

Your application uses this interface everywhere.

Now, you want to integrate a third-party library that provides the following class:

```java
public class LegacyPrinter {

    public void printText(String text) {
        System.out.println("Printing: " + text);
    }
}
```

The problem is:

- Your application expects `print()`.
- The third-party library provides `printText()`.

The interfaces are incompatible.

Changing the third-party code is not possible.

---

## Solution

Create an **Adapter** that implements your application's expected interface (`Printer`) and internally delegates the request to the `LegacyPrinter`.

---

## Participants

### 1. Target Interface

The interface expected by the client.

```java
public interface Printer {
    void print(String text);
}
```

---

### 2. Adaptee

The existing class with an incompatible interface.

```java
public class LegacyPrinter {

    public void printText(String text) {
        System.out.println("Printing: " + text);
    }
}
```

---

### 3. Adapter

Converts one interface into another.

```java
public class PrinterAdapter implements Printer {

    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String text) {
        legacyPrinter.printText(text);
    }
}
```

---

### 4. Client

Uses only the `Printer` interface.

```java
public class Main {

    public static void main(String[] args) {

        LegacyPrinter legacyPrinter = new LegacyPrinter();

        Printer printer = new PrinterAdapter(legacyPrinter);

        printer.print("Hello Adapter Pattern");
    }
}
```

---

## Output

```
Printing: Hello Adapter Pattern
```

---

## Class Diagram

```
                  +----------------------+
                  |       Printer        |   (Target)
                  +----------------------+
                  | +print(String)       |
                  +----------------------+
                             ^
                             |
                     implements
                             |
                  +----------------------+
                  |   PrinterAdapter     |
                  +----------------------+
                  | - LegacyPrinter      |
                  +----------------------+
                  | +print()             |
                  +----------------------+
                             |
                             | delegates
                             v
                  +----------------------+
                  |   LegacyPrinter      |   (Adaptee)
                  +----------------------+
                  | +printText()         |
                  +----------------------+
```

---

## Execution Flow

1. Client calls:

```java
printer.print("Hello");
```

2. Adapter receives the request.

3. Adapter translates it into:

```java
legacyPrinter.printText("Hello");
```

4. LegacyPrinter performs the actual work.

```
Client
   |
   v
Printer.print()
   |
   v
PrinterAdapter
   |
   v
LegacyPrinter.printText()
```

---

## Advantages

- Allows incompatible classes to work together.
- Reuses existing or third-party classes.
- Avoids modifying legacy code.
- Follows the Open/Closed Principle.
- Improves code flexibility and maintainability.

---

## Disadvantages

- Adds an extra layer of abstraction.
- Can increase the number of classes.

---

## Real-World Examples

### Mobile Charger

- **Phone** expects a USB-C connector.
- **Old charger** has a Micro-USB connector.
- A **USB-C to Micro-USB adapter** allows them to work together.

```
Phone
   |
USB-C Adapter
   |
Micro-USB Charger
```

---

### Java Examples

- `Arrays.asList()`
- `InputStreamReader` (adapts `InputStream` to `Reader`)
- `OutputStreamWriter` (adapts `OutputStream` to `Writer`)
- JDBC drivers adapting database-specific APIs to the JDBC interface.

---

## When to Use

Use the Adapter Pattern when:

- Integrating third-party libraries with different interfaces.
- Working with legacy systems.
- Reusing existing classes without modifying them.
- Two classes need to collaborate but have incompatible interfaces.

---

Example:

**Adapter**

```
Client
    |
Printer.print()
    |
Adapter
    |
LegacyPrinter.printText()
```

**Decorator**

```
MilkDecorator
      |
SugarDecorator
      |
SimpleCoffee
```

The adapter changes **how the client talks to an object**, while the decorator enhances **what the object does**.

---

## Design Principles Used

- Open/Closed Principle (OCP)
- Composition over Inheritance
- Encapsulation

---

## Key Takeaways

- The **Target** defines what the client expects.
- The **Adaptee** is the existing class with an incompatible interface.
- The **Adapter** implements the target interface and delegates work to the adaptee.
- The client interacts only with the target interface and remains unaware of the adaptee.
- Adapter is commonly used when integrating legacy systems or third-party libraries without changing their code.