// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/conf/routes
// @DATE:Wed Dec 16 14:00:53 CST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_1: controllers.HomeController,
  // @LINE:14
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_1: controllers.HomeController,
    // @LINE:14
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.HomeController.search(searchkey:String, request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/""" + "$" + """channelID<[^/]+>""", """controllers.HomeController.profile(channelID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """CVideos""", """controllers.HomeController.CVideos(channelID:String, keyword:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """similar""", """controllers.HomeController.similar(videoId:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.HomeController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_search1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_HomeController_search1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.search(fakeValue[String], fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "search",
      Seq(classOf[String], classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_profile2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile/"), DynamicPart("channelID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_profile2_invoker = createInvoker(
    HomeController_1.profile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "profile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """profile/""" + "$" + """channelID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_CVideos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("CVideos")))
  )
  private[this] lazy val controllers_HomeController_CVideos3_invoker = createInvoker(
    HomeController_1.CVideos(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "CVideos",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """CVideos""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_similar4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("similar")))
  )
  private[this] lazy val controllers_HomeController_similar4_invoker = createInvoker(
    HomeController_1.similar(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "similar",
      Seq(classOf[String]),
      "GET",
      this.prefix + """similar""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_ws5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_HomeController_ws5_invoker = createInvoker(
    HomeController_1.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws",
      Nil,
      "GET",
      this.prefix + """ws""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_1.index(req))
      }
  
    // @LINE:6
    case controllers_HomeController_search1_route(params@_) =>
      call(params.fromQuery[String]("searchkey", None)) { (searchkey) =>
        controllers_HomeController_search1_invoker.call(
          req => HomeController_1.search(searchkey, req))
      }
  
    // @LINE:7
    case controllers_HomeController_profile2_route(params@_) =>
      call(params.fromPath[String]("channelID", None)) { (channelID) =>
        controllers_HomeController_profile2_invoker.call(HomeController_1.profile(channelID))
      }
  
    // @LINE:8
    case controllers_HomeController_CVideos3_route(params@_) =>
      call(params.fromQuery[String]("channelID", None), params.fromQuery[String]("keyword", None)) { (channelID, keyword) =>
        controllers_HomeController_CVideos3_invoker.call(HomeController_1.CVideos(channelID, keyword))
      }
  
    // @LINE:9
    case controllers_HomeController_similar4_route(params@_) =>
      call(params.fromQuery[String]("videoId", None)) { (videoId) =>
        controllers_HomeController_similar4_invoker.call(HomeController_1.similar(videoId))
      }
  
    // @LINE:11
    case controllers_HomeController_ws5_route(params@_) =>
      call { 
        controllers_HomeController_ws5_invoker.call(HomeController_1.ws)
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
