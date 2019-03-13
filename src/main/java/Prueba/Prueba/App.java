package Prueba.Prueba;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import javax.json.JsonException;
import org.json.JSONArray;
import org.json.JSONObject;


public class App {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JsonException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JsonException {
	  obtenerJSON();
	  
	  
	  
	  
	  
  }

protected static void obtenerJSON() throws IOException {
	JSONObject json = readJsonFromUrl("https://apiperiquito.herokuapp.com/recibo-json.php?imagenes=b.jpg,a.jpg");
	  JSONArray imagenes = json.getJSONArray("imagenes");
	  JSONArray imagenes_bd = json.getJSONArray("imagenes_bd");

	  for (int i = 0; i < imagenes_bd.length(); i++) {
		  System.out.println(imagenes.get(i).toString()+ " - " +imagenes_bd.get(i).toString());
		}
}
}