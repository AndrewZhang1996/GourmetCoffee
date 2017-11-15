package GourmetCoffee;

import java.io.*;

/**
 * Interface CatalogLoader 
 * 
 * @author Andrew
 */
public interface CatalogLoader {

	Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException;
	
}
