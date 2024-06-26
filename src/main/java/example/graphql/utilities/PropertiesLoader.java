package example.graphql.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** Code copied from the course site for an interface to be implemented in the 
 * analyzer project.
 * 
 * @author Eric Knapp
 * @author OscarJohnson6
 *
 */
public interface PropertiesLoader {

    /**
     * Object for logging any exception errors.
     */
    Logger logger = LogManager.getLogger(PropertiesLoader.class);

    /**
     * This default method will load a properties file into a Properties instance
     * and return it.
     * 
     * @param propertiesFilePath    Location of file.
     * @return                      The object variable properties final value.
     * @since 1.0
     */
    default Properties loadProperties(String propertiesFilePath) {
        Properties properties = new Properties();

        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));
        } catch (FileNotFoundException fileNotFoundException) {
            logger.error("file not found ", fileNotFoundException);
        } catch (IOException ioException) {
            logger.error("Error reading properties file ", ioException);
        }

        return properties;
    }

}