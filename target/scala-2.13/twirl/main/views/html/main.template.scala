
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/assetsFinder/*14.66*/.path("stylesheets/main.css")),format.raw/*14.95*/("""">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/assetsFinder/*16.71*/.path("images/favicon.png")),format.raw/*16.98*/("""">
"""),format.raw/*17.115*/("""
        """),format.raw/*18.9*/("""<style>

                * """),format.raw/*20.19*/("""{"""),format.raw/*20.20*/("""
                    """),format.raw/*21.21*/("""box-sizing: border-box;
                """),format.raw/*22.17*/("""}"""),format.raw/*22.18*/("""

                """),format.raw/*24.17*/("""h1"""),format.raw/*24.19*/("""{"""),format.raw/*24.20*/("""
                    """),format.raw/*25.21*/("""margin-top: 20px;
                    color:#c5464a;
                    font-size: 45px;
                """),format.raw/*28.17*/("""}"""),format.raw/*28.18*/("""

                """),format.raw/*30.17*/("""body """),format.raw/*30.22*/("""{"""),format.raw/*30.23*/("""
                    """),format.raw/*31.21*/("""margin: 0;
                    padding: 0;
                    background: #FFFFFF;
                    font-weight: 500;
                    font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial,sans-serif, FreeSans, Arimo;
                """),format.raw/*36.17*/("""}"""),format.raw/*36.18*/("""

                """),format.raw/*38.17*/("""#container """),format.raw/*38.28*/("""{"""),format.raw/*38.29*/("""
                    """),format.raw/*39.21*/("""width: 500px;
                    height: 820px;
                    margin: 0 auto;
                """),format.raw/*42.17*/("""}"""),format.raw/*42.18*/("""
                """),format.raw/*43.17*/("""div.search """),format.raw/*43.28*/("""{"""),format.raw/*43.29*/("""padding: 30px 0;"""),format.raw/*43.45*/("""}"""),format.raw/*43.46*/("""

                """),format.raw/*45.17*/("""form """),format.raw/*45.22*/("""{"""),format.raw/*45.23*/("""
                    """),format.raw/*46.21*/("""position: relative;
                    width: 300px;
                    margin: 0 auto;
                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/("""

                """),format.raw/*51.17*/("""input, button """),format.raw/*51.31*/("""{"""),format.raw/*51.32*/("""
                    """),format.raw/*52.21*/("""border: none;
                    outline: none;
                """),format.raw/*54.17*/("""}"""),format.raw/*54.18*/("""

                """),format.raw/*56.17*/("""input """),format.raw/*56.23*/("""{"""),format.raw/*56.24*/("""
                    """),format.raw/*57.21*/("""width: 100%;
                    height: 42px;
                    padding-left: 13px;
                    padding-right:46px;
                """),format.raw/*61.17*/("""}"""),format.raw/*61.18*/("""

                """),format.raw/*63.17*/("""button """),format.raw/*63.24*/("""{"""),format.raw/*63.25*/("""
                    """),format.raw/*64.21*/("""height: 42px;
                    width: 42px;
                    cursor: pointer;
                    position: absolute;
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/("""

                """),format.raw/*70.17*/(""".bar6 input """),format.raw/*70.29*/("""{"""),format.raw/*70.30*/("""
                    """),format.raw/*71.21*/("""border: 2px solid #c5464a;
                    border-radius: 5px;
                    background: transparent;
                    top: 0;
                    right: 0;
                """),format.raw/*76.17*/("""}"""),format.raw/*76.18*/("""
                """),format.raw/*77.17*/(""".bar6 button """),format.raw/*77.30*/("""{"""),format.raw/*77.31*/("""
                    """),format.raw/*78.21*/("""background: #c5464a;
                    border-radius: 0 5px 5px 0;
                    width: 60px;
                    top: 0;
                    right: 0;
                """),format.raw/*83.17*/("""}"""),format.raw/*83.18*/("""
                """),format.raw/*84.17*/(""".bar6 button:before """),format.raw/*84.37*/("""{"""),format.raw/*84.38*/("""
                    """),format.raw/*85.21*/("""content: "Go";
                    font-size: 13px;
                    color: #F9F0DA;
                """),format.raw/*88.17*/("""}"""),format.raw/*88.18*/("""

        """),format.raw/*90.9*/("""</Style>
    </head>
    <body  data-ws-url="ws://localhost:9000/ws">

        <div class="form-group" style="text-align: center">
            <h1>
                YouTube Analyzer
            </h1>
            <br>
            <br>


            <div class="search bar6">
                <div id="search">
                    <form action="search" method="GET" id="searchForm" name="search">
                    <input type="text" name="searchkey" id="query" placeholder="Search">
                    <button type="submit" value="Search" onclick="sendMessage()"></button>
                    </form>
                </div>
            </div>
        </div>
                """),format.raw/*112.32*/("""
        """),_display_(/*113.10*/content),format.raw/*113.17*/("""
    """),format.raw/*114.5*/("""</body>



</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-16T14:00:54.357918
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/main.scala.html
                  HASH: 9f4c46d5d1afa8c77a897701d40fc1dbdf6df157
                  MATRIX: 1178->260|1339->328|1366->329|1446->434|1482->443|1517->451|1543->456|1632->518|1653->530|1703->559|1876->705|1897->717|1945->744|1977->861|2013->870|2068->897|2097->898|2146->919|2214->959|2243->960|2289->978|2319->980|2348->981|2397->1002|2531->1108|2560->1109|2606->1127|2639->1132|2668->1133|2717->1154|2991->1400|3020->1401|3066->1419|3105->1430|3134->1431|3183->1452|3312->1553|3341->1554|3386->1571|3425->1582|3454->1583|3498->1599|3527->1600|3573->1618|3606->1623|3635->1624|3684->1645|3818->1751|3847->1752|3893->1770|3935->1784|3964->1785|4013->1806|4106->1871|4135->1872|4181->1890|4215->1896|4244->1897|4293->1918|4464->2061|4493->2062|4539->2080|4574->2087|4603->2088|4652->2109|4820->2249|4849->2250|4895->2268|4935->2280|4964->2281|5013->2302|5227->2488|5256->2489|5301->2506|5342->2519|5371->2520|5420->2541|5624->2717|5653->2718|5698->2735|5746->2755|5775->2756|5824->2777|5956->2881|5985->2882|6022->2892|6725->3656|6763->3666|6792->3673|6825->3678
                  LINES: 32->7|37->8|38->9|41->12|42->13|42->13|42->13|43->14|43->14|43->14|45->16|45->16|45->16|46->17|47->18|49->20|49->20|50->21|51->22|51->22|53->24|53->24|53->24|54->25|57->28|57->28|59->30|59->30|59->30|60->31|65->36|65->36|67->38|67->38|67->38|68->39|71->42|71->42|72->43|72->43|72->43|72->43|72->43|74->45|74->45|74->45|75->46|78->49|78->49|80->51|80->51|80->51|81->52|83->54|83->54|85->56|85->56|85->56|86->57|90->61|90->61|92->63|92->63|92->63|93->64|97->68|97->68|99->70|99->70|99->70|100->71|105->76|105->76|106->77|106->77|106->77|107->78|112->83|112->83|113->84|113->84|113->84|114->85|117->88|117->88|119->90|140->112|141->113|141->113|142->114
                  -- GENERATED --
              */
          