# Facade Design Pattern (Java)

## Overview

The **Facade Pattern** is a **Structural Design Pattern** that provides a **simple, unified interface** to a complex subsystem.

Instead of interacting with multiple classes directly, the client communicates with a single **Facade** class, which internally coordinates the subsystem classes.

The goal is to **hide complexity** and make the subsystem easier to use.

---

## Problem Statement

Suppose you're building a Home Theater system.

To watch a movie, the user must:

- Turn on the TV
- Turn on the Sound System
- Turn on the DVD Player
- Set the TV input
- Set the sound mode
- Play the movie

Without a Facade, the client has to know every step.

```java
TV tv = new TV();
SoundSystem sound = new SoundSystem();
DVDPlayer dvd = new DVDPlayer();

tv.on();
sound.on();
dvd.on();

tv.setInput("HDMI");
sound.setSurroundMode();

dvd.play("Avengers");
```

This makes the client code complex and tightly coupled to many classes.

---

## Solution

Create a **HomeTheaterFacade** that performs all these operations through a single method.

```java
homeTheater.watchMovie("Avengers");
```

The client doesn't need to know how the subsystem works.

---

# Participants

## 1. Subsystem Classes

### TV

```java
public class TV {

    public void on() {
        System.out.println("TV ON");
    }

    public void setInput(String input) {
        System.out.println("Input set to " + input);
    }
}
```

### SoundSystem

```java
public class SoundSystem {

    public void on() {
        System.out.println("Sound System ON");
    }

    public void setSurroundMode() {
        System.out.println("Surround Mode Enabled");
    }
}
```

### DVDPlayer

```java
public class DVDPlayer {

    public void on() {
        System.out.println("DVD Player ON");
    }

    public void play(String movie) {
        System.out.println("Playing " + movie);
    }
}
```

---

## 2. Facade

```java
public class HomeTheaterFacade {

    private TV tv;
    private SoundSystem sound;
    private DVDPlayer dvd;

    public HomeTheaterFacade(TV tv,
                             SoundSystem sound,
                             DVDPlayer dvd) {

        this.tv = tv;
        this.sound = sound;
        this.dvd = dvd;
    }

    public void watchMovie(String movie) {

        tv.on();
        sound.on();
        dvd.on();

        tv.setInput("HDMI");
        sound.setSurroundMode();

        dvd.play(movie);
    }
}
```

---

## 3. Client

```java
public class Main {

    public static void main(String[] args) {

        TV tv = new TV();
        SoundSystem sound = new SoundSystem();
        DVDPlayer dvd = new DVDPlayer();

        HomeTheaterFacade theater =
                new HomeTheaterFacade(tv, sound, dvd);

        theater.watchMovie("Avengers");
    }
}
```

---

## Output

```
TV ON
Sound System ON
DVD Player ON
Input set to HDMI
Surround Mode Enabled
Playing Avengers
```

---

# Class Diagram

```
                        Client
                           |
                           v
                +----------------------+
                | HomeTheaterFacade    |
                +----------------------+
                | +watchMovie()        |
                +----------------------+
                  |       |         |
                  |       |         |
                  v       v         v
              +------+ +-----------+ +-----------+
              | TV   | |SoundSystem| |DVDPlayer |
              +------+ +-----------+ +-----------+
```

---

# Execution Flow

Without Facade:

```
Client
   |
   |--> TV.on()
   |--> TV.setInput()
   |--> Sound.on()
   |--> Sound.setMode()
   |--> DVD.on()
   |--> DVD.play()
```

With Facade:

```
Client
   |
   v
Facade.watchMovie()
   |
   |--> TV
   |--> SoundSystem
   |--> DVDPlayer
```

The client only calls one method.

---

# Advantages

- Simplifies client code.
- Hides subsystem complexity.
- Reduces coupling between client and subsystem.
- Improves readability.
- Makes subsystem easier to use.

---

# Disadvantages

- The facade can become a "God Class" if it takes on too many responsibilities.
- It may hide advanced subsystem features that some clients need.

---

# Real-World Examples

### Banking App

Instead of:

```
Validate User
↓
Check Balance
↓
Verify OTP
↓
Transfer Money
↓
Send SMS
```

Client simply calls:

```java
bankFacade.transferMoney();
```

---

### Computer Startup

Pressing the power button internally performs:

- Start CPU
- Load BIOS
- Initialize RAM
- Load Operating System

The user just presses one button.

---

### Java Examples

- `java.sql.DriverManager` (simplifies obtaining database connections)
- Spring's `JdbcTemplate` (simplifies JDBC operations)
- SLF4J (provides a simple logging interface over different logging frameworks)

---

# When to Use

Use the Facade Pattern when:

- A subsystem is complex.
- Clients only need a simple interface.
- You want to reduce dependencies on subsystem classes.
- You want to hide implementation details.

---

# Design Principles Used

- Encapsulation
- Composition over Inheritance
- Principle of Least Knowledge (Law of Demeter)

---

# Key Takeaways

- A **Facade** provides a single entry point to a complex subsystem.
- It reduces coupling between the client and subsystem classes.
- The subsystem classes are still available for advanced use cases.
- The Facade doesn't add new behavior or change interfaces - it simply makes the subsystem easier to use.
- It's commonly used in frameworks and libraries to provide simple APIs over complex internals.