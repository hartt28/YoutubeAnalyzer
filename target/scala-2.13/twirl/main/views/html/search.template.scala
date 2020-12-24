
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
/*5.2*/import com.google.api.services.youtube.model.SearchResult
/*6.2*/import java.util.concurrent.CompletableFuture

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,List[SearchingResults],AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*7.2*/(keyword: String ,list : List[SearchingResults])(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""

"""),format.raw/*14.3*/("""
"""),_display_(/*15.2*/main("Search Result")/*15.23*/ {_display_(Seq[Any](format.raw/*15.25*/("""
    """),format.raw/*16.5*/("""<head>
        <style type="text/css">
                h2"""),format.raw/*18.19*/("""{"""),format.raw/*18.20*/("""
                    """),format.raw/*19.21*/("""margin-top: 20px;
                    color:#c5464a;
                    font-size: 20px;
                """),format.raw/*22.17*/("""}"""),format.raw/*22.18*/("""
                """),format.raw/*23.17*/("""body"""),format.raw/*23.21*/("""{"""),format.raw/*23.22*/("""
                    """),format.raw/*24.21*/("""text-align: center;

                """),format.raw/*26.17*/("""}"""),format.raw/*26.18*/("""
                """),format.raw/*27.17*/("""table.gridtable """),format.raw/*27.33*/("""{"""),format.raw/*27.34*/("""
                    """),format.raw/*28.21*/("""font-family: verdana,arial,sans-serif;
                    font-size:11px;
                    color:#333333;
                    border-width: 1px;
                    border-color: #666666;
                    border-collapse: collapse;
                    width:70%;
                    margin:auto;
                    margin-bottom: 10%;

                """),format.raw/*38.17*/("""}"""),format.raw/*38.18*/("""
                """),format.raw/*39.17*/("""table.gridtable th """),format.raw/*39.36*/("""{"""),format.raw/*39.37*/("""
                    """),format.raw/*40.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #c5464a;
                    color: #FFFFFF;
                    text-align: center;
                """),format.raw/*47.17*/("""}"""),format.raw/*47.18*/("""
                """),format.raw/*48.17*/("""table.gridtable td """),format.raw/*48.36*/("""{"""),format.raw/*48.37*/("""
                    """),format.raw/*49.21*/("""border-width: 1px;
                    padding: 8px;
                    border-style: solid;
                    border-color: #666666;
                    background-color: #ffffff;
                    text-align: center;
                """),format.raw/*55.17*/("""}"""),format.raw/*55.18*/("""
        """),format.raw/*56.9*/("""</style>

    </head>
    <body>
        <div id="searchkey"> </div>
    <div class = "container">
    <br>
    <h2 style="color: #cc0000; text-align: center">Search results for: """),_display_(/*63.73*/keyword),format.raw/*63.80*/("""</h2>



            <table class="gridtable" id="table">
                <tr>
                    <th>Title</th>
                    <th>Channel Name</th>
                    <th>Recent Videos</th>
                    <th>View Counts</th>
                    <th>Time lapsed</th>
                    <th>Sentiment</th>
                </tr>
                <div id="videos"></div>

"""),format.raw/*78.52*/("""
"""),format.raw/*79.123*/("""
"""),format.raw/*80.132*/("""
"""),format.raw/*81.56*/("""
"""),format.raw/*82.59*/("""
"""),format.raw/*83.51*/("""
"""),format.raw/*84.51*/("""
            """),format.raw/*85.13*/("""</table>


    </div>
    </body>

    <script type="text/javascript">
            let idList =[];
            let videoList = [];
            var websocket;
            websocket = new WebSocket("ws://localhost:9000/ws");
            websocket.onmessage = function processMessage(message)"""),format.raw/*96.67*/("""{"""),format.raw/*96.68*/("""
                """),format.raw/*97.17*/("""var message = JSON.parse(message.data);
                if(idList.includes(message.videoId))"""),format.raw/*98.53*/("""{"""),format.raw/*98.54*/("""console.log(message)"""),format.raw/*98.74*/("""}"""),format.raw/*98.75*/("""
                """),format.raw/*99.17*/("""else """),format.raw/*99.22*/("""{"""),format.raw/*99.23*/("""
                    """),format.raw/*100.21*/("""idList.push(message.videoId);
                    console.log(message);
                    parseVideos(message);
                """),format.raw/*103.17*/("""}"""),format.raw/*103.18*/("""
            """),format.raw/*104.13*/("""}"""),format.raw/*104.14*/("""
            """),format.raw/*105.13*/("""function sendMessage()"""),format.raw/*105.35*/("""{"""),format.raw/*105.36*/("""
                """),format.raw/*106.17*/("""websocket.send(query.value);
                console.log(query.value);
            """),format.raw/*108.13*/("""}"""),format.raw/*108.14*/("""

            """),format.raw/*110.13*/("""function parseVideos(message)"""),format.raw/*110.42*/("""{"""),format.raw/*110.43*/("""
                """),format.raw/*111.17*/("""var tr=document.createElement("tr");
                var vtitle=document.createElement("td");
                var ctitle=document.createElement("td");
                var ctitle2=document.createElement("td");
                var view = document.createElement("td");
                var time=document.createElement("td");
                var sentiment=document.createElement("td");

                vtitle.innerHTML= '<a href="http://localhost:9000/similar?videoId='+ message.videoId+'">' + message.videoTitle + '</a>';
                ctitle.innerHTML='<a href="http://localhost:9000/profile/'+ message.channelID +'">' + message.channelTitle + '</a>';
                ctitle2.innerHTML='<a href="http://localhost:9000/CVideos?channelID='+ message.channelID +'&keyword='+message.query+'">' + message.channelTitle + '</a>';
                view.innerHTML = message.viewCount;
                time.innerHTML= message.timeAgo;
                sentiment.innerHTML= message.sentiment;

                var tab= document.getElementById("table");
                tab.appendChild(tr);
                tr.appendChild(vtitle);
                tr.appendChild(ctitle);
                tr.appendChild(ctitle2);
                tr.appendChild(view);
                tr.appendChild(time);
                tr.appendChild(sentiment);

            """),format.raw/*135.13*/("""}"""),format.raw/*135.14*/("""
    """),format.raw/*136.5*/("""</script>
""")))}))
      }
    }
  }

  def render(keyword:String,list:List[SearchingResults],assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(keyword,list)(assetsFinder)

  def f:((String,List[SearchingResults]) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (keyword,list) => (assetsFinder) => apply(keyword,list)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-16T14:00:54.281460
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/search.scala.html
                  HASH: 5c4f4aff3d652c08a688d8f26b83a9318427467c
                  MATRIX: 610->134|675->193|1062->240|1241->326|1270->518|1298->520|1328->541|1368->543|1400->548|1485->605|1514->606|1563->627|1697->733|1726->734|1771->751|1803->755|1832->756|1881->777|1946->814|1975->815|2020->832|2064->848|2093->849|2142->870|2530->1230|2559->1231|2604->1248|2651->1267|2680->1268|2729->1289|3033->1565|3062->1566|3107->1583|3154->1602|3183->1603|3232->1624|3500->1864|3529->1865|3565->1874|3772->2054|3800->2061|4211->2495|4241->2618|4271->2750|4300->2806|4329->2865|4358->2916|4387->2967|4428->2980|4745->3269|4774->3270|4819->3287|4939->3379|4968->3380|5016->3400|5045->3401|5090->3418|5123->3423|5152->3424|5202->3445|5361->3575|5391->3576|5433->3589|5463->3590|5505->3603|5556->3625|5586->3626|5632->3643|5744->3726|5774->3727|5817->3741|5875->3770|5905->3771|5951->3788|7309->5117|7339->5118|7372->5123
                  LINES: 23->5|24->6|29->7|34->8|36->14|37->15|37->15|37->15|38->16|40->18|40->18|41->19|44->22|44->22|45->23|45->23|45->23|46->24|48->26|48->26|49->27|49->27|49->27|50->28|60->38|60->38|61->39|61->39|61->39|62->40|69->47|69->47|70->48|70->48|70->48|71->49|77->55|77->55|78->56|85->63|85->63|100->78|101->79|102->80|103->81|104->82|105->83|106->84|107->85|118->96|118->96|119->97|120->98|120->98|120->98|120->98|121->99|121->99|121->99|122->100|125->103|125->103|126->104|126->104|127->105|127->105|127->105|128->106|130->108|130->108|132->110|132->110|132->110|133->111|157->135|157->135|158->136
                  -- GENERATED --
              */
          