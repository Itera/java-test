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


---

## Parametric

A parametric test allows us to reuse the same test with a range of different test data sets.

The test method is annotated to tell JUnit that it is parameterized and also where to get the data from.

There's a bunch of different sources available[^1] - we'll use MethodSource.

Example in SimpleParametricTest

[^1]: https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/package-summary.html

---

## Maven testing

There are three main sets of configuration in the pom.xml file.

* Surefire plugin - runs unit tests
* Failsafe plugin - runs integration tests
* Jacoco - generates code coverage

Surefire will run under mvn test, and failsafe under mvn verify [^2]

Jacoco sets itself up under pre-integration-test and builds the result in post-integration-test so will also be triggered by verify.

[^2]: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html

