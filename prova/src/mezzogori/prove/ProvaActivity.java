package mezzogori.prove;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class ProvaActivity extends Activity {
	
  private TextView textView1;
  private Button bottone1;
  private Button bottone2;
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
        
    textView1 = (TextView) findViewById(R.id.testo1);
    textView1.setText("Testo modificato con setText");
        
    bottone1 = (Button) findViewById(R.id.bottone1);
    bottone2 = (Button) findViewById(R.id.bottone2);
    
    View.OnClickListener gestore = new View.OnClickListener() {
    	  public void onClick(View view) { 
    	    
    	    switch(view.getId()){
    	            	
    	      case R.id.bottone1:
    	        textView1.setText("E' stato cliccato il bottone 1 !!!!!");
    	        break;
    	            	    	
    	      case R.id.bottone2:
    	        textView1.setText("E' stato cliccato il bottone 2  !!!!!");
    	        break;
    	    }	
    	  }
    	};
    	        
    	bottone1.setOnClickListener(gestore);
    	bottone2.setOnClickListener(gestore);
    
   /* bottone1.setOnClickListener(new View.OnClickListener() {
    	  public void onClick(View view) { 
    	    textView1.setText("E' stato premuto il bottone 1");
    	  }
    	});
    	        
    	bottone2.setOnClickListener(new View.OnClickListener() {
    	  public void onClick(View view) { 
    	    textView1.setText("E' stato premuto il bottone 2");
    	  }
    	});
  */
    }
}