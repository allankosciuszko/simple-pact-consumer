import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.ActorMaterializer
import au.com.dius.pact.consumer.PactSpec
import au.com.dius.pact.consumer.dsl.PactDslJsonBody
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.concurrent.duration.Duration

@RunWith(classOf[JUnitRunner])
class PactClientSpec extends Specification with PactSpec {
  override val provider: String = "SpecsProvider"
  override val consumer: String = "SpecsConsumers"

  implicit val actorSystem = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val dispatcher = actorSystem.dispatcher

  val timeout = Duration(5000, MILLISECONDS)


  val body = new PactDslJsonBody()
    .stringMatcher("count", "\\d{1,9}")

  override def is = uponReceiving("a request for foo with a body")
    .matching(path = "/users/1234")
    .willRespondWith(
      status = 200,
      headers = Map.empty[String, String],
      bodyAndMatchers = body
    )
    .withConsumerTest(providerConfig => {
      val responseFuture = Http().singleRequest(HttpRequest(uri = s"http://${providerConfig.url}/users/1234"))
      (Await.result(responseFuture, timeout) must be_==(200, "{}"))
    })

}