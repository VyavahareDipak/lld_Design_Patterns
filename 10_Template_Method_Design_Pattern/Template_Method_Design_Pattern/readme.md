# Template Method Design Pattern (Java)

## Overview

The **Template Method Pattern** is a **Behavioral Design Pattern** that defines the **skeleton (template)** of an algorithm in a base class while allowing subclasses to override specific steps without changing the overall algorithm.

The base class controls **what steps are executed and in what order**, while subclasses customize only the variable parts.

---

# Problem Statement

Suppose you're building an application that generates different types of reports.

Every report follows the same process:

1. Fetch data
2. Process data
3. Export report

The export format can vary:

- PDF
- Excel
- CSV

Without the Template Method Pattern, each report class would duplicate the common workflow.

---

# Solution

Move the common algorithm into an abstract class and allow subclasses to implement only the specific steps.

---

# Participants

## 1. Abstract Class (Template)

Defines the algorithm.

```java
public abstract class ReportGenerator {

    // Template Method
    public final void generateReport() {
        fetchData();
        processData();
        exportReport();
    }

    protected void fetchData() {
        System.out.println("Fetching data...");
    }

    protected void processData() {
        System.out.println("Processing data...");
    }

    protected abstract void exportReport();
}
```

Notice:

- `generateReport()` defines the complete workflow.
- Subclasses cannot change the algorithm because it's marked `final`.
- Only `exportReport()` is customizable.

---

## 2. Concrete Class (PDF)

```java
public class PdfReport extends ReportGenerator {

    @Override
    protected void exportReport() {
        System.out.println("Exporting PDF Report");
    }
}
```

---

## 3. Concrete Class (Excel)

```java
public class ExcelReport extends ReportGenerator {

    @Override
    protected void exportReport() {
        System.out.println("Exporting Excel Report");
    }
}
```

---

## 4. Client

```java
public class Main {

    public static void main(String[] args) {

        ReportGenerator pdf = new PdfReport();
        pdf.generateReport();

        System.out.println();

        ReportGenerator excel = new ExcelReport();
        excel.generateReport();
    }
}
```

---

# Output

```
Fetching data...
Processing data...
Exporting PDF Report

Fetching data...
Processing data...
Exporting Excel Report
```

---

# Class Diagram

```
                   +---------------------------+
                   |     ReportGenerator       |
                   +---------------------------+
                   | +generateReport() final   |
                   | #fetchData()              |
                   | #processData()            |
                   | #exportReport() abstract  |
                   +---------------------------+
                               ^
                    -------------------------
                    |                       |
          +----------------+      +------------------+
          |   PdfReport    |      |  ExcelReport     |
          +----------------+      +------------------+
          | +exportReport()|      | +exportReport()  |
          +----------------+      +------------------+
```

---

# Execution Flow

For `PdfReport`:

```
generateReport()
      |
      v
fetchData()
      |
      v
processData()
      |
      v
exportReport()  --> PdfReport implementation
```

For `ExcelReport`:

```
generateReport()
      |
      v
fetchData()
      |
      v
processData()
      |
      v
exportReport()  --> ExcelReport implementation
```

The workflow remains the same; only one step changes.

---

# Real-World Example

### Online Shopping

Every order follows the same process:

1. Select Items
2. Make Payment
3. Deliver Order

Different payment methods:

- Credit Card
- UPI
- PayPal

```
placeOrder()
    |
    +--> selectItems()
    |
    +--> makePayment()   <-- Different
    |
    +--> deliver()
```

---

# Advantages

- Eliminates duplicate code.
- Ensures a fixed workflow.
- Allows customization of specific steps.
- Follows the Open/Closed Principle.
- Promotes code reuse.

---

# Disadvantages

- Uses inheritance, leading to tighter coupling.
- Changes to the template may affect all subclasses.
- Less flexible than composition-based patterns.

---

# Real-World Examples

- Data import/export workflows
- Report generation
- File parsing
- Payment processing
- Document generation
- Build pipelines

---

# Java Examples

- `HttpServlet` (`service()` calls `doGet()`, `doPost()`, etc.)
- `AbstractList`
- `AbstractMap`
- `AbstractSet`
- Spring's `JdbcTemplate` follows a similar idea by defining a workflow while allowing custom behavior through callbacks.

---

# Template Method vs Strategy

| Template Method | Strategy |
|----------------|----------|
| Uses inheritance | Uses composition |
| Algorithm structure is fixed | Algorithm can be changed at runtime |
| Subclasses override steps | Different strategy objects are injected |
| Compile-time flexibility | Runtime flexibility |

Example:

**Template Method**

```
generateReport()

↓

fetchData()

↓

processData()

↓

exportReport()   <-- Subclass decides
```

**Strategy**

```
PaymentService
      |
      +---- CreditCardStrategy
      |
      +---- UPIStrategy
      |
      +---- PayPalStrategy
```

---

# When to Use

Use the Template Method Pattern when:

- Multiple classes follow the same workflow.
- Only a few steps differ between implementations.
- You want to avoid duplicating common algorithm code.
- The order of execution must remain fixed.

---

# Design Principles Used

- Open/Closed Principle (OCP)
- Don't Repeat Yourself (DRY)
- Hollywood Principle: **"Don't call us, we'll call you."**
    - The base class controls the workflow and calls subclass methods when needed.

---

# Key Takeaways

- The **Template Method** defines the overall algorithm.
- Common steps are implemented in the abstract base class.
- Variable steps are left abstract (or provided as hooks) for subclasses to implement.
- The order of execution is controlled by the base class.
- This pattern is ideal when the workflow is fixed but certain steps need customization.