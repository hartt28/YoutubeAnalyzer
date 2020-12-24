
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("YouTubeAnalyzer")/*4.25*/ {_display_(Seq[Any](format.raw/*4.27*/("""


""")))}),format.raw/*7.2*/("""

"""))
      }
    }
  }

  def render(assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(assetsFinder)

  def f:((AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (assetsFinder) => apply(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-10T23:10:15.859661
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/index.scala.html
                  HASH: 8146f8b4a020a891d593434a4a4d23c5958d0098
                  MATRIX: 913->2|1044->40|1071->42|1102->65|1141->67|1174->71
                  LINES: 27->2|32->3|33->4|33->4|33->4|36->7
                  -- GENERATED --
              */
          