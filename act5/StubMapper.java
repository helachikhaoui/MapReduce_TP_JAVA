package act5;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StubMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  
	  	String s = value.toString();

		String date ;
		String time ;
		String store ;
		String item ;
		Double cost;
		String payment;
		
	    String[] fields = s.split("\t");
	    	if (fields.length==6){
	    		 date = fields[0];
	    		 time = fields[1];
	    		 store = fields[2];
	    		 item = fields[3];
	    		 cost = Double.parseDouble(fields[4]);
	    		 payment = fields[5];
	    		 Text outputKey = new Text(item.toUpperCase().trim());
	    		 DoubleWritable outputValue = new DoubleWritable(cost);
	    		 context.write(outputKey, outputValue);

	    		
	    	}

  }

}
