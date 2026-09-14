# Java Selenium E-commerce Automation Framework

A maintainable **UI test automation framework built with Java, Selenium WebDriver, TestNG, and Maven**, designed to automate the complete e-commerce workflow of the [SauceDemo](https://www.saucedemo.com/) application.

The framework follows the **Page Object Model (POM)** design pattern and includes reusable components for browser management, test data, configuration, screenshots, reporting, and CI execution.

---

## 📌 Project Overview

This project demonstrates how I designed and implemented an end-to-end Selenium automation framework for an e-commerce application.

The framework automates the following user journey:

**Login → Products → Cart → Checkout → Checkout Overview → Order Confirmation**

The objective was not only to automate individual test cases, but to build a **structured, reusable, and maintainable automation framework following industry-style practices**.

### Key highlights

* 40 automated test cases
* Java + Selenium WebDriver
* TestNG test framework
* Maven project structure
* Page Object Model (POM)
* Reusable `BasePage` and `BaseTest`
* `DriverFactory` for browser management
* External JSON test data
* External configuration using `config.properties`
* Screenshot utility
* ExtentReports integration
* Chrome, Edge and Firefox support
* GitHub Actions CI pipeline
* 40/40 tests passing in CI

---

# 🛠️ Tech Stack

| Technology                  | Purpose                           |
| --------------------------- | --------------------------------- |
| **Java**                    | Programming language              |
| **Selenium WebDriver**      | Web UI automation                 |
| **TestNG**                  | Test execution and assertions     |
| **Maven**                   | Dependency and build management   |
| **Page Object Model**       | Maintainable framework design     |
| **Jackson**                 | Reading JSON test data            |
| **ExtentReports**           | Test execution reporting          |
| **Git & GitHub**            | Version control and collaboration |
| **GitHub Actions**          | Continuous Integration            |
| **Chrome / Edge / Firefox** | Cross-browser execution           |

---

# 🧪 Application Under Test

**SauceDemo** is a sample e-commerce web application used for practicing and demonstrating web automation.

The automation covers the main shopping workflow from authentication through order completion.

---

# 📋 Test Coverage

The framework currently contains **40 automated test cases**.

### 🔐 Login — 8 tests

Covers:

* Valid login
* Invalid username
* Invalid password
* Invalid username and password
* Locked-out user
* Required field validation
* Login error messages
* Login behaviour and navigation

---

### 🛍️ Products — 11 tests

Covers:

* Product listing
* Product details
* Product selection
* Product sorting
* Price sorting
* Name sorting
* Add product to cart
* Cart badge validation
* Product-related UI validations

---

### 🛒 Cart — 7 tests

Covers:

* Cart navigation
* Added product validation
* Product details in cart
* Cart item count
* Removing products
* Cart state validation
* Continue shopping functionality

---

### 💳 Checkout — 5 tests

Covers:

* Checkout navigation
* Valid customer information
* First name validation
* Last name validation
* Postal code validation
* Required field validation

---

### 📦 Checkout Overview — 6 tests

Covers:

* Checkout overview page
* Product information
* Item price
* Quantity
* Payment information
* Order summary and total

---

### ✅ Order Confirmation — 3 tests

Covers:

* Order completion
* Confirmation message
* Post-order navigation / validation

---

# 🏗️ Framework Architecture

The project follows the **Page Object Model (POM)** approach.

```text
SeleniumEcommerceAutomation
│
├── .github
│   └── workflows
│       └── maven-tests.yml
│
├── src
│   │
│   ├── main
│   │   └── java
│   │       ├── base
│   │       │   └── BasePage.java
│   │       │
│   │       └── pages
│   │           ├── LoginPage.java
│   │           ├── ProductPage.java
│   │           ├── CartPage.java
│   │           ├── CheckoutPage.java
│   │           ├── CheckoutOverviewPage.java
│   │           └── OrderConfirmationPage.java
│   │
│   └── test
│       │
│       ├── java
│       │   ├── base
│       │   │   └── BaseTest.java
│       │   │
│       │   ├── utils
│       │   │   ├── ConfigReader.java
│       │   │   ├── DriverFactory.java
│       │   │   ├── JsonDataReader.java
│       │   │   ├── ScreenshotUtil.java
│       │   │   ├── ExtentReportManager.java
│       │   │   └── ExtentTestListener.java
│       │   │
│       │   ├── LoginTest.java
│       │   ├── ProductPageTest.java
│       │   ├── CartPageTest.java
│       │   ├── CheckoutPageTest.java
│       │   ├── CheckoutOverviewPageTest.java
│       │   └── OrderConfirmationPageTest.java
│       │
│       └── resources
│           ├── testdata
│           │   └── testData.json
│           │
│           └── config
│               └── config.properties
│
└── pom.xml
```

---

# 🧩 Framework Components

## BasePage

`BasePage` contains reusable Selenium functionality shared across page classes.

This helps reduce duplicate Selenium code and keeps page classes focused on application-specific behaviour.

---

## Page Objects

Each major application page has its own Page Object.

```text
LoginPage
     ↓
ProductPage
     ↓
CartPage
     ↓
CheckoutPage
     ↓
CheckoutOverviewPage
     ↓
OrderConfirmationPage
```

Page classes encapsulate:

* Locators
* Page-specific actions
* Navigation
* Reusable page-level methods

This makes the test classes easier to read and maintain.

---

## BaseTest

`BaseTest` provides common test setup and teardown functionality.

It is responsible for:

* Initialising the WebDriver
* Opening the application
* Loading test data
* Providing reusable login functionality
* Closing the browser after each test
* Initialising and flushing ExtentReports

---

## DriverFactory

`DriverFactory` centralises WebDriver creation.

The framework supports:

* Chrome
* Edge
* Firefox

The browser can be controlled through the external configuration file.

For GitHub Actions, Chrome is executed in **headless mode** with CI-specific options so that the tests can run reliably on the Linux runner.

---

## Test Data Management

Test data is maintained separately from the test implementation using JSON.

Example structure:

```text
src/test/resources/testdata/testData.json
```

This approach separates:

**Test logic → Test data**

and makes the framework easier to maintain when test data changes.

Jackson is used to read and process the JSON data.

---

## Configuration Management

Environment-related configuration is maintained separately in:

```text
src/test/resources/config/config.properties
```

This keeps configurable values such as the application URL and browser selection outside the test classes.

---

# 📊 Reporting

The framework integrates **ExtentReports** to provide test execution reports.

The reporting implementation includes:

* Test execution status
* Passed / failed test information
* Test lifecycle integration
* Screenshots for failed tests

A TestNG listener is used to integrate test execution with the reporting framework.

---

# 📸 Screenshot Handling

A reusable screenshot utility is included in the framework.

Screenshots can be captured during test execution, particularly when a test fails, helping with:

* Failure investigation
* Debugging
* Test evidence
* Root-cause analysis

---

# 🌐 Cross-Browser Support

The framework is designed to support multiple browsers through `DriverFactory`.

Supported browsers:

```text
Chrome
Edge
Firefox
```

The framework has been validated using **Chrome, Edge and Firefox**.

---

# ⚙️ Continuous Integration

The project uses **GitHub Actions** to automatically execute the Maven test suite.

Workflow:

```text
Code Push / Pull Request
          ↓
    GitHub Actions
          ↓
       Maven
          ↓
    Selenium Tests
          ↓
      TestNG
          ↓
    Test Results
```

The CI workflow runs:

```bash
mvn clean test
```

Chrome runs in headless mode on the GitHub Actions Linux environment.

### CI Result

**40 tests executed**

```text
Tests run: 40
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# ▶️ How to Run the Tests

## Prerequisites

Make sure the following are installed:

* Java JDK
* Maven
* Git
* A supported browser

---

## Clone the Repository

```bash
git clone https://github.com/testwithAagy/Java-Selenium-Ecommerce-Automation.git
```

Navigate to the project:

```bash
cd Java-Selenium-Ecommerce-Automation
```

---

## Configure the Browser

Update:

```text
src/test/resources/config/config.properties
```

For example:

```properties
browser=chrome
```

---

## Run the Test Suite

Run all tests using Maven:

```bash
mvn clean test
```

---

# 📈 Test Execution

Current automation coverage:

| Module             |  Tests |
| ------------------ | -----: |
| Login              |      8 |
| Products           |     11 |
| Cart               |      7 |
| Checkout           |      5 |
| Checkout Overview  |      6 |
| Order Confirmation |      3 |
| **Total**          | **40** |

**Current result: 40/40 tests passing**

---

# 🎯 What This Project Demonstrates

This project demonstrates practical experience in:

* Web UI automation
* Selenium WebDriver
* Java test automation
* TestNG
* Maven
* Page Object Model
* Test data management
* Configuration management
* Reusable framework components
* Cross-browser testing
* Test reporting
* Screenshot capture
* CI automation
* Git and GitHub
* Debugging CI-specific browser issues

The framework was designed with a focus on **readability, reusability, maintainability, and realistic QA automation practices** rather than simply creating individual Selenium scripts.

---

# 🚀 Future Improvements

Potential future enhancements include:

* Parallel test execution
* Browser selection through Maven parameters
* Additional API automation
* More comprehensive test data parameterisation
* Enhanced reporting
* Docker-based test execution
* Additional CI matrix testing across browsers
* Integration with a test management system

---

# 👩‍💻 Author

**Aagy Paulose**

QA Engineer | Manual & Automation Testing | Selenium | Java | API Testing | BDD

GitHub: **[@testwithAagy](https://github.com/testwithAagy)**


