package com.example.foregroundbackgroundcell.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foregroundbackgroundcell.R;
import com.example.foregroundbackgroundcell.adapter.MessageAdapter;
import com.example.foregroundbackgroundcell.helper.RecyclerItemTouchHelper;
import com.example.foregroundbackgroundcell.helper.RecyclerItemTouchHelperLeft;
import com.example.foregroundbackgroundcell.model.Message;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Message> messages = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.rv_messages);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ItemTouchHelper.SimpleCallback simpleCallbackLeft = new RecyclerItemTouchHelperLeft(0, ItemTouchHelper.LEFT, new RecyclerItemTouchHelperLeft.RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

            }
        });
        new ItemTouchHelper(simpleCallbackLeft).attachToRecyclerView(recyclerView);

        ItemTouchHelper.SimpleCallback simpleCallbackRight = new RecyclerItemTouchHelper(0, ItemTouchHelper.RIGHT, new RecyclerItemTouchHelper.RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

            }
        });
        new ItemTouchHelper(simpleCallbackRight).attachToRecyclerView(recyclerView);


        fillMessageList();

        refreshAdapter();
    }

    private void fillMessageList() {
        for (int i = 0; i < 20; i++) {
            messages.add(new Message("Sender" + i, "Good message sent by...", R.drawable.message_sender));
        }
    }

    private void refreshAdapter() {
        MessageAdapter messageAdapter = new MessageAdapter(messages);
        recyclerView.setAdapter(messageAdapter);
    }
}