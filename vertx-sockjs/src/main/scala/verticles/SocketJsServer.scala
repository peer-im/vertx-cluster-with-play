package verticles

import org.vertx.scala.core._
import org.vertx.scala.core.json._
import org.vertx.scala.platform.Verticle
import org.vertx.scala.core.sockjs.EventBusBridgeHook

import scala.concurrent.Promise

/* ths version uses redis */
class SocketJSServer extends Verticle {

  override def start(promise: Promise[Unit]): Unit = {
    val defaultPort = 8081
    val config = Option(container.config()).getOrElse(Json.emptyObj())
    val inPermitteds = config.getArray("inbound_permitted", Json.arr());
    val outPermitteds = config.getArray("outbound_permitted", Json.arr());
    val server = vertx.createHttpServer
    val sockServer = vertx.createSockJSServer(server)
    val sockServerConf = config.getObject("sjs_config", Json.obj("prefix" -> "/eventbus"))
    val bridgeConf = config.getObject("bridge_config", Json.emptyObj())
    sockServer.bridge(sockServerConf, inPermitteds, outPermitteds, bridgeConf)
    val port = config.getNumber("port", defaultPort).intValue
    server.listen(port, result => {
      if (result.succeeded()) {
        logger.info(s"****** SockJS created with on port: ${port} ******")
        container.deployVerticle("scala:verticles.ConnVerticle", container.config(), 2)
        logger.info("****** Conn Verticle Module deployment done ******")
            promise.success() // okay
            } else {
              logger.fatal("****** Could not start sockjs verticle! ******", result.cause())
            promise.failure(result.cause()) //failed
          }
          })
  }

}
