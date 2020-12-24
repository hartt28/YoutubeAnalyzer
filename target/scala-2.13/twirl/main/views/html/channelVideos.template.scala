
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
/*5.2*/import java.util.concurrent.CompletableFuture
/*6.2*/import com.google.api.services.youtube.model.PlaylistItem

object channelVideos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[List[Videos],AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*8.2*/(list:List[Videos])(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*14.3*/("""
"""),_display_(/*15.2*/main("Search Result")/*15.23*/ {_display_(Seq[Any](format.raw/*15.25*/("""
"""),format.raw/*16.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <style type="text/css">
                h2"""),format.raw/*20.19*/("""{"""),format.raw/*20.20*/("""
                    """),format.raw/*21.21*/("""margin-top: 20px;
                    color:#c5464a;
                    font-size: 20px;
                """),format.raw/*24.17*/("""}"""),format.raw/*24.18*/("""
                """),format.raw/*25.17*/("""body"""),format.raw/*25.21*/("""{"""),format.raw/*25.22*/("""
                    """),format.raw/*26.21*/("""text-align: center;

                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/("""
                """),format.raw/*29.17*/("""table.gridtable """),format.raw/*29.33*/("""{"""),format.raw/*29.34*/("""
                    """),format.raw/*30.21*/("""font-family: verdana,arial,sans-serif;
                    font-size:11px;
                    color:#333333;
                    border-width: 1px;
                    border-color: #666666;
                    border-collapse: collapse;
                    width:70%;
                    margin:auto;
                    margin-bottom: 10%;

                """),format.raw/*40.17*/("""}"""),format.raw/*40.18*/("""
                """),format.raw/*41.17*/("""table.gridtable th """),format.raw/*41.36*/("""{"""),format.raw/*41.37*/("""
                    """),format.raw/*42.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #c5464a;
                    color: #FFFFFF;
                    text-align: center;
                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/("""
                """),format.raw/*50.17*/("""table.gridtable td """),format.raw/*50.36*/("""{"""),format.raw/*50.37*/("""
                    """),format.raw/*51.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #ffffff;
                    text-align: center;
                """),format.raw/*57.17*/("""}"""),format.raw/*57.18*/("""
        """),format.raw/*58.9*/("""</style>

    </head>
    <body>
        <body>
            <div class = "container">
                <table class="gridtable">
                    <tr>
                        <th>Date</th><th>Title</th>
                    </tr>
        """),_display_(/*68.10*/for(result <- list) yield /*68.29*/ {_display_(Seq[Any](format.raw/*68.31*/("""
            """),format.raw/*69.13*/("""<tr>
                <td>"""),_display_(/*70.22*/result/*70.28*/.getStringDate),format.raw/*70.42*/("""</td>
                <td>"""),_display_(/*71.22*/result/*71.28*/.getVideoTitle),format.raw/*71.42*/("""</td>
            </tr>
        """)))}),format.raw/*73.10*/("""
                """),format.raw/*74.17*/("""</table>
            </div>
    </body>
""")))}),format.raw/*77.2*/("""



"""))
      }
    }
  }

  def render(list:List[Videos],assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(list)(assetsFinder)

  def f:((List[Videos]) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (list) => (assetsFinder) => apply(list)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-10T23:10:15.894845
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/channelVideos.scala.html
                  HASH: 682ed0a11c9364a876e32e965fc9b3071501a23b
                  MATRIX: 610->134|663->181|1052->241|1202->298|1230->489|1258->491|1288->512|1328->514|1356->515|1478->609|1507->610|1556->631|1690->737|1719->738|1764->755|1796->759|1825->760|1874->781|1939->818|1968->819|2013->836|2057->852|2086->853|2135->874|2523->1234|2552->1235|2597->1252|2644->1271|2673->1272|2722->1293|3026->1569|3055->1570|3100->1587|3147->1606|3176->1607|3225->1628|3493->1868|3522->1869|3558->1878|3825->2118|3860->2137|3900->2139|3941->2152|3994->2178|4009->2184|4044->2198|4098->2225|4113->2231|4148->2245|4212->2278|4257->2295|4328->2336
                  LINES: 23->5|24->6|29->8|34->9|35->14|36->15|36->15|36->15|37->16|41->20|41->20|42->21|45->24|45->24|46->25|46->25|46->25|47->26|49->28|49->28|50->29|50->29|50->29|51->30|61->40|61->40|62->41|62->41|62->41|63->42|70->49|70->49|71->50|71->50|71->50|72->51|78->57|78->57|79->58|89->68|89->68|89->68|90->69|91->70|91->70|91->70|92->71|92->71|92->71|94->73|95->74|98->77
                  -- GENERATED --
              */
          