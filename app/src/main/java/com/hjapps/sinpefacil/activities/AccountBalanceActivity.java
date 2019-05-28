package com.hjapps.sinpefacil.activities;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.hjapps.sinpefacil.sms.BaseSmsReceiver;

public class AccountBalanceActivity extends AppCompatActivity {

    private BaseSmsReceiver smsBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        smsBroadcastReceiver = new BaseSmsReceiver("", "");
        registerReceiver(smsBroadcastReceiver, new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION));
        setContentView(R.layout.activity_account_balance);
    }

    public void queryBalance(View view){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String phoneNo = prefs.getString("bankPhoneNumber", null);
        String sms = "Saldo";

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "SMS Sent!",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }

    @Override
    public void onDestroy() {
        unregisterReceiver(smsBroadcastReceiver);
        super.onDestroy();
    }
}
