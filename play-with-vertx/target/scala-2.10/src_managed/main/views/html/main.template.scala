
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
<head>
  <title>"""),_display_(Seq[Any](/*7.11*/title)),format.raw/*7.16*/("""</title>
  <script src=""""),_display_(Seq[Any](/*8.17*/routes/*8.23*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*8.68*/("""" type="text/javascript"></script>
  <script src="http://cdn.sockjs.org/sockjs-0.3.4.min.js"></script>
  <script src=""""),_display_(Seq[Any](/*10.17*/routes/*10.23*/.Assets.at("javascripts/vertxbus.js"))),format.raw/*10.60*/("""" type="text/javascript"></script>
</head>
<style>
  .box """),format.raw/*13.8*/("""{"""),format.raw/*13.9*/("""
    background-color: #F0F0F0;
    border: 5px solid blue;
    width: 400px;
    height: 300px;
  """),format.raw/*18.3*/("""}"""),format.raw/*18.4*/("""

  .innerbox """),format.raw/*20.13*/("""{"""),format.raw/*20.14*/("""
    overflow: auto;
    border: 5px solid blue;
    border-left: 0px;
    border-right: 0px;
  """),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""

  body """),format.raw/*27.8*/("""{"""),format.raw/*27.9*/("""
    background-color: #F0F0F0;
  """),format.raw/*29.3*/("""}"""),format.raw/*29.4*/("""
</style>

<body>

<div id="send" class="box" style="position:absolute;left:0px;top:0px">

  <form onsubmit="return false;">
    Address:<input type="text" id="sendAddress" value="someaddress"/><br>
    Message:<input type="text" id="sendMessage" value="Hello, World!"/>
    <input type="button" id="sendButton" value="Send message"/>
  </form>

  <br>
  Sent messages:<br>

  <div id="sent" class="innerbox" style="width: 400px; height: 205px;">
  </div>
</div>

<div id="subscribe" class="box" style="position:absolute;left:450px;top:0px">

  <form onsubmit="return false;">
    Address:<input type="text" id="subscribeAddress" value="someaddress"/>
    <input type="button" id="subscribeButton" value="Subscribe"/>
  </form>

  <br>
  Subscriptions:<br>

  <div id="subscribed" class="innerbox" style="width: 400px; height: 230px;">
  </div>
</div>

<br>

<div id="receive" class="box" style="position:absolute;left:0px;top:350px">

  Received messages:<br>

  <div id="received" class="innerbox" style="width: 400px; height: 275px;">
  </div>

</div>

<div id="status" class="box" style="position:absolute;left:450px;top:350px">
  <input type="button" id="connectButton" value="Open connection"/><br>
  <input type="button" id="closeButton" value="Close connection"/><br>
  Connection Status:&nbsp;
  <div id="status_info">Not connected</div>
</div>

<script>

  var eb = null;

  function publish(address,  message) """),format.raw/*85.39*/("""{"""),format.raw/*85.40*/("""
    if (eb) """),format.raw/*86.13*/("""{"""),format.raw/*86.14*/("""
      var json = """),format.raw/*87.18*/("""{"""),format.raw/*87.19*/("""text: message"""),format.raw/*87.32*/("""}"""),format.raw/*87.33*/(""";
      eb.publish(address, 123.2);
      $('#sent').append($("<code>").text("Address:" + address + " Message:" + message));
      $('#sent').append($("</code><br>"));
    """),format.raw/*91.5*/("""}"""),format.raw/*91.6*/("""
  """),format.raw/*92.3*/("""}"""),format.raw/*92.4*/("""

  function subscribe(address) """),format.raw/*94.31*/("""{"""),format.raw/*94.32*/("""
    if (eb) """),format.raw/*95.13*/("""{"""),format.raw/*95.14*/("""
      eb.registerHandler(address, function(msg, replyTo) """),format.raw/*96.58*/("""{"""),format.raw/*96.59*/("""
        $('#received').append("Address:" + address + " Message:" + msg + "<br>");
      """),format.raw/*98.7*/("""}"""),format.raw/*98.8*/(""");
      $('#subscribed').append($("<code>").text("Address:" + address));
      $('#subscribed').append($("</code><br>"));
    """),format.raw/*101.5*/("""}"""),format.raw/*101.6*/("""
  """),format.raw/*102.3*/("""}"""),format.raw/*102.4*/("""

  function closeConn() """),format.raw/*104.24*/("""{"""),format.raw/*104.25*/("""
    if (eb) """),format.raw/*105.13*/("""{"""),format.raw/*105.14*/("""
      eb.close();
    """),format.raw/*107.5*/("""}"""),format.raw/*107.6*/("""
  """),format.raw/*108.3*/("""}"""),format.raw/*108.4*/("""

  function openConn() """),format.raw/*110.23*/("""{"""),format.raw/*110.24*/("""
    if (!eb) """),format.raw/*111.14*/("""{"""),format.raw/*111.15*/("""
      eb = new vertx.EventBus("http://localhost:8080/eventbus");

      eb.onopen = function() """),format.raw/*114.30*/("""{"""),format.raw/*114.31*/("""
        $("#status_info").text("Connected");
      """),format.raw/*116.7*/("""}"""),format.raw/*116.8*/(""";

      eb.onclose = function() """),format.raw/*118.31*/("""{"""),format.raw/*118.32*/("""
        $("#status_info").text("Not connected");
        eb = null;
      """),format.raw/*121.7*/("""}"""),format.raw/*121.8*/(""";
    """),format.raw/*122.5*/("""}"""),format.raw/*122.6*/("""
  """),format.raw/*123.3*/("""}"""),format.raw/*123.4*/("""

  $(document).ready(function() """),format.raw/*125.32*/("""{"""),format.raw/*125.33*/("""
    $("#sendButton").click(function() """),format.raw/*126.39*/("""{"""),format.raw/*126.40*/("""
      publish($("#sendAddress").val(), $("#sendMessage").val());
    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/(""");

    $("#subscribeButton").click(function() """),format.raw/*130.44*/("""{"""),format.raw/*130.45*/("""
      subscribe($("#subscribeAddress").val());
    """),format.raw/*132.5*/("""}"""),format.raw/*132.6*/(""");

    $("#closeButton").click(function() """),format.raw/*134.40*/("""{"""),format.raw/*134.41*/("""
      closeConn();
    """),format.raw/*136.5*/("""}"""),format.raw/*136.6*/(""");

    $("#connectButton").click(function() """),format.raw/*138.42*/("""{"""),format.raw/*138.43*/("""
      openConn();
    """),format.raw/*140.5*/("""}"""),format.raw/*140.6*/(""");
  """),format.raw/*141.3*/("""}"""),format.raw/*141.4*/(""");

</script>

</body>
</html>"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 14 16:18:38 PDT 2014
                    SOURCE: /Users/macbookpro/workspaces/sparkover/vertx-projects/recluster-issue/play-with-vertx/app/views/main.scala.html
                    HASH: 32ea653d5355379e9de0b3a99ba9026a74fae024
                    MATRIX: 560->1|684->31|762->74|788->79|848->104|862->110|928->155|1083->274|1098->280|1157->317|1242->375|1270->376|1396->475|1424->476|1466->490|1495->491|1618->587|1646->588|1682->597|1710->598|1771->632|1799->633|3248->2054|3277->2055|3318->2068|3347->2069|3393->2087|3422->2088|3463->2101|3492->2102|3691->2274|3719->2275|3749->2278|3777->2279|3837->2311|3866->2312|3907->2325|3936->2326|4022->2384|4051->2385|4167->2474|4195->2475|4350->2602|4379->2603|4410->2606|4439->2607|4493->2632|4523->2633|4565->2646|4595->2647|4646->2670|4675->2671|4706->2674|4735->2675|4788->2699|4818->2700|4861->2714|4891->2715|5016->2811|5046->2812|5126->2864|5155->2865|5217->2898|5247->2899|5350->2974|5379->2975|5413->2981|5442->2982|5473->2985|5502->2986|5564->3019|5594->3020|5662->3059|5692->3060|5790->3130|5819->3131|5895->3178|5925->3179|6005->3231|6034->3232|6106->3275|6136->3276|6188->3300|6217->3301|6291->3346|6321->3347|6372->3370|6401->3371|6434->3376|6463->3377
                    LINES: 19->1|22->1|28->7|28->7|29->8|29->8|29->8|31->10|31->10|31->10|34->13|34->13|39->18|39->18|41->20|41->20|46->25|46->25|48->27|48->27|50->29|50->29|106->85|106->85|107->86|107->86|108->87|108->87|108->87|108->87|112->91|112->91|113->92|113->92|115->94|115->94|116->95|116->95|117->96|117->96|119->98|119->98|122->101|122->101|123->102|123->102|125->104|125->104|126->105|126->105|128->107|128->107|129->108|129->108|131->110|131->110|132->111|132->111|135->114|135->114|137->116|137->116|139->118|139->118|142->121|142->121|143->122|143->122|144->123|144->123|146->125|146->125|147->126|147->126|149->128|149->128|151->130|151->130|153->132|153->132|155->134|155->134|157->136|157->136|159->138|159->138|161->140|161->140|162->141|162->141
                    -- GENERATED --
                */
            