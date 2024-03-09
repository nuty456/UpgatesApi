package cz.upgates;

import cz.upgates.utils.ReusableWebClient;
import lombok.extern.slf4j.Slf4j;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;

@Slf4j
class ReusableWebClientTest {

  private static MockWebServer mockWebServer;

  @BeforeAll
  static void setup() throws IOException {
    mockWebServer = new MockWebServer();
    mockWebServer.start(8080);

    // Setup a PATCH endpoint that logs received requests
    mockWebServer.enqueue(new MockResponse()
        .setResponseCode(200)
        .setBody("Patch request received"));
  }

  @AfterAll
  static void tearDown() throws IOException {
    mockWebServer.shutdown();
  }

  @Test
  public void whenPatchWithValidPayload_thenReturnsSuccess() throws InterruptedException {
    ReusableWebClient webClient = new ReusableWebClient("http://localhost:8080", "bla bla bla");
    String patch = webClient.patch("/", "{\"valid-payload\":\"valid-value\"}", String.class);

    // Verify a PATCH request was indeed sent to "/"
    RecordedRequest recordedRequest = mockWebServer.takeRequest();
    Assertions.assertEquals("PATCH", recordedRequest.getMethod());
    Assertions.assertEquals("/", recordedRequest.getPath());
    String authorization = recordedRequest.getHeader("Authorization");
    Assertions.assertEquals("bla bla bla", authorization);
    Assertions.assertEquals("{\"valid-payload\":\"valid-value\"}", recordedRequest.getBody().readUtf8());

    // Log the payload of the request
    log.info("Header received: %s".formatted(authorization));
    log.info("Payload received: %s".formatted(recordedRequest.getBody().readUtf8()));
    log.info("Response received: %s".formatted(patch));
  }
}
