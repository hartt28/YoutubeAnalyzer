
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[ProfileImp,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
* This template takes a two arguments, a String containing a
* message to display and an AssetsFinder to locate static assets.
*/
  def apply/*6.2*/(imp : ProfileImp)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*7.1*/("""
"""),format.raw/*12.4*/("""

    """),format.raw/*14.5*/("""<!DOCTYPE html>
    <html lang="en">
        <head>
            <meta name="referrer" content="no-referrer">
            <style>
                    * """),format.raw/*19.23*/("""{"""),format.raw/*19.24*/("""
                        """),format.raw/*20.25*/("""box-sizing: border-box;
                    """),format.raw/*21.21*/("""}"""),format.raw/*21.22*/("""

                    """),format.raw/*23.21*/("""body """),format.raw/*23.26*/("""{"""),format.raw/*23.27*/("""
                        """),format.raw/*24.25*/("""font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial,sans-serif, FreeSans, Arimo;
                        display: flex;
                        align-items: center;
                        justify-content: center;
                        flex-direction: column;
                        min-height: 100vh;
                        margin: 0;
                    """),format.raw/*31.21*/("""}"""),format.raw/*31.22*/("""

                    """),format.raw/*33.21*/(""".channel """),format.raw/*33.30*/("""{"""),format.raw/*33.31*/("""
                        """),format.raw/*34.25*/("""background-color: #fff;
                        border-radius: 10px;
                        box-shadow: 0 10px 10px rgba(0, 0, 0, 0.2);
                        display: flex;
                        max-width: 100%;
                        margin: 20px;
                        width: 700px;
                        word-break: normal;
                    """),format.raw/*42.21*/("""}"""),format.raw/*42.22*/("""


                    """),format.raw/*45.21*/(""".channel h6 """),format.raw/*45.33*/("""{"""),format.raw/*45.34*/("""
                        """),format.raw/*46.25*/("""opacity: 0.6;
                        margin: 0;
                        letter-spacing: 1px;
                        text-transform: uppercase;
                    """),format.raw/*50.21*/("""}"""),format.raw/*50.22*/("""

                    """),format.raw/*52.21*/(""".channel h5 """),format.raw/*52.33*/("""{"""),format.raw/*52.34*/("""
                        """),format.raw/*53.25*/("""margin: 2px;
                        letter-spacing: 1px;
                        font-size: medium;
                    """),format.raw/*56.21*/("""}"""),format.raw/*56.22*/("""

                    """),format.raw/*58.21*/(""".channel p """),format.raw/*58.32*/("""{"""),format.raw/*58.33*/("""
                        """),format.raw/*59.25*/("""font-size: large;
                        font-weight: bold;
                        letter-spacing: 1px;
                        margin: 10px 0;
                    """),format.raw/*63.21*/("""}"""),format.raw/*63.22*/("""
                    """),format.raw/*64.21*/(""".channel-name """),format.raw/*64.35*/("""{"""),format.raw/*64.36*/("""
                        """),format.raw/*65.25*/("""background-color: #c5464a;
                        color: #fff;
                        padding: 30px;
                        max-width: 250px;
                    """),format.raw/*69.21*/("""}"""),format.raw/*69.22*/("""

                    """),format.raw/*71.21*/(""".cahnnel-info """),format.raw/*71.35*/("""{"""),format.raw/*71.36*/("""
                        """),format.raw/*72.25*/("""padding: 30px;
                        position: relative;
                        width: 100%;
                    """),format.raw/*75.21*/("""}"""),format.raw/*75.22*/("""
            """),format.raw/*76.13*/("""</style>
            <meta name="referrer" content="no-referrer">
        </head>
"""),format.raw/*79.19*/("""
"""),format.raw/*80.66*/("""
"""),format.raw/*81.77*/("""
"""),format.raw/*82.95*/("""
"""),format.raw/*83.87*/("""
"""),format.raw/*84.101*/("""
"""),format.raw/*85.86*/("""
"""),format.raw/*86.23*/("""
"""),format.raw/*87.20*/("""
        """),format.raw/*88.9*/("""<body>
        <div class="channel-container">
            <div class="channel">
                <div class="channel-name">
                    <img src="""),_display_(/*92.31*/imp/*92.34*/.getUrl),format.raw/*92.41*/(""" """),format.raw/*92.42*/("""width="90px" height="100px">
                    <br>
                    <br>
                    <h6>Channel</h6>
                    <p>"""),_display_(/*96.25*/imp/*96.28*/.getTitle),format.raw/*96.37*/("""</p>
                </div>
                <div class="channel-info">
                    <h6>Channel description</h6>
                        <h5>"""),_display_(/*100.30*/imp/*100.33*/.getDescription),format.raw/*100.48*/("""</h5><br>
                        <h6>Total view count</h6>
                    <h5>"""),_display_(/*102.26*/imp/*102.29*/.getTotalViews),format.raw/*102.43*/("""</h5>
                        <h6>Subscriber count</h6>
                    <h5>"""),_display_(/*104.26*/imp/*104.29*/.getTotalSubscribers),format.raw/*104.49*/("""</h5>
                        <h6>Video count</h6>
                    <h5>"""),_display_(/*106.26*/imp/*106.29*/.getTotVideos),format.raw/*106.42*/("""</h5>
                    <h6>Created Date</h6>
                    <h5>"""),_display_(/*108.26*/imp/*108.29*/.getPublish),format.raw/*108.40*/("""</h5>
                    <h6>Location</h6>
                    <h5>"""),_display_(/*110.26*/imp/*110.29*/.getCountry),format.raw/*110.40*/("""</h5>
                </div>
                </div>
            </div>
        </body>
    </html>
"""))
      }
    }
  }

  def render(imp:ProfileImp,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(imp)(assetsFinder)

  def f:((ProfileImp) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (imp) => (assetsFinder) => apply(imp)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-12-11T09:47:23.471527
                  SOURCE: /Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/app/views/profile.scala.html
                  HASH: 5b44345f0cca7f2a14488c4cf18aa38de1ab2d07
                  MATRIX: 1054->135|1203->191|1231->386|1264->392|1443->543|1472->544|1525->569|1597->613|1626->614|1676->636|1709->641|1738->642|1791->667|2186->1034|2215->1035|2265->1057|2302->1066|2331->1067|2384->1092|2769->1449|2798->1450|2849->1473|2889->1485|2918->1486|2971->1511|3164->1676|3193->1677|3243->1699|3283->1711|3312->1712|3365->1737|3514->1858|3543->1859|3593->1881|3632->1892|3661->1893|3714->1918|3908->2084|3937->2085|3986->2106|4028->2120|4057->2121|4110->2146|4303->2311|4332->2312|4382->2334|4424->2348|4453->2349|4506->2374|4650->2490|4679->2491|4720->2504|4830->2604|4859->2670|4888->2747|4917->2842|4946->2929|4976->3030|5005->3116|5034->3139|5063->3159|5099->3168|5280->3322|5292->3325|5320->3332|5349->3333|5516->3473|5528->3476|5558->3485|5735->3634|5748->3637|5785->3652|5898->3737|5911->3740|5947->3754|6056->3835|6069->3838|6111->3858|6215->3934|6228->3937|6263->3950|6364->4023|6377->4026|6410->4037|6507->4106|6520->4109|6553->4120
                  LINES: 30->6|35->7|36->12|38->14|43->19|43->19|44->20|45->21|45->21|47->23|47->23|47->23|48->24|55->31|55->31|57->33|57->33|57->33|58->34|66->42|66->42|69->45|69->45|69->45|70->46|74->50|74->50|76->52|76->52|76->52|77->53|80->56|80->56|82->58|82->58|82->58|83->59|87->63|87->63|88->64|88->64|88->64|89->65|93->69|93->69|95->71|95->71|95->71|96->72|99->75|99->75|100->76|103->79|104->80|105->81|106->82|107->83|108->84|109->85|110->86|111->87|112->88|116->92|116->92|116->92|116->92|120->96|120->96|120->96|124->100|124->100|124->100|126->102|126->102|126->102|128->104|128->104|128->104|130->106|130->106|130->106|132->108|132->108|132->108|134->110|134->110|134->110
                  -- GENERATED --
              */
          