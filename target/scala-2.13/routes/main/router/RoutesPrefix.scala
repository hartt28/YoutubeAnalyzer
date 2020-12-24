// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/yuejunchen/Dropbox/SOEN6441/Assignment Two/conf/routes
// @DATE:Wed Dec 16 14:00:53 CST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
