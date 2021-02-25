package cocoda;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;


public class ServiceLocator<T> {

	private PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
	private CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();
	// Increase max total connection to 200
	//	poolingHttpClientConnectionManager.setMaxTotal(200);
	//	// Increase default max connection per route to 20
	//	poolingHttpClientConnectionManager.setDefaultMaxPerRoute(20);
	private ApacheHttpClient4Engine engine = new ApacheHttpClient4Engine(httpClient);


	private final Class<T> serviceInterface;
	private String pathToServer;

	public ServiceLocator(Class<T> serviceInterface, String pathToServer) {
		this.serviceInterface = serviceInterface;
		this.pathToServer = pathToServer;
	}

	public <T> T build() {
		ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
		ResteasyWebTarget target = client.target(UriBuilder.fromPath(pathToServer));
		return (T) target.proxy(serviceInterface);
	}

}
