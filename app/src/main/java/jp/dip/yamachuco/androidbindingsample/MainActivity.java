package jp.dip.yamachuco.androidbindingsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jp.dip.yamachuco.androidbindingsample.fragment.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserListFragment fragment = new UserListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_container, fragment).commit();
    }
}
