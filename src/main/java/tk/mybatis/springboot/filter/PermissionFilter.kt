import org.apache.commons.lang.StringUtils
import org.springframework.boot.web.servlet.ServletComponentScan
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.nio.charset.Charset
import java.util.*
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@ServletComponentScan
@WebFilter(urlPatterns = ["/**"])
class PermissionFilter : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {
    }

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val request = servletRequest as HttpServletRequest
        val response = servletResponse as HttpServletResponse
        // 设置允许跨域访问的域，*表示支持所有的来源
        response.setHeader("Access-Control-Allow-Origin", "*")
        // 设置允许跨域访问的方法
        response.setHeader(
                "Access-Control-Allow-Methods",
                "POST, GET, OPTIONS, DELETE"
        )
        response.setHeader("Access-Control-Max-Age", "3600")
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with")

        val uri = request.requestURI

        val arrayOf = arrayListOf<String>()
        arrayOf.add("/hello/test")
        if (!arrayOf.contains(uri)) {
            filterChain.doFilter(servletRequest, servletResponse)
            return
        }
        val token = request.getParameter("token")
        val nanoTime = System.currentTimeMillis()
        val reversed = nanoTime.toString().toCharArray().reversed()
        val a = StringUtils.join(reversed.subList(0, 6), "a")
        val b = StringUtils.join(reversed.subList(6, 13), "b")
        val str = a + request.queryString + uri + b
//        DigestUtils.md5DigestAsHex()

        var result = Base64.getEncoder().encodeToString((str).toByteArray(Charset.forName("UTF-8")))
        result = Base64.getEncoder().encodeToString((result).toByteArray(Charset.forName("UTF-8")))
        if (token == null) {
            response.characterEncoding = "UTF-8"
            response.contentType = "application/javascript; charset=utf-8"
            response.status = HttpStatus.OK.value()
            response.outputStream.write(getJs(result).toByteArray())
            response.outputStream.flush()
            response.outputStream.close()
        }
        var string = ""
        var newString = ""
        var time = "0"
        try {
            string = String(Base64.getDecoder().decode(token), Charset.forName("utf-8"))
            newString = String(Base64.getDecoder().decode(string), Charset.forName("utf-8"))
            newString = String(Base64.getDecoder().decode(newString), Charset.forName("utf-8"))
            time = newString.substring(newString.length - 6 - 7).replace("b", "").reversed() +
                    newString.substring(0, 5 + 6).replace("a", "").reversed()
        } catch (e: Exception) {

        }

        if (time.toLong() + 30 * 1000 < nanoTime) {
            response.characterEncoding = "UTF-8"
            response.contentType = "application/javascript; charset=utf-8"
            response.status = HttpStatus.OK.value()
            response.outputStream.write(getJs(result).toByteArray())
            response.outputStream.flush()
            response.outputStream.close()
        } else {
            filterChain.doFilter(servletRequest, servletResponse)
        }
    }

    fun getJs(str: String): String {
        val base64 =
                "function b(){_keyStr=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\",this.encode=function(r){var e,t,o,a,n,c,h,d=\"\",C=0;for(r=_utf8_encode(r);C<r.length;)a=(e=r.charCodeAt(C++))>>2,n=(3&e)<<4|(t=r.charCodeAt(C++))>>4,c=(15&t)<<2|(o=r.charCodeAt(C++))>>6,h=63&o,isNaN(t)?c=h=64:isNaN(o)&&(h=64),d=d+_keyStr.charAt(a)+_keyStr.charAt(n)+_keyStr.charAt(c)+_keyStr.charAt(h);return d},this.decode=function(r){var e,t,o,a,n,c,h=\"\",d=0;for(r=r.replace(/[^A-Za-z0-9\\+\\/\\=]/g,\"\");d<r.length;)e=_keyStr.indexOf(r.charAt(d++))<<2|(a=_keyStr.indexOf(r.charAt(d++)))>>4,t=(15&a)<<4|(n=_keyStr.indexOf(r.charAt(d++)))>>2,o=(3&n)<<6|(c=_keyStr.indexOf(r.charAt(d++))),h+=String.fromCharCode(e),64!=n&&(h+=String.fromCharCode(t)),64!=c&&(h+=String.fromCharCode(o));return h=_utf8_decode(h)},_utf8_encode=function(r){r=r.replace(/\\r\\n/g,\"\\n\");for(var e=\"\",t=0;t<r.length;t++){var o=r.charCodeAt(t);o<128?e+=String.fromCharCode(o):o>127&&o<2048?(e+=String.fromCharCode(o>>6|192),e+=String.fromCharCode(63&o|128)):(e+=String.fromCharCode(o>>12|224),e+=String.fromCharCode(o>>6&63|128),e+=String.fromCharCode(63&o|128))}return e},_utf8_decode=function(r){for(var e=\"\",t=0,o=c1=c2=0;t<r.length;)(o=r.charCodeAt(t))<128?(e+=String.fromCharCode(o),t++):o>191&&o<224?(c2=r.charCodeAt(t+1),e+=String.fromCharCode((31&o)<<6|63&c2),t+=2):(c2=r.charCodeAt(t+1),c3=r.charCodeAt(t+2),e+=String.fromCharCode((15&o)<<12|(63&c2)<<6|63&c3),t+=3);return e}};"
        return base64 + "return new b().encode('" + str + "');"
    }

    override fun destroy() {}


}
