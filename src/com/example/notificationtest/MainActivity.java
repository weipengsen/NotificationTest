package com.example.notificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice=(Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
    	switch(v.getId()){
    	case R.id.send_notice:
    		NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    		Notification notification=new Notification(R.drawable.ic_launcher,"This is ticker text",System.currentTimeMillis());
    		Intent intent=new Intent(this,NotificationActivity.class);
    		PendingIntent pi=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
    		notification.setLatestEventInfo(this, "contentTitle", "contentText", pi);
    		manager.notify(1,notification);
    		break;
    	default:
    		break;
    	}
    }
}
