package act7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class StubMapper extends Mapper<LongWritable, Text, Text, TwovalueWritable> {

	Double montant_ventes=(double) 0;
	Double nb_ventes = (double) 0;



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
	    		 montant_ventes+=cost;
	    		 nb_ventes++;

	    	}
	    	

  }
  @Override
  protected void cleanup(Context context) throws IOException, InterruptedException {

		  context.write(new Text("TOTAL"), new TwovalueWritable(montant_ventes,nb_ventes));
	  

  
  
  }

}
