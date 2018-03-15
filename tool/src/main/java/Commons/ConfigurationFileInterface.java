package Commons;

import org.apache.commons.configuration.event.ConfigurationListener;

public interface ConfigurationFileInterface {

	public String getConfigId();

	public Boolean getDelimiterParsingDisabled();

	public ConfigurationListener getConfigurationListener();
}
