package verticles

import org.vertx.scala.platform.Verticle
import org.vertx.scala.core._
import org.vertx.scala.core.json._
import org.vertx.scala.core.eventbus._
import org.vertx.scala.core.FunctionConverters._

import scala.concurrent.Promise
import scala.util.Try
import scala.util.Success
import scala.util.Failure


class ConnVerticle extends Verticle {

  override def start(promise: Promise[Unit]): Unit = {
    // lazy val eb = vertx.eventBus
    lazy val eb:EventBus = vertx.eventBus
    val config = Option(container.config()).getOrElse(Json.emptyObj())
    logger.info("****** Starting SockJS Connection verticle ******")

    eb.registerHandler("eb.echo", (msg: Message[String]) => {
      logger.info(s">>> SockJS Conn verticle received echo request ${msg.body}")
      msg.reply(msg.body)
      }, {
      case Success(_) => {
        logger.info(s">>> SockJS Conn verticle registered success")
        promise.success()
      }
      case Failure(ex) => {
        logger.info(s">>> SockJS Conn verticle registered failure ${ex}")
        promise.failure(ex)
      }
    }: Try[Void] => Unit)

    logger.info(s">>> SockJS Conn verticle started with config ${config.toString}")

  }

}