/**
 * COPYRIGHT LICENSE: This information contains sample code provided in source code form. You may copy, modify, and distribute
 * these sample programs in any form without payment to IBM® for the purposes of developing, using, marketing or distributing
 * application programs conforming to the application programming interface for the operating platform for which the sample code is written.
 * Notwithstanding anything to the contrary, IBM PROVIDES THE SAMPLE SOURCE CODE ON AN "AS IS" BASIS AND IBM DISCLAIMS ALL WARRANTIES,
 * EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY QUALITY,
 * FITNESS FOR A PARTICULAR PURPOSE, TITLE, AND ANY WARRANTY OR CONDITION OF NON-INFRINGEMENT. IBM SHALL NOT BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF THE SAMPLE SOURCE CODE.
 * IBM HAS NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS OR MODIFICATIONS TO THE SAMPLE SOURCE CODE.
 */
package com.NativePagesInHybridApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HelloNative extends Activity {

	EditText editText = null;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		String name = getIntent().getStringExtra("nameParam");
		
		LinearLayout linearLayout = new LinearLayout(this);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		setContentView(linearLayout);
		
		TextView textView1 = new TextView(this);
		textView1.setText("Name received from JavaScript :: " + name);
		
		TextView textView2 = new TextView(this);
		textView2.setText("Enter the phone number");
		
		editText = new EditText(this);
		editText.setText("1234567890");
		
		Button submitButton = new Button(this);
		submitButton.setText("Return to the Web App");
		submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updateResultData();
				finish();
			}
		});
		
		linearLayout.addView(textView1);
		linearLayout.addView(textView2);
		linearLayout.addView(editText);
		linearLayout.addView(submitButton);
	}
	
	private void updateResultData(){
		String phoneNumber = editText.getText().toString();
		Intent phoneNumberInfo = new Intent();
		phoneNumberInfo.putExtra("phoneNumber", phoneNumber);
		setResult(RESULT_OK, phoneNumberInfo);
	}


	@Override
	public void onBackPressed() {
		updateResultData();
		super.onBackPressed();
	}
	
	
	
}
