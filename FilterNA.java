package Filter;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FilterNA extends Mapper <LongWritable,Text,Text,Text>{
public void map(LongWritable key,Text Value,Context context)
throws IOException,InterruptedException
{ if(Value.toString().split("|")!= null)
			{
	String[] lineArray = Value.toString().split("\\|");
	boolean invalidCompanyName=lineArray[0].equals("NA");
	boolean invalidProductname =lineArray[1].equals("NA");
			
if ((!(invalidCompanyName) )&& (!(invalidProductname)))
{
			Text companyName = new Text(lineArray[0]);
			Text productName = new Text(lineArray[1]);
			
			context.write(companyName,productName);}
			
}
			
}			
}
