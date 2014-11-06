package com.android.chatroom;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.adapter.MsgAdapter;
import com.android.model.Message;

public class MainActivity extends Activity {

	private ListView msgListView;

	private EditText inputText;

	private Button send;

	private MsgAdapter adapter;

	private List<Message> msgList = new ArrayList<Message>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initMsgs();
		adapter = new MsgAdapter(MainActivity.this, R.layout.msg_item_layout,
				msgList);
		inputText = (EditText) findViewById(R.id.input_text);
		send = (Button) findViewById(R.id.send);
		msgListView = (ListView) findViewById(R.id.msg_list_view);
		msgListView.setAdapter(adapter);
		send.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String content = inputText.getText().toString();
				if (!"".equals(content)) {
					Message msg = new Message(content, Message.TYPE_SENT);
					msgList.add(msg);
					adapter.notifyDataSetChanged();
					msgListView.setSelection(msgList.size());
					inputText.setText("");
				}
			}
		});
	}

	private void initMsgs() {
		Message msg1 = new Message("Hello guy.", Message.TYPE_RECEIVED);
		msgList.add(msg1);
		Message msg2 = new Message("Hello. Who is that?", Message.TYPE_SENT);
		msgList.add(msg2);
		Message msg3 = new Message("This is Tom. Nice talking to you. ",
				Message.TYPE_RECEIVED);
		msgList.add(msg3);
	}
}
