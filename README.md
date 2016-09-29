# simple-pact-consumer


###When
sbt "testOnly PactClientSpec*"
###Then
```
..... 

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
[error] x Consumer 'SpecsConsumers' has a pact with Provider 'SpecsProvider': a request for foo with a body
[error]
[error]  missing:
[error]         method: GET
[error]         path: /users/1234
[error]         query: null
[error]         headers: [:]
[error]         matchers: MatchingRules(rules=[:])
[error]         body: au.com.dius.pact.model.OptionalBody(EMPTY, ) (PactSpec.scala:29)
[info] PactClientSpec
[info]
[info] Total for specification PactClientSpec
[info] Finished in 793 ms
[info] 1 example, 1 failure, 0 error
[info]
[error] Failed: Total 1, Failed 1, Errors 0, Passed 0
[error] Failed tests:
[error]         PactClientSpec
[error] (test:testOnly) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 10 s, completed Sep 29, 2016 6:09:10 PM

```
