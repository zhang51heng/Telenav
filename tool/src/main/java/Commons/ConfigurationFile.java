package Commons;

import org.apache.commons.configuration.event.ConfigurationListener;

public enum ConfigurationFile implements ConfigurationFileInterface {

	GRAPH_CONSOLE("graph-console", Boolean.TRUE, null);

	private final String configId;
	private final Boolean delimiterParsingDisabled;
	private final ConfigurationListener listener;

	private ConfigurationFile(final String cId, final Boolean delimiterParsingDisabled, final ConfigurationListener listener) {
		this.configId = cId;
		this.delimiterParsingDisabled = delimiterParsingDisabled;
		this.listener = listener;
	}

	@Override
	public String getConfigId() {
		return this.configId;
	}

	@Override
	public Boolean getDelimiterParsingDisabled() {
		return this.delimiterParsingDisabled;
	}

	@Override
	public ConfigurationListener getConfigurationListener() {
		return this.listener;
	}

}
