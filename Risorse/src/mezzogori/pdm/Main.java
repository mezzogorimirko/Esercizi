package mezzogori.pdm;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//    String str="c++";
		//	Log.d("XML PARSER",str);
		int c=0,i=1;
		String elementValue = "Lista elementi nell'XML "+ '\n' + '\n';
		TextView label;
		XmlResourceParser parser=getResources().getXml(R.xml.compilation);
		try {
			int eventType = parser.getEventType();
			while (eventType !=XmlResourceParser.END_DOCUMENT){
				if (eventType == XmlResourceParser.START_TAG){
					String tagName= parser.getName();
					if ("brano".equals(tagName)){
						String id=parser.getAttributeValue(0);
					}
				}else if (eventType==XmlResourceParser.TEXT){
					if (c==0) elementValue = elementValue +"------brano " + i + "------" + '\n';
					c++;
					if (c==3) {elementValue = elementValue +"genere: ";
					c=0;
					i++;
					}
					if (c==2) elementValue = elementValue +"autore: ";
					if (c==1) elementValue = elementValue +"titolo: ";
					elementValue = elementValue + parser.getText()+ "\n";
					label = (TextView) findViewById(R.id.Text1);
					
					label.setText(elementValue);
				}
				eventType=parser.next();

			}
		}catch (XmlPullParserException e){
			e.printStackTrace();

		}catch (IOException e){
			e.printStackTrace();
		}
	}
}