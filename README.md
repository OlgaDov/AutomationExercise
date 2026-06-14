# Automation Exercise Test Automation Framework

This project demonstrates UI and API test automation for the Automation Exercise e-commerce platform.

The framework was created to showcase:
- UI automation using Selenium WebDriver
- API automation using RestAssured
- Test architecture based on Page Object Model
- CI/CD integration with GitHub Actions
- Test reporting with Allure

Project goal: simulate a production-ready QA automation framework for a modern web application.

## Technology Stack

- Java 23
- Selenium WebDriver
- TestNG
- Maven
- RestAssured
- Allure Reports
- GitHub Actions

## Application Under Test

Website:
https://automationexercise.com

Application type:
E-commerce platform

Main business flows:
- User registration
- Authentication
- Product search
- Shopping cart
- Checkout

## Test Strategy

### Scope

The following business-critical areas were selected for automation:

- Authentication
- Product search
- Cart management
- Checkout process
- Product API

### Test Levels

UI Tests:
- End-to-end user journeys
- Critical business flows

API Tests:
- Functional validation
- Data validation
- Negative scenarios

### Out of Scope

The following areas were intentionally excluded:

- Visual testing
- Performance testing
- Security testing
- Email verification flows

Reason:
The project focuses on demonstrating functional UI and API automation.

## Framework Architecture

src
├── main
│   ├── pages
│   ├── api
│   ├── utils
│
├── test
│   ├── ui
│   ├── api
│   └── data

## Implemented Scenarios

### Login

- Successful login