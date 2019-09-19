package micronaut.test;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import javax.inject.Inject;

@Controller
public class MyController {

	@Inject
	private MyDeclarativeClient client;

	@Get("/{name}")
	String hi(@PathVariable(name = "name")String name) {
		String returnedMessage = client.getHiMessage();
		return returnedMessage + name;
	}

}
