package Commons;

import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.reloading.ReloadingStrategy;
import org.apache.commons.lang.StringUtils;

public class Configuration extends PropertiesConfiguration {

	private ConfigurationFileInterface component = null;
	private static final Map<ConfigurationFileInterface, Configuration> CFG = new ConcurrentHashMap<ConfigurationFileInterface, Configuration>();

	public static Configuration getInstance(final ConfigurationFileInterface component) {
		Configuration config = CFG.get(component);
		if (null == config) {
			config = new Configuration(component);
			CFG.put(component, config);
		}
		return config;
	}

	private Configuration(final ConfigurationFileInterface component) {
		super();
		super.addErrorLogListener();

		if (null != component.getDelimiterParsingDisabled()) {
			super.setDelimiterParsingDisabled(component.getDelimiterParsingDisabled());
		}
		final String fileName = SystemProperty.getConfigUrl() + component.getConfigId() + ".properties";
		super.setFileName(fileName);

		if (null != component.getConfigurationListener()) {
			super.addConfigurationListener(component.getConfigurationListener());
		}
		super.setReloadingStrategy(generateReloadingStrategy());

		this.component = component;
		try {
			super.load();
			System.out.println("[CONFIG] - Loading Configuration: " + super.getURL());
		}
		catch (final ConfigurationException e) {
			System.err.println("[CONFIG] - " + e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public PropertiesConfiguration getPropertiesConfiguration(final String key) {
		final String[] nameValueExpressions = getStringArray(key);
		if ((null == nameValueExpressions) || (nameValueExpressions.length == 0)) {
			return null;
		}

		try {
			if (this.component.getDelimiterParsingDisabled()) {
				return getPropertiesConfiguration(nameValueExpressions[0].split(String.valueOf(getListDelimiter())));
			}
			else {
				return getPropertiesConfiguration(nameValueExpressions);
			}
		}
		catch (final ConfigurationException e) {
			System.err.println(e);
			return null;
		}
	}

	public static PropertiesConfiguration getPropertiesConfiguration(final String[] nameValueExpressions) throws ConfigurationException {
		final String nameValueString = StringUtils.join(nameValueExpressions, System.lineSeparator());
		final PropertiesReader in = new PropertiesReader(new StringReader(nameValueString));
		final PropertiesConfiguration properties = new PropertiesConfiguration();
		properties.load(in);
		return properties;
	}

	private ReloadingStrategy generateReloadingStrategy() {
		final FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
		fileChangedReloadingStrategy.setRefreshDelay(SystemProperty.getConfigRefreshDelay());
		return fileChangedReloadingStrategy;
	}

	public Integer getInteger(final String key) {
		return this.getInt(key);
	}

	public static String getString(final ConfigurationFileInterface component, final String key) {
		return getInstance(component).getString(key);
	}

	public static Integer getInteger(final ConfigurationFileInterface component, final String key) {
		return getInstance(component).getInt(key);
	}

	public static Boolean getBoolean(final ConfigurationFileInterface component, final String key) {
		return getInstance(component).getBoolean(key);
	}

	public static String[] getStringArray(final ConfigurationFileInterface component, final String key) {
		return getInstance(component).getStringArray(key);
	}
}
