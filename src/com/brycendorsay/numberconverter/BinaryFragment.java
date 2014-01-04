package com.brycendorsay.numberconverter;

import com.brycendorsay.numberconverter.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BinaryFragment extends Fragment {

	private TextView output;
	private EditText input;
	private Button convert;
	private String in;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_binary_layout, container, false);

		input = (EditText) rootView.findViewById(R.id.decimalToBinaryInput);
		output = (TextView) rootView.findViewById(R.id.decimalToBinaryOutput);
		convert = (Button) rootView.findViewById(R.id.binaryConvertButton);

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
		int mod;
		String newString;
		if(temp <= 0)
			return "";

		mod = temp % 2;
		
		newString = new String(Integer.toString(temp/2));
		
		return "" + convertValue(newString) + mod;
	}

}
