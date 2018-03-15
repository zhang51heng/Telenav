package JsonResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import Commons.FileTest;

public class DeviceInfo {

	public static void main(final String args[]) throws IOException, JSONException {
		final List<String> results = new ArrayList<>();
		//init the json name
		final FileTest filetest = new FileTest();

		final List<String> names = filetest.readFilesTest("src/main/resource/resource.txt");
		//sent a restful request
		for (final String name : names) {
			final HttpClient httpclient = HttpClients.createDefault();
			final String url = "http://resourcedev.telenav.com/resources/schema/user/v6/" + name;
			final HttpGet method = new HttpGet(url.trim());
			HttpResponse httpresponse = null;
			try {
				httpresponse = httpclient.execute(method);
				final HttpEntity httpEntity = httpresponse.getEntity();
				final String response = EntityUtils.toString(httpEntity, "utf-8");
				//result to json.
				final boolean validateDeviceInfo = false;
				boolean validateSecureToken = false;
				final JSONObject jsonObj = new JSONObject(response);
				//				if (!jsonObj.isNull("properties")) {
				//					final JSONObject properties = new JSONObject(jsonObj.get("properties").toString());
				//					validateDeviceInfo = !properties.isNull("device_info");
				//				}
				if (!jsonObj.isNull("required")) {
					final String required = jsonObj.get("required").toString();
					validateSecureToken = required.contains("device_info");
				}
				if (validateDeviceInfo || validateSecureToken) {
					results.add(name);
					System.out.println("--------" + name);
				}
			}
			catch (final ClientProtocolException e) {
				e.printStackTrace();
			}
			catch (final IOException e) {
				e.printStackTrace();
			}
		}
		final String fileUrlname = "./resource/deviceInfo.txt";
		filetest.writeFilesTest(fileUrlname, results);
	}
}
