package com.brycendorsay.numberconverter;

import com.brycendorsay.numberconverter.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HexadecimalFragment extends Fragment {

	private TextView output;
	private EditText input;
	private Button convert;
	private String in;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_hexadecimal_layout, container, false);

		input = (EditText) rootView.findViewById(R.id.decimalToHexInput);
		output = (TextView) rootView.findViewById(R.id.decimalToHexOutput);
		convert = (Button) rootView.findViewById(R.id.hexConvertButton);

		

		convert.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View view) {
						try {
							in = input.getText().toString();
							if(in.length() == 0)
								throw new NullInputException("No Input");
							for(int i = 0; i < in.length(); i++) {
								char x = in.charAt(i);
								if(!Character.isDigit(x)) {
									throw new NullInputException("Invalid Input Characters");
								}
							}
							output.setText("" + convertValue(in));
						} catch(NullInputException e) {
							in = "0";
						} finally {
							output.setText(convertValue(in));
						}
					}
				});

		return rootView;
	}

	private String convertValue(String x) {
		int temp = Integer.parseInt(x);
		int mod = 0;
		String modded = "";
		String newString;
		
		if(temp <= 0)
			return "";

		mod = temp % 16;
		
		if(mod >= 10) {
			
			switch(mod) {
			case 10:
				modded = "A";
				break;
			case 11:
				modded = "B";
				break;
			case 12:
				modded = "C";
				break;
			case 13:
				modded = "D";
				break;
			case 14:
				modded = "E";
				break;
			case 15:
				modded = "F";
				break;
			default:
				modded = "ZONK";
				break;
			}
			
		} else if(mod < 10) {
			modded = Integer.toString(mod);
		}
		
		newString = new String(Integer.toString(temp/16));
		
		return "" + convertValue(newString) + modded;
	}

}
