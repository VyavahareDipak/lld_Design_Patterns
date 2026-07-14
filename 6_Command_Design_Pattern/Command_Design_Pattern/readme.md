# Command Design Pattern (Java)

## Overview

The **Command Pattern** is a **Behavioral Design Pattern** that encapsulates a request as an object. It separates the object that **invokes an operation** from the object that **performs the operation**.

This allows you to:

- Parameterize objects with different requests.
- Queue or schedule requests.
- Support undo/redo operations.
- Decouple the sender from the receiver.

---

## Problem Statement

Imagine building a remote control for a smart home.

The remote can perform actions like:

- Turn ON Light
- Turn OFF Light
- Turn ON Fan
- Turn OFF Fan

### Without Command Pattern

```java
class RemoteControl {

    private Light light;

    public void pressOnButton() {
        light.turnOn();
    }

    public void pressOffButton() {
        light.turnOff();
    }
}
```

Problems:

- Remote is tightly coupled with `Light`.
- Adding a new device (Fan, TV, AC) requires modifying the remote.
- Difficult to implement undo/redo or command history.

---

## Solution

Encapsulate each request into a separate command object.

The remote only knows how to execute a command, not how the action is performed.

---

## Participants

### 1. Command

Defines the interface for executing commands.

```java
public interface Command {
    void execute();
}
```

---

### 2. Receiver

The object that performs the actual work.

```java
public class Light {

    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}
```

---

### 3. Concrete Commands

#### TurnOnLightCommand

```java
public class TurnOnLightCommand implements Command {

    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
```

#### TurnOffLightCommand

```java
public class TurnOffLightCommand implements Command {

    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
```

---

### 4. Invoker

The object that triggers the command.

```java
public class RemoteControl {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```

---

### 5. Client

Creates and wires everything together.

```java
public class Main {

    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new TurnOnLightCommand(light);
        Command offCommand = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}
```

---

## Output

```
Light is ON
Light is OFF
```

---

## Class Diagram

```
                    +----------------+
                    |    Command     |
                    +----------------+
                    | +execute()     |
                    +----------------+
                           ^
                           |
           ---------------------------------
           |                               |
           |                               |
+------------------------+      +-------------------------+
| TurnOnLightCommand     |      | TurnOffLightCommand     |
+------------------------+      +-------------------------+
| - Light light          |      | - Light light           |
+------------------------+      +-------------------------+
| +execute()             |      | +execute()              |
+------------------------+      +-------------------------+
            |                               |
            | uses                          | uses
            v                               v
                  +----------------------+
                  |       Light          |
                  +----------------------+
                  | +turnOn()            |
                  | +turnOff()           |
                  +----------------------+

                         ^
                         |
                 +------------------+
                 |  RemoteControl   |
                 +------------------+
                 | - Command cmd    |
                 +------------------+
                 | +setCommand()    |
                 | +pressButton()   |
                 +------------------+
```

---

## Execution Flow

1. Client creates the `Light` (Receiver).
2. Client creates `TurnOnLightCommand` and passes the `Light`.
3. Client sets the command in `RemoteControl`.
4. User presses the button.
5. `RemoteControl` calls `command.execute()`.
6. The command delegates the request to `Light`.

```
Button Press
      |
      v
RemoteControl
      |
      v
Command.execute()
      |
      v
Light.turnOn()
```

---

## Advantages

- Decouples sender and receiver.
- Easy to add new commands without modifying existing code.
- Supports undo/redo functionality.
- Enables command queuing and scheduling.
- Follows the Open/Closed Principle.

---

## Disadvantages

- Introduces additional classes.
- Can increase complexity for simple operations.

---

## Real-World Examples

- Remote controls
- Menu items in GUI applications
- Undo/Redo functionality in editors
- Task scheduling
- Job queues
- Transaction processing
- Macro recording

---

## Java Examples

- `Runnable` (encapsulates a task to execute)
- `ActionListener` in Swing
- `ExecutorService.submit(Runnable)`
- `Callable`

---

## When to Use

Use the Command Pattern when:

- You want to decouple the requester from the executor.
- You need undo/redo functionality.
- Commands need to be queued or scheduled.
- You want to log or replay operations.
- Different actions should be treated uniformly.

---

## Design Principles Used

- Single Responsibility Principle (SRP)
- Open/Closed Principle (OCP)
- Encapsulation
- Composition over Inheritance

---

## Key Takeaways

- A **Command** encapsulates a request as an object.
- The **Invoker** only knows how to execute a command.
- The **Receiver** contains the business logic.
- The **Client** connects the invoker, command, and receiver.
- Adding a new action usually means creating a new command class without changing existing code.