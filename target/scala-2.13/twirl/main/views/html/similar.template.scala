
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
/*1.2*/import java.util

object similar extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[String],AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(sortedList: List[String])(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
    """),_display_(/*4.6*/main("Search Result")/*4.27*/ {_display_(Seq[Any](format.raw/*4.29*/("""
    """),format.raw/*5.5*/("""<head>
        <style type="text/css">
                h2"""),format.raw/*7.19*/("""{"""),format.raw/*7.20*/("""
                    """),format.raw/*8.21*/("""margin-top: 20px;
                    color:#c5464a;
                    font-size: 20px;
                """),format.raw/*11.17*/("""}"""),format.raw/*11.18*/("""
                """),format.raw/*12.17*/("""body"""),format.raw/*12.21*/("""{"""),format.raw/*12.22*/("""
                    """),format.raw/*13.21*/("""text-align: center;

                """),format.raw/*15.17*/("""}"""),format.raw/*15.18*/("""
                """),format.raw/*16.17*/("""table.gridtable """),format.raw/*16.33*/("""{"""),format.raw/*16.34*/("""
                    """),format.raw/*17.21*/("""font-family: verdana,arial,sans-serif;
                    font-size:11px;
                    color:#333333;
                    border-width: 1px;
                    border-color: #666666;
                    border-collapse: collapse;
                    width:70%;
                    margin:auto;
                    margin-bottom: 10%;

                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/("""
                """),format.raw/*28.17*/("""table.gridtable th """),format.raw/*28.36*/("""{"""),format.raw/*28.37*/("""
                    """),format.raw/*29.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #c5464a;
                    color: #FFFFFF;
                    text-align: center;
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/("""
                """),format.raw/*37.17*/("""table.gridtable td """),format.raw/*37.36*/("""{"""),format.raw/*37.37*/("""
                    """),format.raw/*38.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #ffffff;
                    text-align: center;
                """),format.raw/*44.17*/("""}"""),format.raw/*44.18*/("""
        """),format.raw/*45.9*/("""</style>

    </head>
    <body>
        <div class = "container">
            <table class="gridtable">
                <tr>
                    <th>Title</th>
                </tr>

        """),_display_(/*55.10*/for(result <- sortedList) yield /*55.35*/ {_display_(Seq[Any](format.raw/*55.37*/("""
            """),format.raw/*56.13*/("""<tr><td>Words : """),_display_(/*56.30*/result),format.raw/*56.36*/("""</td></tr>

        """)))}),format.raw/*58.10*/("""
            """),format.raw/*59.13*/("""</table>
        </div>
    </body>
    """)))}),format.raw/*62.6*/("""
"""))
      }
    }
  }

  def render(sortedList:List[String],assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(sortedList)(assetsFinder)

  def f:((List[String]) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (sortedList) => (assetsFinder) => apply(sortedList)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-16T14:00:54.410959
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/similar.scala.html
                  HASH: 7a9537bc2d6ef8692a9ca6690abd74bfce690ed5
                  MATRIX: 610->1|952->19|1109->83|1140->89|1169->110|1208->112|1239->117|1323->174|1351->175|1399->196|1533->302|1562->303|1607->320|1639->324|1668->325|1717->346|1782->383|1811->384|1856->401|1900->417|1929->418|1978->439|2366->799|2395->800|2440->817|2487->836|2516->837|2565->858|2869->1134|2898->1135|2943->1152|2990->1171|3019->1172|3068->1193|3336->1433|3365->1434|3401->1443|3621->1636|3662->1661|3702->1663|3743->1676|3787->1693|3814->1699|3866->1720|3907->1733|3978->1774
                  LINES: 23->1|28->2|33->3|34->4|34->4|34->4|35->5|37->7|37->7|38->8|41->11|41->11|42->12|42->12|42->12|43->13|45->15|45->15|46->16|46->16|46->16|47->17|57->27|57->27|58->28|58->28|58->28|59->29|66->36|66->36|67->37|67->37|67->37|68->38|74->44|74->44|75->45|85->55|85->55|85->55|86->56|86->56|86->56|88->58|89->59|92->62
                  -- GENERATED --
              */
          