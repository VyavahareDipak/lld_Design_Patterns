````markdown
# Decorator Design Pattern (Java)

## Overview

The **Decorator Pattern** is a **Structural Design Pattern** that allows you to **add new functionality to an object dynamically** without modifying its existing code.

Instead of creating multiple subclasses for every possible feature combination, the Decorator Pattern wraps an existing object with one or more decorator objects that add additional behavior.

This follows the **Open/Closed Principle**:

- **Open for extension** ✅
- **Closed for modification** ✅

---

## Problem Statement

Imagine a coffee shop application.

Customers can order:

- Simple Coffee
- Coffee + Milk
- Coffee + Sugar
- Coffee + Chocolate
- Coffee + Milk + Sugar
- Coffee + Milk + Chocolate
- Coffee + Sugar + Chocolate
- Coffee + Milk + Sugar + Chocolate

### Without Decorator

Creating a separate class for every combination quickly becomes unmanageable.

```
SimpleCoffee
MilkCoffee
SugarCoffee
ChocolateCoffee
MilkSugarCoffee
MilkChocolateCoffee
SugarChocolateCoffee
MilkSugarChocolateCoffee
...
```

As the number of toppings grows, the number of classes increases rapidly.

This is known as the **Class Explosion Problem**.

---

## Solution

Instead of creating subclasses for every combination, we:

1. Create a common interface (`Coffee`).
2. Create a basic implementation (`SimpleCoffee`).
3. Create an abstract decorator (`CoffeeDecorator`) that wraps another `Coffee`.
4. Create decorators like:
   - MilkDecorator
   - SugarDecorator
   - ChocolateDecorator

Each decorator adds its own behavior while delegating the remaining work to the wrapped object.

---

## Class Diagram

```
                     +----------------+
                     |    Coffee      |
                     +----------------+
                     | +getDescription() |
                     | +getCost()        |
                     +----------------+
                              ^
                              |
                 ----------------------------
                 |                          |
        +------------------+      +----------------------+
        |  SimpleCoffee    |      |  CoffeeDecorator     |
        +------------------+      +----------------------+
                                  | - Coffee coffee      |
                                  +----------------------+
                                              ^
                            ----------------------------------------
                            |                  |                   |
                            |                  |                   |
                  +----------------+ +----------------+ +----------------------+
                  | MilkDecorator  | | SugarDecorator | | ChocolateDecorator  |
                  +----------------+ +----------------+ +----------------------+
```

---

## Project Structure

```
src
│
├── Coffee.java
├── SimpleCoffee.java
├── CoffeeDecorator.java
├── MilkDecorator.java
├── SugarDecorator.java
├── ChocolateDecorator.java
└── Main.java
```

---

## Implementation

### 1. Component

```
Coffee
```

Defines the common interface for both concrete objects and decorators.

Methods:

- `getDescription()`
- `getCost()`

---

### 2. Concrete Component

```
SimpleCoffee
```

Represents the basic coffee.

```
Description : Simple Coffee
Cost        : ₹100
```

---

### 3. Decorator

```
CoffeeDecorator
```

Stores a reference to another `Coffee` object.

```
protected Coffee coffee;
```

All decorators extend this class.

---

### 4. Concrete Decorators

#### MilkDecorator

Adds:

- Milk
- ₹20

#### SugarDecorator

Adds:

- Sugar
- ₹10

#### ChocolateDecorator

Adds:

- Chocolate
- ₹30

---

## Execution Flow

```java
Coffee coffee = new SimpleCoffee();

coffee = new MilkDecorator(coffee);
coffee = new SugarDecorator(coffee);
coffee = new ChocolateDecorator(coffee);

System.out.println(coffee.getDescription());
System.out.println(coffee.getCost());
```

---

## Object Wrapping

Initially:

```
SimpleCoffee
```

After adding Milk:

```
MilkDecorator
      |
      v
SimpleCoffee
```

After adding Sugar:

```
SugarDecorator
      |
      v
MilkDecorator
      |
      v
SimpleCoffee
```

After adding Chocolate:

```
ChocolateDecorator
       |
       v
SugarDecorator
       |
       v
MilkDecorator
       |
       v
SimpleCoffee
```

Every decorator wraps the previous object and enhances its behavior.

---

## Sample Output

```
Description : Simple Coffee, Milk, Sugar, Chocolate
Cost        : 160.0
```

---

## Advantages

- Follows the **Open/Closed Principle**.
- Avoids creating many subclasses.
- Allows features to be added dynamically.
- Multiple decorators can be combined in any order.
- Easy to extend by adding new decorators.

---

## Disadvantages

- Can result in many small classes.
- Object wrapping can make debugging more difficult.
- Deep chains of decorators may be harder to understand.

---

## Real-World Examples

### Java I/O

```java
InputStream input =
    new BufferedInputStream(
        new FileInputStream("data.txt"));
```

- `FileInputStream` reads bytes from a file.
- `BufferedInputStream` adds buffering functionality.

---

### Other Examples

- Coffee/Pizza toppings
- Text formatting (Bold, Italic, Underline)
- Logging wrappers
- Compression wrappers
- Encryption wrappers
- HTTP request/response filters
- Spring Security filter chain (conceptually similar)

---

## When to Use

Use the Decorator Pattern when:

- Functionality should be added dynamically.
- There are many possible feature combinations.
- Creating subclasses for every combination is impractical.
- You want to extend behavior without modifying existing classes.

---

## Design Principles Used

- Open/Closed Principle (OCP)
- Composition over Inheritance
- Single Responsibility Principle (SRP)

---

## Key Takeaways

- A decorator **implements the same interface** as the object it decorates.
- A decorator **contains** another object of the same interface.
- Decorators can be stacked to combine multiple behaviors.
- Behavior is added at runtime without changing existing code.
- This pattern is widely used in the Java Standard Library, especially in the `java.io` package.
````
