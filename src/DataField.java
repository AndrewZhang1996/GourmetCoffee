package GourmetCoffee;

/**
 * Class Product
 * 
 * @author Andrew
 */
public class DataField {

	private String name;
	private String value;
	
	/*Constructor*/
	public DataField(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * This method is to return the Name in English or not.
	 * 
	 * @param isEnglish: if false, return Name in Chinese
	 * @return name
	 */
	public String getName(boolean isEnglish)
	{
		if(isEnglish)
			return name;
		else
		{
			if(name.equals("Code"))
				return "代码";
			else if(name.equals("Description"))
				return "描述";
			else if(name.equals("Price"))
				return "价格";
			else if(name.equals("Origin"))
				return "来源地";
			else if(name.equals("Roast"))
				return "烘培";
			else if(name.equals("Flavor"))
				return "风味";
			else if(name.equals("Aroma"))
				return "香味";
			else if(name.equals("Acidity"))
				return "酸度";
			else if(name.equals("Body"))
				return "形状";
			else if(name.equals("Model"))
				return "模型";
			else if(name.equals("Water supply"))
				return "水供应";
			else if(name.equals("Number of cups"))
				return "杯数";
			else return name;
		}
	}
	
	/**
	 * This method is to return the Value in English or not.
	 * 
	 * @param isEnglish: if false, return Name in Chinese
	 * @return value
	 */
	public String getValue(boolean isEnglish)
	{
		if(isEnglish)
			return value;
		else
		{
			if(value.equals("Colombia, Whole, 1 lb")) 
				return "哥伦比亚，整体，1磅";
	    	if(value.equals("Colombia")) 
	    		return "哥伦比亚";
	    	if(value.equals("Medium")) 
	    		return "中等的";
	    	if(value.equals("Rich and Hearty")) 
	    		return "丰富而热烈";
	    	if(value.equals("Rich"))
	    		return "丰富";
	    	if(value.equals("Full")) 
	    		return "饱满";
	    	if(value.equals("Colombia, Ground, 1 lb")) 
	    		return "哥伦比亚，地面，1磅";	
	    	if(value.equals("Italian Roast, Whole, 1 lb")) 
	    		return "意大利烘烤，整体，1磅";
	    	if(value.equals("Latin American Blend")) 
	    		return "拉丁美洲 调和";
	    	if(value.equals("Italian Roast")) 
	    		return "意大利烘烤";
	    	if(value.equals("Dark and heavy")) 
	    		return "黝黑浓郁";
	    	if(value.equals("Intense")) 
	    		return "浓烈的";
	    	if(value.equals("Low"))
	    		return "低"; 	
	    	if(value.equals("Italian Roast, Ground, 1 lb")) 
	    		return "意大利烘烤，地面，1磅";   	
	    	if(value.equals("French Roast, Whole, 1 lb")) 
	    		return "法国烘烤，整体，1磅";
	    	if(value.equals("French Roast, Ground, 1 lb")) 
	    		return "法国烘烤，地面，1磅";
	    	if(value.equals("French Roast")) 
	    		return "法国烘烤";
	    	if(value.equals("Bittersweet, full intense"))
	    		return "苦甜参半，富有强烈口感";
	    	if(value.equals("Intense, full"))
	    		return "强烈，丰富";
	    	if(value.equals("None"))
	    		return "无";
	    	if(value.equals("Guatemala, Whole, 1 lb")) 
	    		return "瓜地马拉，整体，1磅";
	    	if(value.equals("Guatemala")) 
	    		return "瓜地马拉";
	    	if(value.equals("Rich and complex")) 
	    		return "丰富而复杂";
	    	if(value.equals("Spicy")) 
	    		return "辣";
	    	if(value.equals("Medium to high")) 
	    		return "中高等";
	    	if(value.equals("Medium to full")) 
	    		return "中等浓郁";    	
	    	if(value.equals("Guatemala, Ground, 1 lb")) 
	    		return "瓜地马拉，地面，1磅";  	
	    	if(value.equals("Sumatra, Whole, 1 lb")) 
	    		return "苏门答腊，整体，1磅";
	    	if(value.equals("Sumatra")) 
	    		return "苏门答腊";
	    	if(value.equals("Vibrant and powdery")) 
	    		return "活力而均匀";
	    	if(value.equals("Like dark chocolate")) 
	    		return "像黑巧克力";
	    	if(value.equals("Gentle")) 
	    		return "轻微";
	    	if(value.equals("Rich and full")) 
	    		return "丰富饱满";
	    	if(value.equals("Sumatra, Ground, 1 lb")) 
	    		return "苏门答腊，地面，1磅";
	    	if(value.equals("Decaf Blend, Whole, 1 lb")) 
	    		return "咖啡因混合，整体，1磅";
	    	if(value.equals("Dark roast")) 
	    		return "烘焙";
	    	if(value.equals("Full, roasted flavor")) 
	    		return "全烤风味";
	    	if(value.equals("Hearty")) 
	    		return "浓烈";
	    	if(value.equals("Bold and rich")) 
	    		return "大胆而丰富";
	    	if(value.equals("Decaf Blend, Ground, 1 lb")) 
	    		return "咖啡因混合，地面，1磅";
	    	else return value;
		}
	}
}
