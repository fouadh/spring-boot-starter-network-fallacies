A Spring Boot Starter to simulate network failures in an app.

It can be used to check how an application reacts to network issues (either in tests or eventually in production).

The way to use it simple:

* Activate the starter with the @EnableNetworkFallacies annotation.
* Use the @NetworkFailure annotation on methods liable to call some service through the network. The **odds** property
specifies the odds to have a network failure. 

For example, a value of 2 says that there is one chance over two to get a 
failure either before the external service is called (request failure) either after it has been called (response failure).

