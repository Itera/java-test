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
* Matchers (JUnit/Hamcrest/AssertJ)
* Mocking/Spying (Mockito)
* Integration (Spring)
* DB (Spring + flyway)
* Kotlin (kotest and mockk)

---

## Design for testing

* Follow SOLID - well designed code is usually easier to test
* Injection - prefer constructor to setters or injected properties
* Use of `@VisibleForTesting` [^1]

[^1]: VisibleForTesting simply documents why access to a method or value is more open than it should be. It does nothing for enforcement - but can be used by static code analysis.

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

There's a bunch of different sources available[^2] - we'll use MethodSource.

Example in SimpleParametricTest

[^2]: https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/package-summary.html

---

## Maven testing

There are three main sets of configuration in the pom.xml file.

* Surefire plugin - runs unit tests
* Failsafe plugin - runs integration tests
* Jacoco - generates code coverage

Surefire will run under mvn test, and failsafe under mvn verify [^3]

Jacoco sets itself up under pre-integration-test and builds the result in post-integration-test so will also be triggered by verify.

[^3]: https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html

---

## Unit tests in a real application

Example: DummyJavaServiceTest

Issue - we need to provide a full implementation of the repository to test a non-related method.

Things to consider:

* Poor separation of concerns?
* Mocking (we'll see this later)?
* In this instance - the calculation method could be static

---

## Parametric tests in a real application

Example: DummyJavaServiceParametricTest

The issues here are the same as for the simple test.

---

## Mocking

In the above two examples - mocking is not really the solution - they should likely be refactored with SOLID in mind.

However - there are situations were mocking a dependency allows you to test a higher level component.

For example - we want to test a service - but to have test control over what the repository responds. This allows for unit testing of the service without starting up the entire application [^4]

[^4]: We will do this in integration testing

---

## Simple Mocking example

Example: DummyJavaServiceMockTest

JUnit needs some help to allow for mocking so we add an extension to the test class and set up our mock dependency:

```java
@ExtendWith(MockitoExtension.class)
class DummyJavaServiceMockTest {
  @Mock
  DummyRepository dummyRepository;
}
```

---

We can now use that repository in our tests and tell it what to do under certain conditions e.g.:

```java
@Test
void testServiceBackendCheck() {
    // When the repository isUp() is called then we will return value true
    when(dummyRepository.isUp()).thenReturn(true);

    // Instantiate test service with mock repo
    DummyJavaService service = new DummyJavaService(dummyRepository);

    // Test
    Assertions.assertThat(service.backendCheck()).isTrue();
}
```

---

## Simple spying example - argument capture

We want to know something about an internal call that our test candidate makes.

For that we'll use argument capture.

Example: DataJavaServiceMockTest

As well as using a mocked repository we add a Captor:

```java
@Captor
ArgumentCaptor<Long> captor;
```

---

We can use this when configuring the mock to capture an argument value:

```java
when(repository.findById(captor.capture()))
  .thenReturn(Optional.of(new DataJava(1L, "qwerty")));
```

And we can test that this was in fact called with the correct value:

```java
Assertions.assertThat(captor.getValue()).isEqualTo(1L);
```

---

## Verification

We can also check that certain expectations match - how many times a mocked method is called, order of calls etc.

For the previous example - we can verify that the findById method is called only once:

```java
verify(repository, times(1)).findById(any());
```

Here we use `any()` as matcher - we could also choose to verify with a concrete parameter value.



---

Expected structure for this doc:

* Integration test in a spring app (with mock/spy)
* DB Tests
* Kotlin

