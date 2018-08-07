package tk.mybatis.springboot.util;

import kotlin.jvm.internal.Intrinsics;
import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 网络请求
 */
public class HttpUtil {

    /**
     * 发送https请求
     *
     * @param reqeustUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static JSONObject httpsRequest(String reqeustUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(reqeustUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //请求method  GET/POST
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //关闭资源 返回结果
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 发送http请求
     *
     * @param reqeustUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static JSONObject httpRequest(String reqeustUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(reqeustUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            //请求method  GET/POST
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            //关闭资源 返回结果
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 获取ip
     *
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getJs(String str) {
        Intrinsics.checkParameterIsNotNull(str, "str");
        String base64 = "function b(){_keyStr=\"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=\",this.encode=function(r){var e,t,o,a,n,c,h,d=\"\",C=0;for(r=_utf8_encode(r);C<r.length;)a=(e=r.charCodeAt(C++))>>2,n=(3&e)<<4|(t=r.charCodeAt(C++))>>4,c=(15&t)<<2|(o=r.charCodeAt(C++))>>6,h=63&o,isNaN(t)?c=h=64:isNaN(o)&&(h=64),d=d+_keyStr.charAt(a)+_keyStr.charAt(n)+_keyStr.charAt(c)+_keyStr.charAt(h);return d},this.decode=function(r){var e,t,o,a,n,c,h=\"\",d=0;for(r=r.replace(/[^A-Za-z0-9\\+\\/\\=]/g,\"\");d<r.length;)e=_keyStr.indexOf(r.charAt(d++))<<2|(a=_keyStr.indexOf(r.charAt(d++)))>>4,t=(15&a)<<4|(n=_keyStr.indexOf(r.charAt(d++)))>>2,o=(3&n)<<6|(c=_keyStr.indexOf(r.charAt(d++))),h+=String.fromCharCode(e),64!=n&&(h+=String.fromCharCode(t)),64!=c&&(h+=String.fromCharCode(o));return h=_utf8_decode(h)},_utf8_encode=function(r){r=r.replace(/\\r\\n/g,\"\\n\");for(var e=\"\",t=0;t<r.length;t++){var o=r.charCodeAt(t);o<128?e+=String.fromCharCode(o):o>127&&o<2048?(e+=String.fromCharCode(o>>6|192),e+=String.fromCharCode(63&o|128)):(e+=String.fromCharCode(o>>12|224),e+=String.fromCharCode(o>>6&63|128),e+=String.fromCharCode(63&o|128))}return e},_utf8_decode=function(r){for(var e=\"\",t=0,o=c1=c2=0;t<r.length;)(o=r.charCodeAt(t))<128?(e+=String.fromCharCode(o),t++):o>191&&o<224?(c2=r.charCodeAt(t+1),e+=String.fromCharCode((31&o)<<6|63&c2),t+=2):(c2=r.charCodeAt(t+1),c3=r.charCodeAt(t+2),e+=String.fromCharCode((15&o)<<12|(63&c2)<<6|63&c3),t+=3);return e}};";
        return base64 + "return new b().encode('" + str + "');";
    }

    public static void dealResponse(HttpServletResponse response, String result) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/javascript; charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        response.getOutputStream().write(getJs(result).getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

}
