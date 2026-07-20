# Composite Design Pattern (Java)

## Overview

The **Composite Pattern** is a **Structural Design Pattern** that allows you to treat **individual objects (Leaf)** and **groups of objects (Composite)** uniformly.

It organizes objects into a **tree structure** to represent part-whole hierarchies.

The client interacts with both single objects and collections of objects through the same interface.

---

# Problem Statement

Suppose you're building a File Explorer.

A file system contains:

- Files
- Folders

A folder can contain:

- Files
- Other folders

Example:

```
Root
│
├── File1.txt
├── File2.txt
│
├── Documents
│     ├── Resume.pdf
│     └── Notes.txt
│
└── Images
      ├── Photo1.jpg
      └── Vacation
            ├── Goa.png
            └── Beach.png
```

Without the Composite Pattern, you'd need separate logic for files and folders.

---

# Solution

Create a common interface called `FileSystemComponent`.

Both:

- File
- Folder

implement this interface.

A folder stores a list of `FileSystemComponent`, allowing it to contain both files and folders.

---

# Participants

## 1. Component

Common interface.

```java
public interface FileSystemComponent {

    void showDetails();
}
```

---

## 2. Leaf

Represents an individual object.

```java
public class File implements FileSystemComponent {

    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println(name);
    }
}
```

---

## 3. Composite

Represents a group of objects.

```java
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {

    private String name;

    private List<FileSystemComponent> components =
            new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        components.add(component);
    }

    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void showDetails() {

        System.out.println("Folder : " + name);

        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}
```

---

## 4. Client

```java
public class Main {

    public static void main(String[] args) {

        File file1 = new File("Resume.pdf");
        File file2 = new File("Notes.txt");
        File file3 = new File("Photo.jpg");

        Folder documents = new Folder("Documents");
        documents.add(file1);
        documents.add(file2);

        Folder images = new Folder("Images");
        images.add(file3);

        Folder root = new Folder("Root");

        root.add(documents);
        root.add(images);

        root.showDetails();
    }
}
```

---

# Output

```
Folder : Root
Folder : Documents
Resume.pdf
Notes.txt
Folder : Images
Photo.jpg
```

---

# Class Diagram

```
                   +--------------------------+
                   | FileSystemComponent      |
                   +--------------------------+
                   | +showDetails()           |
                   +--------------------------+
                              ^
                    ---------------------
                    |                   |
                    |                   |
             +-------------+     +----------------+
             |    File     |     |    Folder      |
             +-------------+     +----------------+
             | - name      |     | - name         |
             +-------------+     | - children     |
             | +showDetails|     +----------------+
                                | +add()         |
                                | +remove()      |
                                | +showDetails() |
                                +----------------+
```

---

# Object Structure

```
Root
│
├── Documents
│      ├── Resume.pdf
│      └── Notes.txt
│
└── Images
       └── Photo.jpg
```

Each folder can contain both files and folders.

---

# Execution Flow

```
root.showDetails()

↓

Root Folder

↓

Documents Folder

↓

Resume.pdf

↓

Notes.txt

↓

Images Folder

↓

Photo.jpg
```

The call recursively travels through the tree.

---

# Why Composite Works

Notice:

```
Folder
```

contains

```
List<FileSystemComponent>
```

Since both:

- File
- Folder

implement `FileSystemComponent`, a folder can contain either.

```
Folder
   |
   +---- File
   |
   +---- File
   |
   +---- Folder
              |
              +---- File
              |
              +---- Folder
```

This recursive structure is the heart of the Composite Pattern.

---

# Advantages

- Treats individual objects and groups uniformly.
- Simplifies client code.
- Supports recursive tree structures.
- Easy to add new component types.
- Follows the Open/Closed Principle.

---

# Disadvantages

- Can make the design overly general.
- Sometimes difficult to restrict what can be added to a composite.

---

# Real-World Examples

### File System

```
Folder
    |
    +--- Folder
    |
    +--- File
```

---

### Organization Structure

```
CEO
│
├── Manager
│      ├── Employee
│      └── Employee
│
└── Manager
       └── Employee
```

---

### GUI Components

```
Window
│
├── Button
├── Label
└── Panel
      ├── TextField
      └── Checkbox
```

---

### HTML DOM

```
<html>
    <body>
        <div>
            <p>Hello</p>
        </div>
    </body>
</html>
```

Every HTML element is a node, and nodes can contain other nodes.

---

# Java Examples

- `java.awt.Container`
- Swing components (`JPanel`, `JButton`, etc.)
- JavaFX scene graph
- XML/JSON DOM trees

---

# Composite vs Decorator

| Composite | Decorator |
|-----------|-----------|
| Builds tree structures | Adds functionality dynamically |
| Represents part-whole hierarchies | Enhances an existing object |
| Parent contains children | Wrapper contains one object |
| Focuses on object composition | Focuses on behavior extension |

---

# Composite vs Facade

| Composite | Facade |
|-----------|---------|
| Represents hierarchical structures | Simplifies access to a subsystem |
| Recursive relationship | One-level wrapper |
| Parent contains children | Facade coordinates subsystem classes |

---

# When to Use

Use the Composite Pattern when:

- You have tree-like or hierarchical data.
- Clients should treat individual objects and groups the same way.
- Objects naturally form parent-child relationships.
- Recursive processing is required.

---

# Design Principles Used

- Open/Closed Principle (OCP)
- Composition over Inheritance
- Recursive Composition

---

# Key Takeaways

- **Leaf** represents an individual object.
- **Composite** represents a collection of components.
- Both implement the same interface (`Component`).
- The client works with both leaves and composites uniformly.
- The Composite Pattern is ideal for representing tree structures such as file systems, UI hierarchies, and organizational charts.