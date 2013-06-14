package real.awesome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnInitListener{
	Locale currentLocale = Locale.US;
	Map<String, Locale> locales = new HashMap<String, Locale>();
	TextToSpeech tts;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		locales.put("US", Locale.US);
		locales.put("Canada", Locale.CANADA);
		locales.put("French-Canada", Locale.CANADA_FRENCH);
		locales.put("Chinese", Locale.CHINA);
		List<String> lArr = new ArrayList<String>();
		for(String s : locales.keySet())
			lArr.add(s);
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lArr);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		spinner.setSelection(lArr.indexOf("US"));

		tts = new TextToSpeech(this, this);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onInit(int status) {
		tts.setLanguage(currentLocale);

	}

}
