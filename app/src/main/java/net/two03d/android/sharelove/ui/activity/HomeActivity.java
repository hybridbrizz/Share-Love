package net.two03d.android.sharelove.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.two03d.android.sharelove.ui.fragment.GiveBackFragment;
import net.two03d.android.sharelove.ui.fragment.LoveFragment;
import net.two03d.android.sharelove.ui.fragment.ShareFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends FragmentActivity {

    @InjectView(R.id.tabHost) FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.inject(this);

        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        mTabHost.addTab(mTabHost.newTabSpec("share").setIndicator(buildTabLayout(R.drawable.icon)), ShareFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("love").setIndicator(buildTabLayout(R.drawable.icon)), LoveFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("giveBack").setIndicator(buildTabLayout(R.drawable.icon)), GiveBackFragment.class, null);
    }

    private View buildTabLayout(int iconId) {
        View tab = getLayoutInflater().inflate(R.layout.tab_layout, null);

        ((ImageView) tab.findViewById(android.R.id.icon)).setImageDrawable(getResources().getDrawable(iconId));

        return tab;
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
