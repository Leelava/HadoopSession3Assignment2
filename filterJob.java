package Filter;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class filterJob{
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception{
		 Configuration conf = new Configuration();
	
		Job job = new Job(conf,"Filter");
		 job.setJarByClass(filterJob.class);
		 
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(Text.class);
		 
		 job.setOutputKeyClass(Text.class);
		 job.setOutputValueClass(Text.class);
		 
		 job.setMapperClass(FilterNA.class);
	//	 job.setReducerClass(Task2Reducer.class);
		 
		 job.setInputFormatClass(TextInputFormat.class);
		 job.setOutputFormatClass(TextOutputFormat.class);
		 
		 FileInputFormat.addInputPath(job,new Path(args[0]));
		 FileOutputFormat.setOutputPath(job, new Path (args[1]));
		 job.setNumReduceTasks(0);
		 job.waitForCompletion(true);
	}
}
