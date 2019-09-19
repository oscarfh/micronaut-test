package micronaut.test;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@io.micronaut.http.client.annotation.Client(id = "my-declarative-client")
public interface MyDeclarativeClient {

	@Get("/himessage")
	@Produces({ "application/json" })
	String getHiMessage();
}