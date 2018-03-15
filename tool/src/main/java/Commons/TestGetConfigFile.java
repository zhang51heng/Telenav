package Commons;

public class TestGetConfigFile {

	private static final Configuration CASSANDRA_CONFIG = Configuration.getInstance(ConfigurationFile.GRAPH_CONSOLE);

	public static void main(final String args[]) {

		final String string = CASSANDRA_CONFIG.getString("storage.backend");
		System.out.println(string);
	}
}
