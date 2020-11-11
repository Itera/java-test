theme: Itera
slide-transition: true
autoscale: true

# Java Test

![inline](logo.png)

--- 

## Types of test

[.column]

* Unit
* Integration
* DB
* Web
* Component

[.column]

* Smoke
* Regression
* User Acceptance
* Black Box
* ...

---

## Types of test

Way too many to cover in one workshop - we will take a look at the following:

* Design for testing (brief)
* Unit test (JUnit - including paramterized test)
* Mocking/Spying (Mockito)
* Integration (Spring)
* DB (Spring + flyway)
* Matchers (JUnit/Hamcrest/AssertJ)
* Kotlin (kotest and mockk)

---

## Design for testing

* Follow SOLID - well designed code is usually easier to test
* Injection - prefer constructor to setters or Injected properties
* Use of `@VisibleForTesting`

---

## Unit test with JUnit 5

Let's take a look at SimpleJunitTest:

* The test function is marked with `@Test`
* We use the built in JUnit assertEquals

---

## Assertions

There are multiple ways to assert in tests. JUnit has its inbuilt set. Some other popular libraries are Hamcrest and AssertJ.

* Hamcrest - `assertThat(result, equalTo(5))`
* AssertJ - `assertThat(result).isEqualTo(5)`

Which to use us a matter of personal preference and/or project standards.


