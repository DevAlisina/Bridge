package com.bridge.bridge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatItem> chatList;
    private TextView bridgeTitle;
    private TextView onlineCount;
    private View topBar;
    private boolean isScrolled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupRecyclerView();
        setupBottomNavigation();
        setupScrollBehavior();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        bridgeTitle = findViewById(R.id.bridgeTitle);
        onlineCount = findViewById(R.id.onlineCount);
        topBar = findViewById(R.id.topBar);
        
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            // TODO: Implement new chat functionality
                // Toast.makeText(this, R.string.new_chat, Toast.LENGTH_SHORT).show();
        });
    }

    private void setupRecyclerView() {
        chatList = new ArrayList<>();
        // Sample data
        chatList.add(new ChatItem("علی", "سلام، حالت چطوره؟", R.drawable.ic_avatar));
        chatList.add(new ChatItem("سارا", "فردا می‌بینمت", R.drawable.ic_avatar));
        chatList.add(new ChatItem("رضا", "مرسی از کمکت", R.drawable.ic_avatar));
        chatList.add(new ChatItem("مریم", "پروژه آماده شد", R.drawable.ic_avatar));
        chatList.add(new ChatItem("احمد", "وقت بخیر", R.drawable.ic_avatar));

        chatAdapter = new ChatAdapter(chatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigation);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_chats) {
                // Already on chats page
                return true;
            } else if (id == R.id.nav_contacts) {
                // TODO: Navigate to contacts
                return true;
            } else if (id == R.id.nav_settings) {
                // TODO: Navigate to settings
                return true;
            } else if (id == R.id.nav_profile) {
                // TODO: Navigate to profile
                return true;
            }
            return false;
        });
    }

    private void setupScrollBehavior() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                
                if (dy > 0 && !isScrolled) {
                    // Scrolling down - hide title, show compact bar
                    isScrolled = true;
                    bridgeTitle.setVisibility(View.GONE);
                    onlineCount.setVisibility(View.VISIBLE);
                    topBar.setBackgroundColor(getResources().getColor(R.color.white));
                } else if (dy < 0 && isScrolled) {
                    // Scrolling up - show title, hide compact bar
                    isScrolled = false;
                    bridgeTitle.setVisibility(View.VISIBLE);
                    onlineCount.setVisibility(View.GONE);
                    topBar.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                }
            }
        });
    }
}