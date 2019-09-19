package micronaut.test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.http.ContentTypeHeader;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class MyControllerTest {

	@Inject
	@Client("/")
	HttpClient httpClient;

	private static WireMockServer wireMockServer = new WireMockServer(wireMockConfig().port(8090));

	@BeforeAll
	public static void setupWiremockServer() {
		wireMockServer.stubFor(get(urlEqualTo("/my-declarative-client-path/himessage"))
				.willReturn(ok()
				.withBody("hi ")));

		wireMockServer.start();
	}

	@AfterAll
	public static void shutdownServer() {
		wireMockServer.stop();
	}

	@Test
	public void test() {
		String greeting = httpClient.toBlocking().retrieve("john");
		assertEquals("hi john", greeting);
	}

	@Test
	public void test2() {
		String greeting = httpClient.toBlocking().retrieve("john");
		assertEquals("hi john", greeting);
	}
}