package act7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StubReducer extends Reducer<Text, TwovalueWritable, Text, TwovalueWritable> {
	  
	HashMap<String, Double> hmap = new HashMap<String, Double>();
	Double montant_ventes=(double) 0;
	int nombre_Ventes =  0;

  @Override
  public void reduce(Text key, Iterable<TwovalueWritable> values, Context context)
      throws IOException, InterruptedException {

	  double mt_ventes=0;
	  double nb_ventes=0;
	  
	  for(TwovalueWritable value : values){
		  mt_ventes = value.getFirst();
		  nb_ventes = value.getSecond();
		  montant_ventes+=mt_ventes;
		  nombre_Ventes+=nb_ventes;
		  
	   }
	  context.write(new Text("TOTAL"), new TwovalueWritable(montant_ventes,nombre_Ventes));


  }
  


}