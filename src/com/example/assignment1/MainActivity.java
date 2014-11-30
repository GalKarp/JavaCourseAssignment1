package com.example.assignment1;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	private TextView txtViewUL;
	private Button btnAbout;
	private Button btnBrowser;
	private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	float density = getResources().getDisplayMetrics().density;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewUL = (TextView) findViewById(R.id.textView1);
        btnAbout = (Button) findViewById(R.id.buttonAbout);
        btnBrowser = (Button) findViewById(R.id.buttonBrowser);

        if(density == 0.75){str = "ldpi";}
        else if(density == 1.0){str = "mdpi";}
        else if(density == 1.5){str = "mdpi";}
        else if(density == 2.0){str = "xhdpi";}
        else if(density == 3.0){str = "xxhdpi";}
        else if(density == 4.0){str = "xxxhdpi";}

        
        txtViewUL.setText("Hello. You are using resources from " +str);
        
        btnBrowser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("http://afeka.ac.il"));
				startActivity(intent);				
			}
		});
        
        btnAbout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_VIEW);
				startActivity(intent);
				startActivity(new Intent(MainActivity.this, AboutActivity.class));
				
			}
		});
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
        
        
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
