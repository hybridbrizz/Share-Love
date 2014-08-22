package net.two03d.android.sharelove.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import net.two03d.android.sharelove.ui.adapter.PostAdapter;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ListPostsActivity extends FragmentActivity {

    @InjectView(R.id.gridPosts) GridView mPostsGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.inject(this);

        mPostsGrid.setAdapter(new PostAdapter(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
