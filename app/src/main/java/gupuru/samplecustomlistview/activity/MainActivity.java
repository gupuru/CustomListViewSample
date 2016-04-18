package gupuru.samplecustomlistview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import gupuru.samplecustomlistview.R;
import gupuru.samplecustomlistview.adapter.ListViewAdapter;
import gupuru.samplecustomlistview.bean.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            User user = new User("たなか" + i, i * 4);
            users.add(user);
        }

        ListView listView = (ListView)findViewById(R.id.list_view);
        ListViewAdapter adapter = new ListViewAdapter(MainActivity.this, users);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

    }
}
