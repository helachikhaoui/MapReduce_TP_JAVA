package act6;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	  
	HashMap<String, Double> hmap = new HashMap<String, Double>();

  @Override
  public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
      throws IOException, InterruptedException {

	  double maxSales=0;
	  
	  for(DoubleWritable value : values){
		   if(value.get()>maxSales)
			  maxSales=value.get();
	   }
	  //Mémoriser RENO, CHANDLER et TOLEDO
	   if((key.toString()).equals("RENO")||key.toString().equals("CHANDLER")||key.toString().equals("TOLEDO"))
		   hmap.put(key.toString(), maxSales);
	   context.write(new Text(key.toString()), new DoubleWritable(maxSales));
  
  }
  
  @Override
  protected void cleanup(Context context) throws IOException, InterruptedException {
	  //Les 3 dernières lignes correspondent aux valeurs de RENO, CHANDLER et TOLDEO , il suffit de faire un tail -3 pour les retrouver
	  for (Entry<String, Double> entry : hmap.entrySet())
	  {
		  context.write(new Text(entry.getKey()), new DoubleWritable(entry.getValue()));
	  }
  }

}