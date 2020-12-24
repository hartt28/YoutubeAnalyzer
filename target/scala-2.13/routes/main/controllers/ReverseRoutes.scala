// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/conf/routes
// @DATE:Wed Dec 16 14:00:53 CST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def profile(channelID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("channelID", channelID)))
    }
  
    // @LINE:6
    def search(searchkey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("searchkey", searchkey)))))
    }
  
    // @LINE:8
    def CVideos(channelID:String, keyword:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "CVideos" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("channelID", channelID)), Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("keyword", keyword)))))
    }
  
    // @LINE:11
    def ws(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws")
    }
  
    // @LINE:9
    def similar(videoId:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "similar" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("videoId", videoId)))))
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:14
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
