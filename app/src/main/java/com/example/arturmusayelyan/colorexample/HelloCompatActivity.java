package com.example.arturmusayelyan.colorexample;

import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelloCompatActivity extends AppCompatActivity implements View.OnClickListener {
	private final String TEXT_COLOR_KEY = "color_key";
	private TextView helloWordTv;
	private Button changeColorBtn;

	private String[] colorsArray = {"red", "pink", "purple", "deep_purple", "indigo", "blue", "light_blue", "cyan", "teal", "green"}; // "light_green", "lime", "yellow", "amber", "orange", "deep_orange", "brown", "grey", "blue_grey", "black"};
	private Map<Integer, String> colorsMapByName;
	private Map<Integer, Integer> colorsMapById;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helo_compat);

		initUI();
		changeColorBtn.setOnClickListener(this);

		initColorMaps();//1-in tarberak maper-ov

		if (savedInstanceState != null) {
			helloWordTv.setTextColor(savedInstanceState.getInt(TEXT_COLOR_KEY));
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(TEXT_COLOR_KEY, helloWordTv.getCurrentTextColor());
	}

	private void initUI() {
		helloWordTv = findViewById(R.id.hello_word_tv);
		changeColorBtn = findViewById(R.id.change_color_btn);
	}

	@Override
	public void onClick(View v) {
		//changeHelloWordTvColor(chooseRandomColor1());//1-in tarberak maper-ov

		changeHelloWordTvColor(chooseRandomColor2());//2-rd tarberak array-ov
	}

	private void changeHelloWordTvColor(int colorResId) {
		//helloWordTv.setTextColor(ContextCompat.getColor(this, colorResId));

		//kam
		/** Get the integer ID for the actual color from the resources and assign it to a colorResId variable:
		 * The getResources() method gets the set of resources for your app,
		 * and the getColor() method retrieves a specific color from those resources by the ID of the color name.
		 **/
		helloWordTv.setTextColor(getResources().getColor(colorResId));//API 23/ic cacr nayev   this.getTheme()
	}

	/**
	 * 1-in tarberak maperov
	 */
	private void initColorMaps() {
		colorsMapByName = new HashMap<>();
		colorsMapByName.put(0, "red");
		colorsMapByName.put(1, "pink");
		colorsMapByName.put(2, "purple");
		colorsMapByName.put(3, "deep_purple");
		colorsMapByName.put(4, "indigo");
		colorsMapByName.put(5, "blue");
		colorsMapByName.put(6, "light_blue");
		colorsMapByName.put(7, "cyan");
		colorsMapByName.put(8, "teal");
		colorsMapByName.put(9, "green");

		colorsMapById = new HashMap<>();
		colorsMapById.put(0, R.color.red);
		colorsMapById.put(1, R.color.pink);
		colorsMapById.put(2, R.color.purple);
		colorsMapById.put(3, R.color.deep_purple);
		colorsMapById.put(4, R.color.indigo);
		colorsMapById.put(5, R.color.blue);
		colorsMapById.put(6, R.color.light_blue);
		colorsMapById.put(7, R.color.cyan);
		colorsMapById.put(8, R.color.teal);
		colorsMapById.put(9, R.color.green);
	}

	private int chooseRandomColor1() {
		int randomNumber = new Random().nextInt(10);//0-10
		int colorId = colorsMapById.get(randomNumber);
		String colorName = colorsMapByName.get(randomNumber);
		Toast.makeText(this, "selected color is " + colorName, Toast.LENGTH_SHORT).show();

		return colorId;
	}


	/**
	 * 2-rd tarberak aranc maperi, sovorakan array-ov
	 */
	private int chooseRandomColor2() {
		int randomNumber = new Random().nextInt(10);//0-10
		String colorName = colorsArray[randomNumber];
		Toast.makeText(this, "selected color is " + colorName, Toast.LENGTH_SHORT).show();

		/**
		 * Get the resource identifier (an integer) for the color name out of the resources:
		 * When your app is compiled, the Android system converts the definitions in your XML files
		 * into resources with internal integer IDs. There are separate IDs for both the names and the values.
		 * This line matches the color strings from the colorName array with the corresponding color name IDs in the XML resource file.
		 * The getResources() method gets all the resources for your app.
		 * The getIdentifier() method looks up the color name (the string) in the color resources ("color") for the current package name.
		 * aysinqn menq ays metodi mijocov talis enq miayn resoursi anune u inqe mez veradarznum e ayd resoursi id-in;
		 **/
		int colorId = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());

		return colorId;
	}
}
