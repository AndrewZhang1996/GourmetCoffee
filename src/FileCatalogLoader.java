//package GourmetCoffee;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//
//
//
//
//public class FileCatalogLoader implements CatalogLoader{
//
//	private BufferedReader reader;
//	private Catalog catalog;
//
//	private Product readProduct(String line) throws DataFormatException
//	{
//		StringTokenizer tokenizer = new StringTokenizer(line,"_");
//		
//		if(tokenizer.countTokens()!=4)
//		{
//			if(GourmetCoffeeGUI.isEnglish)
//				throw new DataFormatException("Pruduct information error!");
//			else
//				throw new DataFormatException("产品信息错误");
//		}
//		else{
//			Product product = new Product(tokenizer.nextToken(),tokenizer.nextToken(),Double.parseDouble(tokenizer.nextToken()));
//			return product;
//		}
//	}
//	
//	private Coffee readCoffee(String line) throws DataFormatException
//	{
//		StringTokenizer tokenizer = new StringTokenizer(line,"_");
//		
//		if(tokenizer.countTokens()!= 10)
//		{
//			if(GourmetCoffeeGUI.isEnglish)
//				throw new DataFormatException("Pruduct information error!");
//			else
//				throw new DataFormatException("产品信息错误!");
//		}
//		else
//		{
//			Coffee coffee = new Coffee(tokenizer.nextToken(),tokenizer.nextToken(),Double.parseDouble(tokenizer.nextToken()), 
//					tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(), 
//					tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
//			return coffee;
//		}
//	}
//	
//	private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException
//	{
//		StringTokenizer tokenizer = new StringTokenizer(line,"_");
//		
//		if(tokenizer.countTokens()!=7)
//		{
//			if(GourmetCoffeeGUI.isEnglish)
//				throw new DataFormatException("Pruduct information error!");
//			else
//				throw new DataFormatException("产品信息错误");
//		}
//		else
//		{
//			CoffeeBrewer brewer = new CoffeeBrewer(tokenizer.nextToken(), tokenizer.nextToken(), Double.parseDouble(tokenizer.nextToken()), 
//					tokenizer.nextToken(), tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
//			return brewer;
//		}
//	}
//	
//	@Override
//	public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException
//	{
//		catalog = new Catalog();
//		reader = new BufferedReader(new FileReader(fileName));
//		String line = reader.readLine();
//		
//		while(line!=null)
//		{
//			if(line.startsWith("Brewer"))
//				catalog.addProduct(readCoffeeBrewer(line));
//			else if(line.startsWith("Coffee"))
//			{
//				catalog.addProduct(readCoffee(line));
//			}
//			else if(line.startsWith("Product"))
//			{
//				catalog.addProduct(readProduct(line));
//			}
//			else
//			{
//				throw new DataFormatException("Negative Prefix");
//			}
//			line = reader.readLine();
//		}
//		reader.close();
//		return catalog;
//	}
//
//}
package GourmetCoffee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Class FileCatalogLoader 
 * 
 * @author Andrew
 * @implements CatalogLoader
 */
public class FileCatalogLoader implements CatalogLoader{
	
	/**
	 * This method will load Catalog File.
	 * 
	 * @param fileName: the name of catalog file
	 * @throws FIleNotFoundException,IOException,DataFormatException
	 */
	@Override
	public Catalog loadCatalog(String fileName) throws FileNotFoundException,
	IOException, DataFormatException {
		
		Catalog catalog = new Catalog();
		BufferedReader reader=
				new BufferedReader(new FileReader(fileName));
		String line = reader.readLine();
		
		while (line!=null) {
			
			if (line.startsWith("Brewer")) {
				catalog.addProduct(readCoffeeBrewer(line));
			}
			else if (line.startsWith("Coffee")) {
				catalog.addProduct(readCoffee(line));
			}
			else if (line.startsWith("Product")) {
				catalog.addProduct(readProduct(line));
			}
			else {
				throw new DataFormatException("Error Prefix");
			}
			line = reader.readLine();
		}
		reader.close();
		return catalog;
	}
	
	/**
	 * This method will load Product data.
	 * 
	 * @param line: data in catalog file
	 * @throws FIleNotFoundException,IOException,DataFormatException
	 */
	private Product readProduct(String line)throws DataFormatException{
		StringTokenizer tokenizer=new StringTokenizer(line,"_");
		if(tokenizer.countTokens()!=4){
				throw new DataFormatException("Pruduct information error!");
		}
		else {
			String string=tokenizer.nextToken(); //make the tokenizer pass the prefix
			Product tempProduct=
					new Product(tokenizer.nextToken(),
						tokenizer.nextToken(),Double.parseDouble(tokenizer.nextToken()));
			return tempProduct;
		}
	}
	
	/**
	 * This method will load Coffee data.
	 * 
	 * @param line: data in catalog file
	 * @throws FIleNotFoundException,IOException,DataFormatException
	 */
	private Coffee  readCoffee (String line)throws DataFormatException{
		StringTokenizer tokenizer=new StringTokenizer(line,"_");
		if(tokenizer.countTokens()!=10)
				throw new DataFormatException("Pruduct information error!");
		else {
			String string=tokenizer.nextToken();
			Coffee tempCoffee=
					new Coffee(tokenizer.nextToken(),
				tokenizer.nextToken(),Double.parseDouble(tokenizer.nextToken()),
				tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken(),
				tokenizer.nextToken(), tokenizer.nextToken(), tokenizer.nextToken());
			return tempCoffee;
		}
	}
	
	/**
	 * This method will load CoffeeBrewer data.
	 * 
	 * @param line: data in catalog file
	 * @throws FIleNotFoundException,IOException,DataFormatException
	 */
	private CoffeeBrewer  readCoffeeBrewer (String line)throws DataFormatException{
		StringTokenizer tokenizer=new StringTokenizer(line,"_");
		if(tokenizer.countTokens()!=7)
				throw new DataFormatException("Pruduct information error!");
		else {
			String string=tokenizer.nextToken();
			CoffeeBrewer tempCoffeeBrewer=
					new CoffeeBrewer(tokenizer.nextToken(),
				tokenizer.nextToken(),Double.parseDouble(tokenizer.nextToken()), 
				tokenizer.nextToken(), tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
			return tempCoffeeBrewer;
					
		}
		
	}
	
}

