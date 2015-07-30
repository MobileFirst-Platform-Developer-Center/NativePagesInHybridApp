/**
* Copyright 2015 IBM Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
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
