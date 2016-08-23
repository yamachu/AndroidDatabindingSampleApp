package jp.dip.yamachuco.androidbindingsample.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jp.dip.yamachuco.androidbindingsample.adapter.UserItemCellAdapter;
import jp.dip.yamachuco.androidbindingsample.model.User;
import jp.dip.yamachuco.androidbindingsample.R;
import jp.dip.yamachuco.androidbindingsample.databinding.FragmentUserListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {
    private FragmentUserListBinding binding;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false);
        binding.userListRecycler.setAdapter(new UserItemCellAdapter(getMockData()));
        binding.userListRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }

    private List<User> getMockData() {
        List<User> user_array = new ArrayList<>();
        user_array.add(new User("hoge hoge", "hoge user"));
        user_array.add(new User("fuga fuga", "fuga user"));
        user_array.add(new User("piyo piyo", "piyo user"));
        user_array.add(new User("hoge hoge", "hoge user"));
        user_array.add(new User("fuga fuga", "fuga user"));
        user_array.add(new User("piyo piyo", "piyo user"));
        user_array.add(new User("hoge hoge", "hoge user"));
        user_array.add(new User("fuga fuga", "fuga user"));
        user_array.add(new User("piyo piyo", "piyo user"));
        user_array.add(new User("hoge hoge", "hoge user"));
        user_array.add(new User("fuga fuga", "fuga user"));
        user_array.add(new User("piyo piyo", "piyo user"));

        return user_array;
    }

}
