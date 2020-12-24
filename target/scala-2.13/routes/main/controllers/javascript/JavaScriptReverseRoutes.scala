// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/conf/routes
// @DATE:Wed Dec 16 14:00:53 CST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def profile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.profile",
      """
        function(channelID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("channelID", channelID0))})
        }
      """
    )
  
    // @LINE:6
    def search: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.search",
      """
        function(searchkey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("searchkey", searchkey0)])})
        }
      """
    )
  
    // @LINE:8
    def CVideos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.CVideos",
      """
        function(channelID0,keyword1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "CVideos" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("channelID", channelID0), (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("keyword", keyword1)])})
        }
      """
    )
  
    // @LINE:11
    def ws: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws"})
        }
      """
    )
  
    // @LINE:9
    def similar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.similar",
      """
        function(videoId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "similar" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("videoId", videoId0)])})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
