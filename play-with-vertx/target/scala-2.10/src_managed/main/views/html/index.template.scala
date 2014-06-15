
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<h1> Test Vertx </h1>

"""),_display_(Seq[Any](/*5.2*/main("Welcome to Play 2.1")/*5.29*/ {_display_(Seq[Any](format.raw/*5.31*/("""
    
   
    
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 14 16:18:38 PDT 2014
                    SOURCE: /Users/macbookpro/workspaces/sparkover/vertx-projects/recluster-issue/play-with-vertx/app/views/index.scala.html
                    HASH: 7fbc9deb916b35f715d6843314b5d2fd567565c9
                    MATRIX: 556->1|667->18|727->44|762->71|801->73|847->89
                    LINES: 19->1|22->1|26->5|26->5|26->5|30->9
                    -- GENERATED --
                */
            